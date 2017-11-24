package com.wzsport.graphql;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.wzsport.mapper.PhysicalTestMapper;
import com.wzsport.mapper.SportsCourseMapper;
import com.wzsport.mapper.UpdatePhysicalTestRecordMapper;
import com.wzsport.mapper.UserMapper;
import com.wzsport.model.PhysicalTest;
import com.wzsport.model.SportsCourse;
import com.wzsport.model.SportsCourseExample;
import com.wzsport.model.UpdatePhysicalTestRecord;
import com.wzsport.model.User;
import com.wzsport.model.SportsCourseExample.Criteria;

import graphql.Scalars;
import graphql.schema.GraphQLArgument;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLObjectType;

@Component
public class PhysicalTestType {
	private static GraphQLObjectType type;
	private static GraphQLFieldDefinition singleQueryField;
	private static PhysicalTestMapper physicalTestMapper;
	private static UserMapper userMapper;
	private static SportsCourseMapper sportsCourseMapper;
	private static UpdatePhysicalTestRecordMapper updatePhysicalTestRecordMapper;
	private static DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public PhysicalTestType() {}
	
	public static GraphQLObjectType getType() {
		if(type == null) {
			type = GraphQLObjectType.newObject()
					.name("PhysicalTest")
					.description("完整体测数据类型")
					.field(GraphQLFieldDefinition.newFieldDefinition().name("id").description("唯一主键")
							.type(Scalars.GraphQLLong).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("gradeNo").description("年级编号")
							.type(Scalars.GraphQLLong).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("studentName").description("学生姓名")
							.type(Scalars.GraphQLString).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("classNo").description("班级编号")
							.type(Scalars.GraphQLLong).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("className").description("班级名称")
							.type(Scalars.GraphQLString).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("collegeName").description("学院名称")
							.type(Scalars.GraphQLString).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("isMan").description("性别")
							.type(Scalars.GraphQLBoolean).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("studentNo").description("学号")
							.type(Scalars.GraphQLString).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("totalScore").description("总分")
							.type(Scalars.GraphQLFloat).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("height").description("身高")
							.type(Scalars.GraphQLFloat).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("weight").description("体重")
							.type(Scalars.GraphQLFloat).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("vitalCapacity").description("肺活量")
							.type(Scalars.GraphQLLong).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("standingLongJump").description("立定跳远")
							.type(Scalars.GraphQLInt).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("sitAndReach").description("坐位体前屈")
							.type(Scalars.GraphQLFloat).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("oneMinuteSitUp").description("仰卧起坐")
							.type(Scalars.GraphQLInt).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("pullUp").description("引体向上")
							.type(Scalars.GraphQLInt).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("fiftyRunTime").description("50米跑成绩")
							.type(Scalars.GraphQLFloat).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("eightHundredRunTime").description("800米跑成绩")
							.type(Scalars.GraphQLFloat).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("oneThousandRunTime").description("1000米跑成绩")
							.type(Scalars.GraphQLFloat).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("result").description("修改或新增结果")
							.type(Scalars.GraphQLBoolean).build())
					.build();
		}
		return type;
	}
	
	
	public static GraphQLFieldDefinition getSingleQueryField(){
		if(singleQueryField == null) {
			singleQueryField = GraphQLFieldDefinition.newFieldDefinition()
	        		.argument(GraphQLArgument.newArgument().name("id").type(Scalars.GraphQLLong).build())
	        		.argument(GraphQLArgument.newArgument().name("universityId").type(Scalars.GraphQLLong).build())
	        		.argument(GraphQLArgument.newArgument().name("studentName").type(Scalars.GraphQLString).build())
	        		.argument(GraphQLArgument.newArgument().name("studentNo").type(Scalars.GraphQLString).build())
	        		.argument(GraphQLArgument.newArgument().name("isMan").type(Scalars.GraphQLInt).build())
	        		.argument(GraphQLArgument.newArgument().name("collegeName").type(Scalars.GraphQLString).build())
	        		.argument(GraphQLArgument.newArgument().name("className").type(Scalars.GraphQLString).build())
	        		.argument(GraphQLArgument.newArgument().name("height").type(Scalars.GraphQLFloat).build())
	        		.argument(GraphQLArgument.newArgument().name("weight").type(Scalars.GraphQLFloat).build())
	        		.argument(GraphQLArgument.newArgument().name("vitalCapacity").type(Scalars.GraphQLLong).build())
	        		.argument(GraphQLArgument.newArgument().name("standingLongJump").type(Scalars.GraphQLInt).build())
	        		.argument(GraphQLArgument.newArgument().name("sitAndReach").type(Scalars.GraphQLFloat).build())
	        		.argument(GraphQLArgument.newArgument().name("oneMinuteSitUp").type(Scalars.GraphQLInt).build())
	        		.argument(GraphQLArgument.newArgument().name("pullUp").type(Scalars.GraphQLInt).build())
	        		.argument(GraphQLArgument.newArgument().name("fiftyRunTime").type(Scalars.GraphQLFloat).build())
	        		.argument(GraphQLArgument.newArgument().name("eightHundredRunTime").type(Scalars.GraphQLFloat).build())
	        		.argument(GraphQLArgument.newArgument().name("oneThousandRunTime").type(Scalars.GraphQLFloat).build())
	        		.argument(GraphQLArgument.newArgument().name("remarks").type(Scalars.GraphQLString).build())
	        		.argument(GraphQLArgument.newArgument().name("userName").type(Scalars.GraphQLString).build())
	        		.argument(GraphQLArgument.newArgument().name("courseTime").type(Scalars.GraphQLString).build())
	        		.argument(GraphQLArgument.newArgument().name("courseName").type(Scalars.GraphQLString).build())
	        		.argument(GraphQLArgument.newArgument().name("teacherName").type(Scalars.GraphQLString).build())
	        		.argument(GraphQLArgument.newArgument().name("term").type(Scalars.GraphQLInt).build())
	        		.argument(GraphQLArgument.newArgument().name("schoolYear").type(Scalars.GraphQLString).build())
	                .name("addOrAlterPhysicalTest")
	                .description("修改或新增体测记录")
	                .type(getType())
	                .dataFetcher(environment ->  {
	                	Integer isMan = environment.getArgument("isMan");
	                	Long id = environment.getArgument("id");
	                	Long universityId = environment.getArgument("universityId");
	                	String studentName = environment.getArgument("studentName");
	                	String studentNo = environment.getArgument("studentNo");
	                	String collegeName = environment.getArgument("collegeName");
	                	String className = environment.getArgument("className");
	                	Double height = environment.getArgument("height");
	                	Double weight = environment.getArgument("weight");
	                	Long vitalCapacity = environment.getArgument("vitalCapacity");
	                	Integer standingLongJump = environment.getArgument("standingLongJump");
	                	Double sitAndReach = environment.getArgument("sitAndReach");
	                	Integer oneMinuteSitUp = environment.getArgument("oneMinuteSitUp");
	                	Integer pullUp = environment.getArgument("pullUp");
	                	Double fiftyRunTime = environment.getArgument("fiftyRunTime");
	                	Double eightHundredRunTime = environment.getArgument("eightHundredRunTime");
	                	Double oneThousandRunTime = environment.getArgument("oneThousandRunTime");
	                	String remarks = environment.getArgument("remarks");
	                	String userName = environment.getArgument("userName");              	
	                	String schoolYear = environment.getArgument("schoolYear");
	                	Integer term = environment.getArgument("term");
	                	String teacherName = environment.getArgument("teacherName");
	                	String courseName = environment.getArgument("courseName");
	                	String courseTime = environment.getArgument("courseTime");
	                	
	                	PhysicalTest physicalTest = new PhysicalTest();
	                	if (id != null) {	//修改
	                		physicalTest = physicalTestMapper.selectByPrimaryKey(id);
	                	} else {	//新增
	                		if (schoolYear != null && term != null && studentNo != null) {
	                			SportsCourseExample example = new SportsCourseExample();
	                			Criteria criteria = example.createCriteria();
	                			criteria.andSchoolYearEqualTo(schoolYear);
	                			physicalTest.setSchoolYear(schoolYear);
	                			criteria.andTermEqualTo(term);
	                			physicalTest.setTerm(term);
	                			criteria.andStudentNoEqualTo(studentNo);
	                			List<SportsCourse> list = sportsCourseMapper.selectByExample(example);
	                			if (list.size() == 0) {
	                				SportsCourse sportsCourse = new SportsCourse();
	                				sportsCourse.setSchoolYear(schoolYear);
	                				sportsCourse.setTerm(term);
	                				sportsCourse.setStudentNo(studentNo);
	                				if (collegeName != null) {
		                				sportsCourse.setCollegeName(collegeName);
	                				}
	                				if (className != null) {
	                					sportsCourse.setMajorName(className);
	                				}
	                				if (universityId != null) {
		                				sportsCourse.setUniversityId(universityId);
	                				}
	                				if (teacherName != null) {
	                					sportsCourse.setTeacherName(teacherName);
	                				}
	                				if (courseName != null) {
	                					sportsCourse.setCourseName(courseName);
	                				}
	                				if (courseTime != null) {
	                					sportsCourse.setCourseTime(courseTime);
	                				}
	                				if (studentName != null) {
	                					sportsCourse.setStudentName(studentName);
	                				}
	                				if (isMan != null) {
	                					if (isMan == 0) {
		                					sportsCourse.setIsMan(false);
	                					} else {
	                						sportsCourse.setIsMan(true);
	                					}
	                				}
	                				sportsCourseMapper.insert(sportsCourse);
	                			} else {
	                				physicalTest.setResult(false);
	                				return physicalTest;
	                			}
	                		}
	                	}
	                	if (universityId != null) {
	                		physicalTest.setUniversityId(universityId);
	                	}
	                	if (studentName != null) {
                			physicalTest.setStudentName(studentName);
                		}
                		if (studentNo != null) {
                			physicalTest.setStudentNo(studentNo);
                		}
                		if (collegeName != null) {
                			physicalTest.setCollegeName(collegeName);
                		}
                		if (className != null) {
                			physicalTest.setClassName(className);
                		}
                		if (height != null) {
                			physicalTest.setHeight(height);
                		}
                		if (weight != null) {
                			physicalTest.setWeight(weight);
                		}
                		if (vitalCapacity != null) {
                			physicalTest.setVitalCapacity(vitalCapacity);
                		}
                		if (standingLongJump != null) {
                			physicalTest.setStandingLongJump(standingLongJump);
                		}
                		if (sitAndReach != null) {
                			physicalTest.setSitAndReach(sitAndReach);
                		}	
                		if (fiftyRunTime != null) {
                			physicalTest.setFiftyRunTime(fiftyRunTime);
                		}
	                	//女生
	                	if (isMan == 0) {
	                		physicalTest.setIsMan(false);
	                		if (oneMinuteSitUp != null) {
	                			physicalTest.setOneMinuteSitUp(oneMinuteSitUp);
	                		}
	                		if (eightHundredRunTime != null) {
	                			physicalTest.setEightHundredRunTime(eightHundredRunTime);
	                		}
	                	}
	                	//男生
	                	if (isMan == 1){
	                		physicalTest.setIsMan(true);
	                		if (pullUp != null) {
	                			physicalTest.setPullUp(pullUp);
	                		}
	                		if (oneThousandRunTime != null) {
	                			physicalTest.setOneThousandRunTime(oneThousandRunTime);
	                		}
	                	}
	                	int result = 0;
	                	if (id != null){
		                	result = physicalTestMapper.updateByPrimaryKey(physicalTest);
	                	} else {
	                		result = physicalTestMapper.insert(physicalTest);
	                	}
	                	if (result == 1) {
	                		User user = userMapper.selectWithRolesByUsername(userName);
	                		UpdatePhysicalTestRecord updatePhysicalTestRecord = new UpdatePhysicalTestRecord();
	                		if (id == null) {
	                			id = (long) physicalTestMapper.getMaxId();
	                			updatePhysicalTestRecord.setIsAlter(false);
	                		} else {
	                			updatePhysicalTestRecord.setIsAlter(true);
	                		}
	                		updatePhysicalTestRecord.setPhysicalTestId(id);
	                		updatePhysicalTestRecord.setAlterUserId(user.getId());
	                		updatePhysicalTestRecord.setAlterUserName(userName);
	                		Date date = new Date();
	                		Timestamp ts = Timestamp.valueOf(sdf.format(date));
	                		updatePhysicalTestRecord.setAlterTime(ts);
	                		if (remarks != null) {
	                			updatePhysicalTestRecord.setRemarks(remarks);
	                		}
	                		if (updatePhysicalTestRecordMapper.insert(updatePhysicalTestRecord) == 1) {
	                			physicalTest.setResult(true);
	                		} else {
	                			physicalTest.setResult(false);
	                		}
	                	} else {
	                		physicalTest.setResult(false);
	                	}
	                	return physicalTest;
	                } ).build();
		}
        return singleQueryField;
	}
	
	@Autowired(required = true)
	public void setPhysicalTestMapper(PhysicalTestMapper physicalTestMapper) {
		PhysicalTestType.physicalTestMapper = physicalTestMapper;
	}
	
	@Autowired(required = true)
	public void setUserMapper(UserMapper userMapper) {
		PhysicalTestType.userMapper = userMapper;
	}
	
	@Autowired(required = true)
	public void setUpdatePhysicalTestRecordMapper(UpdatePhysicalTestRecordMapper updatePhysicalTestRecordMapper) {
		PhysicalTestType.updatePhysicalTestRecordMapper = updatePhysicalTestRecordMapper;
	}

	@Autowired(required = true)
	public void setSportsCourseMapper(SportsCourseMapper sportsCourseMapper) {
		PhysicalTestType.sportsCourseMapper = sportsCourseMapper;
	}
	
	
	
}
