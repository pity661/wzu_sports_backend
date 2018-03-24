/**
 * 
 */
package com.wzsport.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzsport.mapper.PhysicalTestMapper;
import com.wzsport.mapper.SportsCourseMapper;
import com.wzsport.model.PhysicalTest;
import com.wzsport.model.PhysicalTestExample;
import com.wzsport.model.SportsCourse;
import com.wzsport.model.SportsCourseExample;
import com.wzsport.service.PhysicalTestService;

/**
 * @author wenky
 *
 */
@Service
public class PhysicalTestServiceImpl implements PhysicalTestService {


	@Autowired
	private PhysicalTestMapper physicalTestMapper;
	
	@Autowired
	private SportsCourseMapper sportsCourseMapper;
	/* (non-Javadoc)
	 * @see com.wzsport.service.PhysicalTestService#updatePhysicalTest(com.wzsport.model.PhysicalTest)
	 */
	@Override
	public void updatePhysicalTest(PhysicalTest physicalTest) {
		// TODO Auto-generated method stub
		PhysicalTestExample physicalTestExample = new PhysicalTestExample();
		physicalTestExample.createCriteria()
			.andUniversityIdEqualTo(physicalTest.getUniversityId())
			.andStudentNoEqualTo(physicalTest.getStudentNo())
			.andYearEqualTo(physicalTest.getYear());
		if (physicalTestMapper.selectByExample(physicalTestExample).size() == 0) {
			physicalTestMapper.insert(physicalTest);
			//插入该学生的教学班级
			SportsCourseExample sportsCourseExample = new SportsCourseExample();
			sportsCourseExample.createCriteria()
				.andUniversityIdEqualTo(physicalTest.getUniversityId())
				.andStudentNoEqualTo(physicalTest.getStudentNo())
				.andYearEqualTo(physicalTest.getYear());
			if (sportsCourseMapper.selectByExample(sportsCourseExample).size() == 0) {
				SportsCourse sportsCourse = new SportsCourse();
				sportsCourse.setIsMan(physicalTest.getIsMan());
				sportsCourse.setCollegeName(physicalTest.getCollegeName());
				sportsCourse.setUniversityId(physicalTest.getUniversityId());
				sportsCourse.setSchoolYear(physicalTest.getSchoolYear());
				sportsCourse.setTerm(physicalTest.getTerm());
				sportsCourse.setStudentNo(physicalTest.getStudentNo());
				sportsCourse.setStudentName(physicalTest.getStudentName());
				sportsCourse.setMajorName(physicalTest.getClassName());
				sportsCourse.setYear(physicalTest.getYear());
				sportsCourseMapper.insert(sportsCourse);
			}
		} else {
			//存在就更新所有信息
			physicalTest.setId(physicalTestMapper.selectByExample(physicalTestExample).get(0).getId());
			physicalTestMapper.updateByPrimaryKey(physicalTest);
		}
	}
	
}
