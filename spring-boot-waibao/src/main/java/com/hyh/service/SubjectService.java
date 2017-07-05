package com.hyh.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hyh.entity.Subject;
import com.hyh.entity.SubjectOptions;
import com.hyh.repository.SubjectDao;


@Service
public class SubjectService {
	
	@Resource
	SubjectDao subjectdao;
	
	public String AddSubject(String content
			,String type
			,String answer
			,int professionId
			,List<SubjectOptions> options){
		Subject sj=new Subject(content, type, answer, professionId, options);
		sj=subjectdao.save(sj);
		return "1";
	}
}
