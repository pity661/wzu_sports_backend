package com.wzsport.mapper;

import com.wzsport.model.FixLocationOutdoorSportPoint;
import com.wzsport.model.FixLocationOutdoorSportPointExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface FixLocationOutdoorSportPointMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_fix_location_outdoor_sport_point
	 * @mbg.generated  Sun Apr 01 19:24:01 CST 2018
	 */
	long countByExample(FixLocationOutdoorSportPointExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_fix_location_outdoor_sport_point
	 * @mbg.generated  Sun Apr 01 19:24:01 CST 2018
	 */
	int deleteByExample(FixLocationOutdoorSportPointExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_fix_location_outdoor_sport_point
	 * @mbg.generated  Sun Apr 01 19:24:01 CST 2018
	 */
	@Delete({ "delete from wzsport_fix_location_outdoor_sport_point", "where id = #{id,jdbcType=BIGINT}" })
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_fix_location_outdoor_sport_point
	 * @mbg.generated  Sun Apr 01 19:24:01 CST 2018
	 */
	@Insert({ "insert into wzsport_fix_location_outdoor_sport_point (name, latitude, ", "longitude, radius, ",
			"qualified_cost_time, addr, ", "is_enabled, description, ", "university_id)",
			"values (#{name,jdbcType=VARCHAR}, #{latitude,jdbcType=DECIMAL}, ",
			"#{longitude,jdbcType=DECIMAL}, #{radius,jdbcType=INTEGER}, ",
			"#{qualifiedCostTime,jdbcType=INTEGER}, #{addr,jdbcType=VARCHAR}, ",
			"#{isEnabled,jdbcType=TINYINT}, #{description,jdbcType=VARCHAR}, ", "#{universityId,jdbcType=BIGINT})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
	int insert(FixLocationOutdoorSportPoint record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_fix_location_outdoor_sport_point
	 * @mbg.generated  Sun Apr 01 19:24:01 CST 2018
	 */
	int insertSelective(FixLocationOutdoorSportPoint record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_fix_location_outdoor_sport_point
	 * @mbg.generated  Sun Apr 01 19:24:01 CST 2018
	 */
	List<FixLocationOutdoorSportPoint> selectByExample(FixLocationOutdoorSportPointExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_fix_location_outdoor_sport_point
	 * @mbg.generated  Sun Apr 01 19:24:01 CST 2018
	 */
	@Select({ "select", "id, name, latitude, longitude, radius, qualified_cost_time, addr, is_enabled, ",
			"description, university_id", "from wzsport_fix_location_outdoor_sport_point",
			"where id = #{id,jdbcType=BIGINT}" })
	@ResultMap("com.wzsport.mapper.FixLocationOutdoorSportPointMapper.BaseResultMap")
	FixLocationOutdoorSportPoint selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_fix_location_outdoor_sport_point
	 * @mbg.generated  Sun Apr 01 19:24:01 CST 2018
	 */
	int updateByExampleSelective(@Param("record") FixLocationOutdoorSportPoint record,
			@Param("example") FixLocationOutdoorSportPointExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_fix_location_outdoor_sport_point
	 * @mbg.generated  Sun Apr 01 19:24:01 CST 2018
	 */
	int updateByExample(@Param("record") FixLocationOutdoorSportPoint record,
			@Param("example") FixLocationOutdoorSportPointExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_fix_location_outdoor_sport_point
	 * @mbg.generated  Sun Apr 01 19:24:01 CST 2018
	 */
	int updateByPrimaryKeySelective(FixLocationOutdoorSportPoint record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_fix_location_outdoor_sport_point
	 * @mbg.generated  Sun Apr 01 19:24:01 CST 2018
	 */
	@Update({ "update wzsport_fix_location_outdoor_sport_point", "set name = #{name,jdbcType=VARCHAR},",
			"latitude = #{latitude,jdbcType=DECIMAL},", "longitude = #{longitude,jdbcType=DECIMAL},",
			"radius = #{radius,jdbcType=INTEGER},", "qualified_cost_time = #{qualifiedCostTime,jdbcType=INTEGER},",
			"addr = #{addr,jdbcType=VARCHAR},", "is_enabled = #{isEnabled,jdbcType=TINYINT},",
			"description = #{description,jdbcType=VARCHAR},", "university_id = #{universityId,jdbcType=BIGINT}",
			"where id = #{id,jdbcType=BIGINT}" })
	int updateByPrimaryKey(FixLocationOutdoorSportPoint record);
}