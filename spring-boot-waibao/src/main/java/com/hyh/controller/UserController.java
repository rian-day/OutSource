package com.hyh.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hyh.bean.User;
import com.hyh.entity.Profession;
import com.hyh.service.ProfessionService;
import com.hyh.service.UserService;

@Controller
public class UserController {
	
 @Resource
 private UserService userService;
 @Resource
 private ProfessionService ps;
 
 @PostMapping("/editInfo.do")
 public User EditInfo(User user,HttpSession session){
	 String mail=session.getAttribute("Mail").toString();
	 if(user.getBoss()=='1'){
		 userService.updateUserInfo(mail, user);
	 }else{
		 userService.updateAdimInfo(mail, user);
	 }
	 return result;
 }
 
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
 @PostMapping(value = "/proRead.do")
 public String[] proRead(){
	 List<Profession> list=ps.searchAll();
	 String []data=new String[list.size()];
	 for(int i=0;i<list.size();i++){
		 data[i]=list.get(i).getName();
	 }
	 return data;
 }
 
}