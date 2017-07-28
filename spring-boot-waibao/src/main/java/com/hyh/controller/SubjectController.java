package com.hyh.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hyh.bean.SubjectC;
import com.hyh.entity.Exam;
import com.hyh.entity.Subject;
import com.hyh.service.ExamService;
import com.hyh.service.SubjectService;

@Controller
public class SubjectController {
	@Resource
	SubjectService ss;
	@Resource
	ExamService es;
	/**
	 * 随机生成试卷
	 * 
	 * @param professionId
	 * @param userId
	 * @return
	 */
	@RequestMapping("/randomsubjects")
	public ModelAndView randomSubjects(Integer professionId,Integer userId){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String time=df.format(new Date());
		List<Subject> list=ss.randomSubjects(professionId);
		Exam exam=es.saveExam(time,userId,professionId,list);
		ModelAndView mav=new ModelAndView();
		mav.addObject("exam",exam);
		mav.setViewName("");
		return mav;
	}
	
	@PostMapping("/addsubject")
	@ResponseBody
	public String AddSubject(@RequestParam(value="list") List<Subject> list){
		ss.AddSubject(list);
		return "success";
	}
	/**
	 * 散题给分保存
	 * @param list
	 * @return
	 */
	@PostMapping("/submitTest.do")
	public Map CorrectSubjects(
			List<SubjectC> list
			,Integer userId
			,Integer professionId
			,Integer examId){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String time=df.format(new Date());
		int grade=ss.CorrectSubjects(examId,time,list);
		Map map=new HashMap();
		map.put("time", time);
		map.put("grade",grade);
		return map;
	}
	@RequestMapping("/searchsubject")
	@ResponseBody
	public ModelAndView SearchSubject(@RequestParam(value="id") Integer id){
		List<Subject> result=ss.SearchSubject(id);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("index");
		mav.addObject("items", result);
		mav.addObject("name", "hyh");
		
//		String out="";
//		for(int i=0;i<result.size();i++){
//			Set imgs=result.get(i).getSubjectImg();
//			Set options=result.get(i).getOptions();
//			Iterator it1=imgs.iterator();
//			Iterator it=options.iterator();
//			while(it.hasNext()){
//				SubjectOptions option=(SubjectOptions) it.next();
//				out+="<br/>content:"+option.getContent();
//				out+="<br/>option:"+option.getOptionName();
//			}
//			while(it1.hasNext()){
//				SubjectImg img=(SubjectImg) it1.next();
//				out+="<br/>src:"+img.getSrc();
//				out+="<br/>id:"+img.getId();
//			}
//		}
		return mav;
	}
}
