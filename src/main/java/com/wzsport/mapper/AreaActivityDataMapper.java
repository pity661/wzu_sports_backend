package com.wzsport.mapper;

import com.wzsport.model.AreaActivityData;
import com.wzsport.model.AreaActivityDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface AreaActivityDataMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_area_activity_data
	 * @mbg.generated  Wed Nov 15 15:06:04 CST 2017
	 */
	long countByExample(AreaActivityDataExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_area_activity_data
	 * @mbg.generated  Wed Nov 15 15:06:04 CST 2017
	 */
	int deleteByExample(AreaActivityDataExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_area_activity_data
	 * @mbg.generated  Wed Nov 15 15:06:04 CST 2017
	 */
	@Delete({ "delete from wzsport_area_activity_data", "where id = #{id,jdbcType=BIGINT}" })
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_area_activity_data
	 * @mbg.generated  Wed Nov 15 15:06:04 CST 2017
	 */
	@Insert({ "insert into wzsport_area_activity_data (activity_id, acquisition_time, ", "is_normal, longitude, ",
			"latitude, location_type, ", "created_at, updated_at)",
			"values (#{activityId,jdbcType=BIGINT}, #{acquisitionTime,jdbcType=TIMESTAMP}, ",
			"#{isNormal,jdbcType=TINYINT}, #{longitude,jdbcType=DECIMAL}, ",
			"#{latitude,jdbcType=DECIMAL}, #{locationType,jdbcType=TINYINT}, ",
			"#{createdAt,jdbcType=TIMESTAMP}, #{updatedAt,jdbcType=TIMESTAMP})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
	int insert(AreaActivityData record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_area_activity_data
	 * @mbg.generated  Wed Nov 15 15:06:04 CST 2017
	 */
	int insertSelective(AreaActivityData record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_area_activity_data
	 * @mbg.generated  Wed Nov 15 15:06:04 CST 2017
	 */
	List<AreaActivityData> selectByExample(AreaActivityDataExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_area_activity_data
	 * @mbg.generated  Wed Nov 15 15:06:04 CST 2017
	 */
	@Select({ "select", "id, activity_id, acquisition_time, is_normal, longitude, latitude, location_type, ",
			"created_at, updated_at", "from wzsport_area_activity_data", "where id = #{id,jdbcType=BIGINT}" })
	@ResultMap("com.wzsport.mapper.AreaActivityDataMapper.BaseResultMap")
	AreaActivityData selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_area_activity_data
	 * @mbg.generated  Wed Nov 15 15:06:04 CST 2017
	 */
	int updateByExampleSelective(@Param("record") AreaActivityData record,
			@Param("example") AreaActivityDataExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_area_activity_data
	 * @mbg.generated  Wed Nov 15 15:06:04 CST 2017
	 */
	int updateByExample(@Param("record") AreaActivityData record, @Param("example") AreaActivityDataExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_area_activity_data
	 * @mbg.generated  Wed Nov 15 15:06:04 CST 2017
	 */
	int updateByPrimaryKeySelective(AreaActivityData record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_area_activity_data
	 * @mbg.generated  Wed Nov 15 15:06:04 CST 2017
	 */
	@Update({ "update wzsport_area_activity_data", "set activity_id = #{activityId,jdbcType=BIGINT},",
			"acquisition_time = #{acquisitionTime,jdbcType=TIMESTAMP},", "is_normal = #{isNormal,jdbcType=TINYINT},",
			"longitude = #{longitude,jdbcType=DECIMAL},", "latitude = #{latitude,jdbcType=DECIMAL},",
			"location_type = #{locationType,jdbcType=TINYINT},", "created_at = #{createdAt,jdbcType=TIMESTAMP},",
			"updated_at = #{updatedAt,jdbcType=TIMESTAMP}", "where id = #{id,jdbcType=BIGINT}" })
	int updateByPrimaryKey(AreaActivityData record);
}