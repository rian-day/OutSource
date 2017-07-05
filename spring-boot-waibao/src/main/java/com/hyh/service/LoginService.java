package com.hyh.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

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
	
	public UserInfo Register(String mail,String password,String name,char sex){
		password=md5.encode(password);
		UserInfo user=new UserInfo(mail,name,password,sex);
		user=uir.save(user);
		return user;
	}
}
