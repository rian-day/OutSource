package com.hyh.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hyh.service.UserService;

@RestController
public class UserController {
	
 @Resource
 private UserService userService;
 
 @PostMapping(value = "/fileUpload")
 public String fileUpload(@RequestParam("file") MultipartFile file
		 , @RequestParam("userId") Integer userId) {
 //ResultVo resultVo = new ResultVo();
 	//验证文件类型是否合法
	 userService.UploadUserHead(file, userId);
	 
	 //String extension = Files.getFileExtension(fileName);
	 //Matcher matcher = pattern.matcher(extension.toLowerCase());
	 //boolean match = matcher.matches();
	 return "success";
 
 }
 
}