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

}
