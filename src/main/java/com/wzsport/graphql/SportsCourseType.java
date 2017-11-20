package com.wzsport.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.pagehelper.PageHelper;
import com.wzsport.mapper.PhysicalTestMapper;
import com.wzsport.mapper.SportsCourseMapper;
import com.wzsport.model.PhysicalTest;
import com.wzsport.model.PhysicalTestExample;
import com.wzsport.model.SportsCourse;
import com.wzsport.model.SportsCourseExample;
import com.wzsport.model.Student;

import graphql.Scalars;
import graphql.schema.GraphQLArgument;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLObjectType;

import com.wzsport.model.SportsCourseExample.Criteria;
@Component
public class SportsCourseType {
	private static GraphQLObjectType type;
	private static GraphQLFieldDefinition listQueryField;
	private static GraphQLFieldDefinition queryField;
	private static SportsCourseMapper sportsCourseMapper;
	private static PhysicalTestMapper physicalTestMapper;
	private SportsCourseType() {
	}
	
	public static GraphQLObjectType getType(){
		if (type == null) {
			type = GraphQLObjectType.newObject().name("SportsCourse").description("教学班类型")
					.field(GraphQLFieldDefinition.newFieldDefinition().name("id").description("唯一主键")
							.type(Scalars.GraphQLLong).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("universityId").description("学校id")
							.type(Scalars.GraphQLLong).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("schoolYear").description("学年")
							.type(Scalars.GraphQLString).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("term").description("学期")
							.type(Scalars.GraphQLByte).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("subjectNumber").description("课程编号")
							.type(Scalars.GraphQLString).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("courseName").description("课程名称")
							.type(Scalars.GraphQLString).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("teacherName").description("教师姓名")
							.type(Scalars.GraphQLString).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("courseTime").description("上课时间")
							.type(Scalars.GraphQLString).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("studentNo").description("学生学号")
							.type(Scalars.GraphQLString).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("studentName").description("学生姓名")
							.type(Scalars.GraphQLString).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("isMan").description("学生性别")
							.type(Scalars.GraphQLBoolean).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("majorName").description("专业名称")
							.type(Scalars.GraphQLString).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("collegeName").description("学院名称")
							.type(Scalars.GraphQLString).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("physicalTest")
							.argument(GraphQLArgument.newArgument().name("testResult").type(Scalars.GraphQLInt).build())
							.description("该学生的所有体测数据取第一条")
							.type(PhysicalTestType.getType())
							.dataFetcher(environment -> {
								SportsCourse sportsCourse = environment.getSource();
								PhysicalTestExample example = new PhysicalTestExample();
								com.wzsport.model.PhysicalTestExample.Criteria criteria = example.createCriteria();
								criteria.andStudentNoEqualTo(sportsCourse.getStudentNo());
								Integer testResult = environment.getArgument("testResult");
								System.out.println(testResult+"123");
								if (testResult != null) {
									if (testResult == 1) {
										criteria.andIsTestedEqualTo(false);
									}//没测
									if (testResult == 2) {
										criteria.andIsFreeTestEqualTo(true);
									}//免测
									if (testResult == 3) {
										criteria.andTotalScoreLessThan(60.0);
									}
								}
								List<PhysicalTest> physicalTestList = physicalTestMapper.selectByExample(example);
								if (physicalTestList.size() != 0) {
									return physicalTestList.get(0);
								}
								return null;
							}).build())
					.build();
		}
		return type;
	}
	public static GraphQLFieldDefinition getListQueryField(){
		if (listQueryField == null) {
			listQueryField = GraphQLFieldDefinition.newFieldDefinition()
					.argument(GraphQLArgument.newArgument().name("universityId").type(Scalars.GraphQLLong).build())
					.argument(GraphQLArgument.newArgument().name("className").type(Scalars.GraphQLString).build())
					.argument(GraphQLArgument.newArgument().name("studentName").type(Scalars.GraphQLString).build())
					.argument(GraphQLArgument.newArgument().name("studentNo").type(Scalars.GraphQLString).build())
					.argument(GraphQLArgument.newArgument().name("pageNumber").type(Scalars.GraphQLInt).build())
					.argument(GraphQLArgument.newArgument().name("pageSize").type(Scalars.GraphQLInt).build())
					.type(PageType.getPageTypeBuidler(getType())
							.name("courseStudentPage")
							.description("根据学生信息分页")
							.build())
					.name("searchCourseStudents").description("搜索课程学生").dataFetcher(environment -> {
						String className = environment.getArgument("className");
						String studentName = environment.getArgument("studentName");
						String studentNo = environment.getArgument("studentNo");
						SportsCourseExample example = new SportsCourseExample();
						Criteria criteria = example.createCriteria();
						
						if (className != null) {
							criteria.andMajorNameLike("%" + className + "%");
						}
						if (studentName != null) {
							criteria.andStudentNameLike("%" + studentName + "%");
						}
						if (studentNo != null) {
							criteria.andStudentNoLike("%" + studentNo + "%");
						}
						
						PageHelper.startPage(environment.getArgument("pageNumber"),
								environment.getArgument("pageSize"));
						
						List<SportsCourse> studentList = sportsCourseMapper.selectByExample(example);
						return studentList;
					}).build();
		}
		return listQueryField;
	}
	
	
	@Autowired(required = true)
	public void setSportsCourseMapper(SportsCourseMapper sportsCourseMapper) {
		SportsCourseType.sportsCourseMapper = sportsCourseMapper;
	}
	
	@Autowired(required = true)
	public void setPhysicalTestMapper(PhysicalTestMapper physicalTestMapper) {
		SportsCourseType.physicalTestMapper = physicalTestMapper;
	}
	
	
}
