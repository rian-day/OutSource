package com.hyh.controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hyh.entity.UserInfo;
import com.hyh.repository.UserInfoRepository;
import com.hyh.service.LoginService;

@Controller
@ResponseBody
public class MainController {
	
	@Autowired
	LoginService loginservice;
	@Autowired
	UserInfoRepository userDao;
	
	@RequestMapping("/login")
	public String CheckLogin(@RequestParam(value = "mail", defaultValue = "null") String mail,
			@RequestParam(value = "password", defaultValue = "null") String password){
		boolean IsUser=loginservice.CheckLogin(mail, password);
		if(IsUser)
			return "welcome"+mail;
		return "fail";
	}
	
	/**
	 * 分页
	 * @param name
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value = "/params", method= RequestMethod.GET)
	@ResponseBody
    public String getEntryByParams(@RequestParam(value = "name", defaultValue = "林志强") String name, 
    		@RequestParam(value = "page", defaultValue = "0") Integer page, 
    		@RequestParam(value = "size", defaultValue = "15") Integer size) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        Page<UserInfo> pages=userDao.findByNameNot(name,pageable);
        Iterator<UserInfo> it=pages.iterator();
        String result=null;
        while(it.hasNext()){
        	result=result+"\n value:"+((UserInfo)it.next()).getId();
        }
        return result;
    }
	
	
}
