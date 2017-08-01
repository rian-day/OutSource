package com.hyh.service;

import java.util.ArrayList;
import java.util.Iterator;
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
import com.hyh.entity.Subject;
import com.hyh.entity.SubjectGroup;
import com.hyh.entity.UserAnswer;
import com.hyh.repository.ExamDao;
import com.hyh.repository.UserAnswerDao;
import com.hyh.repository.UserInfoDao;
@Service
public class ExamService {
	
	@Resource
	ExamDao ed;
	@Resource
	UserInfoDao ud;
	@Resource
	UserAnswerDao ad;
	
	
	
	/**
	 * 批改题目
	 * @param examId
	 * @param time
	 * @param list
	 * @return
	 */
	public int CorrectSubjects(int examId,String time,List<SubjectC> list){
		int totalgrade=0;
		Exam exam=ed.findById(examId);
		int []singlegrade=exam.getSinglegrade();
		for(int i=0;i<list.size();i++){
			SubjectC sc=list.get(i);
			UserAnswer useranswer=exam.getUseranswer().get(i);
			Subject subject=useranswer.getSubject();
			char status=0;
			if(subject.getType().equals("单选题")|subject.getType().equals("多选题")){
				if(subject.getRealAnswer().equals(sc.getUseranswer())){
					totalgrade+=singlegrade[i];
					status=1;
				}else{
					status=0;
				}
			}else if(subject.getType().equals("填空题")){
				if(subject.getRealAnswer().equals(sc.getUseranswer())){
					totalgrade+=singlegrade[i];
					status=1;
				}else{
					status=0;
				}
			}
			useranswer.setAnswer(sc.getUseranswer());
			useranswer.setStatus(status);
			ad.save(useranswer);
		}
		return totalgrade;
	}
	/**
	 * 通过已有试卷创建考试记录
	 * @param id
	 * @return
	 */
	public Exam buildByGroupId(int userId,SubjectGroup subjectgroup,String time){
		Set<Subject> set=subjectgroup.getSubjects();
		Exam exam =new Exam();
		Iterator<Subject> iterator=set.iterator();
		while(iterator.hasNext()){
			Subject subject=iterator.next();
			UserAnswer useranswer=new UserAnswer();
			useranswer.setSubject(subject);
			useranswer.setUserId(userId);
			exam.adduseranswer(useranswer);
		}
		exam.setSinglegrade(subjectgroup.getSinglegrade());
		exam.setProfessionId(subjectgroup.getProfessionId());
		exam.setTime(time);
		exam.setTotalgrade(subjectgroup.getTotalgrade());
		return ed.save(exam);
	}
	/**
	 * 查找所有考试记录
	 * @param userId
	 * @param nowpage
	 * @param size
	 * @return
	 */
	public Page<Exam> searchPersonAllExam(int userId ,int nowpage ,int size){
		Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(nowpage, size, sort);
		Page<Exam> page=ed.findByUserId(userId,pageable);
		return page;
	}
	public List<UserAnswer> searchUseranswerByExamid(int examid){
		return ed.findById(examid).getUseranswer();
	}
	public Exam searchByExamid(int id){
		return ed.findById(id);
	}
	/**
	 * 随机生成试卷保存
	 * @param time
	 * @param userId
	 * @param professionId
	 * @param list
	 * @return
	 */
	public Exam saveExam(String time,int userId,int professionId,List<Subject> list){
		List<UserAnswer> useranswerList=new ArrayList<UserAnswer>();
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
