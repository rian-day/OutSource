package com.hyh.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * 用户职业关联表
 * @author 10513
 *
 */
@Entity
public class UserProfession {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	//用户ID
	private int userId;
	//职业ID
	private int professionId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getProfessionId() {
		return professionId;
	}
	public void setProfessionId(int professionId) {
		this.professionId = professionId;
	}
	
}
