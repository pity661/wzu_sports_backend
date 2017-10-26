package com.wzsport.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wzsport.mapper.RunningSportMapper;
import com.wzsport.model.RunningSport;
import com.wzsport.model.RunningSportExample;
import com.wzsport.model.RunningSportExample.Criteria;
import com.wzsport.service.RunningActivityService;

import graphql.Scalars;
import graphql.schema.GraphQLArgument;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLObjectType;

/**
* GraphQL RunningSport类型的定义及查询字段定义
* 
* @author x1ny
* @date 2017年5月26日
*/
@Component
public class RunningSportType {

	private static RunningSportMapper runningSportMapper;
	private static GraphQLObjectType type;
	private static GraphQLFieldDefinition singleQueryField;
	private static GraphQLFieldDefinition listQueryField;
	private static RunningActivityService runningActivityService;
	
	private RunningSportType() {}
	
	public static GraphQLObjectType getType() {
		if(type == null) {
			type = GraphQLObjectType.newObject()
					.name("runningSport")
					.description("跑步项目类型")
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("id")
							.description("唯一主键")
							.type(Scalars.GraphQLLong)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("universityId")
							.description("所属大学的ID")
							.type(Scalars.GraphQLLong)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("name")
							.description("跑步项目名称")
							.type(Scalars.GraphQLString)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("type")
							.description("项目的类型")
							.type(Scalars.GraphQLString)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("isEnabled")
							.description("该项目是否启用")
							.type(Scalars.GraphQLBoolean)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("isMan")
							.description("性别")
							.type(Scalars.GraphQLBoolean)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("imgUrl")
							.description("背景图片")
							.type(Scalars.GraphQLString)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("qualifiedDistance")
							.description("该项目的合格距离(单位:米)")
							.type(Scalars.GraphQLInt)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("qualifiedCostTime")
							.description("该项目的合格耗时(单位:秒)")
							.type(Scalars.GraphQLInt)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
                            .name("qualifiedVelocity")
                            .description("该项目的合格速度(单位:米/秒)")
                            .type(Scalars.GraphQLBigDecimal)
                            .build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("minCostTime")
							.description("该项目的最少耗时(单位:秒)")
							.type(Scalars.GraphQLInt)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("acquisitionInterval")
							.description("采集运动数据的时间间隔(单位:秒)")
							.type(Scalars.GraphQLInt)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("sampleNum")
							.description("采集运动数据的采样数")
							.type(Scalars.GraphQLInt)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
                            .name("stepThreshold")
                            .description("计步阈值")
                            .type(Scalars.GraphQLInt)
                            .staticValue(4)
                            .build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("participantNum")
							.description("参加人数")
							.type(Scalars.GraphQLInt)
							.dataFetcher(environment -> {
								RunningSport runningSport = environment.getSource();
								return runningActivityService.getParticipantNum(runningSport.getId());
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
	                .name("runningSport")
	                .description("根据Id获取跑步项目")
	                .type(getType())
	                .dataFetcher(environment ->  {
	                	long id = environment.getArgument("id");
	                	RunningSport runningSport = runningSportMapper.selectByPrimaryKey(id);
	                	return runningSport;
	                } ).build();
		}
        return singleQueryField;
    }
	
	public static GraphQLFieldDefinition getListQueryField() {
		if(listQueryField == null) {
			listQueryField = GraphQLFieldDefinition.newFieldDefinition()
	        		.argument(GraphQLArgument.newArgument().name("universityId").type(Scalars.GraphQLLong).build())
	        		.argument(GraphQLArgument.newArgument().name("isEnabled").type(Scalars.GraphQLBoolean).build())
	        		.argument(GraphQLArgument.newArgument().name("isMan").type(Scalars.GraphQLBoolean).build())
	                .name("runningSports")
	                .description("根据大学Id获取关联的所有跑步项目")
	                .type(new GraphQLList(getType()))
	                .dataFetcher(environment ->  {
	                	RunningSportExample runningSportExample = new RunningSportExample();
	                	Criteria criteria = runningSportExample.createCriteria();
	                	
	                	Long universityId;
	                	if ((universityId= environment.getArgument("universityId")) == null) {
	                		return null;
	                	} else {
	                		criteria.andUniversityIdEqualTo(universityId);
	                	}
	                	
	                	Boolean isEnabled;
	                	if ((isEnabled = environment.getArgument("isEnabled")) != null) {
	                		criteria.andIsEnabledEqualTo(isEnabled);
	                	}
	                	
	                	Boolean isMan;
	                	if ((isMan = environment.getArgument("isMan")) != null) {
	                		criteria.andIsManEqualTo(isMan);
	                	}
	                	
                        runningSportExample.setOrderByClause("qualified_velocity ASC");
	                	List<RunningSport> runningSportList = runningSportMapper.selectByExample(runningSportExample);
	                	return runningSportList;
	                } ).build();
		}
        return listQueryField;
    }

	@Autowired(required = true)
	public void setRunningSportMapper(RunningSportMapper runningSportMapper) {
		RunningSportType.runningSportMapper = runningSportMapper;
	}
	
	@Autowired(required = true)
	public void setRunningActivityService(RunningActivityService runningActivityService) {
		RunningSportType.runningActivityService = runningActivityService;
	}
}
