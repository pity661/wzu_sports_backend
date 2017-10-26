package com.wzsport.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wzsport.mapper.ClassMapper;
import com.wzsport.mapper.StudentMapper;
import com.wzsport.model.Class;
import com.wzsport.model.ClassExample;
import com.wzsport.model.ClassExample.Criteria;
import com.wzsport.model.Student;
import com.wzsport.model.StudentExample;

import graphql.Scalars;
import graphql.schema.GraphQLArgument;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLObjectType;

/**
* GraphQL班级类型的定义及查询字段定义
* 
* @author x1ny
* @date 2017年5月25日
*/
@Component
public class ClassType {

	private static ClassMapper classMapper;
	private static StudentMapper studentMapper;
	private static GraphQLObjectType type;
	private static GraphQLFieldDefinition singleQueryField;
	private static GraphQLFieldDefinition listQueryField;

	private ClassType() {}
	
	public static GraphQLObjectType getType() {
		if(type == null) {
			type = GraphQLObjectType.newObject()
					.name("Class")
					.description("班级类型")
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("id")
							.type(Scalars.GraphQLLong)
							.description("唯一主键")
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("name")
							.description("班级名称")
							.type(Scalars.GraphQLString)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("majorId")
							.description("所属专业的ID")
							.type(Scalars.GraphQLLong)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("grade")
							.description("年级")
							.type(Scalars.GraphQLInt)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("universityId")
							.description("所属大学的ID")
							.type(Scalars.GraphQLLong)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("students")
							.description("该班级下所有的学生")
							.type(new GraphQLList(StudentType.getType()))
							.dataFetcher(environment ->  {
								Class studentClass = environment.getSource();
								StudentExample studentExample = new StudentExample();
								studentExample.createCriteria().andClassIdEqualTo(studentClass.getId());
			                	List<Student> studentList = studentMapper.selectByExample(studentExample);
			                	return studentList;
							} )
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("studentsCount")
							.description("该班级下所有的学生的总数")
							.type(Scalars.GraphQLInt)
							.dataFetcher(environment ->  {
								Class studentClass = environment.getSource();
								StudentExample studentExample = new StudentExample();
								studentExample.createCriteria().andClassIdEqualTo(studentClass.getId());
			                	int  studentCount = (int) studentMapper.countByExample(studentExample);
			                	return studentCount;
							} )
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("maleStudentsCount")
							.description("该班级下所有的男性学生的总数")
							.type(Scalars.GraphQLInt)
							.dataFetcher(environment ->  {
								Class studentClass = environment.getSource();
								StudentExample studentExample = new StudentExample();
								studentExample.createCriteria().andClassIdEqualTo(studentClass.getId()).andManEqualTo(true);
								int maleStudentCount = (int)studentMapper.countByExample(studentExample);
			                	return maleStudentCount;
							} )
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("femaleStudentsCount")
							.description("该班级下所有的女性学生的总数")
							.type(Scalars.GraphQLInt)
							.dataFetcher(environment ->  {
								Class studentClass = environment.getSource();
								StudentExample studentExample = new StudentExample();
								studentExample.createCriteria().andClassIdEqualTo(studentClass.getId()).andManEqualTo(false);
								int femaleStudentCount = (int) studentMapper.countByExample(studentExample);
			                	return femaleStudentCount;
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
	                .name("class")
	                .description("根据ID获取班级")
	                .type(getType())
	                .dataFetcher(environment ->  {
	                	long id = environment.getArgument("id");
	                	Class sudentClass = classMapper.selectByPrimaryKey(id);
	                	return sudentClass;
	                } ).build();
		}
        return singleQueryField;
    }
	
	public static GraphQLFieldDefinition getListQueryField() {
		if(listQueryField == null) {
			listQueryField = GraphQLFieldDefinition.newFieldDefinition()
			        .argument(GraphQLArgument.newArgument().name("UniversityId").type(Scalars.GraphQLLong).build())
	        		.argument(GraphQLArgument.newArgument().name("majorId").type(Scalars.GraphQLLong).build())
	        		.argument(GraphQLArgument.newArgument().name("grade").type(Scalars.GraphQLInt).build())
	                .name("classes")
	                .description("根据学校Id、专业Id、班级Id获取关联的班级")
	                .type(new GraphQLList(getType()))
	                .dataFetcher(environment -> {
	                    ClassExample classExample = new ClassExample();
	                    Criteria criteria = classExample.createCriteria();
	                    
	                    Long universityId = environment.getArgument("universityId");
	                    if (universityId != null) {
	                        criteria.andUniversityIdEqualTo(universityId);
	                    }
	                    
	                	Long majorId = environment.getArgument("majorId");
	                	if (majorId != null) {
	                	    criteria.andMajorIdEqualTo(majorId);
	                	}
	                	
	                	Integer gradle = environment.getArgument("grade");
	                	if (gradle != null) {
	                		criteria.andGradeEqualTo(gradle);
	                	}
	                	List<Class> classList = classMapper.selectByExample(classExample);
	                	return classList;
	                } ).build();
		}
        return listQueryField;
    }

	@Autowired(required = true) 
	public void setClassMapper(ClassMapper classMapper) {
		ClassType.classMapper = classMapper;
	}

	@Autowired(required = true) 
	public void setStudentMapper(StudentMapper studentMapper) {
		ClassType.studentMapper = studentMapper;
	}
}
