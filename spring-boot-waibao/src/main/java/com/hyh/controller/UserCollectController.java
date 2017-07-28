package com.hyh.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hyh.service.UserCollectService;

@Controller
public class UserCollectController {
	@Resource
	UserCollectService ucs;
	
	@RequestMapping("/collect.do")
	public String collect(Integer useranswerId){
		return ucs.collect(useranswerId);
	}
	@RequestMapping("/cancelCollect.do")
	public String cancelCollect(Integer useranswerId){
		return ucs.cancelCollect(useranswerId);
	}
	
	@PostMapping("editAnalyse.do")
	public String editAnalyse(
			@RequestParam("analyse") String analyse
			,@RequestParam("answerId") Integer answerId){
		return ucs.editAnalyse(answerId, analyse);
	}
	
	
}
