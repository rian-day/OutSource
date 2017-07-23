package com.hyh.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.crsh.console.jline.internal.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hyh.entity.Administrators;
import com.hyh.entity.Profession;
import com.hyh.entity.UserInfo;
import com.hyh.repository.AdministratorsDao;
import com.hyh.repository.ProfessionDao;
import com.hyh.repository.UserInfoDao;
import com.hyh.utils.MD5Util;

@Service
public class LoginService {
	MD5Util md5=new MD5Util();
	
	@Resource
	UserInfoDao uir;
	@Resource
	AdministratorsDao ad;
	@Resource
	ProfessionDao pd;
	
	public Administrators CheckAdmin(String mail,String password){
		ArrayList<Administrators> list= ad.findByMailAndPassword(mail, md5.encode(password));
		if(list.size()!=0)
			return list.get(0);
		else
			return null;
	}
	
	public UserInfo CheckLogin(String mail,String password){
		//Log.warn(md5.encode(password));
		ArrayList<UserInfo> list= uir.findByMailAndPassword(mail, md5.encode(password));
		if(list.size()!=0){
			//Log.warn("找到用户");
			return list.get(0);
		}else{
			return null;
		}
	}
	
	public UserInfo Register(
			//String mail,String password,String name,char sex
			UserInfo user
			,int professionId
			){
		
		String password=user.getPassword();
		user.setProfessionId(professionId);
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
