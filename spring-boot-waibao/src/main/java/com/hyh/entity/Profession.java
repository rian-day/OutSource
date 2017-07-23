package com.hyh.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

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
	
//	@ManyToMany(mappedBy = "profession",fetch=FetchType.LAZY)
//	@NotFound(action=NotFoundAction.IGNORE)//代表可以为空，允许为null
//	private Set<UserInfo> user;

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
