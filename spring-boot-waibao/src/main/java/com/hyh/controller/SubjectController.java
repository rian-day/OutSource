package com.hyh.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hyh.entity.Subject;
import com.hyh.service.ExamService;
import com.hyh.service.SubjectService;

@Controller
public class SubjectController {
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

	@RequestMapping("/searchsubject")
	@ResponseBody
	public ModelAndView SearchSubject(@RequestParam(value="id") Integer id){
		Subject result=ss.SearchSubject(id);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("index");
		mav.addObject("result", result);
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
