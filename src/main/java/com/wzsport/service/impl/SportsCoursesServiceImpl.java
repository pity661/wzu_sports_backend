/**
 * 
 */
package com.wzsport.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzsport.mapper.SportsCourseMapper;
import com.wzsport.model.SportsCourse;
import com.wzsport.model.SportsCourseExample;
import com.wzsport.service.SportsCoursesService;

/**
 * @author wenky
 *
 */
@Service
public class SportsCoursesServiceImpl implements SportsCoursesService {
	@Autowired
	private SportsCourseMapper sportsCourseMapper;

	/* (non-Javadoc)
	 * @see com.wzsport.service.SportsCoursesService#updateSportsCourse(com.wzsport.model.SportsCourse)
	 */
	@Override
	public void updateSportsCourse(SportsCourse sportsCourse) {
		// TODO Auto-generated method stub
		SportsCourseExample sportsCourseExample = new SportsCourseExample();
		sportsCourseExample.createCriteria().andUniversityIdEqualTo(sportsCourse.getUniversityId())
			.andStudentNoEqualTo(sportsCourse.getStudentNo())
			.andSchoolYearEqualTo(sportsCourse.getSchoolYear())
			.andTermEqualTo(sportsCourse.getTerm());
		
		if (sportsCourseMapper.selectByExample(sportsCourseExample).size() == 0) {
			sportsCourseMapper.insert(sportsCourse);
		} else {
			sportsCourse.setId(sportsCourseMapper.selectByExample(sportsCourseExample).get(0).getId());
			sportsCourseMapper.updateByPrimaryKey(sportsCourse);
		}
	}
}
