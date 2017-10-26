package com.wzsport.service;

import com.wzsport.model.RunningActivityData;
import com.wzsport.util.ResponseBody;

public interface RunningActivityDataService {

	/**
	* 提交运动采集数据
	*/
	@SuppressWarnings("rawtypes")
	int create(RunningActivityData runningActivityData, ResponseBody resBody);
}
