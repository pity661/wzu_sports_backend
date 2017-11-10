package com.wzsport.graphql;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wzsport.mapper.RunningActivityDataMapper;
import com.wzsport.mapper.RunningActivityMapper;
import com.wzsport.mapper.RunningActivityViewMapper;
import com.wzsport.mapper.RunningSportMapper;
import com.wzsport.mapper.StudentMapper;
import com.wzsport.model.RunningActivity;
import com.wzsport.model.RunningActivityDataExample;
import com.wzsport.model.RunningActivityExample;
import com.wzsport.model.RunningActivityExample.Criteria;
import com.wzsport.model.RunningActivityView;
import com.wzsport.model.RunningActivityViewExample;
import com.wzsport.model.Student;
import com.wzsport.model.StudentExample;

import graphql.Scalars;
import graphql.schema.GraphQLArgument;
import graphql.schema.GraphQLEnumType;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLTypeReference;

/**
* GraphQL RunningActivity类型的定义及查询字段定义
* 
* @author x1ny
* @date 2017年5月26日
*/
@Component
public class RunningActivityType {
	
	private static RunningActivityMapper runningActivityMapper;
	private static RunningActivityViewMapper runningActivityViewMapper;
	private static RunningActivityDataMapper runningActivityDataMapper;
	private static RunningSportMapper runningSportMapper;
	private static StudentMapper studentMapper;
	private static GraphQLObjectType type;
	private static GraphQLFieldDefinition singleQueryField;
	private static GraphQLFieldDefinition listQueryField;
	
	public static enum Operator {
		LESS_THAN, GREATER_THAN, EQUAL, BETWEEN
	}
	
	private static GraphQLEnumType operatorEnumType = GraphQLEnumType.newEnum()
		    .name("Operator")
		    .value(Operator.LESS_THAN.toString())
		    .value(Operator.GREATER_THAN.toString())
		    .value(Operator.EQUAL.toString())
		    .value(Operator.BETWEEN.toString())
		    .build();
	
	private RunningActivityType() {}
	
	public static GraphQLObjectType getType() {
		if(type == null) {
			type = GraphQLObjectType.newObject()
					.name("RunningActivity")
					.description("跑步活动类型")
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("id")
							.description("唯一主键")
							.type(Scalars.GraphQLLong)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("runningSportId")
							.description("该活动关联的项目的ID")
							.type(Scalars.GraphQLLong)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("studentId")
							.description("该活动关联的学生的ID")
							.type(Scalars.GraphQLLong)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("distance")
							.description("活动距离(单位:米)")
							.type(Scalars.GraphQLInt)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("stepCount")
							.description("步数")
							.type(Scalars.GraphQLInt)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("costTime")
							.description("活动耗时(单位:秒)")
							.type(Scalars.GraphQLInt)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("targetFinishedTime")
							.description("达到目标距离的时间(单位:秒)")
							.type(Scalars.GraphQLInt)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("sportDate")
							.description("运动日期")
							.type(Scalars.GraphQLString)
							.dataFetcher(environment ->  {
								RunningActivityView runningActivity = environment.getSource();
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						        return sdf.format(runningActivity.getStartTime());
							} )
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("startTime")
							.description("活动开始时间,时间戳格式(毫秒)")
							.type(Scalars.GraphQLLong)
							.dataFetcher(environment ->  {
								RunningActivityView runningActivity = environment.getSource();
			                	return runningActivity.getStartTime().getTime();
							} )
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("endedAt")
							.description("活动结束时间,时间戳格式(毫秒)")
							.type(Scalars.GraphQLLong)
							.dataFetcher(environment ->  {
								RunningActivityView runningActivity = environment.getSource();
								if (runningActivity.getEndedAt() != null) {
									return runningActivity.getEndedAt().getTime();
								} else {
									return 0;
								}
							} )
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("qualifiedDistance")
							.description("该次活动的合格距离(单位:米)")
							.type(Scalars.GraphQLInt)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("qualifiedCostTime")
							.description("该次活动的合格耗时(单位:秒)")
							.type(Scalars.GraphQLInt)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("minCostTime")
							.description("该次活动的最少耗时(单位:秒)")
							.type(Scalars.GraphQLInt)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("kcalConsumed")
							.description("本次活动的卡路里(大卡)消耗量")
							.type(Scalars.GraphQLInt)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("qualified")
							.description("本次活动是否达标")
							.type(Scalars.GraphQLBoolean)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("isValid")
							.description("本次活动数据是否正常")
							.type(Scalars.GraphQLBoolean)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("speed")
							.description("平均速度")
							.type(Scalars.GraphQLFloat)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("stepPerSecond")
							.description("平均每秒步数")
							.type(Scalars.GraphQLFloat)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("distancePerStep")
							.description("平均步幅")
							.type(Scalars.GraphQLFloat)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("runningSport")
							.description("该活动所属的运动项目")
							.type(RunningSportType.getType())
							.dataFetcher(environment ->  {
								RunningActivityView runningActivity = environment.getSource();
			                	return runningSportMapper.selectByPrimaryKey(runningActivity.getRunningSportId());
							} )
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("student")
							.description("该活动记录所属的学生")
							.type(new GraphQLTypeReference("Student"))
							.dataFetcher(environment ->  {
								RunningActivityView runningActivity = environment.getSource();
			                	return studentMapper.selectByPrimaryKey(runningActivity.getStudentId());
							} )
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("data")
							.description("该活动记录的采集数据")
							.type(new GraphQLList(RunningActivityDataType.getType()))
							.dataFetcher(environment ->  {
								RunningActivityView runningActivity = environment.getSource();
								RunningActivityDataExample example = new RunningActivityDataExample();
								example.createCriteria().andActivityIdEqualTo(runningActivity.getId());
			                	return runningActivityDataMapper.selectByExample(example);
							} )
							.build())
					.build();
		}
		return type;
	}
	
	public static GraphQLFieldDefinition getSingleQueryField() {
		if(singleQueryField == null) {
			singleQueryField = GraphQLFieldDefinition.newFieldDefinition()
	        		.argument(GraphQLArgument.newArgument().name("id").type(Scalars.GraphQLLong).build())
	                .name("runningActivity")
	                .description("根据ID获取跑步活动类型")
	                .type(getType())
	                .dataFetcher(environment ->  {
	                	long id = environment.getArgument("id");
	                	RunningActivity runningActivity = runningActivityMapper.selectByPrimaryKey(id);
	                	return runningActivity;
	                } ).build();
		}
        return singleQueryField;
    }
	
	public static GraphQLFieldDefinition getListQueryField() {
		if(listQueryField == null) {
			listQueryField = GraphQLFieldDefinition.newFieldDefinition()
	        		.argument(GraphQLArgument.newArgument().name("studentId").type(Scalars.GraphQLLong).build())
	                .name("runningActivities")
	                .description("根据学生ID获取相关联的所有跑步活动")
	                .type(new GraphQLList(getType()))
	                .dataFetcher(environment ->  {
	                	long studentId = environment.getArgument("studentId");
	                	RunningActivityExample runningActivityExample = new RunningActivityExample();
	                	runningActivityExample.createCriteria().andStudentIdEqualTo(studentId);
	                	List<RunningActivity> runningActivityList = runningActivityMapper.selectByExample(runningActivityExample);
	                	return runningActivityList;
	                } ).build();
		}
        return listQueryField;
    }
	
	public static GraphQLFieldDefinition getSearchField() {
		return GraphQLFieldDefinition.newFieldDefinition()
		            .argument(GraphQLArgument.newArgument().name("universityId").type(Scalars.GraphQLLong).build())
	        		.argument(GraphQLArgument.newArgument().name("studentName").type(Scalars.GraphQLString).build())
	        		.argument(GraphQLArgument.newArgument().name("studentNo").type(Scalars.GraphQLString).build())
	        		.argument(GraphQLArgument.newArgument().name("startTime").type(Scalars.GraphQLLong).build())
	        		.argument(GraphQLArgument.newArgument().name("endTime").type(Scalars.GraphQLLong).build())
	        		.argument(GraphQLArgument.newArgument().name("runningSportId").type(Scalars.GraphQLLong).build())
	        		.argument(GraphQLArgument.newArgument().name("speed").type(Scalars.GraphQLFloat).build())
	        		.argument(GraphQLArgument.newArgument().name("speedOperator").type(operatorEnumType).build())
	        		.argument(GraphQLArgument.newArgument().name("anotherSpeed").type(Scalars.GraphQLFloat).build())
	        		.argument(GraphQLArgument.newArgument().name("stepPerSecond").type(Scalars.GraphQLFloat).build())
	        		.argument(GraphQLArgument.newArgument().name("stepPerSecondOperator").type(operatorEnumType).build())
	        		.argument(GraphQLArgument.newArgument().name("anotherStepPerSecond").type(Scalars.GraphQLFloat).build())
	        		.argument(GraphQLArgument.newArgument().name("distancePerStep").type(Scalars.GraphQLFloat).build())
	        		.argument(GraphQLArgument.newArgument().name("distancePerStepOperator").type(operatorEnumType).build())
	        		.argument(GraphQLArgument.newArgument().name("anotherDistancePerStep").type(Scalars.GraphQLFloat).build())
	        		.argument(GraphQLArgument.newArgument().name("pageNumber").type(Scalars.GraphQLInt).build())
					.argument(GraphQLArgument.newArgument().name("pageSize").type(Scalars.GraphQLInt).build())
					.argument(GraphQLArgument.newArgument().name("qualified").type(Scalars.GraphQLBoolean).build())
					.argument(GraphQLArgument.newArgument().name("isValid").type(Scalars.GraphQLBoolean).build())
					.type(PageType.getPageTypeBuidler(getType())
														.name("RunningActivityPage")
														.description("活动记录分页")
														.build())
	                .name("searchRunningActivities")
	                .dataFetcher(environment ->  {
	                    Long universityId = environment.getArgument("universityId");
	                    if (universityId == null) {
	                        return null;
	                    }
	                    
	                	RunningActivityViewExample example = new RunningActivityViewExample();
	                	com.wzsport.model.RunningActivityViewExample.Criteria criteria = example.createCriteria();
	                	
	                	criteria.andUniversityIdEqualTo(universityId);
	                	
	                	String studentName = environment.getArgument("studentName");
	                	if (studentName != null) {
	                		StudentExample studentExample =  new StudentExample();
	                		studentExample.createCriteria().andNameLike("%" + studentName + "%");
	                		List<Student> studentList = studentMapper.selectByExample(studentExample);
	                		if(studentList.size() > 0) {
	                			List<Long> studentIdList = new ArrayList<Long>();
		                		for(Student student : studentList) {
		                			studentIdList.add(student.getId());
		                		}
		                		criteria.andStudentIdIn(studentIdList);
	                		} else {
	                			return new Page<>();
	                		}
	                	}
	                	
	                	String studentNo = environment.getArgument("studentNo");
	                	if (studentNo != null) {
	                		StudentExample studentExample =  new StudentExample();
	                		studentExample.createCriteria().andStudentNoLike("%" + studentNo + "%");
	                		List<Student> studentList = studentMapper.selectByExample(studentExample);
	                		if(studentList.size() > 0) {
	                			List<Long> studentIdList = new ArrayList<Long>();
		                		for(Student student : studentList) {
		                			studentIdList.add(student.getId());
		                		}
		                		criteria.andStudentIdIn(studentIdList);
	                		} else {
	                			return new Page<>();
	                		}
	                	}
	                	
	                	Long runningSportId = environment.getArgument("runningSportId");
	                	if (runningSportId != null) {
	                		criteria.andRunningSportIdEqualTo(runningSportId);
	                	}
	                	
	                	Long startTime = environment.getArgument("startTime");
	                	if (startTime != null) {
	                		criteria.andStartTimeGreaterThanOrEqualTo(new Date(startTime));
	                	}
	                	
	                	Long endTime = environment.getArgument("endTime");
	                	if (endTime != null) {
	                		criteria.andStartTimeLessThanOrEqualTo(new Date(endTime));
	                	}
	                	
	                	Double speed = environment.getArgument("speed");
	                	if (speed != null) {
	                		
	                		switch(Operator.valueOf(environment.getArgument("speedOperator"))) {
							case BETWEEN:
								double anotherSpeed = environment.getArgument("anotherSpeed");
								criteria.andSpeedBetween(speed, anotherSpeed);
								break;
							case EQUAL:
								criteria.andSpeedEqualTo(speed);
								break;
							case GREATER_THAN:
								criteria.andSpeedGreaterThanOrEqualTo(speed);
								break;
							case LESS_THAN:
								criteria.andSpeedLessThanOrEqualTo(speed);
								break;
							default:
								break;
	                		}
	                	}
	                	
	                	Double stepPerSecond = environment.getArgument("stepPerSecond");
	                	if (stepPerSecond != null) {
	                		
	                		switch(Operator.valueOf(environment.getArgument("stepPerSecondOperator"))) {
							case BETWEEN:
								double anotherStepPerSecond = environment.getArgument("anotherStepPerSecond");
								criteria.andStepPerSecondBetween(stepPerSecond, anotherStepPerSecond);
								break;
							case EQUAL:
								criteria.andStepPerSecondEqualTo(stepPerSecond);
								break;
							case GREATER_THAN:
								criteria.andStepPerSecondGreaterThanOrEqualTo(stepPerSecond);
								break;
							case LESS_THAN:
								criteria.andStepPerSecondLessThanOrEqualTo(stepPerSecond);
								break;
							default:
								break;
	                		}
	                	}
	                	
	                	Double distancePerStep = environment.getArgument("distancePerStep");
	                	if (distancePerStep != null) {
	                		
	                		switch(Operator.valueOf(environment.getArgument("distancePerStepOperator"))) {
							case BETWEEN:
								double anotherDistancePerStep = environment.getArgument("anotherDistancePerStep");
								criteria.andDistancePerStepBetween(distancePerStep, anotherDistancePerStep);
								break;
							case EQUAL:
								criteria.andDistancePerStepEqualTo(distancePerStep);
								break;
							case GREATER_THAN:
								criteria.andDistancePerStepGreaterThanOrEqualTo(distancePerStep);
								break;
							case LESS_THAN:
								criteria.andDistancePerStepLessThanOrEqualTo(distancePerStep);
								break;
							default:
								break;
	                		}
	                	}
	                	
	                	Boolean qualified = environment.getArgument("qualified");
	                	if (qualified != null) {
	                		criteria.andQualifiedEqualTo(qualified);
	                	}
	                	
	                	Boolean isValid = environment.getArgument("isValid");
	                	if (isValid != null) {
	                		criteria.andIsValidEqualTo(isValid);
	                	}
	                	
	                	Integer pageNumber = environment.getArgument("pageNumber");
	                	if (pageNumber == null) {
	                	    pageNumber = 1;
	                	}
	                	
	                	Integer pageSize = environment.getArgument("pageSize");
	                	if (pageSize == null) {
	                	    pageSize = 10;
	                	}
	                	PageHelper.startPage(pageNumber, pageSize);
	                	example.setOrderByClause("start_time desc");
	                	List<RunningActivityView> list = runningActivityViewMapper.selectByExample(example);
	                	return list;
	                } ).build();
    }

	@Autowired(required = true)
	public void setRunningActivityMapper(RunningActivityMapper runningActivityMapper) {
		RunningActivityType.runningActivityMapper = runningActivityMapper;
	}
	
	@Autowired(required = true)
	public void setRunningSportMapper(RunningSportMapper runningSportMapper) {
		RunningActivityType.runningSportMapper = runningSportMapper;
	}
	
	@Autowired(required = true)
	public void setStudentMapper(StudentMapper studentMapper) {
		RunningActivityType.studentMapper = studentMapper;
	}
	
	@Autowired(required = true)
	public void setRunningActivityDataMapper(RunningActivityDataMapper runningActivityDataMapper) {
		RunningActivityType.runningActivityDataMapper = runningActivityDataMapper;
	}
	
    @Autowired(required = true)
    public void setRunningActivityViewMapper(RunningActivityViewMapper runningActivityViewMapper) {
        RunningActivityType.runningActivityViewMapper = runningActivityViewMapper;
    }
}
