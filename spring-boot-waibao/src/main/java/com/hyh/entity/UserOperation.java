package com.hyh.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * 用户操作表
 * @author 10513
 *
 */
@Entity
public class UserOperation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String operation;
	
	private String time;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private UserInfo user;
}
