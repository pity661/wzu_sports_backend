package com.wzsport.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.pagehelper.PageHelper;
import com.wzsport.mapper.SportsCourseMapper;
import com.wzsport.model.SportsCourse;
import com.wzsport.model.SportsCourseExample;
import graphql.Scalars;
import graphql.schema.GraphQLArgument;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLObjectType;

import com.wzsport.model.SportsCourseExample.Criteria;
@Component
public class SportsCourseType {
	private static GraphQLObjectType type;
	private static GraphQLFieldDefinition listQueryField;
	private static GraphQLFieldDefinition queryField;
	private static SportsCourseMapper sportsCourseMapper;
	
	private SportsCourseType() {
	}
	
	public static GraphQLObjectType getType(){
		if (type == null) {
			type = GraphQLObjectType.newObject().name("SportsCourse").description("教学班类型")
					.field(GraphQLFieldDefinition.newFieldDefinition().name("id").description("唯一主键")
							.type(Scalars.GraphQLLong).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("universityId").description("学校id")
							.type(Scalars.GraphQLLong).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("schoolYear").description("学年")
							.type(Scalars.GraphQLString).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("term").description("学期")
							.type(Scalars.GraphQLByte).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("subjectNumber").description("课程编号")
							.type(Scalars.GraphQLString).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("courseName").description("课程名称")
							.type(Scalars.GraphQLString).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("teacherName").description("教师姓名")
							.type(Scalars.GraphQLString).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("courseTime").description("上课时间")
							.type(Scalars.GraphQLString).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("studentNo").description("学生学号")
							.type(Scalars.GraphQLString).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("studentName").description("学生姓名")
							.type(Scalars.GraphQLString).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("isMan").description("学生性别")
							.type(Scalars.GraphQLBoolean).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("majorName").description("专业名称")
							.type(Scalars.GraphQLString).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("collegeName").description("学院名称")
							.type(Scalars.GraphQLString).build())
					.build();
		}
		return type;
	}
	
	
	
	@Autowired(required = true)
	public void setSportsCourseMapper(SportsCourseMapper sportsCourseMapper) {
		SportsCourseType.sportsCourseMapper = sportsCourseMapper;
	}
	
	
}
