package com.wzsport.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.pagehelper.PageHelper;
import com.wzsport.model.StudentCoursePhysicalTestExample;
import com.wzsport.model.StudentCoursePhysicalTestExample.Criteria;
import com.wzsport.model.StudentExample;
import com.wzsport.mapper.ClassMapper;
import com.wzsport.mapper.StudentCoursePhysicalTestMapper;
import com.wzsport.mapper.StudentMapper;
import com.wzsport.model.ClassExample;
import com.wzsport.model.StudentCoursePhysicalTest;

import graphql.Scalars;
import graphql.schema.GraphQLArgument;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLObjectType;

@Component
public class StudentCoursePhysicalTestType {
	private static GraphQLObjectType type;
	private static GraphQLFieldDefinition listQueryField;

	private static ClassMapper classMapper;
	private static StudentCoursePhysicalTestMapper studentCoursePhysicalTestMapper;
	
	
	public static GraphQLObjectType getType(){
		if (type == null) {
			type = GraphQLObjectType.newObject().name("StudentCoursesPhysicalTest").description("教学班学生体测数据类型")
					.field(GraphQLFieldDefinition.newFieldDefinition().name("id").description("唯一主键").type(Scalars.GraphQLLong).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("gradeNo").description("年级编号").type(Scalars.GraphQLLong).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("studentName").description("学生姓名").type(Scalars.GraphQLString).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("classNo").description("班级编号").type(Scalars.GraphQLLong).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("className").description("班级名称").type(Scalars.GraphQLString).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("collegeName").description("学院名称").type(Scalars.GraphQLString).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("isMan").description("性别").type(Scalars.GraphQLBoolean).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("studentNo").description("学号").type(Scalars.GraphQLString).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("totalScore").description("总分").type(Scalars.GraphQLFloat).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("height").description("身高").type(Scalars.GraphQLFloat).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("weight").description("体重").type(Scalars.GraphQLFloat).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("vitalCapacity").description("肺活量").type(Scalars.GraphQLLong).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("standingLongJump").description("立定跳远").type(Scalars.GraphQLInt).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("sitAndReach").description("坐位体前屈").type(Scalars.GraphQLFloat).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("oneMinuteSitUp").description("仰卧起坐").type(Scalars.GraphQLInt).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("pullUp").description("引体向上").type(Scalars.GraphQLInt).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("fiftyRunTime").description("50米跑成绩").type(Scalars.GraphQLFloat).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("eightHundredRunTime").description("800米跑成绩").type(Scalars.GraphQLFloat).build())
					.field(GraphQLFieldDefinition.newFieldDefinition().name("oneThousandRunTime").description("1000米跑成绩").type(Scalars.GraphQLFloat).build())
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
					.argument(GraphQLArgument.newArgument().name("testResult").type(Scalars.GraphQLInt).build())
					.argument(GraphQLArgument.newArgument().name("schoolYear").type(Scalars.GraphQLString).build())
					.argument(GraphQLArgument.newArgument().name("term").type(Scalars.GraphQLInt).build())
					.argument(GraphQLArgument.newArgument().name("teacherName").type(Scalars.GraphQLString).build())
					.argument(GraphQLArgument.newArgument().name("courseName").type(Scalars.GraphQLString).build())
					.argument(GraphQLArgument.newArgument().name("courseTime").type(Scalars.GraphQLString).build())
					.argument(GraphQLArgument.newArgument().name("classId").type(Scalars.GraphQLInt).build())
					.type(PageType.getPageTypeBuidler(getType())
							.name("studentCoursePhysicalTestPage")
							.description("根据学生课程体测信息分页")
							.build())
					.name("searchCoursePhysicalTest").description("搜索课程学生").dataFetcher(environment -> {
						Long universityId = environment.getArgument("universityId");
						String className = environment.getArgument("className");
						String studentName = environment.getArgument("studentName");
						String studentNo = environment.getArgument("studentNo");
						String courseTime = environment.getArgument("courseTime");
						String schoolYear = environment.getArgument("schoolYear");
						String teacherName = environment.getArgument("teacherName");
						String courseName = environment.getArgument("courseName");
						Integer term = environment.getArgument("term");
						Integer testResult = environment.getArgument("testResult");
						Integer classId = environment.getArgument("classId");
						
						StudentCoursePhysicalTestExample example = new StudentCoursePhysicalTestExample();
						Criteria criteria = example.createCriteria();
						if (classId != null) {
							ClassExample classExample = new ClassExample();
							classExample.createCriteria().andIdEqualTo(classId.longValue());
							com.wzsport.model.Class c = classMapper.selectByExample(classExample).get(0);
							criteria.andClassNameEqualTo(c.getName());
						}
						if (universityId == null) {
							return null;
						} else {
							criteria.andUniversityIdEqualTo(universityId);
						}
						if (testResult != null) {
							if (testResult == 1) {
								criteria.andIsTestedEqualTo(false);
							}//没测
							if (testResult == 2) {
								criteria.andIsFreeTestEqualTo(true);
							}//免测
							if (testResult == 3) {
								criteria.andIsPassEqualTo(false);
							}//不及格
						}
						if (className != null) {
							criteria.andMajorNameLike("%" + className + "%");
						}
						if (studentName != null) {
							criteria.andStudentNameLike("%" + studentName + "%");
						}
						if (studentNo != null) {
							criteria.andStudentNoLike("%" + studentNo + "%");
						}
						if (courseTime != null) {
							criteria.andCourseTimeEqualTo(courseTime);
						}
						if (schoolYear != null) {
							criteria.andSchoolYearEqualTo(schoolYear);
						}
						if (teacherName != null) {
							criteria.andTeacherNameEqualTo(teacherName);
						}
						if (courseName != null) {
							criteria.andCourseNameEqualTo(courseName);
						}
						if (term != null) {
							criteria.andTermEqualTo(term);
						}
						PageHelper.startPage(environment.getArgument("pageNumber"),
								environment.getArgument("pageSize"));
						List<StudentCoursePhysicalTest> list = studentCoursePhysicalTestMapper.selectByExample(example);
						return list;
					}).build();
		}
		return listQueryField;
	}
	
	@Autowired(required = true)
	public void setStudentCoursePhysicalTestMapper(StudentCoursePhysicalTestMapper studentCoursePhysicalTestMapper) {
		StudentCoursePhysicalTestType.studentCoursePhysicalTestMapper = studentCoursePhysicalTestMapper;
	}
	
	@Autowired(required = true)
	public void setClassMapper(ClassMapper classMapper) {
		StudentCoursePhysicalTestType.classMapper = classMapper;
	}
	
	
	
}
