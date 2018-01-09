package com.wzsport.model;

import java.util.Date;

public class Major {

    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column wzsport_major.id
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    private Long id;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column wzsport_major.college_id
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    private Long collegeId;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column wzsport_major.university_id
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    private Long universityId;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column wzsport_major.name
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    private String name;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column wzsport_major.created_at
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    private Date createdAt;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column wzsport_major.updated_at
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    private Date updatedAt;

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column wzsport_major.id
     * @return  the value of wzsport_major.id
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column wzsport_major.id
     * @param id  the value for wzsport_major.id
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column wzsport_major.college_id
     * @return  the value of wzsport_major.college_id
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    public Long getCollegeId() {
        return collegeId;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column wzsport_major.college_id
     * @param collegeId  the value for wzsport_major.college_id
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    public void setCollegeId(Long collegeId) {
        this.collegeId = collegeId;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column wzsport_major.university_id
     * @return  the value of wzsport_major.university_id
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    public Long getUniversityId() {
        return universityId;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column wzsport_major.university_id
     * @param universityId  the value for wzsport_major.university_id
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    public void setUniversityId(Long universityId) {
        this.universityId = universityId;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column wzsport_major.name
     * @return  the value of wzsport_major.name
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column wzsport_major.name
     * @param name  the value for wzsport_major.name
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column wzsport_major.created_at
     * @return  the value of wzsport_major.created_at
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column wzsport_major.created_at
     * @param createdAt  the value for wzsport_major.created_at
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column wzsport_major.updated_at
     * @return  the value of wzsport_major.updated_at
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column wzsport_major.updated_at
     * @param updatedAt  the value for wzsport_major.updated_at
     * @mbg.generated  Wed Jan 10 00:03:11 CST 2018
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}