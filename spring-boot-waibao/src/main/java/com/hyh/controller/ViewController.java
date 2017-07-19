package com.hyh.controller;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hyh.entity.Exam;
import com.hyh.entity.Subject;
import com.hyh.entity.SubjectGroup;
import com.hyh.entity.UserAnswer;
import com.hyh.service.ExamService;
import com.hyh.service.SubjectService;
@Controller
public class ViewController {
	@Resource
	ExamService xs;
	
	@Resource
	SubjectService ss;
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
	@RequestMapping("/student-test.html")
	public ModelAndView studenttest(
			@RequestParam(value = "groupid") Integer groupid){
		Set<Subject> subjects=ss.SearchSubjectByGroupId(groupid);
		ModelAndView mav=new ModelAndView();
		mav.addObject("content",subjects);
		mav.setViewName("student-test");
		return mav;
	}
	@RequestMapping("/student-history.html")
	public ModelAndView studenthistory(
			@RequestParam(value = "size", defaultValue = "5") Integer size
			, @RequestParam(value = "nowPage", defaultValue = "1") Integer nowpage
			, HttpSession session){
		String mail=session.getAttribute("mail").toString();
		Page<Exam> page=xs.searchPersonAllExam(mail,nowpage,size);
		ModelAndView mav=new ModelAndView();
		mav.addObject("totalPage",page.getTotalPages());
		mav.addObject("nowPage",nowpage);
		mav.addObject("totalElements",page.getNumberOfElements());
		mav.addObject("content",page.getContent());
		mav.setViewName("student-history");
		return mav;
	}
	@RequestMapping("/student-info.html")
	public String studentinfo(){
		return "student-info";
	}
	@RequestMapping("/student-history-test.html")
	public ModelAndView studenthistorytest(
			@RequestParam("examid") Integer examid){
		ModelAndView mav=new ModelAndView();
		List<UserAnswer> set=xs.searchUseranswerByExamid(examid);
		mav.addObject("content",set);
		mav.setViewName("student-history-test");
		return mav;
	}
	@RequestMapping("/student-alltest.html")
	public ModelAndView listAllTest(
			@RequestParam(value = "size", defaultValue = "6") Integer size
			, @RequestParam(value = "nowPage", defaultValue = "1") Integer nowpage
			, HttpSession session){
		
		Page<SubjectGroup> page=ss.listAllSubjectGroup(nowpage,size);
		ModelAndView mav=new ModelAndView();
		mav.addObject("totalPage",page.getTotalPages());
		mav.addObject("nowPage",nowpage);
		mav.addObject("totalElements",page.getNumberOfElements());
		mav.addObject("content",page.getContent());
		mav.setViewName("student-alltest");
		return mav;
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
	@RequestMapping("/manage-adduser.html")
	public String manageadduser(){
		return "manage-adduser";
	}
	@RequestMapping("/manage-index.html")
	public String manageindex(){
		return "manage-index";
	}
	@RequestMapping("/manage-info.html")
	public String manageinfo(){
		return "manage-info";
	}
	@RequestMapping("/manage-pro.html")
	public String managepro(){
		return "manage-pro";
	}
	@RequestMapping("/manage-subjectlist.html")
	public String managesubjectlist(){
		return "manage-subjectlist";
	}
	@RequestMapping("/manage-tplist.html")
	public String managetplist(){
		return "manage-tplist";
	}
	@RequestMapping("/manage-userlist.html")
	public String manageuserlist(){
		return "manage-userlist";
	}
	
	
}
