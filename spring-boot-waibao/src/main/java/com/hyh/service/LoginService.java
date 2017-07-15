package com.hyh.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hyh.entity.UserInfo;
import com.hyh.repository.UserInfoDao;
import com.hyh.utils.MD5Util;

@Service
public class LoginService {
	MD5Util md5=new MD5Util();
	
	@Autowired
	UserInfoDao uir;
	
	public boolean CheckLogin(String mail,String password){
		ArrayList<UserInfo> list= uir.findByMailAndPassword(mail, password);
		if(list.size()!=0)
			return true;
		else
			return false;
	}
	
	public UserInfo Register(
			//String mail,String password,String name,char sex
			UserInfo user
			){
		String password=user.getPassword();
		password=md5.encode(password);
		user.setPassword(password);
		user=uir.save(user);
		return user;
	}
	public Page<UserInfo> SearchForPage(String name,int page,int size){
		Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        Page<UserInfo> pages=uir.findByName(name,pageable);
        return pages;
	}
}
