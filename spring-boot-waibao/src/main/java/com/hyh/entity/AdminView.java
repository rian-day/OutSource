package com.hyh.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AdminView {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int adminId;
	private int[] indexList;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public int[] getIndexList() {
		return indexList;
	}
	public void setIndexList(int[] indexList) {
		this.indexList = indexList;
	}
	
	
}
