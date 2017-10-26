package com.wzsport.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzsport.mapper.FitnessCheckDataMapper;
import com.wzsport.model.FitnessCheckData;
import com.wzsport.service.FitnessCheckDataService;
import com.wzsport.util.BmiUtil;

@Service
public class FitnessCheckDataServiceImpl implements FitnessCheckDataService {

	@Autowired
	private FitnessCheckDataMapper fitnessCheckDataMapper;
	
	@Override
	public FitnessCheckData create(FitnessCheckData fitnessCheckData) {
		//计算BMI
		if(fitnessCheckData.getBmi() == null){
			float bmi = BmiUtil.calculateBmi(fitnessCheckData.getWeight(), fitnessCheckData.getHeight());
			fitnessCheckData.setBmi((double)bmi);
		}
		fitnessCheckDataMapper.insertSelective(fitnessCheckData);
		return fitnessCheckData;
	}

	@Override
	public FitnessCheckData update(FitnessCheckData fitnessCheckData) {
		float bmi = BmiUtil.calculateBmi(fitnessCheckData.getWeight(), fitnessCheckData.getHeight());
		fitnessCheckData.setBmi((double)bmi);
		fitnessCheckDataMapper.updateByPrimaryKeySelective(fitnessCheckData);
		return fitnessCheckData;
	}
}
