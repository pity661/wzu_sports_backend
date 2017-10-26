package com.wzsport.controller;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wzsport.model.SportScore;
import com.wzsport.service.SportScoreService;

import io.swagger.annotations.Api;

/**
 * sportScore Controller
 * 
 * @author linhongyong
 * 2017年5月27日
 */
@Api(tags = "体育成绩接口，暂不需要对接")
@RestController
@RequestMapping(value = "/sportScores", produces = "application/json;charset=UTF-8")
public class SportScoreController {
	
	@Autowired
	private SportScoreService sportScoreService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestParam long studentId,
							 	 @RequestParam double meter50SprintTime,
							 	 @RequestParam int meter50SprintScore,
							 	 @RequestParam int standingJumpDistance,
							 	 @RequestParam int standingJumpScore,
							 	 @RequestParam int meter1500RunTime,
							 	 @RequestParam int meter1500RunScore,
							 	 @RequestParam int abdominalCurlCount,
							 	 @RequestParam int abdominalCurlScore){
		SportScore sportScore = new SportScore();
		sportScore.setStudentId(studentId);
		sportScore.setMeter50SprintTime(meter50SprintTime);
		sportScore.setMeter50SprintScore(meter50SprintScore);
		sportScore.setStandingJumpDistance(standingJumpDistance);
		sportScore.setStandingJumpScore(standingJumpScore);
		sportScore.setMeter1500RunTime(meter1500RunTime);
		sportScore.setMeter1500RunScore(meter1500RunScore);
		sportScore.setAbdominalCurlCount(abdominalCurlCount);
		sportScore.setAbdominalCurlScore(abdominalCurlScore);
	
		sportScore.setCreatedAt(new Date());
		
		if(!sportScoreService.create(sportScore)) {
			ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.ok().build();
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public ResponseEntity<?> update( 
			 @PathVariable long id,
			 @RequestParam(required = false) Double meter50SprintTime,
		 	 @RequestParam(required = false) Integer meter50SprintScore,
		 	 @RequestParam(required = false) Integer standingJumpDistance,
		 	 @RequestParam(required = false) Integer standingJumpScore,
		 	 @RequestParam(required = false) Integer meter1500RunTime,
		 	 @RequestParam(required = false) Integer meter1500RunScore,
		 	 @RequestParam(required = false) Integer abdominalCurlCount,
		 	 @RequestParam(required = false) Integer abdominalCurlScore){
		SportScore sportScore = new SportScore();
		sportScore.setId(id);
		sportScore.setMeter50SprintTime(meter50SprintTime);
		sportScore.setMeter50SprintScore(meter50SprintScore);
		sportScore.setStandingJumpDistance(standingJumpDistance);
		sportScore.setStandingJumpScore(standingJumpScore);
		sportScore.setMeter1500RunTime(meter1500RunTime);
		sportScore.setMeter1500RunScore(meter1500RunScore);
		sportScore.setAbdominalCurlCount(abdominalCurlCount);
		sportScore.setAbdominalCurlScore(abdominalCurlScore);
		
		if(!sportScoreService.update(sportScore)) {
			ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.ok().build();
	}

}
