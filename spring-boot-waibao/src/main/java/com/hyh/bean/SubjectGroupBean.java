package com.hyh.bean;

import com.hyh.entity.Administrators;

public class SubjectGroupBean {
	private Administrators createAdmin;
	private String groupName;
	private int[] subjectId;
	private int[] grade;
	private String createTime;
	private int limitedTime;
	private int professionId;
	private int level;
	
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
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
	public int[] getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int[] subjectId) {
		this.subjectId = subjectId;
	}
	public int[] getGrade() {
		return grade;
	}
	public void setGrade(int[] grade) {
		this.grade = grade;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public int getLimitedTime() {
		return limitedTime;
	}
	public void setLimitedTime(int limitedTime) {
		this.limitedTime = limitedTime;
	}
	public int getProfessionId() {
		return professionId;
	}
	public void setProfessionId(int professionId) {
		this.professionId = professionId;
	}
	
	
}
