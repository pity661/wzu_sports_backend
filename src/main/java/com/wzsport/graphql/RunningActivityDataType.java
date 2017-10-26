package com.wzsport.graphql;

import com.wzsport.model.RunningActivityData;

import graphql.Scalars;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLObjectType;

public class RunningActivityDataType {

	private static GraphQLObjectType type;
	
	public static GraphQLObjectType getType() {
		if(type == null) {
			type = GraphQLObjectType.newObject()
					.name("RunningActivityData")
					.description("运动采集数据")
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("id")
							.description("唯一主键")
							.type(Scalars.GraphQLLong)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("activityId")
							.description("该数据关联的运动的ID")
							.type(Scalars.GraphQLLong)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("acquisitionTime")
							.description("数据采集时间,时间戳格式(毫秒)")
							.type(Scalars.GraphQLLong)
							.dataFetcher(environment ->  {
								RunningActivityData runningActivityData = environment.getSource();
			                	return runningActivityData.getAcquisitionTime().getTime();
							} )
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("stepCount")
							.description("该时段累计步数")
							.type(Scalars.GraphQLInt)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
                            .name("stepCountCal")
                            .description("自己实现的计步器的步数")
                            .type(Scalars.GraphQLInt)
                            .build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
                            .name("distancePerStep")
                            .description("步幅")
                            .type(Scalars.GraphQLFloat)
                            .build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
                            .name("stepPerSecond")
                            .description("步频")
                            .type(Scalars.GraphQLFloat)
                            .build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("distance")
							.description("该时段活动距离(单位:米)")
							.type(Scalars.GraphQLInt)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("longitude")
							.description("该时刻的经度")
							.type(Scalars.GraphQLFloat)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("latitude")
							.description("该时刻的纬度")
							.type(Scalars.GraphQLFloat)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("locationType")
							.description("定位方式")
							.type(Scalars.GraphQLInt)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("isNormal")
							.description("数据是否正常")
							.type(Scalars.GraphQLBoolean)
							.build())
					.build();
		}
		return type;
	}
}
