package com.hyh.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hyh.bean.SessionUser;
import com.hyh.bean.SubjectGroupBean;
import com.hyh.entity.Administrators;
import com.hyh.entity.Subject;
import com.hyh.service.AdminService;
import com.hyh.service.AspectService;
import com.hyh.service.SubjectGroupService;
import com.hyh.service.SubjectService;

@Controller
public class SubjectGroupController {
	@Resource
	SubjectGroupService sgs;
	@Resource
	AdminService as;
	@Resource
	AspectService aspect;
	@Resource
	SubjectService ss;
	
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式

	
	@PostMapping("sendtp.do")
	@ResponseBody
	public String createGroup(
			SubjectGroupBean sgb
			,@RequestParam("subjectId[]") Integer[] subjectId
			,@RequestParam("grade[]") Integer[] grade
			,HttpSession session){
		String time=df.format(new Date());
		SessionUser user=(SessionUser) session.getAttribute("user");
		Administrators admin=as.searchById(user.getUserId());
		aspect.saveAdminInfo(user.getUserId(),"管理员("+user.getName()+"):创建了一场考试("+sgb.getGroupName()+")", time);
		return sgs.createGroup(sgb,admin,time,subjectId,grade);
	}
	@PostMapping("addtp-search.do")
	@ResponseBody
	public void findSubject(
			@RequestParam(value = "size", required=false) String content
			,@RequestParam(value = "size", defaultValue = "5") Integer size
			, @RequestParam(value = "nowPage", defaultValue = "1") Integer nowPage
			,Model model
			){
		nowPage--;
		Page<Subject> page=ss.SearchSubjectLike(content, nowPage, size);
		model.addAttribute("content", page.getContent());
		model.addAttribute("totalPage",page.getTotalPages());
		nowPage++;
		model.addAttribute("nowPage",nowPage);
		model.addAttribute("totalElements",page.getNumberOfElements());
		//return model;
	}
}
