package com.hyh.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hyh.entity.Administrators;
import com.hyh.repository.AdministratorsDao;
@Service
public class AdminService {
	@Resource
	AdministratorsDao ad;
	
	//修改按键顺序
	public String changeIndexList(char[] index ,int id){
		Administrators admin=ad.findById(id);
		admin.setIndexOrder(index);
		admin=ad.save(admin);
		return "1";
	}
	
	//管理员界面按键顺序
	public char[] getAdminPage(int id){
		return ad.findById(id).getIndexOrder();
	}
	public Administrators searchById(int id){
		return ad.findById(id);
	}
	
	public String editAndminInfo(int adminId,String name,char sex){
		Administrators admin=ad.findById(adminId);
		admin.setName(name);
		admin.setSex(sex);
		ad.save(admin);
		return "1";
	}
}
