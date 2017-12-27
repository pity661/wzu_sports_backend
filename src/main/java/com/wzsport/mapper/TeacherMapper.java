package com.wzsport.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.wzsport.model.Teacher;
import com.wzsport.model.TeacherExample;

public interface TeacherMapper {
	
	/**
     * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_teacher
     * @mbg.generated  Wed Dec 27 15:06:24 CST 2017
     */
    long countByExample(TeacherExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_teacher
     * @mbg.generated  Wed Dec 27 15:06:24 CST 2017
     */
    int deleteByExample(TeacherExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_teacher
     * @mbg.generated  Wed Dec 27 15:06:24 CST 2017
     */
    @Delete({ "delete from wzsport_teacher", "where id = #{id,jdbcType=BIGINT}" })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_teacher
     * @mbg.generated  Wed Dec 27 15:06:24 CST 2017
     */
    @Insert({ "insert into wzsport_teacher (job_no, university_id, ", "name, is_man, created_at, ", "updated_at)",
            "values (#{jobNo,jdbcType=VARCHAR}, #{universityId,jdbcType=BIGINT}, ",
            "#{name,jdbcType=VARCHAR}, #{man,jdbcType=BIT}, #{createdAt,jdbcType=TIMESTAMP}, ",
            "#{updatedAt,jdbcType=TIMESTAMP})" })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
    int insert(Teacher record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_teacher
     * @mbg.generated  Wed Dec 27 15:06:24 CST 2017
     */
    int insertSelective(Teacher record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_teacher
     * @mbg.generated  Wed Dec 27 15:06:24 CST 2017
     */
    List<Teacher> selectByExample(TeacherExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_teacher
     * @mbg.generated  Wed Dec 27 15:06:24 CST 2017
     */
    @Select({ "select", "id, job_no, university_id, name, is_man, created_at, updated_at", "from wzsport_teacher",
            "where id = #{id,jdbcType=BIGINT}" })
    @ResultMap("com.wzsport.mapper.TeacherMapper.BaseResultMap")
    Teacher selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_teacher
     * @mbg.generated  Wed Dec 27 15:06:24 CST 2017
     */
    int updateByExampleSelective(@Param("record") Teacher record, @Param("example") TeacherExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_teacher
     * @mbg.generated  Wed Dec 27 15:06:24 CST 2017
     */
    int updateByExample(@Param("record") Teacher record, @Param("example") TeacherExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_teacher
     * @mbg.generated  Wed Dec 27 15:06:24 CST 2017
     */
    int updateByPrimaryKeySelective(Teacher record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_teacher
     * @mbg.generated  Wed Dec 27 15:06:24 CST 2017
     */
    @Update({ "update wzsport_teacher", "set job_no = #{jobNo,jdbcType=VARCHAR},",
            "university_id = #{universityId,jdbcType=BIGINT},", "name = #{name,jdbcType=VARCHAR},",
            "is_man = #{man,jdbcType=BIT},", "created_at = #{createdAt,jdbcType=TIMESTAMP},",
            "updated_at = #{updatedAt,jdbcType=TIMESTAMP}", "where id = #{id,jdbcType=BIGINT}" })
    int updateByPrimaryKey(Teacher record);

    @Insert({ "insert into wzsport_r_teacher_class (teacher_id, class_id)",
		"values (#{teacherId}, #{ClassId})" })
	int associateTeacherAndClass(@Param("teacherId") long teacherId,@Param("ClassId") long ClassId);
	
	/**
	* 根据classId获取�??有相关联的teacher
	* 
	* @param classId
	*/
	@Select("SELECT teacher.id AS id, "
			+ "teacher.university_id AS university_id, "
			+ "teacher.name AS name, "
			+ "teacher.job_no AS job_no, "
			+ "teacher.is_man AS man, "
			+ "teacher.created_at AS created_at "
			+ "FROM wzsport_r_teacher_class "
			+ "JOIN wzsport_teacher as teacher ON wzsport_r_teacher_class.teacher_id = teacher.id "
			+ "WHERE wzsport_r_teacher_class.class_id = #{classId}")
	List<Teacher> listTeacherByClassId(long classId);
}