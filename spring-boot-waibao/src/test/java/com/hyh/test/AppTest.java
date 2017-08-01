package com.hyh.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hyh.entity.Subject;
import com.hyh.repository.SubjectDao;
import com.hyh.service.SubjectService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {
	@Resource
	SubjectService subjectservice;
	@Resource
	SubjectDao sd;
	
	@Test
	public void MyTest(){
		Subject subject=new Subject();
		String []answer={"hyh1","hyh2"};
		subject.setRealAnswer(answer);
		subject=sd.save(subject);
		System.out.println(subject.getRealAnswer());
		for(String x:subject.getRealAnswer()){
			System.out.println(x);
		}
	}
}
