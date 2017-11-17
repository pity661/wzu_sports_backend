package com.wzsport.mapper;

import com.wzsport.model.StudentStatisticView;
import com.wzsport.model.StudentStatisticViewExample;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface StudentStatisticViewMapper {

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_student_statistic_view
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    long countByExample(StudentStatisticViewExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_student_statistic_view
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    int deleteByExample(StudentStatisticViewExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_student_statistic_view
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    @Insert({ "insert into wzsport_student_statistic_view (class_name, university_id, ", "user_type, open_id, ",
            "student_id, student_name, ", "student_no, is_man, class_id, ", "sign_in_count, running_activity_count, ",
            "area_activity_count, running_activity_qualified_count, ", "area_activity_qualified_count)",
            "values (#{className,jdbcType=VARCHAR}, #{universityId,jdbcType=BIGINT}, ",
            "#{userType,jdbcType=TINYINT}, #{openId,jdbcType=VARCHAR}, ",
            "#{studentId,jdbcType=BIGINT}, #{studentName,jdbcType=VARCHAR}, ",
            "#{studentNo,jdbcType=VARCHAR}, #{isMan,jdbcType=BIT}, #{classId,jdbcType=BIGINT}, ",
            "#{signInCount,jdbcType=BIGINT}, #{runningActivityCount,jdbcType=BIGINT}, ",
            "#{areaActivityCount,jdbcType=BIGINT}, #{runningActivityQualifiedCount,jdbcType=BIGINT}, ",
            "#{areaActivityQualifiedCount,jdbcType=BIGINT})" })
    int insert(StudentStatisticView record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_student_statistic_view
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    int insertSelective(StudentStatisticView record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_student_statistic_view
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    List<StudentStatisticView> selectByExample(StudentStatisticViewExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_student_statistic_view
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    int updateByExampleSelective(@Param("record") StudentStatisticView record,
            @Param("example") StudentStatisticViewExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_student_statistic_view
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    int updateByExample(@Param("record") StudentStatisticView record,
            @Param("example") StudentStatisticViewExample example);
}