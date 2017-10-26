package com.wzsport.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzsport.mapper.RunningSportMapper;
import com.wzsport.model.RunningSport;
import com.wzsport.model.RunningSportExample;
import com.wzsport.service.RunningSportService;
import com.wzsport.util.ResponseBody;
import com.wzsport.util.RetMsgTemplate;

@Service
public class RunningSportServiceImpl implements RunningSportService {
	private static final Logger logger = LoggerFactory.getLogger(RunningSportServiceImpl.class);
	
	private String logMsg = "";

	@Autowired
	private RunningSportMapper runningSportMapper;
	
	@Override
	public boolean updateIndex(long id, int qualifiedDistance, int qualifiedCostTime, int minCostTime, byte acquisitionInterval) {
		RunningSport runningSport = new RunningSport();
		runningSport.setId(id);
		runningSport.setQualifiedCostTime(qualifiedCostTime);
		runningSport.setQualifiedDistance(qualifiedDistance);
		runningSport.setAcquisitionInterval(acquisitionInterval);
		
		int affectedCount = runningSportMapper.updateByPrimaryKeySelective(runningSport);
		if(affectedCount > 0) {
			return true;
		}
		
		return false;
	}
	
//	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public int update(RunningSport runningSport) {
		int ret = runningSportMapper.updateByPrimaryKeySelective(runningSport);
		return ret;
		
//		RunningSportExample example = new RunningSportExample();
//		example.createCriteria().andIdNotEqualTo(runningSport.getId()).andNameEqualTo(runningSport.getName());
//		List<RunningSport> list = runningSportMapper.selectByExample(example);
//		if (list.size() > 0) {
//			logMsg = RetMsgTemplate.MSG_TEMPLATE_NAME_EXIST.replace("%s", runningSport.getName());
//			logger.error(logMsg);
//			
//			resBody.obj = list.get(0);
//			resBody.statusMsg = logMsg; 
//			
//			return HttpServletResponse.SC_CONFLICT;
//		} else {
//			int result = runningSportMapper.updateByPrimaryKeySelective(runningSport);
//			if (result > 0) {	
//				logMsg = RetMsgTemplate.MSG_TEMPLATE_OPERATION_OK;
//				logger.info(logMsg);
//				
//				resBody.obj = runningSport;
//				resBody.statusMsg = logMsg; 
//				
//				return HttpServletResponse.SC_OK;
//			} else {
//				logMsg = RetMsgTemplate.MSG_TEMPLATE_NOT_FIND_BY_ID.replace("%s", String.valueOf(runningSport.getId()));
//				logger.error(logMsg);
//				
//				resBody.obj = null;
//				resBody.statusMsg = logMsg;
//				
//				return HttpServletResponse.SC_NOT_FOUND;
//			}
//		}
	}

	@Override
	public boolean updateEnable(long id, boolean isEnabled) {
		RunningSport runningSport = new RunningSport();
		runningSport.setId(id);
		runningSport.setIsEnabled(isEnabled);
		
		int affectedCount = runningSportMapper.updateByPrimaryKeySelective(runningSport);
		if(affectedCount > 0) {
			return true;
		}
		
		return false;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public int create(RunningSport sport, ResponseBody resBody) {
		RunningSportExample example = new RunningSportExample();
		example.createCriteria().andNameEqualTo(sport.getName());
		List<RunningSport> list = runningSportMapper.selectByExample(example);
		if (list.size() > 0) {
			logMsg = RetMsgTemplate.MSG_TEMPLATE_NAME_EXIST.replace("%s", sport.getName());
			logger.error(logMsg);
			
			sport.setId(list.get(0).getId());
			
			resBody.obj = sport;
			resBody.statusMsg = logMsg; 
			
			return HttpServletResponse.SC_CONFLICT;
		} else {
			runningSportMapper.insert(sport);
			
			logMsg = RetMsgTemplate.MSG_TEMPLATE_OPERATION_OK;
			logger.info(logMsg);
			
			resBody.obj = sport;
			resBody.statusMsg = logMsg; 
			
			return HttpServletResponse.SC_OK;
		}
	}
}
