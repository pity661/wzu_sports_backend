package com.wzsport.service;

import java.util.List;

import com.wzsport.model.FixLocationOutdoorSportPoint;
import com.wzsport.util.ResponseBody;

public interface FixLocationOutdoorSportPointService {

	public int create(FixLocationOutdoorSportPoint point, ResponseBody resBody);

	public int show(FixLocationOutdoorSportPoint point, ResponseBody resBody);

	public int update(FixLocationOutdoorSportPoint point, ResponseBody resBody);

	public int index(List<FixLocationOutdoorSportPoint> list, ResponseBody resBody);
	
	public int index(long universityId, List<FixLocationOutdoorSportPoint> list, ResponseBody resBody);

}
