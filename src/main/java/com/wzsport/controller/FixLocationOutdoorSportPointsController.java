package com.wzsport.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wzsport.model.FixLocationOutdoorSportPoint;
import com.wzsport.service.FixLocationOutdoorSportPointService;
import com.wzsport.service.RunningActivityDataService;
import com.wzsport.service.RunningSportService;
import com.wzsport.util.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
* FixLocationOutdoorSportPoints Controller.
* 
* @author x1ny
* @date 2017年5月25日
*/
@Api(tags = "定点室外运动点相关接口")
@RestController
//@RequestMapping(value="/fixLocationOutdoorSportPoints", produces="application/json;charset=UTF-8")
public class FixLocationOutdoorSportPointsController {
	
	/** The res body. */
	@SuppressWarnings("rawtypes")
//	private ResponseBody resBody;
//	
//	private int status;
	
	private static final Logger logger = LoggerFactory.getLogger(FixLocationOutdoorSportPointsController.class);
	
	@Autowired
	private FixLocationOutdoorSportPointService fixLocationSportPointService;

	/**
	* 更新项目指标
	* 
	* @param id
	* @param qualifiedDistance
	* @param qualifiedCostTime
	* @param minCostTime
	*/
	@SuppressWarnings("rawtypes")
	@ApiOperation(value = "创建一个室外定点活动点", notes = "使用POST来创建一个新的室外活动地点，这个时候对父一级目录进行请求，由服务端来分配创建一个新资源")
	@RequestMapping(value = "/fixLocationOutdoorSportPoints", method = RequestMethod.POST, produces="application/json;charset=UTF-8") 
	public ResponseEntity<?> create(
						@ApiParam("活动点名称")
						@RequestParam String name,
							@ApiParam("纬度")
							@RequestParam BigDecimal latitude,
							@ApiParam("经度")
							@RequestParam BigDecimal longitude,
							@ApiParam("定点活动区域的半径（米）")
							@RequestParam Integer radius,
							@ApiParam("达标时间")
							@RequestParam int qualifiedCostTime,
							@ApiParam("定点活动区域的地址")
							@RequestParam String addr,
							@ApiParam("是否生效")
							@RequestParam boolean isEnabled,
							@ApiParam("学校Id")
							@RequestParam long universityId,
							@ApiParam("对该地点的描述")
							@RequestParam String description
							) {
		FixLocationOutdoorSportPoint point = new FixLocationOutdoorSportPoint();
		point.setName(name);
		point.setLatitude(latitude);
		point.setLongitude(longitude);
		point.setRadius(radius);
		point.setQualifiedCostTime(qualifiedCostTime);
		point.setAddr(addr);
		point.setIsEnabled(isEnabled);
		point.setUniversityId(universityId);
		point.setDescription(description);
		
		ResponseBody resBody = new ResponseBody<FixLocationOutdoorSportPoint>();
		
		int status = fixLocationSportPointService.create(point, resBody);
		
		return ResponseEntity.status(status).body(resBody);
	}
	
	@SuppressWarnings("rawtypes")
	@ApiOperation(value = "获取一个室外定点活动点", notes = "根据Id来获取一个活动点")
	@RequestMapping(value = "/fixLocationOutdoorSportPoints/{id}", method = RequestMethod.GET, produces="application/json;charset=UTF-8") 
	public ResponseEntity<?> show(
							@PathVariable long id
							) {
		FixLocationOutdoorSportPoint point = new FixLocationOutdoorSportPoint();
		point.setId(id);
		
		ResponseBody resBody = new ResponseBody<FixLocationOutdoorSportPoint>();
		
		int status = fixLocationSportPointService.show(point, resBody);
		
		return ResponseEntity.status(status).body(resBody);
	}
	
	@SuppressWarnings("rawtypes")
	@ApiOperation(value = "更新一个室外定点活动点", notes = "根据Id来更新一个活动点")
	@RequestMapping(value = "/fixLocationOutdoorSportPoints/{id}", method = RequestMethod.POST, produces="application/json;charset=UTF-8") 
	public ResponseEntity<?> update(
								@ApiParam("id")
								@PathVariable long id,
								@ApiParam("活动点名称")
								@RequestParam String name,
								@ApiParam("纬度")
								@RequestParam BigDecimal latitude,
								@ApiParam("经度")
								@RequestParam BigDecimal longitude,
								@ApiParam("定点活动区域的半径（米）")
								@RequestParam Integer radius,
								@ApiParam("达标时间")
								@RequestParam int qualifiedCostTime,
								@ApiParam("定点活动区域的地址")
								@RequestParam String addr,
								@ApiParam("对该地点的描述")
								@RequestParam String description,
								@ApiParam("达标时间")
								@RequestParam boolean isEnabled,
								@ApiParam("学校Id")
								@RequestParam long universityId
							) {
		FixLocationOutdoorSportPoint point = new FixLocationOutdoorSportPoint();
		point.setId(id);
		point.setName(name);
		point.setLatitude(latitude);
		point.setLongitude(longitude);
		point.setRadius(radius);
		point.setQualifiedCostTime(qualifiedCostTime);
		point.setAddr(addr);
		point.setDescription(description);
		point.setIsEnabled(isEnabled);
		point.setUniversityId(universityId);
		
		ResponseBody resBody = new ResponseBody<FixLocationOutdoorSportPoint>();
		
		int status = fixLocationSportPointService.update(point, resBody);
		
		return ResponseEntity.status(status).body(resBody);	
	}
	
	@SuppressWarnings("rawtypes")
	@ApiOperation(value = "获取室外定点活动点列表", notes = "")
	@RequestMapping(value = "/fixLocationOutdoorSportPoints", method = RequestMethod.GET, produces="application/json;charset=UTF-8") 
	public ResponseEntity<?> index(HttpServletResponse response) {
		List<FixLocationOutdoorSportPoint> list = new ArrayList<FixLocationOutdoorSportPoint>();
		
		ResponseBody resBody = new ResponseBody<FixLocationOutdoorSportPoint>();
		
		int status = fixLocationSportPointService.index(list, resBody);
		
		return ResponseEntity.status(status).body(resBody);	
	}
	
	@SuppressWarnings("rawtypes")
	@ApiOperation(value = "获取室外定点活动点列表", notes = "")
	@RequestMapping(value = "/universities/{id}/FixLocationOutdoorSportPoints", method = RequestMethod.GET, produces="application/json;charset=UTF-8") 
	public ResponseEntity<?> index(
								@ApiParam("学校Id")
								@PathVariable long id) {
		List<FixLocationOutdoorSportPoint> list = new ArrayList<FixLocationOutdoorSportPoint>();
		
		ResponseBody resBody = new ResponseBody<FixLocationOutdoorSportPoint>();
		
		int status = fixLocationSportPointService.index(id, list, resBody);
		
		return ResponseEntity.status(status).body(resBody);	
	}
}
