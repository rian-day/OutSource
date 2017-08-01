package com.hyh.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hyh.bean.SubjectC;
import com.hyh.entity.Exam;
import com.hyh.entity.RandomSubject;
import com.hyh.entity.Subject;
import com.hyh.entity.SubjectGroup;
import com.hyh.entity.UserAnswer;
import com.hyh.repository.ExamDao;
import com.hyh.repository.RandomSubjectDao;
import com.hyh.repository.SubjectDao;
import com.hyh.repository.SubjectGroupDao;
import com.hyh.repository.UserAnswerDao;


@Service
public class SubjectService {
	
	@Resource
	SubjectDao subjectdao;
	@Resource
	SubjectGroupDao sgd;
	@Resource
	UserAnswerDao ad;
	@Resource
	ExamDao ed;
	@Resource
	RandomSubjectDao rd;
	public SubjectGroup SearchSubjectGroupById(int id){
		return sgd.findById(id);
	}
	
	public Page<SubjectGroup> SearchAllSubjectGroup(int nowpage ,int size){
		Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(nowpage, size, sort);
        return sgd.findAll(pageable);
	}
	
	public Page<Subject> SearchAllInPage(int nowpage ,int size){
		Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(nowpage, size, sort);
        return subjectdao.findAll(pageable);
	}
	
	
	public List<Subject> randomSubjects(int ProfessionId){
		List<RandomSubject> list=rd.findAll();
		List<Subject> result = new ArrayList<Subject>();
		for(int i=0;i<list.size();i++){
			RandomSubject rs=list.get(i);
			List<Subject> subjects=subjectdao.findByTypeAndProfessionId(rs.getType(), ProfessionId);
			if(rs.getNum()>subjects.size()){
				//所需类型题目太多题库不够
			}
			int end=subjects.size()-1;
			int []arr=new int[subjects.size()];
			for(int j=0;j<arr.length;j++){
				arr[j]=j;
			}
			for(int j=0;j<rs.getNum();j++){
				int num=(int)(Math.random()*end);
				arr[num]=arr[end];
				end--;
				result.add(subjects.get(arr[num]));
			}
		}
		return result;
	}
	public String AddSingleSubject(Subject sj){
		subjectdao.save(sj);
		return "1";
	}
	public String AddSubject(List<Subject> list){
		subjectdao.save(list);
		return "1";
	}
	public Subject SearchSubject(int id){
		Subject result=subjectdao.findById(id);
		return result;
	}
	public Page<SubjectGroup> listAllSubjectGroup(int nowpage ,int size,int professionId){
		Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(nowpage, size, sort);
		return sgd.findByProfessionId(professionId, pageable);
	}
	public Set<Subject> SearchSubjectByGroupId(int groupid){
		return sgd.findById(groupid).getSubjects();
	}
	
}
