package com.wzsport.timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.wzsport.service.SignInService;

@Component
public class SignInTask {
	@Autowired
	private SignInService signInService;

	@Scheduled(cron = "0 0 3 * * ?")
//	@Scheduled(cron = "*/5 * * * * ?")

    public void job() {
		signInService.create();
    }
}
