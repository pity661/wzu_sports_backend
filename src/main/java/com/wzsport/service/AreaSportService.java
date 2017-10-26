package com.wzsport.service;

import java.util.List;

import com.wzsport.model.AreaSport;
import com.wzsport.util.ResponseBody;

public interface AreaSportService {

	int create(AreaSport sport, ResponseBody resBody);

	int update(AreaSport sport);

	int show(AreaSport sport, ResponseBody resBody);

	int index(List<AreaSport> list, ResponseBody resBody);
	
	
	
}
