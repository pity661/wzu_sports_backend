package com.wzsport.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzsport.mapper.SportDataValidateRuleMapper;
import com.wzsport.model.RunningActivity;
import com.wzsport.model.SportDataValidateRule;
import com.wzsport.model.SportDataValidateRuleExample;
import com.wzsport.service.SportDataValidateService;

@Service
public class SportDataValidateServiceImpl implements SportDataValidateService{

	static final Byte VALIDATE_MODE_RAPID = 0;
	static final Byte VALIDATE_MODE_COMPLETE = 1;

	@Autowired
	private SportDataValidateRuleMapper sportDataValidataRuleMapper;

	@Override
	public boolean rapidValidateForRunningActivity(RunningActivity runningActivity) {

		SportDataValidateRuleExample example = new SportDataValidateRuleExample();
		example.or().andValidateModeEqualTo(VALIDATE_MODE_RAPID);

		List<SportDataValidateRule> list = sportDataValidataRuleMapper.selectByExample(example);

		//当前设计，只有一条规则
		if (list.size() > 0) {
			SportDataValidateRule rule = list.get(0);
			if (Double.compare(rule.getSpeed(), 0.0) != 0) {
				if (Double.compare(runningActivity.getSpeed(), rule.getSpeed()) > 0) {
					return false;
				}
			}
			if (Double.compare(rule.getDistancePerStep(), 0.0) != 0) {
				if (Double.compare(runningActivity.getDistancePerStep(), rule.getDistancePerStep()) > 0) {
					return false;
				} else if (Double.compare(runningActivity.getDistancePerStep(), 0.0) == 0) {//步数判断暂时注释掉
					return false;
				}
			}
		}

		return true;

	}

	@Override
	public int create(SportDataValidateRule rule) {
		int ret = sportDataValidataRuleMapper.insertSelective(rule);
		return ret;
	}

	@Override
	public int update(SportDataValidateRule rule) {
		int ret = sportDataValidataRuleMapper.updateByPrimaryKeySelective(rule);
		return ret;
	}

	@Override
	public List<SportDataValidateRule> index() {
		List<SportDataValidateRule> list = sportDataValidataRuleMapper.selectByExample(null);
		return list;
	}

}
