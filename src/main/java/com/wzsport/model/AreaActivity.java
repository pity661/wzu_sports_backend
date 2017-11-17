package com.wzsport.model;

import java.util.Date;

public class AreaActivity {

    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column wzsport_area_activity.id
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    private Long id;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column wzsport_area_activity.area_sport_id
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    private Long areaSportId;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column wzsport_area_activity.location_id
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    private Long locationId;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column wzsport_area_activity.student_id
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    private Long studentId;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column wzsport_area_activity.cost_time
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    private Integer costTime;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column wzsport_area_activity.start_time
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    private Date startTime;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column wzsport_area_activity.kcal_consumed
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    private Integer kcalConsumed;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column wzsport_area_activity.qualified
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    private Boolean qualified;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column wzsport_area_activity.is_valid
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    private Byte isValid;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column wzsport_area_activity.is_verified
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    private Byte isVerified;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column wzsport_area_activity.qualified_cost_time
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    private Integer qualifiedCostTime;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column wzsport_area_activity.created_at
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    private Date createdAt;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column wzsport_area_activity.updated_at
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    private Date updatedAt;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column wzsport_area_activity.ended_at
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    private Date endedAt;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column wzsport_area_activity.ended_by
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    private Boolean endedBy;

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column wzsport_area_activity.id
     * @return  the value of wzsport_area_activity.id
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column wzsport_area_activity.id
     * @param id  the value for wzsport_area_activity.id
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column wzsport_area_activity.area_sport_id
     * @return  the value of wzsport_area_activity.area_sport_id
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    public Long getAreaSportId() {
        return areaSportId;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column wzsport_area_activity.area_sport_id
     * @param areaSportId  the value for wzsport_area_activity.area_sport_id
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    public void setAreaSportId(Long areaSportId) {
        this.areaSportId = areaSportId;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column wzsport_area_activity.location_id
     * @return  the value of wzsport_area_activity.location_id
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    public Long getLocationId() {
        return locationId;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column wzsport_area_activity.location_id
     * @param locationId  the value for wzsport_area_activity.location_id
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column wzsport_area_activity.student_id
     * @return  the value of wzsport_area_activity.student_id
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    public Long getStudentId() {
        return studentId;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column wzsport_area_activity.student_id
     * @param studentId  the value for wzsport_area_activity.student_id
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column wzsport_area_activity.cost_time
     * @return  the value of wzsport_area_activity.cost_time
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    public Integer getCostTime() {
        return costTime;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column wzsport_area_activity.cost_time
     * @param costTime  the value for wzsport_area_activity.cost_time
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    public void setCostTime(Integer costTime) {
        this.costTime = costTime;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column wzsport_area_activity.start_time
     * @return  the value of wzsport_area_activity.start_time
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column wzsport_area_activity.start_time
     * @param startTime  the value for wzsport_area_activity.start_time
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column wzsport_area_activity.kcal_consumed
     * @return  the value of wzsport_area_activity.kcal_consumed
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    public Integer getKcalConsumed() {
        return kcalConsumed;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column wzsport_area_activity.kcal_consumed
     * @param kcalConsumed  the value for wzsport_area_activity.kcal_consumed
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    public void setKcalConsumed(Integer kcalConsumed) {
        this.kcalConsumed = kcalConsumed;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column wzsport_area_activity.qualified
     * @return  the value of wzsport_area_activity.qualified
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    public Boolean getQualified() {
        return qualified;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column wzsport_area_activity.qualified
     * @param qualified  the value for wzsport_area_activity.qualified
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    public void setQualified(Boolean qualified) {
        this.qualified = qualified;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column wzsport_area_activity.is_valid
     * @return  the value of wzsport_area_activity.is_valid
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    public Byte getIsValid() {
        return isValid;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column wzsport_area_activity.is_valid
     * @param isValid  the value for wzsport_area_activity.is_valid
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    public void setIsValid(Byte isValid) {
        this.isValid = isValid;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column wzsport_area_activity.is_verified
     * @return  the value of wzsport_area_activity.is_verified
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    public Byte getIsVerified() {
        return isVerified;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column wzsport_area_activity.is_verified
     * @param isVerified  the value for wzsport_area_activity.is_verified
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    public void setIsVerified(Byte isVerified) {
        this.isVerified = isVerified;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column wzsport_area_activity.qualified_cost_time
     * @return  the value of wzsport_area_activity.qualified_cost_time
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    public Integer getQualifiedCostTime() {
        return qualifiedCostTime;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column wzsport_area_activity.qualified_cost_time
     * @param qualifiedCostTime  the value for wzsport_area_activity.qualified_cost_time
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    public void setQualifiedCostTime(Integer qualifiedCostTime) {
        this.qualifiedCostTime = qualifiedCostTime;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column wzsport_area_activity.created_at
     * @return  the value of wzsport_area_activity.created_at
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column wzsport_area_activity.created_at
     * @param createdAt  the value for wzsport_area_activity.created_at
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column wzsport_area_activity.updated_at
     * @return  the value of wzsport_area_activity.updated_at
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column wzsport_area_activity.updated_at
     * @param updatedAt  the value for wzsport_area_activity.updated_at
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column wzsport_area_activity.ended_at
     * @return  the value of wzsport_area_activity.ended_at
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    public Date getEndedAt() {
        return endedAt;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column wzsport_area_activity.ended_at
     * @param endedAt  the value for wzsport_area_activity.ended_at
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    public void setEndedAt(Date endedAt) {
        this.endedAt = endedAt;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column wzsport_area_activity.ended_by
     * @return  the value of wzsport_area_activity.ended_by
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    public Boolean getEndedBy() {
        return endedBy;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column wzsport_area_activity.ended_by
     * @param endedBy  the value for wzsport_area_activity.ended_by
     * @mbg.generated  Fri Nov 17 10:25:55 CST 2017
     */
    public void setEndedBy(Boolean endedBy) {
        this.endedBy = endedBy;
    }
}