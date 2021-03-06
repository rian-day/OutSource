package com.hyh.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hyh.service.UserCollectService;

@Controller
public class UserCollectController {
	@Resource
	UserCollectService ucs;
	
	@RequestMapping("/collect.do")
	@ResponseBody
	public String collect(
			@RequestParam("id") Integer id){
		return ucs.collect(id);
	}
	@RequestMapping("/cancelCollect.do")
	@ResponseBody
	public String cancelCollect(
			@RequestParam("id") Integer id){
		return ucs.cancelCollect(id);
	}
	
	@PostMapping("editAnalyse.do")
	@ResponseBody
	public String editAnalyse(
			@RequestParam("analyse") String analyse
			,@RequestParam("queId") Integer answerId){
		return ucs.editAnalyse(answerId, analyse);
	}
	
	
}
