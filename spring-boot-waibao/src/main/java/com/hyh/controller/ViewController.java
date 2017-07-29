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

import com.hyh.bean.SessionUser;
import com.hyh.entity.Exam;
import com.hyh.entity.Profession;
import com.hyh.entity.Subject;
import com.hyh.entity.SubjectGroup;
import com.hyh.entity.UserAnswer;
import com.hyh.entity.UserInfo;
import com.hyh.service.AdminService;
import com.hyh.service.ExamService;
import com.hyh.service.ProfessionService;
import com.hyh.service.SubjectService;
import com.hyh.service.UserCollectService;
import com.hyh.service.UserService;
@Controller
public class ViewController {
	@Resource
	ExamService xs;
	@Resource
	ProfessionService ps;
	@Resource
	SubjectService ss;
	@Resource
	UserService us;
	@Resource
	UserCollectService ucs;
	@Resource
	AdminService as;
	@RequestMapping("/index.html")
	public String index(){
		return "index";
	}
	@RequestMapping("/login.html")
	public ModelAndView login(){
		List<Profession> list=ps.searchAll();
		ModelAndView mav=new ModelAndView("login");
		mav.addObject("Professions",list);
		return mav;
	}
	@RequestMapping("/forget.html")
	public String forget(){
		return "forget";
	}
	@RequestMapping("/student-error.html")
	public ModelAndView studenterror (
			@RequestParam(value = "size", defaultValue = "5") Integer size
			, @RequestParam(value = "nowPage", defaultValue = "0") Integer nowpage
			, HttpSession session){
		SessionUser user=(SessionUser)session.getAttribute("user");
		int userId=user.getUserId();
		ModelAndView mav=new ModelAndView("student-error");
		Page<UserAnswer> page=ucs.getAllCollection(userId, nowpage, size);
		mav.addObject("totalPage",page.getTotalPages());
		mav.addObject("nowPage",nowpage);
		mav.addObject("totalElements",page.getNumberOfElements());
		mav.addObject("content",page.getContent());
		return mav;
	}
	@RequestMapping("/student-test.html")
	public ModelAndView studenttest(
			@RequestParam(value = "groupid") Integer groupid
			,@RequestParam("time") Integer time){
		Set<Subject> subjects=ss.SearchSubjectByGroupId(groupid);
		ModelAndView mav=new ModelAndView();
		mav.addObject("content",subjects);
		mav.setViewName("student-test");
		mav.addObject("time",time);
		return mav;
	}
	@RequestMapping("/student-history.html")
	public ModelAndView studenthistory(
			@RequestParam(value = "size", defaultValue = "5") Integer size
			, @RequestParam(value = "nowPage", defaultValue = "0") Integer nowpage
			, HttpSession session){
		SessionUser su=(SessionUser) session.getAttribute("user");
		Page<Exam> page=xs.searchPersonAllExam(su.getUserId(),nowpage,size);
		ModelAndView mav=new ModelAndView();
		mav.addObject("totalPage",page.getTotalPages());
		mav.addObject("nowPage",nowpage);
		mav.addObject("totalElements",page.getNumberOfElements());
		mav.addObject("content",page.getContent());
		mav.setViewName("student-history");
		return mav;
	}
	@RequestMapping("/student-info.html")
	public ModelAndView studentinfo(HttpSession session){
		ModelAndView mav=new ModelAndView("student-info");
		SessionUser su=(SessionUser) session.getAttribute("user");
		List<Profession> pros=ps.searchAll();
		String pro = null;
		for(int i=0;i<pros.size();i++){
			if(pros.get(i).getId()==su.getProfessionId())
				pro=pros.get(i).getName();
		}
		mav.addObject("pro",pro);
		mav.addObject("user",su);
		return mav;
	}
	@RequestMapping("/student-history-test.html")
	public ModelAndView studenthistorytest(
			@RequestParam("examid") Integer examid){
		ModelAndView mav=new ModelAndView("student-history-test");
		List<UserAnswer> set=xs.searchUseranswerByExamid(examid);
		mav.addObject("content",set);
		return mav;
	}
	@RequestMapping("/student-alltest.html")
	public ModelAndView listAllTest(
			@RequestParam(value = "size", defaultValue = "6") Integer size
			, @RequestParam(value = "nowPage", defaultValue = "0") Integer nowpage
			, HttpSession session){
		SessionUser su=(SessionUser) session.getAttribute("user");
		//Log.warn(su.getProfessionId());
		Page<SubjectGroup> page=ss.listAllSubjectGroup(nowpage,size,su.getProfessionId());
		ModelAndView mav=new ModelAndView();
		//Log.warn(page.getNumberOfElements());
		mav.addObject("totalPage",page.getTotalPages());
		mav.addObject("nowPage",nowpage);
		mav.addObject("totalElements",page.getNumberOfElements());
		mav.addObject("content",page.getContent());
		mav.setViewName("student-alltest");
		return mav;
	}
	@RequestMapping("/manage-addsubject.html")
	public ModelAndView manageaddsubject(){
		ModelAndView mav=new ModelAndView("manage-addsubject");
		List<Profession> pros=ps.searchAll();
		mav.addObject("pros",pros);
		return mav;
	}
	@RequestMapping("/manage-addtp.html")
	public ModelAndView manageaddtp(
			@RequestParam(value="nowpage",defaultValue = "0") Integer nowpage
			,@RequestParam(value="size",defaultValue= "5") Integer size){
		ModelAndView mav=new ModelAndView("manage-addtp");
		List<Profession> pros=ps.searchAll();
		mav.addObject("pros",pros);
		Page<Subject> result=ss.SearchAllInPage(nowpage,size);
		mav.addObject("content",result.getContent());
		mav.addObject("nowpage",nowpage);
		mav.addObject("TotalElements",result.getNumberOfElements());
		mav.addObject("TotalPages",result.getTotalPages());
		return mav;
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
	public ModelAndView manageindex(HttpSession session){
		SessionUser admin=(SessionUser) session.getAttribute("user");
		char[] order=as.getAdminPage(admin.getUserId());
		ModelAndView mav=new ModelAndView("manage-index");
		mav.addObject("indexList",order);
		return mav;
	}
	@RequestMapping("/manage-info.html")
	public ModelAndView manageinfo(HttpSession session){
		SessionUser su=(SessionUser) session.getAttribute("user");
		ModelAndView mav=new ModelAndView();
		mav.setViewName("manage-info");
		mav.addObject("user",su);
		return mav;
	}
	@RequestMapping("/manage-pro.html")
	public ModelAndView managepro(){
		List<Profession> list=ps.searchAll();
		ModelAndView mav=new ModelAndView("manage-pro");
		mav.addObject("content",list);
		return mav;
	}
	@RequestMapping("/manage-subjectlist.html")
	public ModelAndView managesubjectlist(
			@RequestParam(value="nowpage",defaultValue = "0") Integer nowpage
			,@RequestParam(value="size",defaultValue= "5") Integer size){
		Page<Subject> result=ss.SearchAllInPage(nowpage, size);
		List<Profession> pros=ps.searchAll();
		ModelAndView mav=new ModelAndView("manage-subjectlist");
		mav.addObject("content",result.getContent());
		mav.addObject("TotalElements",result.getNumberOfElements());
		mav.addObject("TotalPages",result.getTotalPages());
		mav.addObject("nowpage",nowpage);
		mav.addObject("pros",pros);
		return mav;
	}
	@RequestMapping("/manage-tplist.html")
	public ModelAndView managetplist(
			@RequestParam(value="nowpage",defaultValue = "0") Integer nowpage
			,@RequestParam(value="size",defaultValue= "5") Integer size){
		ModelAndView mav=new ModelAndView("manage-tplist");
		Page<SubjectGroup> result=ss.SearchAllSubjectGroup(nowpage, size);
		mav.addObject("content",result.getContent());
		mav.addObject("TotalElements",result.getNumberOfElements());
		mav.addObject("nowpage",nowpage);
		mav.addObject("TotalPages",result.getTotalPages());
		List<Profession> pros=ps.searchAll();
		mav.addObject("pros",pros);
		return mav;
	}
	@RequestMapping("/manage-userlist.html")
	public ModelAndView manageuserlist(
			@RequestParam(value="nowpage",defaultValue = "0") Integer nowpage
			,@RequestParam(value="size",defaultValue= "5") Integer size){
		ModelAndView mav=new ModelAndView("manage-userlist");
		List<Profession> pros=ps.searchAll();
		mav.addObject("pros",pros);
		Page<UserInfo> result=us.SearchAllInPage(nowpage,size);
		mav.addObject("content",result.getContent());
		mav.addObject("TotalElements",result.getNumberOfElements());
		mav.addObject("TotalPages",result.getTotalPages());
		mav.addObject("nowpage",nowpage);
		return mav;
	}
	@RequestMapping("/manage-orderlist.html")
	public String manageorderlist(){
		return "manage-orderlist";
	}
	
	
}
