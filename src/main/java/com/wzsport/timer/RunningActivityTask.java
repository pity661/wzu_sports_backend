package com.wzsport.timer;

import java.util.Date;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.wzsport.service.StatisticTaskService;



@Component
public class RunningActivityTask {
	@Autowired
	private StatisticTaskService taskService;

	@Scheduled(cron = "0 0 1 * * ?")
//	@Scheduled(cron = "*/5 * * * * ?")
    public void job() {
        DateTime dt = new DateTime(0);
        Date startDate = dt.toDate();
        
        DateTime now = new DateTime();
        Date endDate = now.withTimeAtStartOfDay().toDate();
	        
		taskService.runningActivityTask(startDate, endDate);
    }
}
