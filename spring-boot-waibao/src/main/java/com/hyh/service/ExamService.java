package com.hyh.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hyh.entity.Exam;
import com.hyh.entity.Subject;
import com.hyh.entity.UserAnswer;
import com.hyh.entity.UserInfo;
import com.hyh.repository.ExamDao;
import com.hyh.repository.UserInfoDao;
@Service
public class ExamService {
	
	@Resource
	ExamDao ed;
	@Resource
	UserInfoDao ud;
	public Page<Exam> searchPersonAllExam(int userId ,int nowpage ,int size){
		Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(nowpage, size, sort);
		Page<Exam> page=ed.findByUserId(userId,pageable);
		return page;
	}
	public List<UserAnswer> searchUseranswerByExamid(int examid){
		return ed.findById(examid).getUseranswer();
	}
	//保存用户考试
	public Exam saveExam(String time,int userId,int professionId,List<Subject> list){
		List<UserAnswer> useranswerList=null;
		int totalgrade=0;
		for(int i=0;i<list.size();i++){
			UserAnswer useranswer=new UserAnswer();
			useranswer.setSubject(list.get(i));
			totalgrade+=list.get(i).getGrade();
			useranswerList.add(useranswer);
		}
		Exam exam=new Exam();
		exam.setTime(time);
		exam.setUserId(userId);
		exam.setProfessionId(professionId);
		exam.setUseranswer(useranswerList);
		exam.setTotalgrade(totalgrade);
		return ed.save(exam);
	}
}
