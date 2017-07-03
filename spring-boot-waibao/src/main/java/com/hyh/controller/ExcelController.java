package com.hyh.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.hyh.service.KnowledgeService;
import com.hyh.utils.ExcelImportUtils;

import reactor.rx.action.Control;

@Controller
public class ExcelController {
	
	@Autowired
	KnowledgeService knowledgeService;
	
	//导入  
	@PostMapping("/excel")
	@ResponseBody
	public String batchImportUserKnowledge(
			@RequestParam(value="filename") MultipartFile file,  
	        HttpServletRequest request
	        ,HttpServletResponse response
	        ,HttpSession session
	        //,@SessionAttribute("username") String username
	        ) throws IOException{  
	  
	    //判断文件是否为空  
	    if(file==null){  
	     session.setAttribute("msg","文件不能为空！");  
	     return "redirect:toUserKnowledgeImport";  
	    }  
	      
	    //获取文件名  
	    String fileName=file.getOriginalFilename();  
	      
	    //验证文件名是否合格  
	    if(!ExcelImportUtils.validateExcel(fileName)){  
	     session.setAttribute("msg","文件必须是excel格式！");  
	     return "redirect:toUserKnowledgeImport";  
	    }  
	      
	    //进一步判断文件内容是否为空（即判断其大小是否为0或其名称是否为null）  
	    long size=file.getSize();  
	    if(StringUtils.isEmpty(fileName) || size==0){  
	     session.setAttribute("msg","文件不能为空！");  
	     return "redirect:toUserKnowledgeImport";  
	    }  
	      
	    //批量导入  
	    String message = knowledgeService.batchImport(fileName
	    		,file
	    		//,username
	    		);  
	    //session.setAttribute("msg",message);  
	    return message;  
	}  
}
