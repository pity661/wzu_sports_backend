package com.wzsport.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzsport.mapper.RunningActivityDataMapper;
import com.wzsport.mapper.RunningActivityMapper;
import com.wzsport.model.RunningActivity;
import com.wzsport.model.RunningActivityData;
import com.wzsport.model.RunningActivityDataExample;
import com.wzsport.model.RunningActivityExample;
import com.wzsport.service.RunningActivityService;
import com.wzsport.service.SignInService;
import com.wzsport.service.StudentSportConsumeStatisticService;
import com.wzsport.service.StatisticTaskService;

@Service
public class StatisticTaskServiceImpl implements StatisticTaskService {

	@Autowired
	private RunningActivityDataMapper runningActivityDataMapper;
	@Autowired
	private RunningActivityMapper runningActivityMapper;
	@Autowired
	private RunningActivityService runningActivityService;
	@Autowired
	private StudentSportConsumeStatisticService studentSportConsumeStatisticService;
	@Autowired
	private SignInService signInService;

	private static final Logger logger = LogManager.getLogger(StatisticTaskService.class);

	@Override
	public void runningActivityTask(Date startDate, Date endDate) {
		//找到昨天所有没有正常结束的活动
	    	RunningActivityExample example = new RunningActivityExample();
	    	example.createCriteria().andEndedAtIsNull().andStartTimeBetween(startDate, endDate);
	    	List<RunningActivity> list = runningActivityMapper.selectByExample(example);
	    	int targetFinishedTime = 0;
	    	int distance = 0;
	    	int stepCount = 0;
	    	int costTime = 0;

	    	System.out.println("job list size: " + list.size());

	    	//根据活动数据表最后一条记录来进行统计，把结果写入活动表
	    	for (RunningActivity act : list) {
	    		distance = 0;
	    		stepCount = 0;
	    		costTime = 0;
	    		targetFinishedTime = 0;

	    		RunningActivityDataExample dataExample = new RunningActivityDataExample();
	    		dataExample.createCriteria().andActivityIdEqualTo(act.getId());
	    		dataExample.setOrderByClause("created_at asc");
	    		List<RunningActivityData> runningActivityDataList = runningActivityDataMapper.selectByExample(dataExample);
	    		if (runningActivityDataList.size() > 0) {
		    		for (RunningActivityData data : runningActivityDataList) {
		    			if (data.getDistance() > act.getQualifiedDistance() && targetFinishedTime == 0) {
		    				targetFinishedTime = (int) ((data.getCreatedAt().getTime() - act.getStartTime().getTime()) / 1000);
		    			}
		    		}

		    		distance = runningActivityDataList.get(runningActivityDataList.size() - 1).getDistance();
		    		stepCount = runningActivityDataList.get(runningActivityDataList.size() - 1).getStepCount();
		    		costTime = (int) ((runningActivityDataList.get(runningActivityDataList.size() - 1).getCreatedAt().getTime()
		    				- runningActivityDataList.get(0).getCreatedAt().getTime()) / 1000);
			}

			RunningActivity runningActivity = new RunningActivity();
			runningActivity.setId(act.getId());
			runningActivity.setDistance(distance);
			runningActivity.setStepCount(stepCount);
			runningActivity.setCostTime(costTime);
			runningActivity.setTargetFinishedTime(targetFinishedTime);
			runningActivity.setEndedBy(true);

			try {
				runningActivity = runningActivityService.endRunningActivity(runningActivity);
			} catch (Exception e) {
				logger.error(e);
			}

		}
	}

	@Override
	public void sportConsumeStatisticTask() {
		studentSportConsumeStatisticService.create();
	}

	@Override
	public void signInTask() {
		signInService.create();
	}

}
