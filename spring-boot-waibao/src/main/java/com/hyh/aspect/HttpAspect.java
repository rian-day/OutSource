package com.hyh.aspect;


import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class HttpAspect {
	private static final Logger LOG=Logger.getLogger(HttpAspect.class.getName());
	
	@Pointcut("execution(public * com.hyh.controller..*.*(..))")
	public void point(){}
	
	@Before(value = "point()")
	public void doBefore(JoinPoint joinPoint){
		LOG.warn("Aspect do before");
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		//打印请求内容
		LOG.info("===============请求内容===============");
		LOG.info("请求地址:"+request.getRequestURL().toString());
		LOG.info("请求方式:"+request.getMethod());
		LOG.info("请求类方法:"+joinPoint.getSignature());
		LOG.info("请求类方法参数:"+ Arrays.toString(joinPoint.getArgs()));
		LOG.info("===============请求内容===============");
	}
	@AfterReturning(returning = "o",pointcut = "point()")
	public void methodAfterReturing(Object o ){
		LOG.info("--------------返回内容----------------");
		LOG.info("Response内容:"+o);
		LOG.info("--------------返回内容----------------");
		LOG.warn("Aspect do AfterReturning");
	}
}
