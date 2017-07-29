package com.hyh.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.crsh.console.jline.internal.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@PostMapping("/danxuan-timu.do")
	public String addSubject(Subject subject){
		return ss.AddSingleSubject(subject);
	}
	@PostMapping("/sendup.do")
	public String addManySubject(List<Subject> list){
		return ss.AddSubject(list);
	}
	@PostMapping("set-index-list.do")
	@ResponseBody
	public String changeIndexList(
			HttpSession session
			,@RequestParam(value = "order[]", defaultValue = "null") char[] index
			){
		//char [] index={0,1};
//		for(char x: index){
//			Log.warn(x);
//		}
		SessionUser user=(SessionUser)session.getAttribute("user");
		int id=user.getUserId();
		return as.changeIndexList(index, id);
	}
}	
