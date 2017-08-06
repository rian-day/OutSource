package com.hyh.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hyh.bean.SubjectGroupBean;
import com.hyh.entity.Administrators;
import com.hyh.entity.Subject;
import com.hyh.entity.SubjectGroup;
import com.hyh.repository.SubjectDao;
import com.hyh.repository.SubjectGroupDao;

@Service
public class SubjectGroupService {
	@Resource
	SubjectGroupDao sgd;
	@Resource
	SubjectDao sd;
	
	public String createGroup(
			SubjectGroupBean sgb
			,Administrators createAdmin
			,String time
			,Integer[] subjectId
			,Integer[] grade
			){
		String groupName=sgb.getGroupName();
		int professionId=sgb.getProfessionId();
		int limitedTime=sgb.getLimitedTime();
		int level=sgb.getLevel();
		SubjectGroup group=new SubjectGroup();
		for(int i=0;i<subjectId.length;i++){
			Subject subject=sd.findById(subjectId[i]);
			group.addSubject(subject);
		}
		int totalgrade=0;
		for(int i=0;i<grade.length;i++){
			totalgrade+=grade[i];
		}
		int[] grade2=new int[grade.length];
		for(int i=0;i<grade.length;i++){
			grade2[i]=grade[i];
		}
		group.setName(groupName);
		group.setSinglegrade(grade2);
		group.setCreateAdmin(createAdmin);
		group.setCreateTime(time);
		group.setProfessionId(professionId);
		group.setTotalgrade(totalgrade);
		group.setLimitedTime(limitedTime);
		group.setLevel(level);
		sgd.save(group);
		return "1";
	}
}
