package com.hyh.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


/**
 * 题目图片表
 * @author 10513
 *
 */
@Entity
public class SubjectImg {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	//题目ID
	@ManyToOne(fetch=FetchType.LAZY)
	private Subject subject;
	//图片地址
	private String src;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	
	
	
}
