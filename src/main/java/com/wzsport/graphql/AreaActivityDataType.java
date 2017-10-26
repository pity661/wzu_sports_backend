package com.wzsport.graphql;

import com.wzsport.model.AreaActivityData;

import graphql.Scalars;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLObjectType;

public class AreaActivityDataType {

	private static GraphQLObjectType type;
	
	public static GraphQLObjectType getType() {
		if(type == null) {
			type = GraphQLObjectType.newObject()
					.name("AreaActivityData")
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
								AreaActivityData areaActivityData = environment.getSource();
			                	return areaActivityData.getAcquisitionTime().getTime();
							} )
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
