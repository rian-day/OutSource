package com.hyh.service;

import java.util.List;
import java.util.Random;
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
	
	public List<Subject> randomSubjects(int ProfessionId){
		List<RandomSubject> list=rd.findAll();
		List<Subject> result = null;
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
				result.add(subjects.get(num));
			}
		}
		return result;
	}
	
	public String AddSubject(List<Subject> list){
		Subject sj;
		String error="";
		for(int i=0;i<list.size();i++){
			sj=list.get(i);
			if(sj.getContent().equals("")){
				
			}else if(sj.getUserAnswer().equals("")){
				
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
	public Page<SubjectGroup> listAllSubjectGroup(int nowpage ,int size){
		Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(nowpage, size, sort);
		return sgd.findAll(pageable);
	}
	public Set<Subject> SearchSubjectByGroupId(int groupid){
		return sgd.findById(groupid).get(0).getSubject();
	}
	//散题批改并存入数据库
	public int CorrectSubjects(int examId,String time,List<SubjectC> list){
		int totalgrade=0;
		Exam exam=ed.findById(examId);
		for(int i=0;i<list.size();i++){
			SubjectC sc=list.get(i);
			Subject subject=exam.getUseranswer().get(i).getSubject();
			char status=0;
			if(subject.getType().equals("选择题")){
				if(subject.getRealAnswer().equals(sc.getUseranswer())){
					totalgrade+=subject.getGrade();
					status=1;
				}
				status=0;
			}
			
			exam.setTime(time);
			UserAnswer useranswer=new UserAnswer();
			useranswer.setAnswer(sc.getUseranswer());
			useranswer.setStatus(status);
			useranswer.setExamId(exam);
			ad.save(useranswer);
		}
		return totalgrade;
	}
	
}
