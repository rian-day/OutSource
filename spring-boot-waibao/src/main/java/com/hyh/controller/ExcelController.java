package com.hyh.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hyh.entity.Subject;
import com.hyh.service.ExcelService;
import com.hyh.utils.ExcelImportUtils;

@Controller
public class ExcelController {
	
	@Autowired
	ExcelService knowledgeService;
	
	//导入  
	@PostMapping("/excel")
	public List<Subject> batchImportUserKnowledge(
			@RequestParam(value="filename") MultipartFile file,  
	        HttpServletRequest request
	        ,HttpServletResponse response
	        ,HttpSession session
	        //,@SessionAttribute("username") String username
	        ) throws IOException{  
	  
	    //判断文件是否为空  
	    if(file==null){  
	     session.setAttribute("msg","文件不能为空！");  
	     return null;  
	    }  
	      
	    //获取文件名  
	    String fileName=file.getOriginalFilename();  
	      
	    //验证文件名是否合格  
	    if(!ExcelImportUtils.validateExcel(fileName)){  
	     session.setAttribute("msg","文件必须是excel格式！");  
	     return null;
	    }  
	      
	    //进一步判断文件内容是否为空（即判断其大小是否为0或其名称是否为null）  
	    long size=file.getSize();  
	    if(StringUtils.isEmpty(fileName) || size==0){  
	     session.setAttribute("msg","文件不能为空！");  
	     return null;
	    }  
	      
	    //批量导入  
	    List<Subject> list = knowledgeService.batchImport(fileName
	    		,file
	    		//,username
	    		);  
	    //session.setAttribute("msg",message);  
	    return list;  
	}  
}
