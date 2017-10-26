package com.wzsport.service;

import java.util.Date;

public interface StatisticTaskService {
	public void runningActivityTask(Date startDate, Date endDate);

	public void sportConsumeStatisticTask();

	public void signInTask();
}
