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

/**
 * 题目表
 * @author 10513
 *
 */
@Entity
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	//题目内容
	private String content;
	//题目类型（选择、填空、判断）
	private String type;
	//题目正确答案
	private String answer;
	//职业ID
	private int professionId;
	
	@OneToMany(mappedBy="subject",fetch=FetchType.LAZY,cascade={CascadeType.MERGE})
	@NotFound(action=NotFoundAction.IGNORE)//代表可以为空，允许为null
	private List<SubjectOptions> options;

	public Subject(String content
			,String type
			,String answer
			,int professionId
			,List<SubjectOptions> options){
		this.content=content;
		this.type=type;
		this.answer=answer;
		this.professionId=professionId;
		this.options=options;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getProfessionId() {
		return professionId;
	}

	public void setProfessionId(int professionId) {
		this.professionId = professionId;
	}

	public List<SubjectOptions> getOptions() {
		return options;
	}

	public void setOptions(List<SubjectOptions> options) {
		this.options = options;
	}
	
	
	
	
}
