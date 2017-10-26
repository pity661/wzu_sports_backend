package com.wzsport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wzsport.service.MockDataService;

import io.swagger.annotations.Api;

@Api(tags = "模拟数据生成接口")
@RestController
@RequestMapping(value="/mockData",produces="application/json;charset=UTF-8")
public class MockDataController {

	@Autowired
	private MockDataService mockDataService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> mockData() {
		boolean result = mockDataService.mockData();
		if(result) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
