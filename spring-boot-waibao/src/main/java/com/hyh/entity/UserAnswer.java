package com.hyh.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


/**
 * 用户答案表(历史)
 * @author 10513
 *
 */
@Entity
public class UserAnswer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	//用户答案
	private String[] Answer;
	//题目ID
	@ManyToOne(fetch=FetchType.LAZY)
	private Subject subject;
	//用户自我分析
	private String analyse;
	//题目状态（对、错、半对）
	private char status;
	//是否收藏
	private char collect;
	//考试ID
	@ManyToOne(fetch=FetchType.LAZY)
	private Exam examId;
	//用户id
	private int userId;
	public UserAnswer(){
		this.collect=0;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String[] getAnswer() {
		return Answer;
	}

	public void setAnswer(String[] answer) {
		Answer = answer;
	}

	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public Exam getExamId() {
		return examId;
	}
	public void setExamId(Exam examId) {
		this.examId = examId;
	}
	
	public String getAnalyse() {
		return analyse;
	}
	public void setAnalyse(String analyse) {
		this.analyse = analyse;
	}
	public char getCollect() {
		return collect;
	}
	public void setCollect(char collect) {
		this.collect = collect;
	}
	
	
	
	
}
