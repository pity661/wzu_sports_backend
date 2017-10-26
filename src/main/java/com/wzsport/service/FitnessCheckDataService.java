package com.wzsport.service;

import com.wzsport.model.FitnessCheckData;

/**
 * 体测成绩Service Interface
 * @author Watermelon_R(ljf)
 * 2017年5月26日
 */
public interface FitnessCheckDataService {
	
	
	/**
	 * 创建保存体测成绩
	 * @param fitnessCheckData 体测成绩对象
	 * @return
	 */
	FitnessCheckData create(FitnessCheckData fitnessCheckData);
	
	/**
	 * 根据id去更新一条记录
	 * @param id
	 * @param fitnessCheckData
	 * @return
	 */
	FitnessCheckData update(FitnessCheckData fitnessCheckData);
	
	
}
