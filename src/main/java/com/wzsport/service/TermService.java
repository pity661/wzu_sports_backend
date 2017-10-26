package com.wzsport.service;

import com.wzsport.model.Term;

/**
* Term service interface.
* 
* @author x1ny
* @date 2017年5月28日
*/
public interface TermService {

	/**
	* 新增
	* 
	* @param term
	*/
	boolean create(Term term);
	
	
	/**
	* 根据id删除
	* 
	* @param id
	*/
	boolean delete(long id);
	
	/**
	* 更新
	* 
	* @param term
	*/
	boolean update(Term term);
	
	
	/**
	* 获取某大学的当前学期
	* 
	* @param universityId 大学的id
	*/
	Term getCurrentTerm(long universityId);
}
