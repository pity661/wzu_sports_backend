package com.wzsport.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wzsport.mapper.FitnessCheckDataMapper;
import com.wzsport.model.FitnessCheckData;
import com.wzsport.model.FitnessCheckDataExample;

import graphql.Scalars;
import graphql.schema.GraphQLArgument;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLObjectType;

@Component
public class FitnessCheckDataType {
	
	private static FitnessCheckDataMapper fitnessCheckDataMapper;
	private static GraphQLObjectType type;
	private static GraphQLFieldDefinition singleQueryField;
	private static GraphQLFieldDefinition listQueryField;
	
	public FitnessCheckDataType() {}
	
	public static GraphQLObjectType getType() {
		if(type == null) {
			type = GraphQLObjectType.newObject()
					.name("FitnessCheckData")
					.description("体测数据类型")
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("id")
							.description("唯一主键")
							.type(Scalars.GraphQLLong)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("studentId")
							.description("体测数据所属学生的ID")
							.type(Scalars.GraphQLLong)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("termId")
							.description("相关联的学期的ID")
							.type(Scalars.GraphQLLong)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("height")
							.description("身高(单位:厘米)")
							.type(Scalars.GraphQLInt)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("weight")
							.description("体重(单位:千克)")
							.type(Scalars.GraphQLInt)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("lungCapacity")
							.description("肺活量(单位:你猜)")
							.type(Scalars.GraphQLInt)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("bmi")
							.description("BMI指标)")
							.type(Scalars.GraphQLFloat)
							.build())
					.build();
		}
		
		return type;
	}
	
	public static GraphQLFieldDefinition getSingleQueryField() {
		if(singleQueryField == null) {
			singleQueryField = GraphQLFieldDefinition.newFieldDefinition()
	        		.argument(GraphQLArgument.newArgument().name("id").type(Scalars.GraphQLLong).build())
	                .name("fitnessCheckData")
	                .description("根据ID获取体测数据")
	                .type(getType())
	                .dataFetcher(environment ->  {
	                	long id = environment.getArgument("id");
	                	FitnessCheckData fitnessCheckData = fitnessCheckDataMapper.selectByPrimaryKey(id);
	                	return fitnessCheckData;
	                } ).build();
		}
        return singleQueryField;
    }
	
	public static GraphQLFieldDefinition getListQueryField() {
		if(listQueryField == null) {
			listQueryField = GraphQLFieldDefinition.newFieldDefinition()
	        		.argument(GraphQLArgument.newArgument().name("studentId").type(Scalars.GraphQLLong).build())
	                .name("fitnessCheckDatas")
	                .description("根据学生ID获取相关联的体测数据")
	                .type(new GraphQLList(getType()))
	                .dataFetcher(environment -> {
	                	long studentId = environment.getArgument("studentId");
	                	FitnessCheckDataExample fitnessCheckDataExample = new FitnessCheckDataExample();
	                	fitnessCheckDataExample.createCriteria().andStudentIdEqualTo(studentId);
	                	List<FitnessCheckData> sportGradeList = fitnessCheckDataMapper.selectByExample(fitnessCheckDataExample);
	                	return sportGradeList;
	                } ).build();
		}
        return listQueryField;
    }

	@Autowired(required = true)
	public void setFitnessCheckDataMapper(FitnessCheckDataMapper fitnessCheckDataMapper) {
		FitnessCheckDataType.fitnessCheckDataMapper = fitnessCheckDataMapper;
	}
}
