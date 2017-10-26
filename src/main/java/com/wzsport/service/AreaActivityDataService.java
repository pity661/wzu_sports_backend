package com.wzsport.service;

import com.wzsport.model.AreaActivityData;
import com.wzsport.util.ResponseBody;

public interface AreaActivityDataService {

	/**
	* 提交运动采集数据
	*/
	@SuppressWarnings("rawtypes")
	int create(AreaActivityData areaActivityData, ResponseBody resBody);
}
