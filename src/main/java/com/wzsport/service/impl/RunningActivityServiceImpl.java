package com.wzsport.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.wzsport.exception.RunningActivityAlreadyEndException;
import com.wzsport.mapper.RunningActivityMapper;
import com.wzsport.mapper.RunningSportMapper;
import com.wzsport.mapper.SignInMapper;
import com.wzsport.model.RunningActivity;
import com.wzsport.model.RunningActivityExample;
import com.wzsport.model.RunningActivityExample.Criteria;
import com.wzsport.model.RunningSport;
import com.wzsport.model.SignInExample;
import com.wzsport.model.Term;
import com.wzsport.service.RunningActivityService;
import com.wzsport.service.SportDataValidateService;
import com.wzsport.service.TermService;
import com.wzsport.util.CalorieUtil;

/**
 * RunningActivity Service 实现类.
 *
 * @author x1ny
 * @date 2017年5月26日
 */
@Service
public class RunningActivityServiceImpl implements RunningActivityService {

	@Autowired
	private RunningSportMapper runningSportMapper;

	@Autowired
	private RunningActivityMapper runningActivityMapper;

	@Autowired
	private SignInMapper signInMapper;

	@Autowired
	private TermService termService;

	@Autowired
	private SportDataValidateService sportDataValidateService;

	/*
	 * (non-Javadoc)
	 *
	 * @see com.wzsport.service.RunningActivityService#create(com.wzsport.model.
	 * RunningActivity)
	 */
	@Override
	public RunningActivity create(RunningActivity runningActivity) {
		// 根据学生ID和开始时间来判断数据是否重复
		RunningActivityExample sameRecordExample = new RunningActivityExample();
		sameRecordExample.createCriteria().andStudentIdEqualTo(runningActivity.getStudentId())
				.andStartTimeEqualTo(runningActivity.getStartTime());
		List<RunningActivity> sameRecordList = runningActivityMapper.selectByExample(sameRecordExample);
		if (sameRecordList.size() != 0) {
			throw new DuplicateKeyException("运动记录重复");
		}

		// 获取关联的项目
		RunningSport runningSport = runningSportMapper.selectByPrimaryKey(runningActivity.getRunningSportId());

		// 判断是否合格
		if (runningActivity.getDistance() >= runningSport.getQualifiedDistance()
				&& runningActivity.getTargetFinishedTime() != null
				&& runningActivity.getTargetFinishedTime() <= runningSport.getQualifiedCostTime()) {
			runningActivity.setQualified(true);
		} else {
			runningActivity.setQualified(false);
		}

		// 计算卡路里消耗
		int caloriesConsumed = CalorieUtil.calculateCalorieConsumption(68, runningActivity.getCostTime(),
				runningSport.getHourlyKcalConsumption());
		runningActivity.setKcalConsumed(caloriesConsumed);

		// 步数至少为1
		if (runningActivity.getStepCount() == 0) {
			runningActivity.setStepCount(1);
		}

		// 计算平均速度、步幅和步频
		BigDecimal speed = new BigDecimal((double) runningActivity.getDistance() / runningActivity.getCostTime());
		runningActivity.setSpeed(speed.setScale(2, RoundingMode.HALF_UP).doubleValue());

		BigDecimal stepPerSecond = new BigDecimal(
				(double) runningActivity.getStepCount() / runningActivity.getCostTime());
		runningActivity.setStepPerSecond(stepPerSecond.setScale(2, RoundingMode.HALF_UP).doubleValue());

		BigDecimal distancePerStep = new BigDecimal(
				(double) runningActivity.getDistance() / runningActivity.getStepCount());
		runningActivity.setDistancePerStep(distancePerStep.setScale(2, RoundingMode.HALF_UP).doubleValue());

		// 插入数据
		runningActivityMapper.insertSelective(runningActivity);

		return runningActivity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.wzsport.service.RunningActivityService#startRunningActivity(long,
	 * long, java.util.Date)
	 */
	public RunningActivity startRunningActivity(long studentId, long runningSportId, Date startTime) {

		RunningSport runningSport = runningSportMapper.selectByPrimaryKey(runningSportId);

		RunningActivity runningActivity = new RunningActivity();
		runningActivity.setStudentId(studentId);
		runningActivity.setRunningSportId(runningSportId);
		runningActivity.setStartTime(new Date());
		runningActivity.setQualifiedDistance(runningSport.getQualifiedDistance());
		runningActivity.setQualifiedCostTime(runningSport.getQualifiedCostTime());

		runningActivityMapper.insertSelective(runningActivity);

		return runningActivity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.wzsport.service.RunningActivityService#endRunningActivity(com.wzsport
	 * .model.RunningActivity)
	 */
	public RunningActivity endRunningActivity(RunningActivity runningActivity) {
		RunningActivity oldRecord = runningActivityMapper.selectByPrimaryKey(runningActivity.getId());

		if (oldRecord == null) {
			throw new DataRetrievalFailureException("找不到指定的记录");
		}

		if (oldRecord.getEndedAt() != null) {
			throw new RunningActivityAlreadyEndException("本次运动已经结束");
		}

		runningActivity.setRunningSportId(oldRecord.getRunningSportId());
		
		if (runningActivity.getEndRunningSportId() == null) {
		    runningActivity.setEndRunningSportId(oldRecord.getRunningSportId());
		}
		
		runningActivity.setStudentId(oldRecord.getStudentId());
		runningActivity.setStartTime(oldRecord.getStartTime());
		runningActivity.setQualifiedDistance(oldRecord.getQualifiedDistance());
		runningActivity.setQualifiedCostTime(oldRecord.getQualifiedCostTime());
		runningActivity.setMinCostTime(oldRecord.getMinCostTime());

		// 判断是否合格
		if (runningActivity.getDistance() >= runningActivity.getQualifiedDistance()) {
//				&& runningActivity.getTargetFinishedTime() != 0
		    if (runningActivity.getTargetFinishedTime() > 0 && runningActivity.getTargetFinishedTime() <= runningActivity.getQualifiedCostTime()) {
		        runningActivity.setQualified(true);
		    } else {
		        BigDecimal d = new BigDecimal(runningActivity.getDistance());
		        BigDecimal t = new BigDecimal(runningActivity.getCostTime());
		        BigDecimal v = d.divide(t, 2, BigDecimal.ROUND_HALF_UP);
		        
		        BigDecimal qD = new BigDecimal(runningActivity.getQualifiedDistance());
		        BigDecimal qT = new BigDecimal(runningActivity.getQualifiedCostTime());
		        BigDecimal qV = qD.divide(qT, 2, BigDecimal.ROUND_HALF_UP);
		        
		        if (v.compareTo(qV) >= 0) {
		            runningActivity.setQualified(true);
		        } else {
		            runningActivity.setQualified(false);
		        }
		    }
		} else {
			runningActivity.setQualified(false);
		}

		// 获取关联的项目
		RunningSport runningSport = runningSportMapper.selectByPrimaryKey(runningActivity.getRunningSportId());

		// 计算卡路里消耗
		int kcalConsumed = CalorieUtil.calculateCalorieConsumption(68, runningActivity.getCostTime(),
				runningSport.getHourlyKcalConsumption());
		runningActivity.setKcalConsumed(kcalConsumed);

		// 步数至少为1
//		if (runningActivity.getStepCount() == 0) {
//			runningActivity.setStepCount(1);
//		}

		// 计算速度、步幅和步频
		BigDecimal speed = runningActivity.getCostTime() == 0 ? new BigDecimal(0) : new BigDecimal((double) runningActivity.getDistance() / runningActivity.getCostTime());
		runningActivity.setSpeed(speed.setScale(2, RoundingMode.HALF_UP).doubleValue());

		BigDecimal stepPerSecond = runningActivity.getCostTime() == 0 ? new BigDecimal(0) : new BigDecimal(
				(double) runningActivity.getStepCount() / runningActivity.getCostTime());
		runningActivity.setStepPerSecond(stepPerSecond.setScale(2, RoundingMode.HALF_UP).doubleValue());

		if (runningActivity.getStepCount() != 0) {
			BigDecimal distancePerStep = runningActivity.getStepCount() == 0 ? new BigDecimal(0) : new BigDecimal(
					(double) runningActivity.getDistance() / runningActivity.getStepCount());
			System.out.println("distance_per_step: " + distancePerStep.setScale(2, RoundingMode.HALF_UP).doubleValue());
			runningActivity.setDistancePerStep(distancePerStep.setScale(2, RoundingMode.HALF_UP).doubleValue());
		} else {
			runningActivity.setDistancePerStep((double) 0);
		}

		//判断数据是否正常
		boolean isValid = sportDataValidateService.rapidValidateForRunningActivity(runningActivity);
		runningActivity.setIsValid(isValid);
		
		//暂时放开，不判断
//		runningActivity.setIsValid(true);

		runningActivity.setEndedAt(new Date());

		// 更新数据
		runningActivityMapper.updateByPrimaryKeySelective(runningActivity);

		return runningActivity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.wzsport.service.RunningActivityService#
	 * getCurrentTermQualifiedActivityCount(long)
	 */
	@Override
	public int getCurrentTermQualifiedActivityCount(long studentId, long universityId) {
		Term term = termService.getCurrentTerm(universityId);
		if (term != null) {
//			RunningActivityExample runningActivityExample = new RunningActivityExample();
//			runningActivityExample.createCriteria().andStartTimeBetween(term.getStartDate(), term.getEndDate())
//					.andStudentIdEqualTo(studentId).andQualifiedEqualTo(true);
//
//			return (int) runningActivityMapper.countByExample(runningActivityExample);
			return (int) runningActivityMapper.currentTermQualifiedActivityCount(studentId, term.getStartDate(), term.getEndDate());
		}
		return 0;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.wzsport.service.RunningActivityService#getCurrentTermActivityCount(
	 * long, long)
	 */
	@Override
	public int getCurrentTermActivityCount(long studentId, long universityId) {
		Term term = termService.getCurrentTerm(universityId);
		if (term != null) {
			RunningActivityExample runningActivityExample = new RunningActivityExample();
			runningActivityExample.createCriteria().andStartTimeBetween(term.getStartDate(), term.getEndDate())
					.andStudentIdEqualTo(studentId);

			return (int) runningActivityMapper.countByExample(runningActivityExample);
//			return (int) runningActivityMapper.currentTermActivityCount(studentId, term.getStartDate(), term.getEndDate());
		}
		return 0;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.wzsport.service.RunningActivityService#getStudentCaloriesConsumption(
	 * long)
	 */
	@Override
	public int getStudentKCalConsumption(long studentId) {
		Integer caloriesConsumption = runningActivityMapper.sumCaloriesConsumedByStudentId(studentId);
		return caloriesConsumption == null ? 0 : caloriesConsumption;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.wzsport.service.RunningActivityService#getStudentTimeCosted(long)
	 */
	@Override
	public int getStudentTimeCosted(long studentId) {
		Integer timeCosted = runningActivityMapper.sumCostTimeByStudentId(studentId);
		return timeCosted == null ? 0 : timeCosted;
	}

	@Override
	public int getStudentKcalConsumption(long studentId, Date start, Date end) {
		Integer timeCosted = runningActivityMapper.sumKCalConsumedByStudentIdAndDuration(studentId, start, end);
		return timeCosted == null ? 0 : timeCosted;
	}

	@Override
	public int getStudentTimeCosted(long studentId, Date start, Date end) {
		Integer timeCosted = runningActivityMapper.sumCostTimeByStudentIdAndDuration(studentId, start, end);
		return timeCosted == null ? 0 : timeCosted;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.wzsport.service.RunningActivityService#getQualifiedActivityCount(
	 * long, java.util.Date, java.util.Date)
	 */
	@Override
	public int getQualifiedActivityCount(long studentId, Date start, Date end) {
		RunningActivityExample runningActivityExample = new RunningActivityExample();
		Criteria criteria = runningActivityExample.createCriteria().andStudentIdEqualTo(studentId)
				.andQualifiedEqualTo(true);
		if (start != null) {
			criteria.andStartTimeGreaterThanOrEqualTo(start);
		}

		if (end != null) {
			criteria.andStartTimeLessThanOrEqualTo(end);
		}

		return (int) runningActivityMapper.countByExample(runningActivityExample);
	}

	@Override
	public int getParticipantNum(long runningSportId) {
		RunningActivityExample runningActivityExample = new RunningActivityExample();
		runningActivityExample.createCriteria().andRunningSportIdEqualTo(runningSportId).andEndedAtIsNull();
		return (int) runningActivityMapper.countByExample(runningActivityExample);
	}

	@Override
	public boolean isActivityExist(long activityId) {
		if (runningActivityMapper.selectByPrimaryKey(activityId) != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int getAccuActivityCount(long studentId, Date start, Date end) {
		RunningActivityExample runningActivityExample = new RunningActivityExample();
		runningActivityExample.createCriteria().andStudentIdEqualTo(studentId).andStartTimeBetween(start, end);
		return (int) runningActivityMapper.countByExample(runningActivityExample);
	}

	@Override
	public int getSignInCount(long studentId, Date start, Date end) {
		SignInExample example = new SignInExample();
		SignInExample.Criteria criteria = example.createCriteria().andStudentIdEqualTo(studentId);

		if (start != null) {
			criteria.andSignInTimeGreaterThanOrEqualTo(start);
		}

		if (end != null) {
			criteria.andSignInTimeLessThanOrEqualTo(end);
		}

		int count = (int) signInMapper.countByExample(example);

		return count;
	}
}
