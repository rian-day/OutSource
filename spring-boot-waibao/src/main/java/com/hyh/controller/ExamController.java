package com.hyh.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hyh.bean.SessionUser;
import com.hyh.bean.SubjectC;
import com.hyh.entity.Exam;
import com.hyh.entity.Subject;
import com.hyh.entity.SubjectGroup;
import com.hyh.service.ExamService;
import com.hyh.service.SubjectService;

@Controller
public class ExamController {
	@Resource
	SubjectService ss;
	@Resource
	ExamService es;
	@Resource
	
	
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	
	
	/**
	 * 题目批改
	 * @param list
	 * @param professionId
	 * @param examId
	 * @return
	 */
	@PostMapping("/submitTest.do")
	public Map CorrectSubjects(
			List<SubjectC> list
			,Integer professionId
			,Integer examId){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String time=df.format(new Date());
		int grade=es.CorrectSubjects(examId,time,list);
		Map map=new HashMap();
		map.put("time", time);
		map.put("grade",grade);
		return map;
	}
	/**
	 * 随机生成exam
	 * @param professionId
	 * @param userId
	 * @return
	 */
	@RequestMapping("/randomsubjects")
	public Exam randomSubjects(
			Integer professionId
			,HttpSession session
			){
		String time=df.format(new Date());
		SessionUser user=(SessionUser) session.getAttribute("user");
		int userId=user.getUserId();
		List<Subject> list=ss.randomSubjects(professionId);
		Exam exam=es.saveExam(time,userId,professionId,list);
		return exam;
	}
	
	public Exam buildByGroupId(
			Integer id
			,HttpSession session
			){
		SessionUser user=(SessionUser) session.getAttribute("user");
		int userId=user.getUserId();
		String time=df.format(new Date());
		SubjectGroup subjectgroup=ss.SearchSubjectGroupById(id);
		return es.buildByGroupId(userId, subjectgroup,time);
	}
}
