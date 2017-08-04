package com.hyh.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hyh.bean.SessionUser;
import com.hyh.bean.SubjectBean;
import com.hyh.entity.Subject;
import com.hyh.service.ExamService;
import com.hyh.service.SubjectService;

@Controller
public class SubjectController {
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	@Resource
	SubjectService ss;
	@Resource
	ExamService es;
	
	@PostMapping("/addsubject")
	@ResponseBody
	public String AddSubject(@RequestParam(value="list") List<Subject> list){
		ss.AddSubject(list);
		return "success";
	}
	@PostMapping("/add-subject.do")
	@ResponseBody
	public String addsingleSubject(
			SubjectBean subject
			,HttpSession session){
		String time=df.format(new Date());
		SessionUser user=(SessionUser)session.getAttribute("user");
		return ss.AddSingleSubject(subject,user.getName(),time);
	}
	

}
