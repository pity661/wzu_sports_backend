package com.wzsport.timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.wzsport.service.StudentSportConsumeStatisticService;

@Component
public class StudentSportConsumeStatisticTask {
	@Autowired
	private StudentSportConsumeStatisticService studentSportConsumeStatisticService;

	@Scheduled(cron = "0 0 1 * * ?")
//	@Scheduled(cron = "*/5 * * * * ?")

    public void job() {
		studentSportConsumeStatisticService.create();
    }
}
