package com.wzsport.service.impl;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzsport.mapper.RunningActivityDataMapper;
import com.wzsport.model.RunningActivityData;
import com.wzsport.service.RunningActivityDataService;
import com.wzsport.util.ResponseBody;

@Service
public class RunningActivityDataServiceImpl implements RunningActivityDataService {
	
	static final private String MSG_COMMIT_OK = "数据提交成功";
	static final private String MSG_COMMIT_FAILED = "数据提交失败";

	@Autowired
	private RunningActivityDataMapper runningActivityDataMapper;
	
	/* (non-Javadoc)
	 * @see com.wzsport.service.RunningActivityDataService#create(com.wzsport.model.RunningActivityData)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public int create(RunningActivityData runningActivityData, ResponseBody resBody) {
		int result = runningActivityDataMapper.insertSelective(runningActivityData);
		if (result > 0) {
			resBody.statusMsg = MSG_COMMIT_OK;
			resBody.obj = runningActivityData;
			return HttpServletResponse.SC_CREATED;
		} else {
			resBody.statusMsg = MSG_COMMIT_FAILED;
			resBody.obj = runningActivityData;
			return HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
		}
	}
}
