package com.hyh.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

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
			Administrators createAdmin
			,String groupName
			,int[] subjectId
			,int[] grade
			,String createTime
			,int limitedTime
			,int professionId){
		SubjectGroup group=new SubjectGroup();
		for(int i=0;i<subjectId.length;i++){
			Subject subject=sd.findById(subjectId[i]);
			group.addSubject(subject);
		}
		int totalgrade=0;
		for(int i=0;i<grade.length;i++){
			totalgrade+=grade[i];
		}
		group.setName(groupName);
		group.setSinglegrade(grade);
		group.setCreateAdmin(createAdmin);
		group.setCreateTime(createTime);
		group.setProfessionId(professionId);
		group.setTotalgrade(totalgrade);
		group.setLimitedTime(limitedTime);
		sgd.save(group);
		return "1";
	}
}
