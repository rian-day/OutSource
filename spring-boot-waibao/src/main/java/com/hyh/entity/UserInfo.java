package com.hyh.entity;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * 用户信息表
 * @author 10513
 *
 */
@Entity
public class UserInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String mail;
	
	private String name;
	
	private String password;
	
	private String head;
	
	private char sex;
	
	private int age;
	
	@ManyToMany(cascade={CascadeType.REFRESH},fetch=FetchType.LAZY)
	    @JoinTable(name="t_student_teacher",
	            inverseJoinColumns=@JoinColumn(name="teacher_id"),
	            joinColumns=@JoinColumn(name="student_id"))
	@NotFound(action=NotFoundAction.IGNORE)//代表可以为空，允许为null
	private Set<Profession> profession;
	
	@OneToMany(mappedBy="user",fetch=FetchType.LAZY,cascade={CascadeType.MERGE})
	private Set<UserOperation> operations;//用户操作
	
	public void clearPro(){
		this.profession.clear();
	}
	
	public void addpro(Profession pro){
		profession.add(pro);
	}
	
	public void removepro(Profession pro){
		profession.remove(pro);
	}
	
	public UserInfo(){
		
	}
	public UserInfo(String mail,String name,String password,char sex){
		this.mail=mail;
		this.name=name;
		this.password=password;
		this.sex=sex;
	}
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		String result="";
		final String BR="<br/>";
		result+=this.getMail()+BR+this.getName()+BR+this.getPassword()+BR+this.getSex();
		return result;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Set<Profession> getProfession() {
		return profession;
	}

	public void setProfession(Set<Profession> profession) {
		this.profession = profession;
	}

	public Set<UserOperation> getOperations() {
		return operations;
	}

	public void setOperations(Set<UserOperation> operations) {
		this.operations = operations;
	}
}
