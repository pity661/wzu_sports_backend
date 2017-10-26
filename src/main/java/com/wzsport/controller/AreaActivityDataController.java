package com.wzsport.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wzsport.model.AreaActivityData;
import com.wzsport.service.AreaActivityDataService;
import com.wzsport.service.AreaActivityService;
import com.wzsport.util.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "AreaActivityData相关接口")
@RestController
@RequestMapping(value="/areaActivityData",produces="application/json;charset=UTF-8")
public class AreaActivityDataController {
	
	private static final Logger logger = LoggerFactory.getLogger(AreaActivityDataController.class);
	
	@Autowired
	private AreaActivityDataService areaActivityDataService;
	
	@Autowired
	private AreaActivityService areaActivityService;
	
	/** The res body. */
	@SuppressWarnings("rawtypes")
//	private ResponseBody resBody;
//	
//	private int status;
	
	@ApiOperation(value = "创建AreaActivityData", notes = "向服务端提交运动的采集数据")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(
								@ApiParam("活动id")
								@RequestParam Long activityId,
								@ApiParam("是否正常")
								@RequestParam Boolean isNormal,
								@ApiParam("当前的经度")
								@RequestParam Double longitude,
								@ApiParam("当前的纬度")
								@RequestParam Double latitude,
								@ApiParam("定位类型")
								@RequestParam int locationType) {
		if (!areaActivityService.isActivityExist(activityId)) {
			logger.error("activityId 不存在。");
			return null;
		}
		
		AreaActivityData areaActivityData = new AreaActivityData();
		
		areaActivityData.setActivityId(activityId);
		areaActivityData.setAcquisitionTime(new Date());
		areaActivityData.setIsNormal(isNormal);
		areaActivityData.setLongitude(longitude);
		areaActivityData.setLatitude(latitude);
		areaActivityData.setLocationType(locationType);
		
		ResponseBody resBody = new ResponseBody<AreaActivityData>();
		int status = areaActivityDataService.create(areaActivityData, resBody);
		
		return ResponseEntity.status(status).body(resBody);
	}
}
