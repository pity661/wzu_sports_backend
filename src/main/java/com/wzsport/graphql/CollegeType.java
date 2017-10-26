package com.wzsport.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wzsport.mapper.CollegeMapper;
import com.wzsport.mapper.MajorMapper;
import com.wzsport.model.College;
import com.wzsport.model.CollegeExample;
import com.wzsport.model.Major;
import com.wzsport.model.MajorExample;

import graphql.Scalars;
import graphql.schema.GraphQLArgument;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLObjectType;

/**
* GraphQL学院类型的定义及查询字段定义
* 
* @author x1ny
* @date 2017年5月25日
*/
@Component
public class CollegeType {

	private static MajorMapper majorMapper;
	private static CollegeMapper collegeMapper;
	private static GraphQLObjectType type;
	private static GraphQLFieldDefinition singleQueryField;
	private static GraphQLFieldDefinition listQueryField;

	private CollegeType() {}
	
	public static GraphQLObjectType getType() {
		if(type == null) {
			type = GraphQLObjectType.newObject()
					.name("College")
					.description("学院类型")
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("id")
							.type(Scalars.GraphQLLong)
							.description("唯一主键")
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("name")
							.description("学院名称")
							.type(Scalars.GraphQLString)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("universityId")
							.description("学院所属大学的ID")
							.type(Scalars.GraphQLLong)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("majors")
							.description("该学院下所有的专业")
							.type(new GraphQLList(MajorType.getType()))
							.dataFetcher(environment ->  {
								College college = environment.getSource();
								MajorExample majorExample = new MajorExample();
								majorExample.createCriteria().andCollegeIdEqualTo(college.getId());
			                	List<Major> majorList = majorMapper.selectByExample(majorExample);
			                	return majorList;
							} )
							.build())
					.build();
		}
		
		return type;
	}
	
	public static GraphQLFieldDefinition getSingleQueryField() {
		if(singleQueryField == null) {
			singleQueryField = GraphQLFieldDefinition.newFieldDefinition()
	        		.argument(GraphQLArgument.newArgument().name("id").type(Scalars.GraphQLLong).build())
	                .name("college")
	                .description("根据ID获取专业")
	                .type(getType())
	                .dataFetcher(environment ->  {
	                	long id = environment.getArgument("id");
	                	College college = collegeMapper.selectByPrimaryKey(id);
	                	return college;
	                } ).build();
		}
        return singleQueryField;
    }
	
	public static GraphQLFieldDefinition getListQueryField() {
		if(listQueryField == null) {
			listQueryField = GraphQLFieldDefinition.newFieldDefinition()
	        		.argument(GraphQLArgument.newArgument().name("universityId").type(Scalars.GraphQLLong).build())
	                .name("colleges")
	                .description("根据学院ID获取相关联的专业")
	                .type(new GraphQLList(getType()))
	                .dataFetcher(environment ->  {
	                	long universityId = environment.getArgument("universityId");
	                	CollegeExample collegeExample = new CollegeExample();
	                	collegeExample.createCriteria().andUniversityIdEqualTo(universityId);
	                	List<College> collegeList = collegeMapper.selectByExample(collegeExample);
	                	return collegeList;
	                } ).build();
		}
        return listQueryField;
    }

	@Autowired(required = true)
	public void setMajorMapper(MajorMapper majorMapper) {
		CollegeType.majorMapper = majorMapper;
	}

	@Autowired(required = true)
	public void setCollegeMapper(CollegeMapper collegeMapper) {
		CollegeType.collegeMapper = collegeMapper;
	}
}
