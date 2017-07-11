package com.hyh.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	
	
}
