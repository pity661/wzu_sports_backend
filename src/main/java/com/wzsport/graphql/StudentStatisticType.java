package com.wzsport.graphql;

import org.springframework.stereotype.Component;

import graphql.Scalars;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLObjectType;
@Component
public class StudentStatisticType {
	private static GraphQLObjectType type;
	
	public StudentStatisticType(){}
	
	public static GraphQLObjectType getType() {
		if(type == null) {
			type = GraphQLObjectType.newObject()
					.name("StudentStatistic")
					.description("学生和注册之间关系")
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("className")
							.description("班级名称")
							.type(Scalars.GraphQLString)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("universityId")
							.description("相关联学校的ID")
							.type(Scalars.GraphQLLong)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("openId")
							.description("注册ID")
							.type(Scalars.GraphQLString)
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
							.description("姓名")
							.type(Scalars.GraphQLString)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("signInCount")
							.description("打卡次数")
							.type(Scalars.GraphQLLong)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("runningActivityCount")
							.description("跑步运动次数")
							.type(Scalars.GraphQLLong)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("areaActivityCount")
							.description("区域运动次数")
							.type(Scalars.GraphQLLong)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("runningActivityQualifiedCount")
							.description("跑步达标运动次数")
							.type(Scalars.GraphQLLong)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("areaActivityQualifiedCount")
							.description("区域达标运动次数")
							.type(Scalars.GraphQLLong)
							.build())
					.build();
		}
		
		return type;
	}

	
}
