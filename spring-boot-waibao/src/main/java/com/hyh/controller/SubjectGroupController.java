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
import com.hyh.service.AspectService;
import com.hyh.service.SubjectGroupService;

@Controller
public class SubjectGroupController {
	@Resource
	SubjectGroupService sgs;
	@Resource
	AdminService as;
	@Resource
	AspectService aspect;
	
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式

	
	@PostMapping("sendtp.do")
	public String createGroup(
			SubjectGroupBean sgb
			,HttpSession session){
		String time=df.format(new Date());
		SessionUser user=(SessionUser) session.getAttribute("user");
		Administrators admin=as.searchById(user.getUserId());
		sgb.setCreateAdmin(admin);
		sgb.setCreateTime(time);
		aspect.saveAdminInfo(user.getUserId(),"管理员("+user.getName()+"):创建了一场考试("+sgb.getGroupName()+")", time);
		return sgs.createGroup(sgb);
	}
}
