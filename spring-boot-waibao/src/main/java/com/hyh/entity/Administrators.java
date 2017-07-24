package com.hyh.entity;

import java.util.Set;

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
 * 管理员表
 * @author 10513
 *
 */
@Entity
public class Administrators {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	//主页顺序
	private int[] indexOrder;
	//邮箱
	private String mail;
	//用户名
	private String name;
	//密码
	private String password;
	//性别
	private char sex;
	//是否为超级管理员
	private char boss;
	@OneToMany(mappedBy="createAdmin",fetch=FetchType.LAZY,cascade={CascadeType.MERGE})
	@NotFound(action=NotFoundAction.IGNORE)//代表可以为空，允许为null
	private Set<SubjectGroup> subjectGroup;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public char getBoss() {
		return boss;
	}
	public void setBoss(char boss) {
		this.boss = boss;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int[] getIndexOrder() {
		return indexOrder;
	}
	public void setIndexOrder(int[] indexOrder) {
		this.indexOrder = indexOrder;
	}
	public Set<SubjectGroup> getSubjectGroup() {
		return subjectGroup;
	}
	public void setSubjectGroup(Set<SubjectGroup> subjectGroup) {
		this.subjectGroup = subjectGroup;
	}
	public void addSubjectGroup(SubjectGroup sg){
		this.subjectGroup.add(sg);
	}
	public void removeSingleSubjectGroup(SubjectGroup sg){
		this.subjectGroup.remove(sg);
	}
}
