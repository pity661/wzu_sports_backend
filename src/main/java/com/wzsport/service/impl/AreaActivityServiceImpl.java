package com.wzsport.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.http.HttpRange;
import org.springframework.stereotype.Service;

import com.wzsport.mapper.AreaActivityMapper;
import com.wzsport.mapper.AreaSportMapper;
import com.wzsport.model.AreaActivity;
import com.wzsport.model.AreaActivityExample;
import com.wzsport.model.AreaSport;
import com.wzsport.model.RunningActivityExample;
import com.wzsport.model.RunningSport;
import com.wzsport.model.AreaActivityExample.Criteria;
import com.wzsport.model.Term;
import com.wzsport.service.AreaActivityService;
import com.wzsport.service.TermService;
import com.wzsport.util.CalorieUtil;
import com.wzsport.util.ResponseBody;
import com.wzsport.util.RetMsgTemplate;

// TODO: Auto-generated Javadoc
/**
 * AreaActivity Service 实现类.
 *
 * @author x1ny
 * @date 2017年5月26日
 */
@Service
public class AreaActivityServiceImpl implements AreaActivityService {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(AreaSportServiceImpl.class);

	/** The area sport mapper. */
	@Autowired
	private AreaSportMapper areaSportMapper;

	/** The area activity mapper. */
	@Autowired
	private AreaActivityMapper areaActivityMapper;

	/** The term service. */
	@Autowired
	private TermService termService;

	/** The log msg. */
	private String logMsg = "";

	/*
	 * (non-Javadoc)
	 *
	 * @see com.wzsport.service.AreaActivityService#create(com.wzsport.model.
	 * AreaActivity)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public int create(AreaActivity areaActivity, ResponseBody resBody) {
		// 根据学生ID和开始时间来判断数据是否重复，这个地方有可能可以做到断点，如果在一次运动中意外退出，这个地方就可以进行判断
		AreaActivityExample sameRecordExample = new AreaActivityExample();
		sameRecordExample.createCriteria().andStudentIdEqualTo(areaActivity.getStudentId())
				.andStartTimeEqualTo(areaActivity.getStartTime());
		List<AreaActivity> list = areaActivityMapper.selectByExample(sameRecordExample);
		if (list.size() > 0) {
			logMsg = RetMsgTemplate.MSG_TEMPLATE_RECORD_EXIST;
			logger.error(logMsg);

			resBody.obj = list.get(0);
			resBody.statusMsg = logMsg;

			return HttpServletResponse.SC_CONFLICT;
		} else {
			// 获取关联的项目
			AreaSport areaSport = areaSportMapper.selectByPrimaryKey(areaActivity.getAreaSportId());
			if (areaSport == null) {
				logMsg = "没有找到areaSportId是%s的记录".replace("%s", String.valueOf(areaActivity.getAreaSportId()));
				logger.error(logMsg);
				return HttpServletResponse.SC_NOT_FOUND;
			}

			areaActivity.setQualifiedCostTime(areaSport.getQualifiedCostTime());

			// 插入数据
			areaActivityMapper.insertSelective(areaActivity);

			logMsg = RetMsgTemplate.MSG_TEMPLATE_OPERATION_OK;
			logger.info(logMsg);

			resBody.obj = areaActivity;
			resBody.statusMsg = logMsg;

			return HttpServletResponse.SC_OK;
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public int update(AreaActivity areaActivity, ResponseBody resBody) {
		AreaActivityExample example = new AreaActivityExample();
		example.createCriteria().andIdEqualTo(areaActivity.getId());
		List<AreaActivity> list = areaActivityMapper.selectByExample(example);
		if (list.size() > 0) {
			if (list.get(0).getEndedAt() != null) {
				logMsg = "该记录的结束时间已经被更新";
				logger.error(logMsg);
				resBody.statusMsg = logMsg;
				return HttpServletResponse.SC_CONFLICT;
			}
			areaActivity = list.get(0);
			areaActivity.setEndedAt(new Date());
			// 获取关联的项目
			AreaSport areaSport = areaSportMapper.selectByPrimaryKey(areaActivity.getAreaSportId());
			if (areaSport == null) {
				logMsg = "没有找到areaSportId是%s的记录".replace("%s", String.valueOf(areaActivity.getAreaSportId()));
				logger.error(logMsg);
				resBody.statusMsg = logMsg;
				return HttpServletResponse.SC_NOT_FOUND;
			}

			int costTime = (int) ((areaActivity.getEndedAt().getTime() - areaActivity.getStartTime().getTime()) / 1000);
			areaActivity.setCostTime(costTime);
			// 判断是否合格
			if (areaActivity.getCostTime() > list.get(0).getQualifiedCostTime()) {
				areaActivity.setQualified(true);
			} else {
				areaActivity.setQualified(false);
			}

			// 计算卡路里消耗
			int caloriesConsumed = CalorieUtil.calculateCalorieConsumption(68, areaActivity.getCostTime(),
					areaSport.getHourlyKcalConsumption());
			areaActivity.setKcalConsumed(caloriesConsumed);

			areaActivityMapper.updateByPrimaryKey(areaActivity);

			logMsg = RetMsgTemplate.MSG_TEMPLATE_OPERATION_OK;
			logger.info(logMsg);

			resBody.obj = areaActivity;
			resBody.statusMsg = logMsg;

			return HttpServletResponse.SC_OK;
		} else {
			logMsg = RetMsgTemplate.MSG_TEMPLATE_NOT_FIND_BY_ID;
			logger.info(logMsg);

			resBody.obj = areaActivity;
			resBody.statusMsg = logMsg;

			return HttpServletResponse.SC_NOT_FOUND;
		}
	}

	public AreaActivity startAreaActivity(long studentId, long areaSportId, Date startTime) {

		AreaSport areaSport = areaSportMapper.selectByPrimaryKey(areaSportId);

		AreaActivity areaActivity = new AreaActivity();
		areaActivity.setStudentId(studentId);
		areaActivity.setAreaSportId(areaSportId);
		areaActivity.setStartTime(new Date());
		areaActivity.setQualifiedCostTime(areaSport.getQualifiedCostTime());

		areaActivityMapper.insertSelective(areaActivity);

		return areaActivity;
	}



	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.wzsport.service.AreaActivityService#endAreaActivity(com.wzsport
	 * .model.AreaActivity)
	 */
	public AreaActivity endAreaActivity(AreaActivity areaActivity) {
		AreaActivity oldRecord = areaActivityMapper.selectByPrimaryKey(areaActivity.getId());

		if (oldRecord == null) {
			throw new DataRetrievalFailureException("找不到指定的记录");
		}

		if (oldRecord.getEndedAt() != null) {
			throw new RuntimeException("本次运动已经结束");
		}

		areaActivity.setAreaSportId(oldRecord.getAreaSportId());
		areaActivity.setStudentId(oldRecord.getStudentId());
		areaActivity.setStartTime(oldRecord.getStartTime());
		areaActivity.setQualifiedCostTime(oldRecord.getQualifiedCostTime());

		// 判断是否合格
		if (areaActivity.getCostTime() >= areaActivity.getQualifiedCostTime()) {
			areaActivity.setQualified(true);
		} else {
			areaActivity.setQualified(false);
		}

		// 获取关联的项目
		AreaSport areaSport = areaSportMapper.selectByPrimaryKey(areaActivity.getAreaSportId());

		// 计算卡路里消耗
		int caloriesConsumed = CalorieUtil.calculateCalorieConsumption(68, areaActivity.getCostTime(),
				areaSport.getHourlyKcalConsumption());
		areaActivity.setKcalConsumed(caloriesConsumed);

		areaActivity.setEndedAt(new Date());

		// 插入数据
		areaActivityMapper.updateByPrimaryKeySelective(areaActivity);

		return areaActivity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.wzsport.service.AreaActivityService#
	 * getCurrentTermQualifiedActivityCount(long)
	 */
	@Override
	public int getCurrentTermQualifiedActivityCount(long studentId, long universityId) {
		Term term = termService.getCurrentTerm(universityId);
		if (term != null) {
//			AreaActivityExample areaActivityExample = new AreaActivityExample();
//			areaActivityExample.createCriteria().andStartTimeBetween(term.getStartDate(), term.getEndDate())
//					.andStudentIdEqualTo(studentId).andQualifiedEqualTo(true);
//
//			return (int) areaActivityMapper.countByExample(areaActivityExample);
			return (int) areaActivityMapper.currentTermQualifiedActivityCount(studentId, term.getStartDate(), term.getEndDate());
		}
		return 0;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.wzsport.service.AreaActivityService#getCurrentTermActivityCount(
	 * long, long)
	 */
	@Override
	public int getCurrentTermActivityCount(long studentId, long universityId) {
		Term term = termService.getCurrentTerm(universityId);
		if (term != null) {
			AreaActivityExample areaActivityExample = new AreaActivityExample();
			areaActivityExample.createCriteria().andStartTimeBetween(term.getStartDate(), term.getEndDate())
					.andStudentIdEqualTo(studentId);

			return (int) areaActivityMapper.countByExample(areaActivityExample);
		}
		return 0;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.wzsport.service.AreaActivityService#getStudentCaloriesConsumption(
	 * long)
	 */
	@Override
	public int getStudentKCalConsumption(long studentId) {
		Integer kcal = areaActivityMapper.sumKcalConsumedByStudentId(studentId);
		return kcal == null ? 0 : kcal;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.wzsport.service.AreaActivityService#getStudentTimeCosted(long)
	 */
	@Override
	public int getStudentTimeCosted(long studentId) {
		Integer timeCosted = areaActivityMapper.sumCostTimeByStudentId(studentId);
		return timeCosted == null ? 0 : timeCosted;
	}

	/* (non-Javadoc)
	 * @see com.wzsport.service.AreaActivityService#getStudentCaloriesConsumption(long, java.util.Date, java.util.Date)
	 */
	@Override
	public int getStudentKcalConsumption(long studentId, Date start, Date end) {
		Integer timeCosted = areaActivityMapper.sumKCalConsumedByStudentIdAndDuration(studentId, start, end);
		return timeCosted == null ? 0 : timeCosted;
	}

	/* (non-Javadoc)
	 * @see com.wzsport.service.AreaActivityService#getStudentTimeCosted(long, java.util.Date, java.util.Date)
	 */
	@Override
	public int getStudentTimeCosted(long studentId, Date start, Date end) {
		Integer timeCosted = areaActivityMapper.sumCostTimeByStudentIdAndDuration(studentId, start, end);
		return timeCosted == null ? 0 : timeCosted;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.wzsport.service.AreaActivityService#getQualifiedActivityCount(
	 * long, java.util.Date, java.util.Date)
	 */
	@Override
	public int getQualifiedActivityCount(long studentId, Date start, Date end) {
		AreaActivityExample areaActivityExample = new AreaActivityExample();
		Criteria criteria = areaActivityExample.createCriteria().andStudentIdEqualTo(studentId)
				.andQualifiedEqualTo(true);
		if (start != null) {
			criteria.andStartTimeGreaterThanOrEqualTo(start);
		}

		if (end != null) {
			criteria.andStartTimeLessThanOrEqualTo(end);
		}

		return (int) areaActivityMapper.countByExample(areaActivityExample);
	}

	/* (non-Javadoc)
	 * @see com.wzsport.service.AreaActivityService#getParticipantNum(long)
	 */
	@Override
	public int getParticipantNum(long areaSportId) {
		AreaActivityExample totalCountExampl = new AreaActivityExample();
		totalCountExampl.createCriteria().andAreaSportIdEqualTo(areaSportId).andEndedAtIsNull();
		return (int) areaActivityMapper.countByExample(totalCountExampl);
	}

	/* (non-Javadoc)
	 * @see com.wzsport.service.AreaActivityService#isActivityExist(long)
	 */
	@Override
	public boolean isActivityExist(long activityId) {
		if (areaActivityMapper.selectByPrimaryKey(activityId) != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Object getAccuActivityCount(long studentId, Date start, Date end) {
		AreaActivityExample areaActivityExample = new AreaActivityExample();
		areaActivityExample.createCriteria().andStudentIdEqualTo(studentId).andStartTimeBetween(start, end);
		return (int) areaActivityMapper.countByExample(areaActivityExample);
	}
}
