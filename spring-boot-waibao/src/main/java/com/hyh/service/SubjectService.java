package com.hyh.service;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hyh.entity.Subject;
import com.hyh.repository.SubjectDao;


@Service
public class SubjectService {
	
	@Resource
	SubjectDao subjectdao;
	
	public String AddSubject(List<Subject> list){
		Subject sj;
		String error="";
		for(int i=0;i<list.size();i++){
			sj=list.get(i);
			if(sj.getContent().equals("")){
				
			}else if(sj.getAnswer().equals("")){
				
			}else if(sj.getType().equals("")){
				if(sj.getType().equals("选择题")){
					//error+= sj.getOptions().size()==0?i:i+1;
				}
			}
			
			sj=subjectdao.save(sj);
		}
		return "1";
	}
	public List<Subject> SearchSubject(int id){
		List<Subject> result=subjectdao.findById(id);
		return result;
	}
}
