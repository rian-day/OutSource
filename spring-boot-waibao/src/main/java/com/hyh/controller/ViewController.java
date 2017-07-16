package com.hyh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class ViewController {
	@RequestMapping("/index.html")
	public String index(){
		return "index";
	}
	@RequestMapping("/login.html")
	public String login(){
		return "login";
	}
	@RequestMapping("/forget.html")
	public String forget(){
		return "forget";
	}
	@RequestMapping("/student-error.html")
	public String studenterror (){
		return "student-error";
	}
	@RequestMapping("/student-history.html")
	public String studenthistory(){
		return "student-history";
	}
	@RequestMapping("/student-info.html")
	public String studentinfo(){
		return "student-info";
	}
	@RequestMapping("/student-history-test.html")
	public String studenthistorytest(){
		return "student-history-test";
	}
	@RequestMapping("/student-random-test.html")
	public String studentrandomtest(){
		return "student-random-test";
	}
	@RequestMapping("/student-test.html")
	public String studenttest(){
		return "student-test";
	}
}
