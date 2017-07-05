package com.hyh.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


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
	private int subjectId;
	//图片地址
	private String src;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	
	
	
}
