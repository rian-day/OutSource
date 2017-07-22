package com.hyh.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	//分值
	private int grade;
	//题目类型（选择、填空、判断）
	private String type;
	//题目正确答案
	private String []realAnswer;
	//注释
	private String tip;
	//职业ID
	private int professionId;
	
	@OneToMany(mappedBy="subject",fetch=FetchType.LAZY,cascade={CascadeType.MERGE})
	@NotFound(action=NotFoundAction.IGNORE)//代表可以为空，允许为null
	private Set<SubjectOptions> options;
	
	@OneToMany(mappedBy="subject",fetch=FetchType.LAZY,cascade={CascadeType.MERGE})
	@NotFound(action=NotFoundAction.IGNORE)//代表可以为空，允许为null
	private Set<SubjectImg> subjectImg;
	
	@OneToMany(mappedBy="subject",fetch=FetchType.LAZY,cascade={CascadeType.MERGE})
	private Set<UserAnswer> userAnswer;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private SubjectGroup subjectGroup;
	
	public void addOption(SubjectOptions option){
		this.options.add(option);
	}
	
	public Subject(){
		
	}
//	public Subject(String content
//			,String type
//			,String answer
//			,int professionId
//			,Set<SubjectOptions> options){
//		this.content=content;
//		this.type=type;
//		this.realAnswer=answer;
//		this.professionId=professionId;
//		this.options=options;
//	}

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


	public String[] getRealAnswer() {
		return realAnswer;
	}

	public void setRealAnswer(String[] realAnswer) {
		this.realAnswer = realAnswer;
	}

	public Set<UserAnswer> getUserAnswer() {
		return userAnswer;
	}
	public void setUserAnswer(Set<UserAnswer> userAnswer) {
		this.userAnswer = userAnswer;
	}
	public SubjectGroup getSubjectGroup() {
		return subjectGroup;
	}
	public void setSubjectGroup(SubjectGroup subjectGroup) {
		this.subjectGroup = subjectGroup;
	}
	public int getProfessionId() {
		return professionId;
	}

	public void setProfessionId(int professionId) {
		this.professionId = professionId;
	}

	public Set<SubjectOptions> getOptions() {
		return options;
	}

	public void setOptions(Set<SubjectOptions> options) {
		this.options = options;
	}
	public Set<SubjectImg> getSubjectImg() {
		return subjectImg;
	}
	public void setSubjectImg(Set<SubjectImg> subjectImg) {
		this.subjectImg = subjectImg;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	
	
	
	
}
