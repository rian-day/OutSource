package com.hyh.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hyh.entity.Profession;
import com.hyh.repository.ProfessionDao;

@Service
public class ProfessionService {
	@Resource
	ProfessionDao pd;
	public List<Profession> searchAll(){
		List<Profession> list=pd.findAll();
		return list;
	}
}
