package com.hyh.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * 用户题目分析表
 * @author 10513
 *
 */
@Entity
public class UserAnalyse {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	//用户自我总结
	private String analyse;
	//题目ID
	private int subjectId;
	//用户ID
	private int userId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAnalyse() {
		return analyse;
	}
	public void setAnalyse(String analyse) {
		this.analyse = analyse;
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
}
