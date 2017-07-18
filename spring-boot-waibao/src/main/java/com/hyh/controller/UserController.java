package com.hyh.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hyh.bean.User;
import com.hyh.entity.Profession;
import com.hyh.service.LoginService;
import com.hyh.service.ProfessionService;
import com.hyh.service.UserService;

@Controller
public class UserController {
	
 @Resource
 private UserService userService;
 @Resource
 private ProfessionService ps;
 @Resource
 private LoginService loginservice;
 
// @PostMapping("/editInfo.do")
// public User EditInfo(User user,HttpSession session){
//	 String mail=session.getAttribute("Mail").toString();
//	 if(user.getBoss()=='1'){
//		 userService.updateUserInfo(mail, user);
//	 }else{
//		 userService.updateAdimInfo(mail, user);
//	 }
//	 return result;
// }
 	@RequestMapping("/editInfo.do")
	@ResponseBody
	public String changeUserInfo(User user){
 		return userService.changeUserInfo(user);
 	}
 	/**
 	 * 检查登录
 	 * @param mail
 	 * @param password
 	 * @param boss
 	 * @param httpSession
 	 * @return
 	 * @throws IOException
 	 */
	@RequestMapping("/login.do")
	@ResponseBody
	public String CheckLogin(@RequestParam(value = "username", defaultValue = "null") String mail
			,@RequestParam(value = "password", defaultValue = "null") String password
			,@RequestParam(value = "boss", defaultValue = "0") String boss
			,HttpSession httpSession) throws IOException{
		boolean IsUser;
		if(boss.equals("1")){
			IsUser=loginservice.CheckAdmin(mail, password);
		}else{
			IsUser=loginservice.CheckLogin(mail, password);
		}
		if(IsUser){
			httpSession.setAttribute("Mail",mail);
			return "1";
		}
			
		return "0";
	}
	/**
	 * 修改密码
	 * @param mail
	 * @param password
	 * @param boss
	 * @return
	 */
 @RequestMapping("/editPwd.do")
 @ResponseBody
 public String changePassword(
		 @RequestParam("mail") String mail
		 , @RequestParam("password") String password
		 , @RequestParam("boss") String boss){
	 if(boss.equals("1")){
		 return userService.updateUserInfo(mail, password);
	 }else{
		 return userService.updateAdimInfo(mail, password);
	 }
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