package com.wzsport.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wzsport.model.RunningActivity;
import com.wzsport.service.RunningActivityService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
* RunningActivity Controller.
* 
* @author x1ny
* @date 2017年5月26日
*/
@Api(tags = "RunningActivity相关接口")
@RestController()
@RequestMapping(value = "/runningActivities",produces = "application/json;charset=UTF-8")
public class RunningActivityController {

	@Autowired
	private RunningActivityService runningActivityService;
	
	/**
	* 创建RunningActivity接口
	*/
	@ApiOperation(value = "创建RunningActivity", notes = "向服务端提交一条活动结果数据，服务端对其进行验证后存储至数据库并返回数据。")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<RunningActivity> create(
								@ApiParam("活动项目id，对应RunningSport的id")
								@RequestParam long runningSportId,
								@ApiParam("学生id") 
								@RequestParam long studentId,
								@ApiParam("活动距离(单位:米)")
								@RequestParam int distance,
								@ApiParam("运动步数累计")
								@RequestParam int stepCount,
								@ApiParam("活动耗时(单位:秒)")
								@RequestParam int costTime,
								@ApiParam("完成项目指标耗时(单位:秒),比如该项目目标距离为1000米，则需要提交此次活动距离达到1000米的耗时")
								@RequestParam int targetFinishedTime,
								@ApiParam("活动开始的时间(使用时间戳格式)")
								@RequestParam Long startTime) {
		
		RunningActivity runningActivity = new RunningActivity();
		runningActivity.setRunningSportId(runningSportId);
		runningActivity.setStudentId(studentId);
		runningActivity.setDistance(distance);
		runningActivity.setStepCount(stepCount);
		runningActivity.setCostTime(costTime);
		runningActivity.setTargetFinishedTime(targetFinishedTime);
		runningActivity.setStartTime(new Date(startTime));
		
		runningActivity = runningActivityService.create(runningActivity);
		return ResponseEntity.ok().body(runningActivity); 
	}
	
	/**
	* 开始活动接口
	*/
	@ApiOperation(value = "开始跑步活动", notes = "开始跑步活动")
	@RequestMapping(value = "/start", method = RequestMethod.POST)
	public ResponseEntity<RunningActivity> start(
								@ApiParam("活动项目id,目前仅对应RunningSport的id")
								@RequestParam long runningSportId,
								@ApiParam("学生id") 
								@RequestParam long studentId,
								@ApiParam("活动开始的时间(使用时间戳格式)")
								@RequestParam Long startTime) {
		
		RunningActivity runningActivity = runningActivityService.startRunningActivity(studentId, runningSportId, new Date(startTime));
		
		return ResponseEntity.ok().body(runningActivity); 
	}
	
	/**
	* 创建RunningActivity接口
	*/
	@ApiOperation(value = "结束活动", notes = "结束活动")
	@RequestMapping(value = "/end", method = RequestMethod.POST)
	public ResponseEntity<RunningActivity> end(
								@ApiParam("活动id")
								@RequestParam long id,
								@ApiParam("活动项目id，对应RunningSport的id")
								@RequestParam(required = false) Long runningSportId,
								@ApiParam("活动距离(单位:米)")
								@RequestParam int distance,
								@ApiParam("运动步数累计")
								@RequestParam int stepCount,
								@ApiParam("活动耗时(单位:秒)")
								@RequestParam int costTime,
								@ApiParam("完成项目指标耗时(单位:秒),比如该项目目标距离为1000米，则需要提交此次活动距离达到1000米的耗时")
								@RequestParam int targetFinishedTime) {
		
		RunningActivity runningActivity = new RunningActivity();
		runningActivity.setId(id);
		
		if (runningSportId != null) {
		    runningActivity.setEndRunningSportId(runningSportId);
		}
		runningActivity.setDistance(distance);
		runningActivity.setStepCount(stepCount);
		runningActivity.setCostTime(costTime);
		runningActivity.setTargetFinishedTime(targetFinishedTime);
		
		runningActivity = runningActivityService.endRunningActivity(runningActivity);
		
		return ResponseEntity.ok().body(runningActivity); 
	}
}
