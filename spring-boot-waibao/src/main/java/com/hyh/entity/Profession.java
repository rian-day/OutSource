package com.hyh.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * 职业表
 * @author 10513
 *
 */
@Entity
public class Profession {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	//职业名
	private String name;
	
	@ManyToMany(mappedBy = "profession")
	private Set<UserInfo> user;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
