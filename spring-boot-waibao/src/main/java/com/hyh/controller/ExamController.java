package com.hyh.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hyh.bean.SessionUser;
import com.hyh.bean.SubjectC;
import com.hyh.entity.Exam;
import com.hyh.entity.Subject;
import com.hyh.entity.SubjectGroup;
import com.hyh.service.AspectService;
import com.hyh.service.ExamService;
import com.hyh.service.SubjectService;

@Controller
public class ExamController {
	@Resource
	SubjectService ss;
	@Resource
	ExamService es;
	@Resource
	AspectService aspect;
	
	public final ObjectMapper mapper = new ObjectMapper(); 
	
	/**
	 * 题目批改
	 * @param list
	 * @param professionId
	 * @param examId
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@PostMapping("/submitTest.do")
	@ResponseBody
	public Map CorrectSubjects(
			String list
			,Integer examId) throws JsonParseException, JsonMappingException, IOException{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String time=df.format(new Date());
		JavaType javaType=mapper.getTypeFactory().constructParametricType(ArrayList.class, SubjectC.class);
		List<SubjectC> list1=(List<SubjectC>)mapper.readValue(list, javaType); 
		int grade=es.CorrectSubjects(examId,time,list1);
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
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
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
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		SessionUser user=(SessionUser) session.getAttribute("user");
		int userId=user.getUserId();
		String time=df.format(new Date());
		SubjectGroup subjectgroup=ss.SearchSubjectGroupById(id);
		aspect.saveUserInfo(userId, "用户("+user.getName()+"):创建了一场考试("+subjectgroup.getName()+")", time);
		return es.buildByGroupId(userId, subjectgroup,time);
	}
}
