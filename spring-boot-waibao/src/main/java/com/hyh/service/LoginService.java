package com.hyh.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyh.entity.UserInfo;
import com.hyh.repository.UserInfoRepository;

@Service
public class LoginService {
	
	@Autowired
	UserInfoRepository uir;
	
	public boolean CheckLogin(String mail,String password){
		ArrayList<UserInfo> list= uir.findByMailAndPassword(mail, password);
		if(list.size()!=0)
			return true;
		else 
			return false;
	}
}
