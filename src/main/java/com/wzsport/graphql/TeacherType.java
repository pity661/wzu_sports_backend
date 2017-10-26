package com.wzsport.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.pagehelper.PageHelper;
import com.wzsport.mapper.ClassMapper;
import com.wzsport.mapper.TeacherMapper;
import com.wzsport.model.Class;
import com.wzsport.model.Teacher;
import com.wzsport.model.TeacherExample;
import com.wzsport.model.TeacherExample.Criteria;

import graphql.Scalars;
import graphql.schema.GraphQLArgument;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLObjectType;

/**
* GraphQL教师类型的定义及查询字段定义
* 
* @author x1ny
* @date 2017年5月25日
*/
@Component
public class TeacherType {
	
	private static TeacherMapper teacherMapper;
	private static ClassMapper classMapper;
	private static GraphQLObjectType type;
	private static GraphQLFieldDefinition singleQueryField;
	private static GraphQLFieldDefinition listQueryField;
	private static GraphQLFieldDefinition listTeachers;
	private TeacherType() {}
	
	public static GraphQLObjectType getType() {
		if(type == null) {
			type = GraphQLObjectType.newObject()
					.name("Teacher")
					.description("教师类型")
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("id")
							.description("唯一主键")
							.type(Scalars.GraphQLLong)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("universityId")
							.description("所属大学的ID")
							.type(Scalars.GraphQLLong)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("jobNo")
							.description("工号")
							.type(Scalars.GraphQLString)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("name")
							.description("教师名字")
							.type(Scalars.GraphQLString)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("isMan")
							.description("性别")
							.type(Scalars.GraphQLBoolean)
							.dataFetcher(environment ->  {
								Teacher teacher = environment.getSource();
			                	return teacher.getMan();
							} )
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("classes")
							.description("所有教学的班级")
							.type(new GraphQLList(ClassType.getType()))
							.dataFetcher(environment ->  {
								Teacher teacher = environment.getSource();
			                	List<Class> classList = classMapper.listClassByTeacherId(teacher.getId());
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
	                .name("teacher")
	                .description("根据ID获取教师")
	                .type(getType())
	                .dataFetcher(environment -> {
	                	long id = environment.getArgument("id");
	                	Teacher teacher = teacherMapper.selectByPrimaryKey(id);
	                	return teacher;
	                } )
	                .build();
		}
		
        return singleQueryField;
    }
	
	public static GraphQLFieldDefinition getListQueryField() {
		if(listQueryField == null) {
			listQueryField = GraphQLFieldDefinition.newFieldDefinition()
	        		.argument(GraphQLArgument.newArgument().name("classId").type(Scalars.GraphQLLong).build())
	                .name("teachers")
	                .description("根据班级的ID获取所有教师")
	                .type(new GraphQLList(getType()))
	                .dataFetcher(environment -> {
	                	long classId = environment.getArgument("classId");
	                	List<Teacher> teacherList = teacherMapper.listTeacherByClassId(classId);
	                	return teacherList;
	                } ).build();
		}
		
        return listQueryField;
    }
	
	public static GraphQLFieldDefinition getListTeacherByJobNoAndNameAndSex() {
		if(listTeachers == null) {
			listTeachers = GraphQLFieldDefinition.newFieldDefinition()
					.name("searchTeachers")
					.description("搜索教师")
					.argument(GraphQLArgument.newArgument().name("universityId").type(Scalars.GraphQLLong).build())
	        		.argument(GraphQLArgument.newArgument().name("jobNo").type(Scalars.GraphQLString).build())
	        		.argument(GraphQLArgument.newArgument().name("name").type(Scalars.GraphQLString).build())
	        		.argument(GraphQLArgument.newArgument().name("isMan").type(Scalars.GraphQLBoolean).build())
	        		.argument(GraphQLArgument.newArgument().name("pageNumber").type(Scalars.GraphQLInt).build())
					.argument(GraphQLArgument.newArgument().name("pageSize").type(Scalars.GraphQLInt).build())
					.type(PageType.getPageTypeBuidler(getType())
														.name("TeacherPage")
														.description("教师类型分页")
														.build())
	                .dataFetcher(environment -> {
	                	Long universityId = environment.getArgument("universityId");
	                	String jobNo = environment.getArgument("jobNo");
	                	String name = environment.getArgument("name");
	                	Boolean isMan = environment.getArgument("isMan");
	                	
	                	TeacherExample teacherExample = new TeacherExample();
	                	Criteria teacherExampleCriteria = teacherExample.createCriteria();
	                	if(universityId != null) {
	                		teacherExampleCriteria.andUniversityIdEqualTo(universityId);
	                	}
	                	if(name != null) {
	                		teacherExampleCriteria.andNameLike("%" + name + "%");
	                	}
	                	if(jobNo != null) {
	                		teacherExampleCriteria.andJobNoLike("%" + jobNo + "%");
	                	}
	                	if(isMan != null) {
	                		teacherExampleCriteria.andManEqualTo(isMan);
	                	}
	                	
	                	PageHelper.startPage(environment.getArgument("pageNumber"), environment.getArgument("pageSize"));
	                	List<Teacher> teacherList = teacherMapper.selectByExample(teacherExample);
	                	
	                	return teacherList;
	                } ).build();
		}
        return listTeachers;
    }

	@Autowired(required = true)
	public void setTeacherMapper(TeacherMapper teacherMapper) {
		TeacherType.teacherMapper = teacherMapper;
	}
	
	@Autowired(required = true)
	public void setClassMapper(ClassMapper classMapper) {
		TeacherType.classMapper = classMapper;
	}
}
