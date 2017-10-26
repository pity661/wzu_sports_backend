package com.wzsport.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wzsport.mapper.FixLocationOutdoorSportPointMapper;
import com.wzsport.model.AreaSport;
import com.wzsport.model.AreaSportExample;
import com.wzsport.model.FixLocationOutdoorSportPoint;
import com.wzsport.model.FixLocationOutdoorSportPointExample;
import graphql.Scalars;
import graphql.schema.GraphQLArgument;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLObjectType;

/**
* GraphQL班级类型的定义及查询字段定义
* 
* @author chaiyu
* @date 2017年7月21日
*/
@Component
public class FixLocationOutdoorSportPointType {
	private static GraphQLObjectType type;
	private static GraphQLFieldDefinition listQueryField;
	private static GraphQLFieldDefinition singleQueryField;
	private static FixLocationOutdoorSportPointMapper fixLocationOutdoorSportPointMapper;

	private FixLocationOutdoorSportPointType() {}
	
	public static GraphQLObjectType getType() {
		if(type == null) {
			type = GraphQLObjectType.newObject()
					.name("FixLocationOutdoorSportPoint")
					.description("室外定点运动地点")
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("id")
							.type(Scalars.GraphQLLong)
							.description("唯一主键")
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("name")
							.description("运动地点名称")
							.type(Scalars.GraphQLString)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
                            .name("description")
                            .description("运动地点名称")
                            .type(Scalars.GraphQLString)
                            .build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("isEnabled")
							.description("是否生效")
							.type(Scalars.GraphQLBoolean)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("latitude")
							.description("纬度")
							.type(Scalars.GraphQLFloat)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("longitude")
							.description("经度")
							.type(Scalars.GraphQLFloat)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("radius")
							.description("半径（米）")
							.type(Scalars.GraphQLLong)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("addr")
							.description("地址")
							.type(Scalars.GraphQLString)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("qualifiedCostTime")
							.description("达标时间（秒）")
							.type(Scalars.GraphQLInt)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("universityId")
							.description("所属大学的ID")
							.type(Scalars.GraphQLLong)
							.build())
					.build();
		}
		
		return type;
	}
	
	public static GraphQLFieldDefinition getSingleQueryField() {
		if(singleQueryField == null) {
			singleQueryField = GraphQLFieldDefinition.newFieldDefinition()
	        		.argument(GraphQLArgument.newArgument().name("id").type(Scalars.GraphQLLong).build())
	                .name("fixLocationOutdoorSportPoint")
	                .description("根据ID获取一项区域运动的信息")
	                .type(getType())
	                .dataFetcher(environment ->  {
	                	long id = environment.getArgument("id");
	                	FixLocationOutdoorSportPoint point = fixLocationOutdoorSportPointMapper.selectByPrimaryKey(id);
	                	return point;
	                } ).build();
		}
        return singleQueryField;
    }
	
	public static GraphQLFieldDefinition getListQueryField() {
		if(listQueryField == null) {
			listQueryField = GraphQLFieldDefinition.newFieldDefinition()
	        		.argument(GraphQLArgument.newArgument().name("universityId").type(Scalars.GraphQLLong).build())
	        		.argument(GraphQLArgument.newArgument().name("isEnabled").type(Scalars.GraphQLBoolean).build())
	                .name("fixLocationOutdoorSportPoints")
	                .description("根据学校ID获取关联的固定运动的地点列表")
	                .type(new GraphQLList(getType()))
	                .dataFetcher(environment -> {
	                	long universityId = environment.getArgument("universityId");
	                	
	                	boolean isEnabled = true;
	                	if (environment.getArgument("isEnabled") != null) {
	                		isEnabled = environment.getArgument("isEnabled");
	                	}
	                	
	                	FixLocationOutdoorSportPointExample example = new FixLocationOutdoorSportPointExample();
	                	example.createCriteria().andUniversityIdEqualTo(universityId).andIsEnabledEqualTo(isEnabled);
	                	List<FixLocationOutdoorSportPoint> pointList = fixLocationOutdoorSportPointMapper.selectByExample(example);
	                	return pointList;
	                } ).build();
		}
        return listQueryField;
    }

	@Autowired(required = true) 
	public void setClassMapper(FixLocationOutdoorSportPointMapper fixLocationOutdoorSportPointMapper) {
		FixLocationOutdoorSportPointType.fixLocationOutdoorSportPointMapper = fixLocationOutdoorSportPointMapper;
	}
}
