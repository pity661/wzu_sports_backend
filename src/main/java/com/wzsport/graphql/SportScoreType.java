package com.wzsport.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wzsport.mapper.SportScoreMapper;
import com.wzsport.model.SportScore;
import com.wzsport.model.SportScoreExample;

import graphql.Scalars;
import graphql.schema.GraphQLArgument;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLObjectType;
/**
 * SportScore Type
 * @author linhongyong
 * 2017年5月27日
 */
@Component
public class SportScoreType {
	
	private static SportScoreMapper sportScoreMapper;
	private static GraphQLObjectType type;
	private static GraphQLFieldDefinition singleQueryField;
	private static GraphQLFieldDefinition listQueryField;
	
	public SportScoreType() {}
	
	public static GraphQLObjectType getType() {
		if(type == null) {
			type = GraphQLObjectType.newObject()
					.name("SportScore")
					.description("体育成绩类型")
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("id")
							.description("唯一主键")
							.type(Scalars.GraphQLLong)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("studentId")
							.description("所属学生的ID")
							.type(Scalars.GraphQLLong)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("termId")
							.description("所属学期的ID")
							.type(Scalars.GraphQLLong)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("meter50SprintTime")
							.description("50米跑步耗时(单位:秒)")
							.type(Scalars.GraphQLFloat)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("meter50SprintScore")
							.description("50米跑步得分")
							.type(Scalars.GraphQLInt)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("standingJumpDistance")
							.description("跳远距离(厘米)")
							.type(Scalars.GraphQLInt)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("standingJumpScore")
							.description("跳远得分")
							.type(Scalars.GraphQLInt)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("meter1500RunTime")
							.description("1500米跑步耗时(秒)")
							.type(Scalars.GraphQLInt)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("meter1500RunScore")
							.description("1500米跑步得分")
							.type(Scalars.GraphQLInt)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("abdominalCurlCount")
							.description("仰卧起坐次数")
							.type(Scalars.GraphQLInt)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("abdominalCurlScore")
							.description("仰卧起坐得分")
							.type(Scalars.GraphQLInt)
							.build())
					.build();
		}
		
		return type;
	}
	
	public static GraphQLFieldDefinition getSingleQueryField() {
		if(singleQueryField == null) {
			singleQueryField = GraphQLFieldDefinition.newFieldDefinition()
	        		.argument(GraphQLArgument.newArgument().name("id").type(Scalars.GraphQLLong).build())
	                .name("sportScore")
	                .description("根据ID获取体育成绩")
	                .type(getType())
	                .dataFetcher(environment ->  {
	                	long id = environment.getArgument("id");
	                	SportScore sportScore = sportScoreMapper.selectByPrimaryKey(id);
	                	return sportScore;
	                } ).build();
		}
        return singleQueryField;
    }
	
	public static GraphQLFieldDefinition getListQueryField() {
		if(listQueryField == null) {
			listQueryField = GraphQLFieldDefinition.newFieldDefinition()
	        		.argument(GraphQLArgument.newArgument().name("studentId").type(Scalars.GraphQLLong).build())
	                .name("sportScores")
	                .description("根据学生ID获取他所有的体育成绩")
	                .type(new GraphQLList(getType()))
	                .dataFetcher(environment -> {
	                	long studentId = environment.getArgument("studentId");
	                	SportScoreExample sportScoreExample = new SportScoreExample();
	                	sportScoreExample.createCriteria().andStudentIdEqualTo(studentId);
	                	List<SportScore> sportScoreList = sportScoreMapper.selectByExample(sportScoreExample);
	                	return sportScoreList;
	                } ).build();
		}
        return listQueryField;
    }

	@Autowired(required = true)
	public void setSportScoreMapper(SportScoreMapper sportScoreMapper) {
		SportScoreType.sportScoreMapper = sportScoreMapper;
	}
}
