package com.hyh.controller;

import javax.servlet.http.HttpSession;

import org.crsh.console.jline.internal.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hyh.bean.User;
import com.hyh.entity.UserInfo;
import com.hyh.repository.UserInfoDao;
import com.hyh.service.LoginService;
import com.hyh.service.RegisterService;

@Controller
public class MainController {
	
	@Autowired
	LoginService loginservice;
	@Autowired
	UserInfoDao userDao;
	@Autowired
	RegisterService rs;
	

	/**
	 * 用户注册验证
	 * @param user
	 * @param httpSession
	 * @return
	 */
	@PostMapping("/register.do")
	public ModelAndView Register( 
			User user
//			@RequestParam(value = "mail", defaultValue = "null") String mail
//			,@RequestParam(value = "password", defaultValue = "null") String password
//			,@RequestParam(value = "name", defaultValue = "null") String name
//			,@RequestParam(value = "sex", defaultValue = "null") char sex
			,HttpSession httpSession){
		ModelAndView mav=new ModelAndView();
		UserInfo userinfo=new UserInfo(user.getUsername(), user.getName(), user.getPassword(), user.getSex());
		String yzm=user.getYzm();
		String msg="";
		if(!yzm.equals(httpSession.getAttribute("yzm"))){
			mav.setViewName("login");
			msg+="验证码错误";
			mav.addObject("msg",msg);
			return mav;
		}
		mav.setViewName("index");
		UserInfo result=loginservice.Register(userinfo,user.getPro());
		if(!result.equals("")){
			mav.addObject("user",result);
			return mav;
		}
		return mav;
	}
	@PostMapping("/yzm.do")
	@ResponseBody
	public String YZM(
			@RequestParam(value = "mail", defaultValue = "null") String mail
			,HttpSession httpSession) throws Exception{
		String yzm="h";
		for(int i=0;i<5;i++){
			yzm+=(int)(Math.random()*10);
		}
		httpSession.setAttribute("yzm", yzm);
		Log.warn("Session:"+httpSession.getAttribute("yzm"));
		Log.warn("mail:"+mail);
		rs.sendSimpleMail(mail,yzm);
		return "";
	}
	@PostMapping("/checkYzm.do")
	@ResponseBody
	public String CheckYzm(
			@RequestParam(value = "yzm") String yzm
			, HttpSession session){
		if(yzm.equals(session.getAttribute("session"))){
			return "1";
		}
		return "0";
	}
	/**
	 * 分页
	 * @param name
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value = "/params", method= RequestMethod.GET)
    public ModelAndView getEntryByParams(@RequestParam(value = "name", defaultValue = "林志强") String name, 
    		@RequestParam(value = "page", defaultValue = "0") Integer page, 
    		@RequestParam(value = "size", defaultValue = "15") Integer size) {
        
        ModelAndView mav=new ModelAndView();
        Page<UserInfo> pages=loginservice.SearchForPage(name, page, size);
        mav.addObject("totalPage",pages.getTotalPages());
        mav.addObject("content",pages.getContent());
        mav.addObject("now",pages.getNumberOfElements());
        mav.addObject("totalel",pages.getTotalElements());
        mav.setViewName("index");
        return mav;
    }
	
	
}
