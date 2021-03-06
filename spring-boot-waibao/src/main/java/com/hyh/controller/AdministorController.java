package com.hyh.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hyh.bean.RandomSubjectBean;
import com.hyh.bean.SessionUser;
import com.hyh.entity.Subject;
import com.hyh.service.AdminService;
import com.hyh.service.SubjectService;

@Controller
public class AdministorController {
	@Resource
	SubjectService ss;
	@Resource
	AdminService as;
	
	/**
	 * 消息推送
	 * @param bbs
	 * @return
	 */
//	@PostMapping("/pushbbs.do")
//	@ResponseBody
//	public String correctRequest(){
//		return "1";
//	}
	@PostMapping("/pushbbs.do")
	@ResponseBody
	public String saveMessage(String bbs){
		return as.saveMessage1(bbs);
	}
	
	@PostMapping("/sendup.do")
	@ResponseBody
	public String addManySubject(HttpSession session){
		List<Subject> list=(List<Subject>) session.getAttribute("excel");
		return ss.AddSubject(list);
	}
	@PostMapping("set-index-list.do")
	@ResponseBody
	public String changeIndexList(
			HttpSession session
			,@RequestParam(value = "order[]", defaultValue = "null") char[] index
			){
		SessionUser user=(SessionUser)session.getAttribute("user");
		int id=user.getUserId();
		return as.changeIndexList(index, id);
	}
	@PostMapping("admin-editInfo.do")
	@ResponseBody
	public String adminEditInfo(
			@RequestParam("name") String name
			,@RequestParam("sex") char sex
			,HttpSession session){
		SessionUser user=(SessionUser) session.getAttribute("user");
		return as.editAndminInfo(user.getUserId(), name, sex);
	}
	/**
	 * 修改随机试卷模板
	 * @param professionId
	 * @param type
	 * @param num
	 * @param mark
	 * @return
	 */
	@PostMapping("creat-suijitp.do")
	@ResponseBody
	public String UpdateRandomSubject(
			//RandomSubjectBean rsb
			Integer professionId
			,@RequestParam("type")String[] type
			,@RequestParam("num")Integer[] num
			,@RequestParam("mark")Integer[] mark){
		RandomSubjectBean rsb=new RandomSubjectBean();
		rsb.setMark(mark);
		rsb.setNum(num);
		rsb.setProfessionId(professionId);
		//rsb.setType(type);
		//return as.updateRandomSubject(rsb);
		return "1";
	}
	
//	@PostMapping("admin-editPwd.do")
//	@ResponseBody
//	public String adminEditPwd(){
//		
//	}
}
