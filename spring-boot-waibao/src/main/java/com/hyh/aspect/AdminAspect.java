package com.hyh.aspect;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.hyh.bean.SessionUser;
import com.hyh.service.AspectService;

@Aspect
@Component
public class AdminAspect {
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	private static final Logger LOG=Logger.getLogger(AdminAspect.class.getName());
	
	@Resource
	AspectService aspectservice;
	
	@Pointcut("execution(* com.hyh.controller.ViewController.*(..)) and @annotation(org.springframework.web.bind.annotation.RequestMapping)")  
	public void userExist(){}
	@Pointcut("execution(* com.hyh.controller.SubjectController.addsingleSubject(..)) and @annotation(org.springframework.web.bind.annotation.RequestMapping)")  
	public void addsubject(){}
	
	@Before(value = "userExist()")
	public void checkUser(JoinPoint joinPoint){
		HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session =request.getSession();
		if("".equals(session.getAttribute("user"))){
			LOG.info("初始化Session中的user");
			session.setAttribute("user", null);
		}
	}
	@AfterReturning(returning = "o",pointcut = "addsubject()")
	public void addSubject(Object o){
		if(o.equals("1")){
			HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
			HttpSession session =request.getSession();
			session.getAttribute("user");
			SessionUser user=(SessionUser)session.getAttribute("user");
			String name=user.getName();
			LOG.info("管理员:"+name+"添加题目");
			String time=df.format(new Date());
			aspectservice.saveAdminInfo(user.getUserId(), "管理员:"+name+"添加题目", time);
		}
	}
}
