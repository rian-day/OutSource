package com.hyh.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class SubjectGroup {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	//创建时间
	private String createTime;
	@ManyToOne(fetch=FetchType.LAZY)
	private Administrators createAdmin;
	//限制时间
	private int limitedTime;
	//试卷名字
	private String name;
	
	private int totalgrade;
	
	private int professionId;
	
	private int[] singlegrade;
	
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(name = "SubjectGroup_Subject", 
            joinColumns = { @JoinColumn(name = "subjectGroupId", referencedColumnName = "id") }, 
            inverseJoinColumns = { @JoinColumn(name = "subjectId", referencedColumnName = "id") })
	private Set<Subject> subjects;

	
	public void addSubject(Subject subject){
		this.subjects.add(subject);
	}
	public Administrators getCreateAdmin() {
		return createAdmin;
	}

	public void setCreateAdmin(Administrators createAdmin) {
		this.createAdmin = createAdmin;
	}

	public int[] getSinglegrade() {
		return singlegrade;
	}

	public void setSinglegrade(int[] singlegrade) {
		this.singlegrade = singlegrade;
	}

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
	public Set<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}
	
	
	
}
