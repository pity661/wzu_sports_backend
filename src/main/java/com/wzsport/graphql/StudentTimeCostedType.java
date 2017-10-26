package com.wzsport.graphql;

import graphql.Scalars;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLObjectType;

public class StudentTimeCostedType {

	private static GraphQLObjectType type;

	public static GraphQLObjectType getType() {
		if(type == null) {
			type = GraphQLObjectType.newObject()
					.name("StudentTimeCosted")
					.description("学生锻炼时间累计")
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("studentId")
							.description("所属学生的ID")
							.type(Scalars.GraphQLLong)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("studentName")
							.description("所属学生的姓名")
							.type(Scalars.GraphQLString)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("avatarUrl")
							.description("学生的头像地址")
							.type(Scalars.GraphQLString)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("timeCosted")
							.description("锻炼时间累计(秒)")
							.type(Scalars.GraphQLInt)
							.build())
					.build();
		}

		return type;
	}
}
