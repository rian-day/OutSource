package com.hyh.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hyh.bean.SessionUser;
import com.hyh.bean.SubjectBean;
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

	public final ObjectMapper mapper = new ObjectMapper(); 
	
	
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
	public Model findSubject(
			@RequestParam(value = "size", defaultValue = "5") Integer size
			,@RequestParam(value = "nowPage", defaultValue = "1") Integer nowPage
			,@RequestParam(value = "professionId") Integer professionId
			,Model model
			){
		nowPage--;
		Page<Subject> page=ss.SearchSubjectLike(nowPage, size,professionId);
		model.addAttribute("content", page.getContent());
		model.addAttribute("totalPage",page.getTotalPages());
		nowPage++;
		model.addAttribute("nowPage",nowPage);
		model.addAttribute("totalElements",page.getNumberOfElements());
		return model;
	}
	@PostMapping("mohu-search-subject.do")
	@ResponseBody
	public List<SubjectBean> mohuSubject(
			String content
			,Integer professionId) throws JsonProcessingException{
		List<SubjectBean> list=ss.MohuSearchSubject(content, professionId);

		return 	list;
	}
}
