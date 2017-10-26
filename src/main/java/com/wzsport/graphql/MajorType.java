package com.wzsport.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wzsport.mapper.ClassMapper;
import com.wzsport.mapper.MajorMapper;
import com.wzsport.model.Class;
import com.wzsport.model.ClassExample;
import com.wzsport.model.Major;
import com.wzsport.model.MajorExample;
import com.wzsport.model.ClassExample.Criteria;

import graphql.Scalars;
import graphql.schema.GraphQLArgument;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLObjectType;

/**
* GraphQL专业类型的定义及查询字段定义
* 
* @author x1ny
* @date 2017年5月25日
*/
@Component
public class MajorType {

	private static MajorMapper majorMapper;
	private static ClassMapper classMapper;
	private static GraphQLObjectType type;
	private static GraphQLFieldDefinition singleQueryField;
	private static GraphQLFieldDefinition listQueryField;
	
	private MajorType() {}
	
	public static GraphQLObjectType getType() {
		if(type == null) {
			type = GraphQLObjectType.newObject()
					.name("Major")
					.description("专业类型")
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("id")
							.description("唯一主键")
							.type(Scalars.GraphQLLong)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("name")
							.description("专业名称")
							.type(Scalars.GraphQLString)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("universityId")
							.description("所属大学的ID")
							.type(Scalars.GraphQLLong)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("collegeId")
							.description("所属学院的ID")
							.type(Scalars.GraphQLLong)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("classes")
							.argument(GraphQLArgument.newArgument().name("grade").type(Scalars.GraphQLInt).build())
							.description("该专业下的所有班级")
							.type(new GraphQLList(ClassType.getType()))
							.dataFetcher(environment ->  {
								Major major = environment.getSource();
								ClassExample classExample = new ClassExample();
								Criteria criteria = classExample.createCriteria().andMajorIdEqualTo(major.getId());
								Integer gradle = environment.getArgument("grade");
			                	if (gradle != null) {
			                		criteria.andGradeEqualTo(gradle);
			                	}
			                	List<Class> classList = classMapper.selectByExample(classExample);
			                	return classList;
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
	                .name("major")
	                .description("根据ID获取专业")
	                .type(getType())
	                .dataFetcher(environment ->  {
	                	long id = environment.getArgument("id");
	                	Major major = majorMapper.selectByPrimaryKey(id);
	                	return major;
	                } ).build();
		}
        return singleQueryField;
    }
	
	public static GraphQLFieldDefinition getListQueryField() {
		if(listQueryField == null) {
			listQueryField = GraphQLFieldDefinition.newFieldDefinition()
	        		.argument(GraphQLArgument.newArgument().name("collegeId").type(Scalars.GraphQLLong).build())
	                .name("majors")
	                .description("根据学院ID获取相关联的所有专业")
	                .type(new GraphQLList(getType()))
	                .dataFetcher(environment ->  {
	                	long collegeId = environment.getArgument("collegeId");
	                	MajorExample majorExample = new MajorExample();
	                	majorExample.createCriteria().andCollegeIdEqualTo(collegeId);
	                	List<Major> majorList = majorMapper.selectByExample(majorExample);
	                	return majorList;
	                } ).build();
		}
        return listQueryField;
    }
	
	@Autowired(required = true)
	public void setClassMapper(ClassMapper classMapper) {
		MajorType.classMapper = classMapper;
	}

	@Autowired(required = true)
	public void setMajorMapper(MajorMapper majorMapper) {
		MajorType.majorMapper = majorMapper;
	}
}
