package com.hyh.bean;

public class User {
	private String username; //mail
	private String password;
	private String name;
	private int professionId;
	private String yzm;
	private int age;
	private char sex;
	private char boss;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getProfessionId() {
		return professionId;
	}
	public void setProfessionId(int professionId) {
		this.professionId = professionId;
	}
	public String getYzm() {
		return yzm;
	}
	public void setYzm(String yzm) {
		this.yzm = yzm;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
