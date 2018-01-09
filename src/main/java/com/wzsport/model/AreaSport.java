package com.wzsport.model;

import java.util.Date;

public class AreaSport {
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column wzsport_area_sport.id
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    private Long id;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column wzsport_area_sport.name
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    private String name;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column wzsport_area_sport.is_enabled
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    private Boolean isEnabled;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column wzsport_area_sport.is_man
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    private Boolean isMan;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column wzsport_area_sport.qualified_cost_time
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    private Integer qualifiedCostTime;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column wzsport_area_sport.img_url
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    private String imgUrl;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column wzsport_area_sport.sample_num
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    private Byte sampleNum;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column wzsport_area_sport.hourly_kcal_consumption
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    private Integer hourlyKcalConsumption;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column wzsport_area_sport.acquisition_interval
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    private Byte acquisitionInterval;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column wzsport_area_sport.university_id
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    private Long universityId;

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column wzsport_area_sport.id
     * @return  the value of wzsport_area_sport.id
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column wzsport_area_sport.id
     * @param id  the value for wzsport_area_sport.id
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column wzsport_area_sport.name
     * @return  the value of wzsport_area_sport.name
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column wzsport_area_sport.name
     * @param name  the value for wzsport_area_sport.name
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column wzsport_area_sport.is_enabled
     * @return  the value of wzsport_area_sport.is_enabled
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    public Boolean getIsEnabled() {
        return isEnabled;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column wzsport_area_sport.is_enabled
     * @param isEnabled  the value for wzsport_area_sport.is_enabled
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column wzsport_area_sport.is_man
     * @return  the value of wzsport_area_sport.is_man
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    public Boolean getIsMan() {
        return isMan;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column wzsport_area_sport.is_man
     * @param isMan  the value for wzsport_area_sport.is_man
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    public void setIsMan(Boolean isMan) {
        this.isMan = isMan;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column wzsport_area_sport.qualified_cost_time
     * @return  the value of wzsport_area_sport.qualified_cost_time
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    public Integer getQualifiedCostTime() {
        return qualifiedCostTime;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column wzsport_area_sport.qualified_cost_time
     * @param qualifiedCostTime  the value for wzsport_area_sport.qualified_cost_time
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    public void setQualifiedCostTime(Integer qualifiedCostTime) {
        this.qualifiedCostTime = qualifiedCostTime;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column wzsport_area_sport.img_url
     * @return  the value of wzsport_area_sport.img_url
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column wzsport_area_sport.img_url
     * @param imgUrl  the value for wzsport_area_sport.img_url
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column wzsport_area_sport.sample_num
     * @return  the value of wzsport_area_sport.sample_num
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    public Byte getSampleNum() {
        return sampleNum;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column wzsport_area_sport.sample_num
     * @param sampleNum  the value for wzsport_area_sport.sample_num
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    public void setSampleNum(Byte sampleNum) {
        this.sampleNum = sampleNum;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column wzsport_area_sport.hourly_kcal_consumption
     * @return  the value of wzsport_area_sport.hourly_kcal_consumption
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    public Integer getHourlyKcalConsumption() {
        return hourlyKcalConsumption;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column wzsport_area_sport.hourly_kcal_consumption
     * @param hourlyKcalConsumption  the value for wzsport_area_sport.hourly_kcal_consumption
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    public void setHourlyKcalConsumption(Integer hourlyKcalConsumption) {
        this.hourlyKcalConsumption = hourlyKcalConsumption;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column wzsport_area_sport.acquisition_interval
     * @return  the value of wzsport_area_sport.acquisition_interval
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    public Byte getAcquisitionInterval() {
        return acquisitionInterval;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column wzsport_area_sport.acquisition_interval
     * @param acquisitionInterval  the value for wzsport_area_sport.acquisition_interval
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    public void setAcquisitionInterval(Byte acquisitionInterval) {
        this.acquisitionInterval = acquisitionInterval;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column wzsport_area_sport.university_id
     * @return  the value of wzsport_area_sport.university_id
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    public Long getUniversityId() {
        return universityId;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column wzsport_area_sport.university_id
     * @param universityId  the value for wzsport_area_sport.university_id
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    public void setUniversityId(Long universityId) {
        this.universityId = universityId;
    }

    public AreaSport() {
    	
    }
}