package com.hyh.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hyh.entity.Subject;
import com.hyh.service.ExcelService;
import com.hyh.service.UserService;
import com.hyh.utils.ExcelImportUtils;

@Controller
public class ExcelController {
	static Logger log = Logger.getLogger (UserService.class.getName ());
	
	@Autowired
	ExcelService knowledgeService;
	//获取模板
	@Value("${web.excel.download}")
	String web_path;
	@PostMapping("/getexcel.do")
    public ResponseEntity<InputStreamResource> downloadFile( Long id)  
            throws IOException {  
		
		String path=ClassUtils.getDefaultClassLoader().getResource("").getPath();
		log.error(path);
		path=path.replace("/target/classes/", "");
        String filePath =path+web_path;
        FileSystemResource file = new FileSystemResource(filePath);  
        HttpHeaders headers = new HttpHeaders();  
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");  
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getFilename()));  
        headers.add("Pragma", "no-cache");  
        headers.add("Expires", "0");  
  
        return ResponseEntity  
                .ok()  
                .headers(headers)  
                .contentLength(file.contentLength())  
                .contentType(MediaType.parseMediaType("application/octet-stream"))  
                .body(new InputStreamResource(file.getInputStream()));  
    }  
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
