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
	@RequestMapping("/manage-addsubject.html")
	public String manageaddsubject(){
		return "manage-addsubject";
	}
	@RequestMapping("/manage-addtp.html")
	public String manageaddtp(){
		return "manage-addtp";
	}
	@RequestMapping("/manage-bbs.html")
	public String managebbs(){
		return "manage-bbs";
	}
	@RequestMapping("manage-adduser.html")
	public String manageadduser(){
		return "";
	}
	@RequestMapping("manage-index.html")
	public String manageindex(){
		return "manage-index";
	}
	@RequestMapping("manage-info.html")
	public String manageinfo(){
		return "manage-info";
	}
	@RequestMapping("manage-pro.html")
	public String managepro(){
		return "manage-pro";
	}
	@RequestMapping("manage-subjectlist.html")
	public String managesubjectlist(){
		return "manage-subjectlist";
	}
	@RequestMapping("manage-tplist.html")
	public String managetplist(){
		return "manage-tplist";
	}
	@RequestMapping("manage-userlist.html")
	public String manageuserlist(){
		return "manage-userlist";
	}
	
	
}
