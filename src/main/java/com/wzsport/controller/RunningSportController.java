package com.wzsport.controller;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wzsport.model.AreaSport;
import com.wzsport.model.RunningSport;
import com.wzsport.service.RunningSportService;
import com.wzsport.util.FileUtil;
import com.wzsport.util.PathUtil;
import com.wzsport.util.ResponseBody;
import com.wzsport.util.RetMsgTemplate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
* RunningSport Controller.
* 
* @author x1ny
* @date 2017年5月25日
*/
@Api(tags = "跑步项目相关接口")
@RestController
@RequestMapping(value="/runningSports", produces="application/json;charset=UTF-8")
public class RunningSportController {

	@Autowired
	private RunningSportService runningSportService;
	
//	@SuppressWarnings("rawtypes")
//	private ResponseBody resBody;
//	
//	private int status;
	
	/**
	* 更新项目指标
	* 
	* @param id
	* @param qualifiedDistance
	* @param qualifiedCostTime
	* @param minCostTime
	*/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ApiOperation(value = "更新项目指标", notes = "更改指定id的项目的指标")
	@RequestMapping(value="/{id}",method = RequestMethod.POST) 
	public ResponseEntity<?> update(
							@ApiParam("唯一主键id")
							@PathVariable("id") long id,
							@ApiParam("该项目的名称")
							@RequestParam(required=false) String name,
							@ApiParam("该项目是否生效")
							@RequestParam(required=false) Boolean isEnabled,
							@ApiParam("性别")
							@RequestParam(required=false) Boolean isMan,
							@ApiParam("该项目达标的行动距离(单位：米)")
							@RequestParam(required=false) Integer qualifiedDistance,
							@ApiParam("该项目达标的行动时间(单位：秒)")
							@RequestParam(required=false) Integer qualifiedCostTime,
							@ApiParam("该项目的运动数据采样数")
							@RequestParam(required=false) Integer sampleNum,
							@ApiParam("图片") 
							@RequestParam(required = false) MultipartFile image,
							HttpServletRequest request
							) {
		RunningSport runningSport = new RunningSport();
		runningSport.setId(id);
		
		if (name != null) {
			runningSport.setName(name);
		}
		
		if (isEnabled != null) {
			runningSport.setIsEnabled(isEnabled);
		}
		
		if (isMan != null) {
			runningSport.setIsMan(isMan);
		}
		
		//这两个字段要求前端一起提交，否则还需要再查一次数据库
		if (qualifiedDistance != null && qualifiedCostTime != null) {
			runningSport.setQualifiedDistance(qualifiedDistance);
			runningSport.setQualifiedCostTime(qualifiedCostTime);
			
            BigDecimal d = new BigDecimal(qualifiedDistance);
            BigDecimal t = new BigDecimal(qualifiedCostTime);
            BigDecimal v = d.divide(t, 2, RoundingMode.HALF_UP);
            runningSport.setQualifiedVelocity(v);
		}
		
		
		if (sampleNum != null) {
			runningSport.setSampleNum(sampleNum);
			byte acquisitionInterval = (byte) (qualifiedCostTime / sampleNum);
			runningSport.setAcquisitionInterval(acquisitionInterval);
		}
		
		String imagePath = "";
		if (image != null) {
			try {
				imagePath = FileUtil.uploadImage(PathUtil.IMG_STORAGE_PATH, image);
				runningSport.setImgUrl(PathUtil.ORIGIN + File.separator + PathUtil.IMG_FOLDER_PATH + imagePath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		ResponseBody resBody = new ResponseBody<AreaSport>();
		int status = 0;
		try {
			int ret = runningSportService.update(runningSport);
			if (ret > 0) {
				resBody.statusMsg = RetMsgTemplate.MSG_TEMPLATE_OPERATION_OK;
				status = HttpServletResponse.SC_OK;
			} else {
				resBody.statusMsg = RetMsgTemplate.MSG_TEMPLATE_NOT_FOUND;;
				status = HttpServletResponse.SC_NOT_FOUND;
			}
		} catch (Exception e) {
			status = 400;
			e.printStackTrace();
		}
	
		return ResponseEntity.status(status).body(resBody);
	}
	
	/**
	* 更新项目的启用状态
	* 
	* @param id
	* @param isEnabled
	*/
	@ApiOperation(value = "更新项目启用状态", notes = "更改指定id的项目的启动状态，开启或者关闭")
	@RequestMapping(value="/{id}/updateEnable",method = RequestMethod.POST) 
	public ResponseEntity<?> updateEnable(
							@ApiParam("唯一主键id")
							@PathVariable("id") long id,
							@ApiParam("该项目的启用状态,true或者false")
							@RequestParam boolean isEnabled) {
		boolean isSuccess = runningSportService.updateEnable(id, isEnabled);
		if(isSuccess) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@SuppressWarnings("rawtypes")
	@ApiOperation(value = "创建一个跑步运动项目", notes = "创建一个定点运动项目")
	@RequestMapping(value="",method = RequestMethod.POST) 
	public ResponseEntity<?> create(
							@ApiParam("项目名称")
							@RequestParam String name,
							@ApiParam("是否生效")
							@RequestParam boolean isEnabled,
							@ApiParam("性别")
							@RequestParam boolean isMan,
							@ApiParam("该项目达标的行动时间(单位：秒)")
							@RequestParam int qualifiedCostTime,
							@ApiParam("该项目达标距离(单位：米)")
							@RequestParam int qualifiedDistance,
							@ApiParam("每小时消耗热量(单位：大卡)")
							@RequestParam int hourlyKcalConsumption,
							@ApiParam("采样样本数，范围1-120")
							@RequestParam int sampleNum,
							@ApiParam("学校Id")
							@RequestParam long universityId
							) {
		RunningSport sport = new RunningSport();
		sport.setName(name);
		sport.setSampleNum(sampleNum);
		byte acquisitionInterval = (byte) (qualifiedCostTime / sampleNum);
		sport.setAcquisitionInterval(acquisitionInterval);
		sport.setHourlyKcalConsumption(hourlyKcalConsumption);
		sport.setIsEnabled(isEnabled);
		sport.setIsMan(isMan);
		sport.setQualifiedDistance(qualifiedDistance);
		sport.setQualifiedCostTime(qualifiedCostTime);
		
		BigDecimal d = new BigDecimal(qualifiedDistance);
		BigDecimal t = new BigDecimal(qualifiedCostTime);
		BigDecimal v = d.divide(t, 2, RoundingMode.HALF_UP);
		sport.setQualifiedVelocity(v);
		
		sport.setUniversityId(universityId);
		
		ResponseBody resBody = new ResponseBody<RunningSport>();
		int status = runningSportService.create(sport, resBody);
		
		return ResponseEntity.status(status).body(resBody);
	}
}
