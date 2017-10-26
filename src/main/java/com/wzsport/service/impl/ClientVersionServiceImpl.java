package com.wzsport.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzsport.mapper.ClientVersionMapper;
import com.wzsport.model.ClientVersion;
import com.wzsport.model.ClientVersionExample;
import com.wzsport.service.ClientVersionService;
import com.wzsport.util.ResponseBody;
import com.wzsport.util.RetMsgTemplate;

@Service
public class ClientVersionServiceImpl implements ClientVersionService {
	
	private static final Logger logger = LoggerFactory.getLogger(ClientVersionServiceImpl.class);
	
	String logMsg = "";

	@Autowired
	private ClientVersionMapper clientVersionMapper;
	
	@Override
	public ClientVersion getLatestVersionInfo(byte platformId) {
		return clientVersionMapper.getLasetVersionInfo(platformId);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public int create(ClientVersion info, ResponseBody resBody) {
		try {
			int count = clientVersionMapper.insertSelective(info);
			if (count > 0) {
				logMsg = RetMsgTemplate.MSG_TEMPLATE_OPERATION_OK;
				logger.info(logMsg);
				
				resBody.obj = info;
				resBody.statusMsg = logMsg;
				
				return HttpServletResponse.SC_CREATED;
			} else {
				//TODO 如何获得错误？返回什么？
	//			logMsg = RetMsgTemplate.MSG_TEMPLATE_OPERATION_OK;
	//			logger.info(logMsg);
	//			
	//			resBody.obj = info;
	//			resBody.statusMsg = logMsg;
	//			
				return HttpServletResponse.SC_OK;
			}
		} catch (Exception e) {
			resBody.obj = info;
			resBody.statusMsg = RetMsgTemplate.MSG_TEMPLATE_RECORD_EXIST;
			
			System.out.println(e.getMessage());
			logger.error(e.getMessage());
			return HttpServletResponse.SC_CONFLICT;
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public int update(ClientVersion info, ResponseBody resBody) {
		int count = clientVersionMapper.updateByPrimaryKeySelective(info);
		if (count > 0) {
			logMsg = RetMsgTemplate.MSG_TEMPLATE_OPERATION_OK;
			logger.info(logMsg);
			
			resBody.obj = info;
			resBody.statusMsg = logMsg;
			
			return HttpServletResponse.SC_OK;
		} else {
			logMsg = RetMsgTemplate.MSG_TEMPLATE_NOT_FIND_BY_ID;
			logger.info(logMsg);
			
			resBody.obj = info;
			resBody.statusMsg = logMsg;
			
			return HttpServletResponse.SC_NOT_FOUND;
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public int index(List<ClientVersion> list, ResponseBody resBody) {
		ClientVersionExample example = new ClientVersionExample();
		example.createCriteria().andIdGreaterThan(0L);
		example.setOrderByClause("version_code desc");
		
		list = clientVersionMapper.selectByExample(example);
		
		logMsg = RetMsgTemplate.MSG_TEMPLATE_OPERATION_OK;
		logger.info(logMsg);
		
		resBody.obj = list;
		resBody.statusMsg = logMsg;
		
		return HttpServletResponse.SC_OK;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public int read(ClientVersion info, ResponseBody resBody) {
		ClientVersionExample example = new ClientVersionExample();
		example.createCriteria().andIdEqualTo(info.getId());
		
		List<ClientVersion> list = clientVersionMapper.selectByExample(example);
		if (list.size() == 0) {
			logMsg = RetMsgTemplate.MSG_TEMPLATE_NOT_FIND_BY_ID.replace("%s", String.valueOf(info.getId()));
			logger.info(logMsg);
			
			resBody.obj = null;
			resBody.statusMsg = logMsg;
			
			return HttpServletResponse.SC_NOT_FOUND;
		} else {
		
			logMsg = RetMsgTemplate.MSG_TEMPLATE_OPERATION_OK;
			logger.info(logMsg);
			
			resBody.obj = list.get(0);
			resBody.statusMsg = logMsg;
			
			return HttpServletResponse.SC_OK;
		}
	}

}
