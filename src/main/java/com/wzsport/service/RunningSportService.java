package com.wzsport.service;

import com.wzsport.model.RunningSport;
import com.wzsport.util.ResponseBody;

/**
* RunningSport service interface.
* 
* @author x1ny
* @date 2017年5月25日
*/
public interface RunningSportService {

	/**
	* 修改指定id的项目指标
	* 
	* @param id
	* @param qualifiedDistance 合格距离
	* @param qualifiedCostTime 合格时间
	* @param minCostTime 最少耗时
	* @param acquisitionInterval 运动数据采集间隔
	*/
	boolean updateIndex(long id, int qualifiedDistance, int qualifiedCostTime, int minCostTime, byte acquisitionInterval);
	
	/**
	* 更改指定id的项目的启动状态
	* 
	* @param id
	* @param isEnabled
	*/
	boolean updateEnable(long id, boolean isEnabled);

	@SuppressWarnings("rawtypes")
	int create(RunningSport sport, ResponseBody resBody);

	int update(RunningSport sport);
}
