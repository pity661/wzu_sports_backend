package com.wzsport.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzsport.mapper.TermSportsTaskMapper;
import com.wzsport.model.TermSportsTask;
import com.wzsport.service.TermSportsTaskService;

/**
* TermSportsTask service implement
* 
* @author x1ny
* @date 2017年5月28日
*/
@Service
public class TermSportsTaskServiceImpl implements TermSportsTaskService {

	@Autowired
	private TermSportsTaskMapper termSportsTaskMapper;
	

	/* (non-Javadoc)
	 * @see com.wzsport.service.TermSportsTaskService#update(com.wzsport.model.TermSportsTask)
	 */
	@Override
	public boolean update(TermSportsTask termSportsTask) {
		int affectedCount = termSportsTaskMapper.updateByPrimaryKeySelective(termSportsTask);
		if(affectedCount > 0) {
			return true;
		}
		
		return false;
	}
}
