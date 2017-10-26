package com.wzsport.service.impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wzsport.mapper.TermMapper;
import com.wzsport.mapper.TermSportsTaskMapper;
import com.wzsport.model.Term;
import com.wzsport.model.TermExample;
import com.wzsport.model.TermSportsTask;
import com.wzsport.model.TermSportsTaskExample;
import com.wzsport.service.TermService;

/**
* Term Service implement
* 
* @author x1ny
* @date 2017年5月28日
*/
@Service
public class TermServiceImpl implements TermService {

	@Autowired
	private TermMapper termMapper;
	@Autowired
	private TermSportsTaskMapper termSportsTaskMapper;
	
	/* (non-Javadoc)
	 * @see com.wzsport.service.TermService#create(com.wzsport.generator.model.Term)
	 */
	@Override
	@Transactional
	public boolean create(Term term) {
		
		int affectedCount = termMapper.insertSelective(term);
		if(affectedCount == 0) {
			throw new RuntimeException("数据库执行失败");
		}
		
		//创建关联的TermSportsTask
		TermSportsTask termSportsTask =  new TermSportsTask();
		termSportsTask.setTermId(term.getId());
		termSportsTask.setTargetSportsTimes(0);
		affectedCount = termSportsTaskMapper.insertSelective(termSportsTask);
		if(affectedCount == 0) {
			throw new RuntimeException("数据库执行失败");
		}
		
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.wzsport.service.TermService#delete(long)
	 */
	@Override
	@Transactional
	public boolean delete(long id) {
		int affectedCount = termMapper.deleteByPrimaryKey(id);
		if(affectedCount == 0) {
			throw new RuntimeException("数据库执行失败");
		}
		
		TermSportsTaskExample termSportsTaskExample = new TermSportsTaskExample();
		termSportsTaskExample.createCriteria().andTermIdEqualTo(id);
		affectedCount = termSportsTaskMapper.deleteByExample(termSportsTaskExample);
		if(affectedCount == 0) {
			throw new RuntimeException("数据库执行失败");
		}
		
		return true;
	}

	
	/* (non-Javadoc)
	 * @see com.wzsport.service.TermService#update(com.wzsport.generator.model.Term)
	 */
	@Override
	public boolean update(Term term) {
		TermExample termExample = new TermExample();
		termExample.createCriteria().andIdEqualTo(term.getId());
		int affectedCount = termMapper.updateByPrimaryKeySelective(term);
		if(affectedCount > 0) {
			return true;
		}
		
		return false;
	}

	/* (non-Javadoc)
	 * @see com.wzsport.service.TermService#getCurrentTerm(long)
	 */
	@Override
	public Term getCurrentTerm(long universityId) {
		Date today = new Date();
		TermExample termExample = new TermExample();
		termExample.createCriteria().andUniversityIdEqualTo(universityId)
									.andStartDateLessThanOrEqualTo(today)
									.andEndDateGreaterThanOrEqualTo(today);
		
		List<Term>  termList = termMapper.selectByExample(termExample);
		
		if(termList.size() != 0) {
			return termList.get(0);
		} 
	
		return null;
	}
}
