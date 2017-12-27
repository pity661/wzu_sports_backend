package com.wzsport.mapper;

import com.wzsport.model.DeviceLoginLog;
import com.wzsport.model.DeviceLoginLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.SelectKey;

public interface DeviceLoginLogMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_device_login_log
	 * @mbg.generated  Sun Dec 24 13:07:03 CST 2017
	 */
	long countByExample(DeviceLoginLogExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_device_login_log
	 * @mbg.generated  Sun Dec 24 13:07:03 CST 2017
	 */
	int deleteByExample(DeviceLoginLogExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_device_login_log
	 * @mbg.generated  Sun Dec 24 13:07:03 CST 2017
	 */
	@Delete({ "delete from wzsport_device_login_log", "where id = #{id,jdbcType=BIGINT}" })
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_device_login_log
	 * @mbg.generated  Sun Dec 24 13:07:03 CST 2017
	 */
	@Insert({ "insert into wzsport_device_login_log (device_id, user_agent)",
			"values (#{deviceId,jdbcType=VARCHAR}, #{userAgent,jdbcType=VARCHAR})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
	int insert(DeviceLoginLog record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_device_login_log
	 * @mbg.generated  Sun Dec 24 13:07:03 CST 2017
	 */
	int insertSelective(DeviceLoginLog record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_device_login_log
	 * @mbg.generated  Sun Dec 24 13:07:03 CST 2017
	 */
	List<DeviceLoginLog> selectByExample(DeviceLoginLogExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_device_login_log
	 * @mbg.generated  Sun Dec 24 13:07:03 CST 2017
	 */
	@Select({ "select", "id, device_id, user_agent", "from wzsport_device_login_log",
			"where id = #{id,jdbcType=BIGINT}" })
	@ResultMap("com.wzsport.mapper.DeviceLoginLogMapper.BaseResultMap")
	DeviceLoginLog selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_device_login_log
	 * @mbg.generated  Sun Dec 24 13:07:03 CST 2017
	 */
	int updateByExampleSelective(@Param("record") DeviceLoginLog record,
			@Param("example") DeviceLoginLogExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_device_login_log
	 * @mbg.generated  Sun Dec 24 13:07:03 CST 2017
	 */
	int updateByExample(@Param("record") DeviceLoginLog record, @Param("example") DeviceLoginLogExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_device_login_log
	 * @mbg.generated  Sun Dec 24 13:07:03 CST 2017
	 */
	int updateByPrimaryKeySelective(DeviceLoginLog record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_device_login_log
	 * @mbg.generated  Sun Dec 24 13:07:03 CST 2017
	 */
	@Update({ "update wzsport_device_login_log", "set device_id = #{deviceId,jdbcType=VARCHAR},",
			"user_agent = #{userAgent,jdbcType=VARCHAR}", "where id = #{id,jdbcType=BIGINT}" })
	int updateByPrimaryKey(DeviceLoginLog record);
}