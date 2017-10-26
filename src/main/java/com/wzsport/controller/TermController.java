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

import com.wzsport.model.Term;
import com.wzsport.service.TermService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
* Term Controller.
* 
* @author x1ny
* @date 2017年5月28日
*/
@Api(tags = "Term(学期)相关接口")
@RestController
@RequestMapping(value="/terms",produces="application/json;charset=UTF-8")
public class TermController {
	
	@Autowired
	private TermService termService;
	
	/**
	* 创建term接口
	*/
	@ApiOperation(value = "创建term", notes = "创建一个学期并自动创建一个相关联学期任务TermSportTask")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(
									@ApiParam("学期名，如'2016~2017学期'")
									@RequestParam String name,
									@ApiParam("对应的大学的id")
									@RequestParam long universityId,
									@ApiParam("学期开始时间(请使用时间戳格式)")
									@RequestParam long startDate,
									@ApiParam("学期结束时间(请使用时间戳格式)")
									@RequestParam long endDate) {
		
		Term term = new Term();
		term.setUniversityId(universityId);
		term.setName(name);
		term.setStartDate(new Date(startDate));
		term.setEndDate(new Date(endDate));
		if(!termService.create(term)) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.ok().build();
	}

	/**
	* 更新term接口
	*/
	@ApiOperation(value = "更新term", notes = "更新学期")
	@RequestMapping(value="/{id}", method = RequestMethod.POST)
	public ResponseEntity<?> update(
									@ApiParam("学期名，如'2016~2017学期'")
									@RequestParam String name,
									@ApiParam("学期开始时间(请使用时间戳格式)")
									@RequestParam long startDate,
									@ApiParam("学期结束时间(请使用时间戳格式)")
									@RequestParam long endDate,
									@ApiParam("唯一主键id")
									@PathVariable long id) {
		Term term = new Term();
		term.setId(id);
		term.setName(name);
		term.setStartDate(new Date(startDate));
		term.setEndDate(new Date(endDate));
		if(!termService.update(term)) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.ok().build();
	}
	
	/**
	* 删除term接口
	*/
	@ApiOperation(value = "删除term", notes = "删除学期")
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@ApiParam("唯一主键id") @PathVariable int id) {
		if(!termService.delete(id)) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.ok().build();
	}
}
