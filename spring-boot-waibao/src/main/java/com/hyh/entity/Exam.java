package com.hyh.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Exam {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	private int grade;
	private int totalgrade;
	private int professionId;
	private String time;
	private int userId;
	@OneToMany(mappedBy="examId",fetch=FetchType.LAZY,cascade={CascadeType.MERGE})
	@NotFound(action=NotFoundAction.IGNORE)
	private List<UserAnswer> useranswer;
	
	
	
	
	
	public List<UserAnswer> getUseranswer() {
		return useranswer;
	}
	public void setUseranswer(List<UserAnswer> useranswer) {
		this.useranswer = useranswer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProfessionId() {
		return professionId;
	}
	public void setProfessionId(int professionId) {
		this.professionId = professionId;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getTotalgrade() {
		return totalgrade;
	}
	public void setTotalgrade(int totalgrade) {
		this.totalgrade = totalgrade;
	}

	
	
}
