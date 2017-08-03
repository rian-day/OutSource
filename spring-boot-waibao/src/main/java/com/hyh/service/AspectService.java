package com.hyh.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hyh.entity.AdminOperation;
import com.hyh.entity.UserInfo;
import com.hyh.entity.UserOperation;
import com.hyh.repository.AdminOperationDao;
import com.hyh.repository.UserInfoDao;
import com.hyh.repository.UserOperationDao;

@Service
public class AspectService {
	@Resource
	AdminOperationDao aod;
	@Resource
	UserOperationDao uod;
	@Resource
	UserInfoDao ud;
	public void saveAdminInfo(int adminId,String content,String time){
		
		AdminOperation ao=new AdminOperation();
		ao.setAdminId(adminId);
		ao.setTime(time);
		ao.setOperation(content);
		aod.save(ao);
	}
	public void saveUserInfo(int userId,String content,String time){
		UserOperation uo=new UserOperation();
		UserInfo user=ud.findById(userId);
		uo.setUser(user);
		uo.setTime(time);
		uo.setOperation(content);
		uod.save(uo);
	}
	
}
