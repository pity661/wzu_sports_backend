package com.wzsport.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzsport.mapper.SportScoreMapper;
import com.wzsport.model.SportScore;
import com.wzsport.service.SportScoreService;

/**
* SportScoreService 实现类
* 
* @author x1ny
* @date 2017年6月6日
*/
@Service
public class SportScoreServiceImpl implements SportScoreService {

	@Autowired
	private SportScoreMapper sportScoreMapper;
	
	@Override
	public boolean create(SportScore sportScore) {
		int affectedCount = sportScoreMapper.insertSelective(sportScore);
		if(affectedCount > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(SportScore sportScore) {
		int affectedCount = sportScoreMapper.updateByPrimaryKeySelective(sportScore);
		if(affectedCount > 0) {
			return true;
		}
		return false;
	}

}

