package com.hyh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.hyh.entity.Subject;

@Controller
public class AdministorController {
	
	@PostMapping("/danxuan-timu.do")
	public String addSubject(Subject subject){
		
	}
}	
