/**
 * 
 */
package com.wzsport.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wzsport.graphql.RunningActivityType.Operator;
import com.wzsport.mapper.RunningActivityViewMapper;
import com.wzsport.model.RunningActivityView;
import com.wzsport.model.RunningActivityViewExample;
import com.wzsport.model.RunningActivityViewExample.Criteria;
import com.wzsport.service.ExportService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author wenky
 *
 */
@Api(tags = "导出运动记录相关接口")
@RestController()
@RequestMapping(value = "/exportRecodeDate",produces = "application/json;charset=UTF-8")
public class ExportRecodeDateController {
	@Autowired
	private ExportService exportService;
	
	@Autowired
	private RunningActivityViewMapper runningActivityViewMapper;
	
	@ApiOperation(value = "导出ExportRecodeDate", notes = "根据用户输入的筛选条件导出运动记录到excel")
	@RequestMapping(value = "", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
	public ResponseEntity<?> export(
								@RequestParam(required = false) Long universityId,
								@RequestParam(required = false) String studentName,
								@RequestParam(required = false) String studentNo,
								@RequestParam(required = false) Long startTime,
								@RequestParam(required = false) Long endTime,
								@RequestParam(required = false) Long runningSportId,
								@RequestParam(required = false) Boolean isValid,
								@RequestParam(required = false) Boolean qualified,
								@RequestParam(required = false) String speedOperator,
								@RequestParam(required = false) Double speed,
								@RequestParam(required = false) Double anotherSpeed,
								@RequestParam(required = false) String stepPerSecondOperator,
								@RequestParam(required = false) Double stepPerSecond,
								@RequestParam(required = false) Double anotherStepPerSecond,
								@RequestParam(required = false) String distancePerStepOperator,
								@RequestParam(required = false) Double distancePerStep,
								@RequestParam(required = false) Double anotherDistancePerStep
							){
		RunningActivityViewExample example = new RunningActivityViewExample();
		Criteria criteria = example.createCriteria();
		criteria.andUniversityIdEqualTo(universityId);
		if (studentName != null) {
			try {
				studentName = URLDecoder.decode(studentName, "utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(studentName);
			criteria.andNameLike("%" + studentName + "%");
		}
		if (studentNo != null) {
			System.out.println(studentNo);
			criteria.andStudentNoLike("%" + studentNo + "%");
		}
		if (startTime != null) {
			criteria.andStartTimeGreaterThanOrEqualTo(new Date(startTime));
		}
		if (endTime != null) {
    		criteria.andEndedAtLessThanOrEqualTo(new Date(endTime));
    	}
		if (runningSportId != null) {
    		criteria.andRunningSportIdEqualTo(runningSportId);
    	}
		if (isValid != null) {
    		criteria.andIsValidEqualTo(isValid);
    	}
		if (qualified != null) {
    		criteria.andQualifiedEqualTo(qualified);
    	}
		//EQUALL GREATER_THAN BETWEEN LESS_THAN
		if (speed != null) {
			switch (speedOperator) {
				case "BETWEEN":
					criteria.andSpeedBetween(speed, anotherSpeed);
					break;
				case "EQUAL":
					criteria.andSpeedEqualTo(speed);
					break;
				case "GREATER_THAN":
					criteria.andSpeedGreaterThanOrEqualTo(speed);
					break;
				case "LESS_THAN":
					criteria.andSpeedLessThanOrEqualTo(speed);
					break;
				default:
					break;	
			}
		}
		if (stepPerSecond != null) {
			switch (stepPerSecondOperator) {
				case "BETWEEN":
					criteria.andStepPerSecondBetween(stepPerSecond, anotherStepPerSecond);
					break;
				case "EQUAL":
					criteria.andStepPerSecondEqualTo(stepPerSecond);
					break;
				case "GREATER_THAN":
					criteria.andStepPerSecondGreaterThanOrEqualTo(stepPerSecond);
					break;
				case "LESS_THAN":
					criteria.andStepPerSecondLessThanOrEqualTo(stepPerSecond);
					break;
				default:
					break;	
			}
		}
		if (distancePerStep != null) {
			switch(distancePerStepOperator) {
				case "BETWEEN":
					criteria.andDistancePerStepBetween(distancePerStep, anotherDistancePerStep);
					break;
				case "EQUAL":
					criteria.andDistancePerStepEqualTo(distancePerStep);
					break;
				case "GREATER_THAN":
					criteria.andDistancePerStepGreaterThanOrEqualTo(distancePerStep);
					break;
				case "LESS_THAN":
					criteria.andDistancePerStepLessThanOrEqualTo(distancePerStep);
					break;
				default:
					break;
    		}
		}
		List<RunningActivityView> lists = runningActivityViewMapper.selectByExample(example);
		String excelName = exportService.createExcelByRunningActivityViews(lists);
		return ResponseEntity.status(HttpServletResponse.SC_OK).body(excelName);
	}
}
