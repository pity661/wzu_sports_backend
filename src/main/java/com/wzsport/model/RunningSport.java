package com.wzsport.model;

import java.util.Date;
import java.math.BigDecimal;

public class RunningSport {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column wzsport_running_sport.id
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	private Long id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column wzsport_running_sport.university_id
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	private Long universityId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column wzsport_running_sport.name
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	private String name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column wzsport_running_sport.is_enabled
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	private Boolean isEnabled;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column wzsport_running_sport.is_man
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	private Boolean isMan;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column wzsport_running_sport.img_url
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	private String imgUrl;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column wzsport_running_sport.qualified_distance
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	private Integer qualifiedDistance;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column wzsport_running_sport.qualified_cost_time
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	private Integer qualifiedCostTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column wzsport_running_sport.qualified_velocity
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	private BigDecimal qualifiedVelocity;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column wzsport_running_sport.hourly_kcal_consumption
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	private Integer hourlyKcalConsumption;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column wzsport_running_sport.sample_num
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	private Integer sampleNum;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column wzsport_running_sport.acquisition_interval
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	private Byte acquisitionInterval;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column wzsport_running_sport.id
	 * @return  the value of wzsport_running_sport.id
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	public Long getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column wzsport_running_sport.id
	 * @param id  the value for wzsport_running_sport.id
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column wzsport_running_sport.university_id
	 * @return  the value of wzsport_running_sport.university_id
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	public Long getUniversityId() {
		return universityId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column wzsport_running_sport.university_id
	 * @param universityId  the value for wzsport_running_sport.university_id
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	public void setUniversityId(Long universityId) {
		this.universityId = universityId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column wzsport_running_sport.name
	 * @return  the value of wzsport_running_sport.name
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column wzsport_running_sport.name
	 * @param name  the value for wzsport_running_sport.name
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column wzsport_running_sport.is_enabled
	 * @return  the value of wzsport_running_sport.is_enabled
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	public Boolean getIsEnabled() {
		return isEnabled;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column wzsport_running_sport.is_enabled
	 * @param isEnabled  the value for wzsport_running_sport.is_enabled
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column wzsport_running_sport.is_man
	 * @return  the value of wzsport_running_sport.is_man
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	public Boolean getIsMan() {
		return isMan;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column wzsport_running_sport.is_man
	 * @param isMan  the value for wzsport_running_sport.is_man
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	public void setIsMan(Boolean isMan) {
		this.isMan = isMan;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column wzsport_running_sport.img_url
	 * @return  the value of wzsport_running_sport.img_url
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	public String getImgUrl() {
		return imgUrl;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column wzsport_running_sport.img_url
	 * @param imgUrl  the value for wzsport_running_sport.img_url
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column wzsport_running_sport.qualified_distance
	 * @return  the value of wzsport_running_sport.qualified_distance
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	public Integer getQualifiedDistance() {
		return qualifiedDistance;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column wzsport_running_sport.qualified_distance
	 * @param qualifiedDistance  the value for wzsport_running_sport.qualified_distance
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	public void setQualifiedDistance(Integer qualifiedDistance) {
		this.qualifiedDistance = qualifiedDistance;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column wzsport_running_sport.qualified_cost_time
	 * @return  the value of wzsport_running_sport.qualified_cost_time
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	public Integer getQualifiedCostTime() {
		return qualifiedCostTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column wzsport_running_sport.qualified_cost_time
	 * @param qualifiedCostTime  the value for wzsport_running_sport.qualified_cost_time
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	public void setQualifiedCostTime(Integer qualifiedCostTime) {
		this.qualifiedCostTime = qualifiedCostTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column wzsport_running_sport.qualified_velocity
	 * @return  the value of wzsport_running_sport.qualified_velocity
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	public BigDecimal getQualifiedVelocity() {
		return qualifiedVelocity;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column wzsport_running_sport.qualified_velocity
	 * @param qualifiedVelocity  the value for wzsport_running_sport.qualified_velocity
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	public void setQualifiedVelocity(BigDecimal qualifiedVelocity) {
		this.qualifiedVelocity = qualifiedVelocity;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column wzsport_running_sport.hourly_kcal_consumption
	 * @return  the value of wzsport_running_sport.hourly_kcal_consumption
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	public Integer getHourlyKcalConsumption() {
		return hourlyKcalConsumption;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column wzsport_running_sport.hourly_kcal_consumption
	 * @param hourlyKcalConsumption  the value for wzsport_running_sport.hourly_kcal_consumption
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	public void setHourlyKcalConsumption(Integer hourlyKcalConsumption) {
		this.hourlyKcalConsumption = hourlyKcalConsumption;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column wzsport_running_sport.sample_num
	 * @return  the value of wzsport_running_sport.sample_num
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	public Integer getSampleNum() {
		return sampleNum;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column wzsport_running_sport.sample_num
	 * @param sampleNum  the value for wzsport_running_sport.sample_num
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	public void setSampleNum(Integer sampleNum) {
		this.sampleNum = sampleNum;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column wzsport_running_sport.acquisition_interval
	 * @return  the value of wzsport_running_sport.acquisition_interval
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	public Byte getAcquisitionInterval() {
		return acquisitionInterval;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column wzsport_running_sport.acquisition_interval
	 * @param acquisitionInterval  the value for wzsport_running_sport.acquisition_interval
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	public void setAcquisitionInterval(Byte acquisitionInterval) {
		this.acquisitionInterval = acquisitionInterval;
	}
}