package com.wzsport.controller;

import java.util.Date;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wzsport.service.StatisticTaskService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Task相关接口")
@RestController
@RequestMapping(value="/statisticTasks",produces="application/json;charset=UTF-8")
public class StatisticTasksController {
	@Autowired
	private StatisticTaskService taskService;

	@ApiOperation(value = "调用跑步运动的统计任务", notes = "调用跑步运动的统计任务")
	@RequestMapping(value="/runningActivityTask", method = RequestMethod.GET)
	public ResponseEntity<?> runningActiviy(@ApiParam("活动开始时间") @RequestParam(required = false) Date startDate,
	        @ApiParam("活动结束时间") @RequestParam(required = false) Date endDate) {
	    
	    if (startDate == null) {
	        DateTime dt = new DateTime(0);
	        startDate = dt.toDate();
	    }
	    
	    if (endDate == null) {
	        DateTime now = new DateTime();
	        endDate = now.withTimeAtStartOfDay().toDate();
	    }
		try {
			taskService.runningActivityTask(startDate, endDate);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@RequestMapping(value="/sportConsumeStatistic", method = RequestMethod.GET)
	public ResponseEntity<?> sportConsumeStatistic() {
		try {
			taskService.sportConsumeStatisticTask();
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@RequestMapping(value="/signIn", method = RequestMethod.GET)
	public ResponseEntity<?> signIn() {
		try {
			taskService.signInTask();
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
