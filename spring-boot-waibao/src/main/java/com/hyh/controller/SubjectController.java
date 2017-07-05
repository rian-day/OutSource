package com.hyh.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hyh.service.SubjectService;

@Controller
public class SubjectController {
	@Resource
	SubjectService ss;
	
	@PostMapping("/addsubject")
	@ResponseBody
	public String AddSubject(
			){
		return "1";
	}
}
