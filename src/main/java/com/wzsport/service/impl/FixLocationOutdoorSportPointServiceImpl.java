package com.wzsport.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzsport.mapper.FixLocationOutdoorSportPointMapper;
import com.wzsport.model.FixLocationOutdoorSportPoint;
import com.wzsport.model.FixLocationOutdoorSportPointExample;
import com.wzsport.service.FixLocationOutdoorSportPointService;
import com.wzsport.util.ResponseBody;
import com.wzsport.util.RetMsgTemplate;

/**
 * RunningActivity Service 实现类.
 *
 * @author x1ny
 * @date 2017年5月26日
 */
@Service
public class FixLocationOutdoorSportPointServiceImpl implements FixLocationOutdoorSportPointService {

	private static final Logger logger = LoggerFactory.getLogger(FixLocationOutdoorSportPointServiceImpl.class);
	
	private String logMsg = "";
	
	@Autowired
	private FixLocationOutdoorSportPointMapper fixLocationOutdoorSportPointMapper;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public int create(FixLocationOutdoorSportPoint fixLocationOutdoorSportPoint, ResponseBody resBody) {
		//判断数据是否重复
		FixLocationOutdoorSportPointExample example = new FixLocationOutdoorSportPointExample();
		example.createCriteria().andNameEqualTo(fixLocationOutdoorSportPoint.getName());
		List<FixLocationOutdoorSportPoint> sameRecordList = fixLocationOutdoorSportPointMapper.selectByExample(example);
		if (sameRecordList.size() != 0) {
			logMsg = RetMsgTemplate.MSG_TEMPLATE_NAME_EXIST.replace("%s", fixLocationOutdoorSportPoint.getName());
			logger.error(logMsg);
			
			fixLocationOutdoorSportPoint.setId(sameRecordList.get(0).getId());
			
			resBody.statusMsg = logMsg;
			resBody.obj = fixLocationOutdoorSportPoint;
			
			return HttpServletResponse.SC_CONFLICT;
		} else {
			fixLocationOutdoorSportPointMapper.insert(fixLocationOutdoorSportPoint);
			
			logMsg = RetMsgTemplate.MSG_TEMPLATE_OPERATION_OK;
			logger.info(logMsg);
			
			resBody.statusMsg = logMsg;
			resBody.obj = fixLocationOutdoorSportPoint;
			
			return HttpServletResponse.SC_CREATED;
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public int show(FixLocationOutdoorSportPoint fixLocationOutdoorSportPoint, ResponseBody resBody) {
		FixLocationOutdoorSportPointExample example = new FixLocationOutdoorSportPointExample();
		example.createCriteria().andIdEqualTo(fixLocationOutdoorSportPoint.getId());
		List<FixLocationOutdoorSportPoint> list = fixLocationOutdoorSportPointMapper.selectByExample(example);
		if (list.size() > 0) {
			logMsg = RetMsgTemplate.MSG_TEMPLATE_OPERATION_OK;
			logger.info(logMsg);
			
			resBody.statusMsg = logMsg;
			resBody.obj = list.get(0);
			
			return HttpServletResponse.SC_OK;
		} else {
			logMsg = RetMsgTemplate.MSG_TEMPLATE_NOT_FIND_BY_ID;
			logger.error(logMsg);
			
			resBody.statusMsg = logMsg;
			resBody.obj = fixLocationOutdoorSportPoint;
			
			return HttpServletResponse.SC_NOT_FOUND;
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public int update(FixLocationOutdoorSportPoint fixLocationOutdoorSportPoint, ResponseBody resBody) {
		FixLocationOutdoorSportPointExample example = new FixLocationOutdoorSportPointExample();
		example.createCriteria().andNameEqualTo(fixLocationOutdoorSportPoint.getName()).andIdNotEqualTo(fixLocationOutdoorSportPoint.getId());
		List<FixLocationOutdoorSportPoint> list = fixLocationOutdoorSportPointMapper.selectByExample(example);
		if (list.size() > 0) {
			logMsg = RetMsgTemplate.MSG_TEMPLATE_NAME_EXIST.replace("%s", fixLocationOutdoorSportPoint.getName());
			logger.error(logMsg);
			
			resBody.obj = list.get(0);
			resBody.statusMsg = logMsg; 
			
			return HttpServletResponse.SC_CONFLICT;
		} else {
			example.clear();
			example.createCriteria().andIdEqualTo(fixLocationOutdoorSportPoint.getId());
			list = fixLocationOutdoorSportPointMapper.selectByExample(example);
			if (list.size() > 0) {
				fixLocationOutdoorSportPointMapper.updateByPrimaryKey(fixLocationOutdoorSportPoint);
				logMsg = RetMsgTemplate.MSG_TEMPLATE_OPERATION_OK;
				logger.info(logMsg);
				
				resBody.obj = fixLocationOutdoorSportPoint;
				resBody.statusMsg = logMsg; 
				
				return HttpServletResponse.SC_OK;
			} else {
				logMsg = RetMsgTemplate.MSG_TEMPLATE_NOT_FIND_BY_ID.replace("%s", String.valueOf(fixLocationOutdoorSportPoint.getId()));
				logger.error(logMsg);
				
				resBody.obj = null;
				resBody.statusMsg = logMsg;
				
				return HttpServletResponse.SC_NOT_FOUND;
			}
		
		}
		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public int index(List<FixLocationOutdoorSportPoint> pointList, ResponseBody resBody) {
		FixLocationOutdoorSportPointExample example = new FixLocationOutdoorSportPointExample();
		example.createCriteria().andIdNotEqualTo(0l);
		List<FixLocationOutdoorSportPoint> list = fixLocationOutdoorSportPointMapper.selectByExample(example);
		if (list.size() > 0) {
			pointList.addAll(list);
			
			logMsg = RetMsgTemplate.MSG_TEMPLATE_OPERATION_OK;
			logger.info(logMsg);
			
			resBody.statusMsg = logMsg;
			resBody.obj = pointList;
			
			return HttpServletResponse.SC_OK;
		} else {
			logMsg = RetMsgTemplate.MSG_TEMPLATE_NOT_FIND_BY_ID;
			logger.error(logMsg);
			
			resBody.statusMsg = logMsg;
			resBody.obj = pointList;
			
			return HttpServletResponse.SC_NOT_FOUND;
		}
	}

	@Override
	public int index(long universityId, List<FixLocationOutdoorSportPoint> pointList, ResponseBody resBody) {
		FixLocationOutdoorSportPointExample example = new FixLocationOutdoorSportPointExample();
		example.createCriteria().andIdNotEqualTo(0l).andUniversityIdEqualTo(universityId).andIsEnabledEqualTo(true);
		List<FixLocationOutdoorSportPoint> list = fixLocationOutdoorSportPointMapper.selectByExample(example);
		if (list.size() > 0) {
			pointList.addAll(list);
			
			logMsg = RetMsgTemplate.MSG_TEMPLATE_OPERATION_OK;
			logger.info(logMsg);
			
			resBody.statusMsg = logMsg;
			resBody.obj = pointList;
			
			return HttpServletResponse.SC_OK;
		} else {
			logMsg = RetMsgTemplate.MSG_TEMPLATE_NOT_FIND_BY_ID;
			logger.error(logMsg);
			
			resBody.statusMsg = logMsg;
			resBody.obj = pointList;
			
			return HttpServletResponse.SC_NOT_FOUND;
		}
	}
}
