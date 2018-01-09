package com.wzsport.mapper;

import com.wzsport.model.TeachingClassStudentSignInCountView;
import com.wzsport.model.TeachingClassStudentSignInCountViewExample;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TeachingClassStudentSignInCountViewMapper {
    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_teaching_class_student_sign_in_count_view
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    long countByExample(TeachingClassStudentSignInCountViewExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_teaching_class_student_sign_in_count_view
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    int deleteByExample(TeachingClassStudentSignInCountViewExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_teaching_class_student_sign_in_count_view
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    @Insert({ "insert into wzsport_teaching_class_student_sign_in_count_view (running_activity_qualified_count, ",
            "area_activity_qualified_count, course_name, ", "term, school_year, ", "course_time, teacher_name, ",
            "student_name, is_man, ", "student_no, university_id)",
            "values (#{runningActivityQualifiedCount,jdbcType=BIGINT}, ",
            "#{areaActivityQualifiedCount,jdbcType=BIGINT}, #{courseName,jdbcType=VARCHAR}, ",
            "#{term,jdbcType=VARCHAR}, #{schoolYear,jdbcType=VARCHAR}, ",
            "#{courseTime,jdbcType=VARCHAR}, #{teacherName,jdbcType=VARCHAR}, ",
            "#{studentName,jdbcType=VARCHAR}, #{isMan,jdbcType=BIT}, ",
            "#{studentNo,jdbcType=VARCHAR}, #{universityId,jdbcType=BIGINT})" })
    int insert(TeachingClassStudentSignInCountView record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_teaching_class_student_sign_in_count_view
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    int insertSelective(TeachingClassStudentSignInCountView record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_teaching_class_student_sign_in_count_view
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    List<TeachingClassStudentSignInCountView> selectByExample(TeachingClassStudentSignInCountViewExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_teaching_class_student_sign_in_count_view
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    int updateByExampleSelective(@Param("record") TeachingClassStudentSignInCountView record,
            @Param("example") TeachingClassStudentSignInCountViewExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_teaching_class_student_sign_in_count_view
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    int updateByExample(@Param("record") TeachingClassStudentSignInCountView record,
            @Param("example") TeachingClassStudentSignInCountViewExample example);

    @Select({ "select", "running_activity_qualified_count, ",
        "area_activity_qualified_count, course_name, ",
        "term, school_year, ",
        "course_time, teacher_name, ",
        "student_name, is_man, ",
        "student_no, university_id", "from wzsport_teaching_class_student_sign_in_count_view ",
		"where university_id = #{id,jdbcType=BIGINT} group by school_year" })
	List<TeachingClassStudentSignInCountView> getSchoolYear(Long id);
    
    @Select({ "select", "running_activity_qualified_count, ",
        "area_activity_qualified_count, course_name, ",
        "term, school_year, ",
        "course_time, teacher_name, ",
        "student_name, is_man, ",
        "student_no, university_id", "from wzsport_teaching_class_student_sign_in_count_view ",
        "where university_id = #{universityId,jdbcType=BIGINT} ", "and school_year = #{schoolYear,jdbcType=VARCHAR} ",
		"and term = #{term,jdbcType=VARCHAR} group by teacher_name"})
    List<TeachingClassStudentSignInCountView> getTeacherBySchoolYearAndTerm(TeachingClassStudentSignInCountView t);
    
    @Select({ "select", "running_activity_qualified_count, ",
        "area_activity_qualified_count, course_name, ",
        "term, school_year, ",
        "course_time, teacher_name, ",
        "student_name, is_man, ",
        "student_no, university_id", "from wzsport_teaching_class_student_sign_in_count_view ",
        "where university_id = #{id,jdbcType=BIGINT} group by teacher_name"})
	List<TeachingClassStudentSignInCountView> getTeacher(Long id);
    
    @Select({ "select", "running_activity_qualified_count, ",
        "area_activity_qualified_count, course_name, ",
        "term, school_year, ",
        "course_time, teacher_name, ",
        "student_name, is_man, ",
        "student_no, university_id", "from wzsport_teaching_class_student_sign_in_count_view ",
        "where university_id = #{universityId,jdbcType=BIGINT} ", "and school_year = #{schoolYear,jdbcType=VARCHAR} ",
		"and term = #{term,jdbcType=VARCHAR} and teacher_name = #{teacherName,jdbcType=VARCHAR} group by course_name"})
	List<TeachingClassStudentSignInCountView> getCourseNameBySchoolYearAndTermAndTeacherName(TeachingClassStudentSignInCountView t);

    @Select({ "select", "running_activity_qualified_count, ",
        "area_activity_qualified_count, course_name, ",
        "term, school_year, ",
        "course_time, teacher_name, ",
        "student_name, is_man, ",
        "student_no, university_id", "from wzsport_teaching_class_student_sign_in_count_view ",
        "where university_id = #{id,jdbcType=BIGINT} group by course_name"})
	List<TeachingClassStudentSignInCountView> getCourseName(Long id);
    
    @Select({ "select", "running_activity_qualified_count, ",
        "area_activity_qualified_count, course_name, ",
        "term, school_year, ",
        "course_time, teacher_name, ",
        "student_name, is_man, ",
        "student_no, university_id", "from wzsport_teaching_class_student_sign_in_count_view ",
        "where university_id = #{universityId,jdbcType=BIGINT} ", "and school_year = #{schoolYear,jdbcType=VARCHAR} ",
		"and term = #{term,jdbcType=VARCHAR} and teacher_name = #{teacherName,jdbcType=VARCHAR} and course_name = #{courseName,jdbcType=VARCHAR} group by course_time"})
	List<TeachingClassStudentSignInCountView> getCourseTimeBySchoolYearAndTermAndTeacherNameAndCourseName(TeachingClassStudentSignInCountView t);

    @Select({ "select", "running_activity_qualified_count, ",
        "area_activity_qualified_count, course_name, ",
        "term, school_year, ",
        "course_time, teacher_name, ",
        "student_name, is_man, ",
        "student_no, university_id", "from wzsport_teaching_class_student_sign_in_count_view ",
        "where university_id = #{id,jdbcType=BIGINT} group by course_time"})
	List<TeachingClassStudentSignInCountView> getCourseTime(Long id);

    @Select({ "select", "running_activity_qualified_count, ",
        "area_activity_qualified_count, course_name, ",
        "term, school_year, ",
        "course_time, teacher_name, ",
        "student_name, is_man, ",
        "student_no, university_id", "from wzsport_teaching_class_student_sign_in_count_view ",
        "where university_id = #{universityId,jdbcType=BIGINT} ", "and school_year = #{schoolYear,jdbcType=VARCHAR} ",
		"group by term"})
	List<TeachingClassStudentSignInCountView> getTermBySchoolYear(TeachingClassStudentSignInCountView t);
    
    @Select({ "select", "running_activity_qualified_count, ",
        "area_activity_qualified_count, course_name, ",
        "term, school_year, ",
        "course_time, teacher_name, ",
        "student_name, is_man, ",
        "student_no, university_id", "from wzsport_teaching_class_student_sign_in_count_view ",
        "where university_id = #{id,jdbcType=BIGINT} group by term"})
	List<TeachingClassStudentSignInCountView> getTerm(Long id);
}