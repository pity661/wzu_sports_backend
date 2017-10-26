package com.wzsport.graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wzsport.mapper.TermSportsTaskMapper;
import com.wzsport.model.TermSportsTask;

import graphql.Scalars;
import graphql.schema.GraphQLArgument;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLObjectType;

/**
* TermSportsTask GraphQL Type
* 
* @author x1ny
* @date 2017年5月28日
*/
@Component
public class TermSportsTaskType {

	private static TermSportsTaskMapper termSportsTaskMapper;
	private static GraphQLObjectType type;
	private static GraphQLFieldDefinition singleQueryField;

	private TermSportsTaskType() {}
	
	public static GraphQLObjectType getType() {
		if(type == null) {
			type = GraphQLObjectType.newObject()
					.name("TermSportsTask")
					.description("学期运动任务")
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("id")
							.description("唯一主键")
							.type(Scalars.GraphQLLong)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("termId")
							.description("所属学期的ID")
							.type(Scalars.GraphQLInt)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("targetSportsTimes")
							.description("目标运动次数")
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
	                .name("termSportsTask")
	                .description("根据ID获取学期运动任务")
	                .type(getType())
	                .dataFetcher(environment -> {
	                	long id = environment.getArgument("id");
	                	TermSportsTask termSportsTask = termSportsTaskMapper.selectByPrimaryKey(id);
	                	return termSportsTask;
	                } )
	                .build();
		}
		
        return singleQueryField;
    }

	@Autowired(required = true)
	public void setTermSportsTaskMapper(TermSportsTaskMapper termSportsTaskMapper) {
		TermSportsTaskType.termSportsTaskMapper = termSportsTaskMapper;
	}
}
