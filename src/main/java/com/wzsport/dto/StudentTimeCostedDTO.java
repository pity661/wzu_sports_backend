package com.wzsport.dto;

public class StudentTimeCostedDTO {

	private Long studentId;
	private String studentName;
	private Integer timeCosted;
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
	public Integer getTimeCosted() {
		return timeCosted;
	}
	public void setTimeCosted(Integer timeCosted) {
		this.timeCosted = timeCosted;
	}
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

}
