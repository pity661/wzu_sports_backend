package com.wzsport.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wzsport.model.SportDataValidateRule;
import com.wzsport.service.SportDataValidateService;
import com.wzsport.util.ResponseBody;
import com.wzsport.util.RetMsgTemplate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "设置异常运动指标相关接口")
@RestController
@RequestMapping(value="/sportDataValidateRules", produces="application/json;charset=UTF-8")
public class SportDataValidateRuleController {
	
	static final String CREATE_OK_MSG = "创建运动指标成功";
	static final String UPDATE_OK_MSG = "更新运动指标成功";
	
	@Autowired
	SportDataValidateService sportDataValidateService;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ApiOperation(value = "创建一个异常运动指标", notes = "创建一个异常运动指标")
	@RequestMapping(value="",method = RequestMethod.POST) 
	public ResponseEntity<?> create(@ApiParam("步幅") @RequestParam(required=false) Double distancePerStep,
							@ApiParam("速度") @RequestParam(required=false) Double speed) {
		SportDataValidateRule rule = new SportDataValidateRule();
		
		if (distancePerStep == null && speed == null) {
			return null;
		}
		
		if (distancePerStep != null) {
			rule.setDistancePerStep(distancePerStep);
		}
		
		if (speed != null) {
			rule.setSpeed(speed);
		}
		
		ResponseBody resBody = new ResponseBody<SportDataValidateRule>();
		int status = 0;
		int ret = sportDataValidateService.create(rule);
		if (ret > 0) {
			resBody.statusMsg = CREATE_OK_MSG;
			status = HttpServletResponse.SC_CREATED;
		} else {
			status = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
		}
		
		return ResponseEntity.status(status).body(resBody);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ApiOperation(value = "更新一个异常运动指标", notes = "更新一个异常运动指标")
	@RequestMapping(value="/{id}",method = RequestMethod.POST) 
	public ResponseEntity<?> update(@ApiParam("唯一主键id") @PathVariable("id") Long id,
							@ApiParam("步幅") @RequestParam(required=false) Double distancePerStep,
							@ApiParam("速度") @RequestParam(required=false) Double speed) {
		SportDataValidateRule rule = new SportDataValidateRule();
		rule.setId(id);
		
		if (distancePerStep == null && speed == null) {
			return null;
		}
		
		if (distancePerStep != null) {
			rule.setDistancePerStep(distancePerStep);
		}
		
		if (speed != null) {
			rule.setSpeed(speed);
		}
		
		ResponseBody resBody = new ResponseBody<SportDataValidateRule>();
		int status = 0;
		int ret = sportDataValidateService.update(rule);
		if (ret > 0) {
			resBody.statusMsg = UPDATE_OK_MSG;
			status = HttpServletResponse.SC_OK;
		} else {
			status = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
		}
		
		return ResponseEntity.status(status).body(resBody);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ApiOperation(value = "获取所有运动指标", notes = "获取所有运动指标")
	@RequestMapping(value="",method = RequestMethod.GET) 
	public ResponseEntity<?> index() {
		ResponseBody resBody = new ResponseBody<SportDataValidateRule>();
		int status = 0;
		List<SportDataValidateRule> list = sportDataValidateService.index();
		if (list.size() > 0) {
			resBody.statusMsg = RetMsgTemplate.MSG_TEMPLATE_OPERATION_OK;
			resBody.obj = list;
			status = HttpServletResponse.SC_OK;
		} else {
			status = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
		}
		
		return ResponseEntity.status(status).body(resBody);
	}

}
