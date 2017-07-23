package com.hyh.service;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.transaction.Transactional;

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
	
	@Transactional
	public String editAnalyse(int id,String analyse){
		UserAnswer useranswer=ad.findById(id);
		useranswer.setAnalyse(analyse);
		ad.save(useranswer);
		return "1";
	}
	@Transactional
	public String collect(int id){
		UserAnswer useranswer=ad.findById(id);
		useranswer.setCollect('1');
		ad.save(useranswer);
		return "1";
	}
	@Transactional
	public String cancelCollect(int id){
		UserAnswer useranswer=ad.findById(id);
		useranswer.setCollect('0');
		ad.save(useranswer);
		return "1";
	}
	
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
	public List<Subject> SearchSubject(int id){
		List<Subject> result=subjectdao.findById(id);
		return result;
	}
	public Page<SubjectGroup> listAllSubjectGroup(int nowpage ,int size,int professionId){
		Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(nowpage, size, sort);
		return sgd.findByProfessionId(professionId, pageable);
	}
	public Set<Subject> SearchSubjectByGroupId(int groupid){
		return sgd.findById(groupid).getSubject();
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
