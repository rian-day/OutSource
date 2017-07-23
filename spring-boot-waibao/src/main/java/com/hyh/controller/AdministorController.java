package com.hyh.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.hyh.entity.Subject;
import com.hyh.service.SubjectService;

@Controller
public class AdministorController {
	@Resource
	SubjectService ss;
	
	@PostMapping("/danxuan-timu.do")
	public String addSubject(Subject subject){
		return ss.AddSingleSubject(subject);
	}
	@PostMapping("/sendup.do")
	public String addManySubject(List<Subject> list){
		return ss.AddSubject(list);
	}
}	
