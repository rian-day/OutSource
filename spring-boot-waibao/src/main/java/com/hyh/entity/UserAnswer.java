package com.hyh.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * 用户答案表
 * @author 10513
 *
 */
@Entity
public class UserAnswer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	//用户ID
	private int userId;
	//用户答案
	private String userAnswer;
	//题目ID
	private int subjectId;
	//题目状态（对、错、半对）
	private char status;
	//考试ID
	private int examId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserAnswer() {
		return userAnswer;
	}
	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	
	
	
}
