package com.hyh.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.hyh.bean.SessionUser;
import com.hyh.bean.SubjectGroupBean;
import com.hyh.entity.Administrators;
import com.hyh.service.AdminService;
import com.hyh.service.SubjectGroupService;

@Controller
public class SubjectGroupController {
	@Resource
	SubjectGroupService sgs;
	@Resource
	AdminService as;
	
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	String time=df.format(new Date());
	
	@PostMapping("sendtp.do")
	public String createGroup(
			SubjectGroupBean sgb
			,HttpSession session){
		SessionUser user=(SessionUser) session.getAttribute("user");
		Administrators admin=as.searchById(user.getUserId());
		sgb.setCreateAdmin(admin);
		sgb.setCreateTime(time);
		return sgs.createGroup(sgb);
	}
}
