package com.wzsport.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wzsport.mapper.SportsCourseMapper;
import com.github.pagehelper.PageHelper;
import com.wzsport.mapper.CollegeMapper;
import com.wzsport.mapper.StudentStatisticViewMapper;
import com.wzsport.mapper.TeacherMapper;
import com.wzsport.mapper.TeachingClassStudentSignInCountViewMapper;
import com.wzsport.mapper.UniversityMapper;
import com.wzsport.mapper.UserMapper;
import com.wzsport.model.College;
import com.wzsport.model.CollegeExample;
import com.wzsport.model.StudentStatisticView;
import com.wzsport.model.StudentStatisticViewExample;
import com.wzsport.model.SportsCourse;
import com.wzsport.model.TeacherExample;
import com.wzsport.model.TeachingClassStudentSignInCountView;
import com.wzsport.model.University;
import com.wzsport.model.UniversityExample;
import com.wzsport.model.UserExample;
import com.wzsport.service.TermService;

import graphql.Scalars;
import graphql.schema.GraphQLArgument;
import graphql.schema.GraphQLEnumType;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLObjectType;

/**
* GraphQL大学类型的定义及查询字段定义
* 
* @author x1ny
* @date 2017年5月25日
*/
@Component
public class UniversityType {

	private static UniversityMapper universityMapper;
	private static CollegeMapper collegeMapper;
	private static TeacherMapper teacherMapper;
	private static SportsCourseMapper sportsCourseMapper;
	private static UserMapper userMapper;
	private static StudentStatisticViewMapper studentStatisticViewMapper;
	private static TermService termService;
	private static GraphQLObjectType type;
	private static GraphQLFieldDefinition singleQueryField;
	private static GraphQLFieldDefinition listField;

	private static TeachingClassStudentSignInCountViewMapper teachingClassStudentSignInCountViewMapper;
	
	public static enum Operator {
		LESS_THAN, GREATER_THAN, EQUAL, BETWEEN
	}
	
	private static GraphQLEnumType operatorEnumType = GraphQLEnumType.newEnum()
		    .name("Operator")
		    .value(Operator.LESS_THAN.toString())
		    .value(Operator.GREATER_THAN.toString())
		    .value(Operator.EQUAL.toString())
		    .value(Operator.BETWEEN.toString())
		    .build();
	
	private UniversityType() {}
	
	public static GraphQLObjectType getType() {
		if(type == null) {
			type = GraphQLObjectType.newObject()
					.name("University")
					.description("大学类型")
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("id")
							.description("唯一主键")
							.type(Scalars.GraphQLLong)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("name")
							.description("大学名称")
							.type(Scalars.GraphQLString)
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("colleges")
							.description("该大学中的所有学院")
							.type(new GraphQLList(CollegeType.getType()))
							.dataFetcher(environment ->  {
								University university = environment.getSource();
								CollegeExample collegeExample = new CollegeExample();
								collegeExample.createCriteria().andUniversityIdEqualTo(university.getId());
			                	List<College> collegeList = collegeMapper.selectByExample(collegeExample);
			                	return collegeList;
							} )
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("teachersCount")
							.description("该大学中的教师总数")
							.type(Scalars.GraphQLInt)
							.dataFetcher(environment ->  {
								University university = environment.getSource();
								TeacherExample teacherExample = new TeacherExample();
								teacherExample.createCriteria().andUniversityIdEqualTo(university.getId());
			                	int teachersCount = (int) teacherMapper.countByExample(teacherExample);
			                	return teachersCount;
							} )
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("maleTeachersCount")
							.description("该大学中的男性教师总数")
							.type(Scalars.GraphQLInt)
							.dataFetcher(environment ->  {
								University university = environment.getSource();
								TeacherExample teacherExample = new TeacherExample();
								teacherExample.createCriteria().andUniversityIdEqualTo(university.getId()).andManEqualTo(true);
			                	int maleTeachersCount = (int) teacherMapper.countByExample(teacherExample);
			                	return maleTeachersCount;
							} )
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("femaleTeachersCount")
							.description("该大学中的女性教师总数")
							.type(Scalars.GraphQLInt)
							.dataFetcher(environment ->  {
								University university = environment.getSource();
								TeacherExample teacherExample = new TeacherExample();
								teacherExample.createCriteria().andUniversityIdEqualTo(university.getId()).andManEqualTo(false);
			                	int femaleTeachersCount = (int) teacherMapper.countByExample(teacherExample);
			                	return femaleTeachersCount;
							} )
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
                            .name("activeStudentCount")
                            .description("该大学中的激活学生总数")
                            .type(Scalars.GraphQLInt)
                            .dataFetcher(environment ->  {
                                University university = environment.getSource();
                                
                                UserExample example = new UserExample();
                                example.createCriteria().andUniversityIdEqualTo(university.getId()).andOpenIdNotEqualTo("");
                                
                                int count = (int) userMapper.countByExample(example);
                                return count;
                            } )
                            .build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
                            .name("studentCount")
                            .description("该大学中的学生总数")
                            .type(Scalars.GraphQLInt)
                            .dataFetcher(environment ->  {
                                University university = environment.getSource();
                                
                                UserExample example = new UserExample();
                                example.createCriteria().andUniversityIdEqualTo(university.getId());
                                
                                int count = (int) userMapper.countByExample(example);
                                return count;
                            } )
                            .build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("kcalConsumptionRanking")
							.description("该校的学生累计热量消耗量排行榜")
							.argument(GraphQLArgument.newArgument().name("pageNumber").type(Scalars.GraphQLInt).build())
							.argument(GraphQLArgument.newArgument().name("pageSize").type(Scalars.GraphQLInt).build())
							.type(PageType.getPageTypeBuidler(StudentKcalConsumptionType.getType())
									.name("StudentKcalConsumptionPage")
									.description("学生卡路里消耗量分页")
									.build())
							.dataFetcher(environment ->  {
								University university = environment.getSource();
								PageHelper.startPage(environment.getArgument("pageNumber"), environment.getArgument("pageSize"));
			                	return universityMapper.getKcalCostedRanking(university.getId());
							} )
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("timeCostedRanking")
							.description("该校的学生累计锻炼时长排行榜")
							.argument(GraphQLArgument.newArgument().name("pageNumber").type(Scalars.GraphQLInt).build())
							.argument(GraphQLArgument.newArgument().name("pageSize").type(Scalars.GraphQLInt).build())
							.type(PageType.getPageTypeBuidler(StudentTimeCostedType.getType())
									.name("StudentTimeCostedPage")
									.description("学生锻炼时间累计分页")
									.build())
							.dataFetcher(environment ->  {
								University university = environment.getSource();
								PageHelper.startPage(environment.getArgument("pageNumber"), environment.getArgument("pageSize"));
								return universityMapper.getTimeCostedRanking(university.getId());
							} )
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("currentTerm")
							.type(TermType.getType())
							.dataFetcher(environment ->  {
								University university = environment.getSource();
								return termService.getCurrentTerm(university.getId());
							} )
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("getSchoolYear")
							.description("该校的所有学年")
							.type(new GraphQLList(TeachingClassStudentSignInCountType.getType()))
							.dataFetcher(environment ->  {
								University university = environment.getSource();
								return teachingClassStudentSignInCountViewMapper.getSchoolYear(university.getId());
							} )
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("getTerm")
							.description("该学年的所有学期")
							.argument(GraphQLArgument.newArgument().name("schoolYear").type(Scalars.GraphQLString).build())
							.type(new GraphQLList(TeachingClassStudentSignInCountType.getType()))
							.dataFetcher(environment ->  {
								University university = environment.getSource();
								String schoolYear = environment.getArgument("schoolYear");
								if (schoolYear != null) {
									TeachingClassStudentSignInCountView t = new TeachingClassStudentSignInCountView();
									t.setSchoolYear(schoolYear);
									t.setUniversityId(university.getId());
									return teachingClassStudentSignInCountViewMapper.getTermBySchoolYear(t);
								}
								return teachingClassStudentSignInCountViewMapper.getTerm(university.getId());
							} )
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("getTeacher")
							.description("该学年学期所有教师")
							.argument(GraphQLArgument.newArgument().name("schoolYear").type(Scalars.GraphQLString).build())
							.argument(GraphQLArgument.newArgument().name("term").type(Scalars.GraphQLString).build())
							.type(new GraphQLList(TeachingClassStudentSignInCountType.getType()))
							.dataFetcher(environment ->  {
								University university = environment.getSource();
								String schoolYear = environment.getArgument("schoolYear");
								String term = environment.getArgument("term");
								if (schoolYear != null && term != null) {
									TeachingClassStudentSignInCountView t = new TeachingClassStudentSignInCountView();
									t.setSchoolYear(schoolYear);
									t.setTerm(term);
									t.setUniversityId(university.getId());
									return teachingClassStudentSignInCountViewMapper.getTeacherBySchoolYearAndTerm(t);
								}
								return teachingClassStudentSignInCountViewMapper.getTeacher(university.getId());
							} )
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("getCourseName")
							.description("该学年学期教师所有课程")
							.argument(GraphQLArgument.newArgument().name("schoolYear").type(Scalars.GraphQLString).build())
							.argument(GraphQLArgument.newArgument().name("term").type(Scalars.GraphQLString).build())
							.argument(GraphQLArgument.newArgument().name("teacherName").type(Scalars.GraphQLString).build())
							.type(new GraphQLList(TeachingClassStudentSignInCountType.getType()))
							.dataFetcher(environment ->  {
								University university = environment.getSource();
								String schoolYear = environment.getArgument("schoolYear");
								String term = environment.getArgument("term");
								String teacherName = environment.getArgument("teacherName");
								if (schoolYear != null && term != null && teacherName != null) {
									TeachingClassStudentSignInCountView t = new TeachingClassStudentSignInCountView();
									t.setSchoolYear(schoolYear);
									t.setTerm(term);
									t.setTeacherName(teacherName);
									t.setUniversityId(university.getId());
									return teachingClassStudentSignInCountViewMapper.getCourseNameBySchoolYearAndTermAndTeacherName(t);
								}
								return teachingClassStudentSignInCountViewMapper.getCourseName(university.getId());
							} )
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("getCourseTime")
							.description("该学年学期教师课程所有时间")
							.argument(GraphQLArgument.newArgument().name("schoolYear").type(Scalars.GraphQLString).build())
							.argument(GraphQLArgument.newArgument().name("term").type(Scalars.GraphQLString).build())
							.argument(GraphQLArgument.newArgument().name("teacherName").type(Scalars.GraphQLString).build())
							.argument(GraphQLArgument.newArgument().name("courseName").type(Scalars.GraphQLString).build())
							.type(new GraphQLList(TeachingClassStudentSignInCountType.getType()))
							.dataFetcher(environment ->  {
								University university = environment.getSource();
								String schoolYear = environment.getArgument("schoolYear");
								String term = environment.getArgument("term");
								String teacherName = environment.getArgument("teacherName");
								String courseName = environment.getArgument("courseName");
								if (schoolYear != null && term != null && teacherName != null && courseName != null) {
									TeachingClassStudentSignInCountView t = new TeachingClassStudentSignInCountView();
									t.setSchoolYear(schoolYear);
									t.setTerm(term);
									t.setTeacherName(teacherName);
									t.setCourseName(courseName);
									t.setUniversityId(university.getId());
									return teachingClassStudentSignInCountViewMapper.getCourseTimeBySchoolYearAndTermAndTeacherNameAndCourseName(t);
								}
								return teachingClassStudentSignInCountViewMapper.getCourseTime(university.getId());
							} )
							.build())

					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("studentStatisticInfo")
							.description("所有学生基本运动信息")
							.argument(GraphQLArgument.newArgument().name("isUser").type(Scalars.GraphQLInt).build())
							.argument(GraphQLArgument.newArgument().name("universityId").type(Scalars.GraphQLLong).build())
							.argument(GraphQLArgument.newArgument().name("pageNumber").type(Scalars.GraphQLInt).build())
							.argument(GraphQLArgument.newArgument().name("pageSize").type(Scalars.GraphQLInt).build())
							.argument(GraphQLArgument.newArgument().name("studentName").type(Scalars.GraphQLString).build())
							.argument(GraphQLArgument.newArgument().name("studentNo").type(Scalars.GraphQLString).build())
							.argument(GraphQLArgument.newArgument().name("className").type(Scalars.GraphQLString).build())
							.argument(GraphQLArgument.newArgument().name("signInCountOperator").type(operatorEnumType).build())
							.argument(GraphQLArgument.newArgument().name("signInCount").type(Scalars.GraphQLLong).build())
							.argument(GraphQLArgument.newArgument().name("anotherSignInCount").type(Scalars.GraphQLLong).build())
							.type(PageType.getPageTypeBuidler(StudentStatisticType.getType())
									.name("StudentStatisticInfoPage").description("学生基本运动信息分页").build())
							.dataFetcher(environment -> {
								List<StudentStatisticView> list = null;
								StudentStatisticViewExample example = new StudentStatisticViewExample();
								com.wzsport.model.StudentStatisticViewExample.Criteria criteria = example.createCriteria();
								Long universityId = environment.getArgument("universityId");
								String studentName = environment.getArgument("studentName");
								
								Long signInCount = environment.getArgument("signInCount");
											
								if (studentName != null) {
									criteria.andStudentNameLike("%" + studentName + "%");
								}
								String studentNo = environment.getArgument("studentNo");
								if (studentNo != null) {
									criteria.andStudentNoLike("%" + studentNo + "%");
								}
								String className = environment.getArgument("className");
								if (className != null) {
									criteria.andClassNameLike("%" + className + "%");
								}
								int isUser = environment.getArgument("isUser");
								if (isUser == 0) {
									criteria.andUniversityIdEqualTo(universityId);
								}
								if (isUser == 1) {
									criteria.andUniversityIdEqualTo(universityId).andOpenIdNotEqualTo("");
								}
								if (isUser == 2) {
									criteria.andUniversityIdEqualTo(universityId).andOpenIdEqualTo("");
								}
																
								if (signInCount != null) {
									switch(Operator.valueOf(environment.getArgument("signInCountOperator"))) {
									case BETWEEN:
										Long anotherSignInCount = environment.getArgument("anotherSignInCount");
										criteria.andSignInCountBetween(signInCount, anotherSignInCount);
										break;
									case EQUAL:
										criteria.andSignInCountEqualTo(signInCount);
										break;
									case GREATER_THAN:
										criteria.andSignInCountGreaterThan(signInCount);
										break;
									case LESS_THAN:
										criteria.andSignInCountLessThan(signInCount);
										break;
									}
								}
															
								PageHelper.startPage(environment.getArgument("pageNumber"), environment.getArgument("pageSize"));
								list = studentStatisticViewMapper.selectByExample(example);
								return list;
							}).build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("teacherNameList")
							.description("该校的所有体育教师")
							.argument(GraphQLArgument.newArgument().name("schoolYear").type(Scalars.GraphQLString).build())
							.argument(GraphQLArgument.newArgument().name("term").type(Scalars.GraphQLInt).build())
							.type(new GraphQLList(SportsCourseType.getType()))
							.dataFetcher(environment ->  {
								University university = environment.getSource();
								
								String schoolYear = environment.getArgument("schoolYear");
								Integer term = environment.getArgument("term");
								if (schoolYear != null && term != null){
									SportsCourse record = new SportsCourse();
									record.setUniversityId(university.getId());
									record.setTerm(term);
									record.setSchoolYear(schoolYear);
									return sportsCourseMapper.getTeacherNameBySchoolYearAndTerm(record);
								} else {
									return sportsCourseMapper.getTeacherName(university.getId());
								}
							} )
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("schoolYearList")
							.description("该校的所有学年")
							.type(new GraphQLList(SportsCourseType.getType()))
							.dataFetcher(environment ->  {
								University university = environment.getSource();
								return sportsCourseMapper.getSchoolYear(university.getId());
							} )
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("courseNameList")
							.description("该校的所有体育课名")
							.argument(GraphQLArgument.newArgument().name("schoolYear").type(Scalars.GraphQLString).build())
							.argument(GraphQLArgument.newArgument().name("term").type(Scalars.GraphQLInt).build())
							.argument(GraphQLArgument.newArgument().name("teacherName").type(Scalars.GraphQLString).build())
							.type(new GraphQLList(SportsCourseType.getType()))
							.dataFetcher(environment ->  {
								
								University university = environment.getSource();
								String schoolYear = environment.getArgument("schoolYear");
								String teacherName = environment.getArgument("teacherName");
								Integer term = environment.getArgument("term");
								
								if (schoolYear != null && teacherName != null && term != null){
									SportsCourse record = new SportsCourse();
									record.setUniversityId(university.getId());
									record.setSchoolYear(schoolYear);
									record.setTeacherName(teacherName);
									record.setTerm(term);
									return sportsCourseMapper.getCourseNameBySchoolYearAndTermAndTeacherName(record);
								}
								return sportsCourseMapper.getCourseName(university.getId());
							} )
							.build())
					.field(GraphQLFieldDefinition.newFieldDefinition()
							.name("courseTimeList")
							.description("该校的所有体育课时段")
							.argument(GraphQLArgument.newArgument().name("schoolYear").type(Scalars.GraphQLString).build())
							.argument(GraphQLArgument.newArgument().name("term").type(Scalars.GraphQLInt).build())
							.argument(GraphQLArgument.newArgument().name("teacherName").type(Scalars.GraphQLString).build())
							.argument(GraphQLArgument.newArgument().name("courseName").type(Scalars.GraphQLString).build())
							.type(new GraphQLList(SportsCourseType.getType()))
							.dataFetcher(environment ->  {
								University university = environment.getSource();
								
								String schoolYear = environment.getArgument("schoolYear");
								String teacherName = environment.getArgument("teacherName");
								String courseName = environment.getArgument("courseName");
								Integer term = environment.getArgument("term");
								
								if (schoolYear != null && teacherName != null && term != null && courseName != null){
									SportsCourse record = new SportsCourse();
									record.setUniversityId(university.getId());
									record.setSchoolYear(schoolYear);
									record.setTeacherName(teacherName);
									record.setTerm(term);
									record.setCourseName(courseName);
									return sportsCourseMapper.getCourseTimeBySchoolYearAndTermAndTeacherNameAndCourseName
											(record);
								}
								return sportsCourseMapper.getCourseTime(university.getId());
							} )
							.build())
					.build();
		}
		
		return type;
	}
	
	public static GraphQLFieldDefinition getSingleQueryField() {
		if(singleQueryField == null) {
			singleQueryField = GraphQLFieldDefinition.newFieldDefinition()
	                .name("university")
	                .description("根据ID获取大学")
	                .argument(GraphQLArgument.newArgument().name("id").type(Scalars.GraphQLLong).build())
	                .type(getType())
	                .dataFetcher(environment ->  {
	                	long id = environment.getArgument("id");
	                	University university = universityMapper.selectByPrimaryKey(id);
	                	return university;
	                } ).build();
		}
        return singleQueryField;
    }
	
	public static GraphQLFieldDefinition getListField() {
		if (listField == null) {
			listField = GraphQLFieldDefinition.newFieldDefinition()
					.name("universities")
	                .description("获取大学列表")
	                .type(new GraphQLList(getType()))
					.dataFetcher(environment -> {
						UniversityExample example = new UniversityExample();
						example.createCriteria().andIdGreaterThan(0L);
						List<University> list = universityMapper.selectByExample(example);
						return list;
					}).build();
		}
		return listField;
	}

	@Autowired(required = true)
   	public void setTeachingClassStudentSignInCountViewMapper(
			TeachingClassStudentSignInCountViewMapper teachingClassStudentSignInCountViewMapper) {
		UniversityType.teachingClassStudentSignInCountViewMapper = teachingClassStudentSignInCountViewMapper;
	}

   	@Autowired(required = true)
    public void setUserMapper(UserMapper userMapper) {
        UniversityType.userMapper = userMapper;
    }

	@Autowired(required = true)
	public void setCollegeMapper(CollegeMapper collegeMapper) {
		UniversityType.collegeMapper = collegeMapper;
	}
	
	@Autowired(required = true)
	public void setTeacherMapper(TeacherMapper teacherMapper) {
		UniversityType.teacherMapper = teacherMapper;
	}
	
	@Autowired(required = true)
	public void setUniversityMapper(UniversityMapper universityMapper) {
		UniversityType.universityMapper = universityMapper;
	}
	
	@Autowired(required = true)
	public void setTermService(TermService termService) {
		UniversityType.termService = termService;
	}
	
	@Autowired(required = true)
	public void setStudentStatisticViewMapper(StudentStatisticViewMapper studentStatisticViewMapper) {
		UniversityType.studentStatisticViewMapper = studentStatisticViewMapper;
	}
	
	@Autowired(required = true)
	public void setSportsCourseMapper(SportsCourseMapper sportsCourseMapper) {
		UniversityType.sportsCourseMapper = sportsCourseMapper;
	}
}
