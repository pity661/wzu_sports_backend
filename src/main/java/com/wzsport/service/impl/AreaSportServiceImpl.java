package com.wzsport.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzsport.mapper.AreaSportMapper;
import com.wzsport.model.AreaSport;
import com.wzsport.model.AreaSportExample;
import com.wzsport.service.AreaSportService;
import com.wzsport.util.ResponseBody;
import com.wzsport.util.RetMsgTemplate;

/**
 * RunningActivity Service 实现类.
 *
 * @author x1ny
 * @date 2017年5月26日
 */
@Service
public class AreaSportServiceImpl implements AreaSportService {
	private static final Logger logger = LoggerFactory.getLogger(AreaSportServiceImpl.class);
	
	String logMsg = "";

	@Autowired
	private AreaSportMapper areaSportMapper;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public int create(AreaSport sport, ResponseBody resBody) {
		AreaSportExample example = new AreaSportExample();
		example.createCriteria().andNameEqualTo(sport.getName());
		List<AreaSport> list = areaSportMapper.selectByExample(example);
		if (list.size() > 0) {
			logMsg = RetMsgTemplate.MSG_TEMPLATE_NAME_EXIST.replace("%s", sport.getName());
			logger.error(logMsg);
			
			sport.setId(list.get(0).getId());
			
			resBody.obj = sport;
			resBody.statusMsg = logMsg; 
			
			return HttpServletResponse.SC_CONFLICT;
		} else {
			areaSportMapper.insert(sport);
			
			logMsg = RetMsgTemplate.MSG_TEMPLATE_OPERATION_OK;
			logger.info(logMsg);
			
			resBody.obj = sport;
			resBody.statusMsg = logMsg; 
			
			return HttpServletResponse.SC_OK;
		}
	}

//	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public int update(AreaSport sport) {
		int ret = areaSportMapper.updateByPrimaryKeySelective(sport);
		return ret;
//		AreaSportExample example = new AreaSportExample();
//		example.createCriteria().andNameEqualTo(sport.getName()).andIdNotEqualTo(sport.getId());
//		List<AreaSport> list = areaSportMapper.selectByExample(example);
//		if (list.size() > 0) {
//			logMsg = RetMsgTemplate.MSG_TEMPLATE_NAME_EXIST.replace("%s", sport.getName());
//			logger.error(logMsg);
//			
//			resBody.obj = list.get(0);
//			resBody.statusMsg = logMsg; 
//			
//			return HttpServletResponse.SC_CONFLICT;
//		} else {
//			int result = areaSportMapper.updateByPrimaryKeySelective(sport);
//			if (result > 0) {
//				logMsg = RetMsgTemplate.MSG_TEMPLATE_OPERATION_OK;
//				logger.info(logMsg);
//				
//				resBody.obj = sport;
//				resBody.statusMsg = logMsg; 
//				
//				return HttpServletResponse.SC_OK;
//			} else {
//				logMsg = RetMsgTemplate.MSG_TEMPLATE_NOT_FIND_BY_ID.replace("%s", String.valueOf(sport.getId()));
//				logger.error(logMsg);
//				
//				resBody.obj = null;
//				resBody.statusMsg = logMsg;
//				
//				return HttpServletResponse.SC_NOT_FOUND;
//			}
//		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public int show(AreaSport sport, ResponseBody resBody) {
		AreaSportExample example = new AreaSportExample();
		example.createCriteria().andIdEqualTo(sport.getId());
		List<AreaSport> list = areaSportMapper.selectByExample(example);
		if (list.size() > 0) {
			logMsg = RetMsgTemplate.MSG_TEMPLATE_OPERATION_OK;
			logger.info(logMsg);
			
			resBody.obj = list.get(0);
			resBody.statusMsg = logMsg; 
			
			return HttpServletResponse.SC_OK;
		} else {
			logMsg = RetMsgTemplate.MSG_TEMPLATE_NOT_FIND_BY_ID.replace("%s", String.valueOf(sport.getId()));
			logger.error(logMsg);
			
			resBody.obj = null;
			resBody.statusMsg = logMsg;
			
			return HttpServletResponse.SC_NOT_FOUND;
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public int index(List<AreaSport> areaList, ResponseBody resBody) {
		AreaSportExample example = new AreaSportExample();
		example.createCriteria().andIdNotEqualTo(0l);
		List<AreaSport> list = areaSportMapper.selectByExample(example);
		if (list.size() > 0) {
			logMsg = RetMsgTemplate.MSG_TEMPLATE_OPERATION_OK;
			logger.info(logMsg);
			
			resBody.obj = list;
			resBody.statusMsg = logMsg;
			
			return HttpServletResponse.SC_OK;
		} else {
			logMsg = RetMsgTemplate.MSG_TEMPLATE_NOT_FOUND;
			logger.error(logMsg);
			
			resBody.obj = null;
			resBody.statusMsg = logMsg;
			
			return HttpServletResponse.SC_NOT_FOUND;
		}
	}

}
