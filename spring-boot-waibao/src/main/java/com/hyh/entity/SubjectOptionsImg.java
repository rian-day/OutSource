package com.hyh.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * 题目选项图片表
 * @author 10513
 *
 */
@Entity
public class SubjectOptionsImg {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	//选项图片地址
	private String src;
	//选项ID
	@ManyToOne(fetch=FetchType.LAZY)
	private SubjectOptions subjectOption;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public SubjectOptions getSubjectOption() {
		return subjectOption;
	}
	public void setSubjectOption(SubjectOptions subjectOption) {
		this.subjectOption = subjectOption;
	}
	
	
	
}
