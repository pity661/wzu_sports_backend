package com.wzsport.service.impl;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzsport.mapper.AreaActivityDataMapper;
import com.wzsport.model.AreaActivityData;
import com.wzsport.service.AreaActivityDataService;
import com.wzsport.util.ResponseBody;
import com.wzsport.util.RetMsgTemplate;

@Service
public class AreaActivityDataServiceImpl implements AreaActivityDataService {

	@Autowired
	private AreaActivityDataMapper areaActivityDataMapper;
	
	private String logMsg = "";
	
	private static final Logger logger = LoggerFactory.getLogger(AreaActivityDataServiceImpl.class);
	
	/* (non-Javadoc)
	 * @see com.wzsport.service.RunningActivityDataService#create(com.wzsport.model.RunningActivityData)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public int create(AreaActivityData areaActivityData, ResponseBody resBody) {
		areaActivityDataMapper.insertSelective(areaActivityData);
		
		logMsg = RetMsgTemplate.MSG_TEMPLATE_OPERATION_OK;
		logger.info(logMsg);
		
		resBody.statusMsg = logMsg;
		resBody.obj = areaActivityData;
		
		return HttpServletResponse.SC_OK;
	}
}
