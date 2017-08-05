package com.hyh.service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hyh.entity.UserAnswer;
import com.hyh.repository.UserAnswerDao;

@Service
public class UserCollectService {
	static Logger log = Logger.getLogger (UserCollectService.class.getName ());
	@Resource
	UserAnswerDao uad;
	public Page<UserAnswer> getAllCollection(int userId,int nowpage,int size){
		Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(nowpage, size, sort);
		return uad.findByUserIdAndCollect(userId,'1',pageable);
	}
	
	@Transactional
	public String collect(int id){
		UserAnswer useranswer=uad.findById(id);
		useranswer.setCollect('1');
		uad.save(useranswer);
		return "1";
	}
	@Transactional
	public String cancelCollect(int id){
		UserAnswer useranswer=uad.findById(id);
		useranswer.setCollect('0');
		uad.save(useranswer);
		return "1";
	}
	
	public String editAnalyse(int answerId,String analyse){
		UserAnswer answer=uad.findById(answerId);
		answer.setAnalyse(analyse);
		uad.save(answer);
		return "1";
	}
	
}
