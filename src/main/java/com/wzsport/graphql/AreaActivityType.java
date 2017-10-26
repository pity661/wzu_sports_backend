package com.wzsport.graphql;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wzsport.mapper.AreaActivityDataMapper;
import com.wzsport.mapper.AreaActivityMapper;
import com.wzsport.mapper.AreaSportMapper;
import com.wzsport.mapper.FixLocationOutdoorSportPointMapper;
import com.wzsport.mapper.StudentMapper;
import com.wzsport.model.AreaActivity;
import com.wzsport.model.AreaActivityDataExample;
import com.wzsport.model.AreaActivityExample;
import com.wzsport.model.AreaActivityExample.Criteria;
import com.wzsport.model.FixLocationOutdoorSportPoint;
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
* GraphQL AreaActivity类型的定义及查询字段定义
* 
*/
@Component
public class AreaActivityType {
	
	private static AreaActivityMapper areaActivityMapper;
	private static AreaActivityDataMapper areaActivityDataMapper;
	private static AreaSportMapper AreaSportMapper;
	private static StudentMapper studentMapper;
	private static FixLocationOutdoorSportPointMapper fixLocationOutdoorSportPointMapper;
	private static GraphQLObjectType type;
	private static GraphQLFieldDefinition singleQueryField;
	private static GraphQLFieldDefinition listQueryField;
	
	public static enum Operator {
		LESS_THAN, GREATER_THAN, EQUALL, BETWEEN
	}
	
	private static GraphQLEnumType operatorEnumType = GraphQLEnumType.newEnum()
		    .name("Operator")
		    .value(Operator.LESS_THAN.toString())
		    .value(Operator.GREATER_THAN.toString())
		    .value(Operator.EQUALL.toString())
		    .value(Operator.BETWEEN.toString())
		    .build();
	
	private AreaActivityType() {}
	
	public static GraphQLObjectType getType() {
		if(type == null) {
			type = GraphQLObjectType.newObject()
					.name("AreaActivity")
					.description("区域运动活动类型")
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("id")
							.description("唯一主键")
							.type(Scalars.GraphQLLong)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("studentId")
							.description("学生的ID")
							.type(Scalars.GraphQLLong)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("areaSportId")
							.description("该活动关联的区域运动的Id")
							.type(Scalars.GraphQLLong)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
                            .name("locationId")
                            .description("运动场所的Id")
                            .type(Scalars.GraphQLLong)
                            .build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
                            .name("location")
                            .description("运动场所信息")
                            .type(FixLocationOutdoorSportPointType.getType())
                            .dataFetcher(environment -> {
                                AreaActivity areaActivity = environment.getSource();
                                FixLocationOutdoorSportPoint point = fixLocationOutdoorSportPointMapper.selectByPrimaryKey(areaActivity.getLocationId());
                                return point;
                            })
                            .build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("costTime")
							.description("活动消耗时间,时间戳格式(毫秒)")
							.type(Scalars.GraphQLInt)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("sportDate")
							.description("运动日期")
							.type(Scalars.GraphQLString)
							.dataFetcher(environment ->  {
								AreaActivity areaActivity = environment.getSource();
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						        return sdf.format(areaActivity.getStartTime());
							} )
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("startTime")
							.description("活动开始时间,时间戳格式(毫秒)")
							.type(Scalars.GraphQLLong)
							.dataFetcher(environment ->  {
								AreaActivity AreaActivity = environment.getSource();
			                	return AreaActivity.getStartTime().getTime();
							} )
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("kcalConsumed")
							.description("本次活动的卡路里(大卡)消耗量")
							.type(Scalars.GraphQLInt)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("endedAt")
							.description("活动结束时间,时间戳格式(毫秒)")
							.type(Scalars.GraphQLLong)
							.dataFetcher(environment ->  {
								AreaActivity AreaActivity = environment.getSource();
								if (AreaActivity.getEndedAt() != null) {
									return AreaActivity.getEndedAt().getTime();
								} else {
									return 0;
								}
							} )
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("qualifiedCostTime")
							.description("该次活动的合格耗时(单位:秒)")
							.type(Scalars.GraphQLInt)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("qualified")
							.description("本次活动是否达标")
							.type(Scalars.GraphQLBoolean)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("areaSport")
							.description("该活动所属的运动项目")
							.type(AreaSportType.getType())
							.dataFetcher(environment ->  {
								AreaActivity AreaActivity = environment.getSource();
			                	return AreaSportMapper.selectByPrimaryKey(AreaActivity.getAreaSportId());
							} )
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("student")
							.description("该活动记录所属的学生")
							.type(new GraphQLTypeReference("Student"))
							.dataFetcher(environment ->  {
								AreaActivity AreaActivity = environment.getSource();
			                	return studentMapper.selectByPrimaryKey(AreaActivity.getStudentId());
							} )
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("data")
							.description("该活动记录的采集数据")
							.type(new GraphQLList(AreaActivityDataType.getType()))
							.dataFetcher(environment ->  {
								AreaActivity AreaActivity = environment.getSource();
								AreaActivityDataExample example = new AreaActivityDataExample();
								example.createCriteria().andActivityIdEqualTo(AreaActivity.getId());
			                	return areaActivityDataMapper.selectByExample(example);
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
	                .name("areaActivity")
	                .description("根据ID获取区域运动活动类型")
	                .type(getType())
	                .dataFetcher(environment ->  {
	                	long id = environment.getArgument("id");
	                	AreaActivity areaActivity = areaActivityMapper.selectByPrimaryKey(id);
	                	return areaActivity;
	                } ).build();
		}
        return singleQueryField;
    }
	
	public static GraphQLFieldDefinition getListQueryField() {
		if(listQueryField == null) {
			listQueryField = GraphQLFieldDefinition.newFieldDefinition()
	        		.argument(GraphQLArgument.newArgument().name("studentId").type(Scalars.GraphQLLong).build())
	                .name("areaActivities")
	                .description("根据学生ID获取相关联的所有活动")
	                .type(new GraphQLList(getType()))
	                .dataFetcher(environment ->  {
	                	long studentId = environment.getArgument("studentId");
	                	AreaActivityExample AreaActivityExample = new AreaActivityExample();
	                	AreaActivityExample.createCriteria().andStudentIdEqualTo(studentId);
	                	List<AreaActivity> areaActivityList = areaActivityMapper.selectByExample(AreaActivityExample);
	                	return areaActivityList;
	                } ).build();
		}
        return listQueryField;
    }
	
	public static GraphQLFieldDefinition getSearchField() {
		return GraphQLFieldDefinition.newFieldDefinition()
	        		.argument(GraphQLArgument.newArgument().name("studentName").type(Scalars.GraphQLString).build())
	        		.argument(GraphQLArgument.newArgument().name("studentNo").type(Scalars.GraphQLString).build())
	        		.argument(GraphQLArgument.newArgument().name("startTime").type(Scalars.GraphQLLong).build())
	        		.argument(GraphQLArgument.newArgument().name("endTime").type(Scalars.GraphQLLong).build())
	        		.argument(GraphQLArgument.newArgument().name("areaSportId").type(Scalars.GraphQLLong).build())
	        		.argument(GraphQLArgument.newArgument().name("pageNumber").type(Scalars.GraphQLInt).build())
					.argument(GraphQLArgument.newArgument().name("pageSize").type(Scalars.GraphQLInt).build())
					.type(PageType.getPageTypeBuidler(getType())
														.name("AreaActivityPage")
														.description("活动记录分页")
														.build())
	                .name("searchActivities")
	                .dataFetcher(environment ->  {
	                	
	                	AreaActivityExample AreaActivityExample = new AreaActivityExample();
	                	Criteria criteria = AreaActivityExample.createCriteria();
	                	
	                	String studentName = environment.getArgument("studentName");
	                	if(studentName != null) {
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
	                	if(studentNo != null) {
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
	                	
	                	Long areaSportId = environment.getArgument("areaSportId");
	                	if(areaSportId != null) {
	                		criteria.andAreaSportIdEqualTo(areaSportId);
	                	}
	                	
	                	Long startTime = environment.getArgument("startTime");
	                	if(startTime != null) {
	                		criteria.andStartTimeGreaterThanOrEqualTo(new Date(startTime));
	                	}
	                	
	                	Long endTime = environment.getArgument("endTime");
	                	if(endTime != null) {
	                		criteria.andStartTimeLessThanOrEqualTo(new Date(endTime));
	                	}
	                	
	                	PageHelper.startPage(environment.getArgument("pageNumber"), environment.getArgument("pageSize"));
	                	List<AreaActivity> areaActivityList = areaActivityMapper.selectByExample(AreaActivityExample);
	                	return areaActivityList;
	                } ).build();
    }

	@Autowired(required = true)
	public void setAreaActivityMapper(AreaActivityMapper areaActivityMapper) {
		AreaActivityType.areaActivityMapper = areaActivityMapper;
	}
	
	@Autowired(required = true)
	public void setAreaSportMapper(AreaSportMapper AreaSportMapper) {
		AreaActivityType.AreaSportMapper = AreaSportMapper;
	}
	
	@Autowired(required = true)
	public void setStudentMapper(StudentMapper studentMapper) {
		AreaActivityType.studentMapper = studentMapper;
	}
	
	@Autowired(required = true)
	public void setAreaActivityDataMapper(AreaActivityDataMapper areaActivityDataMapper) {
		AreaActivityType.areaActivityDataMapper = areaActivityDataMapper;
	}
	
   @Autowired(required = true)
    public void setfixLocationOutdoorSportPointMapper(FixLocationOutdoorSportPointMapper fixLocationOutdoorSportPointMapper) {
        AreaActivityType.fixLocationOutdoorSportPointMapper = fixLocationOutdoorSportPointMapper;
    }
}
