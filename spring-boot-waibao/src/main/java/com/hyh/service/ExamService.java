package com.hyh.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.crsh.console.jline.internal.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
	@Resource
	AspectService aspect;
	
	public final ObjectMapper mapper = new ObjectMapper(); 
	
	/**
	 * 批改题目
	 * @param examId
	 * @param time
	 * @param list
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public int CorrectSubjects(int examId,String time,List<SubjectC> list) throws JsonParseException, JsonMappingException, IOException{
		int totalgrade=0;
		Exam exam=ed.findById(examId);
		int []singlegrade=exam.getSinglegrade();
		for(int i=0;i<list.size();i++){
			SubjectC sc=list.get(i);
			UserAnswer useranswer=exam.getUseranswer().get(i);
			Subject subject=useranswer.getSubject();
			//JavaType javaType=mapper.getTypeFactory().constructParametricType(ArrayList.class, String.class);
			String[] userAnswer=sc.getAnswer().split("");
			String[] realAnswer=subject.getRealAnswer();
			char status=0;
			if(subject.getType().equals("单选题")|subject.getType().equals("多选题")){
				if(userAnswer.length==realAnswer.length){
					int pass=0;
					for(int h=0;h<realAnswer.length;h++){
						if(realAnswer[h].equals(userAnswer[h])){
							pass=1;
						}else{
							pass=0;
							break;
						}
					}
					if(pass==1){
						//totalgrade+=singlegrade[i];
						status=1;
						Log.warn(i+"题对了");
					}else{
						status=0;
						Log.warn(i+"题错了");
					}
				}else if(userAnswer.length<realAnswer.length){
					boolean pass=false;
					for(int h=0;h<userAnswer.length;h++){

						if(userAnswer[h].equals(realAnswer[h])){
							pass=true;
						}else{
							pass=false;
							break;
						}
					}
					if(pass){
						status=2;
						Log.warn(i+"题半对");
						//totalgrade+=singlegrade[i]/2;
					}else{
						Log.warn(i+"题错了");
					}
				}else{
					status=0;
					Log.warn(i+"题错了");
				}
			}else if(subject.getType().equals("填空题")){
				if(subject.getRealAnswer().equals(userAnswer)){
					totalgrade+=singlegrade[i];
					status=1;
				}else{
					status=0;
				}
			}
			useranswer.setAnswer(userAnswer);
			useranswer.setStatus(status);
			ad.save(useranswer);
		}
		exam.setUsergrade(totalgrade);
		ed.save(exam);
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

		exam.setUserId(userId);
		exam.setSinglegrade(subjectgroup.getSinglegrade());
		exam.setProfessionId(subjectgroup.getProfessionId());
		exam.setTime(time);
		exam.setTotalgrade(subjectgroup.getTotalgrade());
		exam=ed.save(exam);
		Iterator<Subject> iterator=set.iterator();
		while(iterator.hasNext()){
			Subject subject=iterator.next();
			UserAnswer useranswer=new UserAnswer();
			useranswer.setSubject(subject);
			useranswer.setUserId(userId);
			useranswer.setExamId(exam);
			ad.save(useranswer);
		}
		return exam;
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
