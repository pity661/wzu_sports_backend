package com.wzsport.dto;

public class StudentKcalConsumptionDTO {

	private Long studentId;
	private String studentName;
	private Integer kcalConsumption;
	private String avatarUrl;
	
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Integer getKcalConsumption() {
		return kcalConsumption;
	}
	public void setKcalConsumption(Integer kcalConsumption) {
		this.kcalConsumption = kcalConsumption;
	}
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
}
