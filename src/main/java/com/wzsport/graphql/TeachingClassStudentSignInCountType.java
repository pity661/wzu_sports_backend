package com.wzsport.graphql;

import org.springframework.stereotype.Component;

import graphql.Scalars;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLObjectType;

@Component
public class TeachingClassStudentSignInCountType {
	private static GraphQLObjectType type;
	
	private TeachingClassStudentSignInCountType() {}
	
	public static GraphQLObjectType getType() {
		if(type == null) {
			type = GraphQLObjectType.newObject()
					.name("TeachingClassStudentSignInCount")
					.description("教学班学生打卡统计类型")
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("runningActivityQualifiedCount")
							.description("跑步运动打卡次数")
							.type(Scalars.GraphQLLong)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("areaActivityQualifiedCount")
							.description("区域运动打卡次数")
							.type(Scalars.GraphQLLong)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("universityId")
							.description("学校id")
							.type(Scalars.GraphQLLong)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("studentNo")
							.description("学号")
							.type(Scalars.GraphQLString)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("isMan")
							.description("性别")
							.type(Scalars.GraphQLBoolean)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("studentName")
							.description("学生姓名")
							.type(Scalars.GraphQLString)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("schoolYear")
							.description("学年")
							.type(Scalars.GraphQLString)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("term")
							.description("学期")
							.type(Scalars.GraphQLString)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("teacherName")
							.description("教师姓名")
							.type(Scalars.GraphQLString)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("courseName")
							.description("课程名")
							.type(Scalars.GraphQLString)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("courseTime")
							.description("课程时间")
							.type(Scalars.GraphQLString)
							.build())
					.build();
		}
		return type;
	}
}
