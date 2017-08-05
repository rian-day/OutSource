package com.hyh.bean;

import com.hyh.entity.Administrators;

public class SubjectGroupBean {
	private Administrators createAdmin;
	private String groupName;
	private Integer[] subjectId;
	private Integer[] grade;
	private String createTime;
	private Integer limitedTime;
	private Integer professionId;
	private Integer level;
	
	public Administrators getCreateAdmin() {
		return createAdmin;
	}
	public void setCreateAdmin(Administrators createAdmin) {
		this.createAdmin = createAdmin;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public Integer[] getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Integer[] subjectId) {
		this.subjectId = subjectId;
	}
	public Integer[] getGrade() {
		return grade;
	}
	public void setGrade(Integer[] grade) {
		this.grade = grade;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public Integer getLimitedTime() {
		return limitedTime;
	}
	public void setLimitedTime(Integer limitedTime) {
		this.limitedTime = limitedTime;
	}
	public Integer getProfessionId() {
		return professionId;
	}
	public void setProfessionId(Integer professionId) {
		this.professionId = professionId;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	
	
	
}
