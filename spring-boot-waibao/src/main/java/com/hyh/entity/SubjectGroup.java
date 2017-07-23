package com.hyh.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SubjectGroup {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	//创建时间
	private String createTime;
	//限制时间
	private int limitedTime;
	//试卷名字
	private String name;
	
	private int totalgrade;
	
	private int professionId;
	
	
	@OneToMany(mappedBy="subjectGroup",fetch=FetchType.LAZY,cascade={CascadeType.MERGE})
	private Set<Subject> subject;

	
	
	public int getTotalgrade() {
		return totalgrade;
	}

	public void setTotalgrade(int totalgrade) {
		this.totalgrade = totalgrade;
	}

	public int getProfessionId() {
		return professionId;
	}

	public void setProfessionId(int professionId) {
		this.professionId = professionId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Subject> getSubject() {
		return subject;
	}

	public void setSubject(Set<Subject> subject) {
		this.subject = subject;
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
	
	
	
}
