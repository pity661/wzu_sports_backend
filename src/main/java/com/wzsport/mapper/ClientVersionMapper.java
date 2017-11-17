package com.wzsport.mapper;

import com.wzsport.model.ClientVersion;
import com.wzsport.model.ClientVersionExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface ClientVersionMapper {
    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_client_version
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    long countByExample(ClientVersionExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_client_version
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    int deleteByExample(ClientVersionExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_client_version
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    @Delete({ "delete from wzsport_client_version", "where id = #{id,jdbcType=BIGINT}" })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_client_version
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    @Insert({ "insert into wzsport_client_version (version_name, version_code, ", "change_log, is_forced, ",
            "download_url, is_published, ", "platform_id, created_at, ", "updated_at)",
            "values (#{versionName,jdbcType=VARCHAR}, #{versionCode,jdbcType=INTEGER}, ",
            "#{changeLog,jdbcType=VARCHAR}, #{isForced,jdbcType=BIT}, ",
            "#{downloadUrl,jdbcType=VARCHAR}, #{isPublished,jdbcType=TINYINT}, ",
            "#{platformId,jdbcType=TINYINT}, #{createdAt,jdbcType=TIMESTAMP}, ", "#{updatedAt,jdbcType=TIMESTAMP})" })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
    int insert(ClientVersion record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_client_version
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    int insertSelective(ClientVersion record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_client_version
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    List<ClientVersion> selectByExample(ClientVersionExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_client_version
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    @Select({ "select", "id, version_name, version_code, change_log, is_forced, download_url, is_published, ",
            "platform_id, created_at, updated_at", "from wzsport_client_version", "where id = #{id,jdbcType=BIGINT}" })
    @ResultMap("com.wzsport.mapper.ClientVersionMapper.BaseResultMap")
    ClientVersion selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_client_version
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    int updateByExampleSelective(@Param("record") ClientVersion record, @Param("example") ClientVersionExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_client_version
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    int updateByExample(@Param("record") ClientVersion record, @Param("example") ClientVersionExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_client_version
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    int updateByPrimaryKeySelective(ClientVersion record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_client_version
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    @Update({ "update wzsport_client_version", "set version_name = #{versionName,jdbcType=VARCHAR},",
            "version_code = #{versionCode,jdbcType=INTEGER},", "change_log = #{changeLog,jdbcType=VARCHAR},",
            "is_forced = #{isForced,jdbcType=BIT},", "download_url = #{downloadUrl,jdbcType=VARCHAR},",
            "is_published = #{isPublished,jdbcType=TINYINT},", "platform_id = #{platformId,jdbcType=TINYINT},",
            "created_at = #{createdAt,jdbcType=TIMESTAMP},", "updated_at = #{updatedAt,jdbcType=TIMESTAMP}",
            "where id = #{id,jdbcType=BIGINT}" })
    int updateByPrimaryKey(ClientVersion record);

    @Select("SELECT * FROM wzsport_client_version where is_published = 1 and platform_id  = #{platform_id,jdbcType=TINYINT} ORDER BY version_code DESC limit 1")
    ClientVersion getLasetVersionInfo(Byte platform_id);
}