package com.wzsport.service;

import com.wzsport.model.SportScore;

/**
 * SportScore Service
 * @author linhongyong
 * 2017年5月27日
 */
public interface SportScoreService {
	
	
	/**
	 * 创建保存体育成绩
	 * @param sportScore 体育成绩对象
	 * @return
	 */
	boolean create(SportScore sportScore);
	
	/**
	 * 根据id去更新一条记录
	 * @param id
	 * @param sportScore
	 * @return
	 */
	boolean update(SportScore sportScore);
	
	
}
