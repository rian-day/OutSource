package com.hyh.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hyh.bean.RandomSubjectBean;
import com.hyh.entity.Administrators;
import com.hyh.entity.RandomSubject;
import com.hyh.repository.AdministratorsDao;
import com.hyh.repository.RandomSubjectDao;
@Service
public class AdminService {
	@Resource
	AdministratorsDao ad;
	@Resource
	RandomSubjectDao rsd;
	
	//修改按键顺序
	public String changeIndexList(char[] index ,int id){
		Administrators admin=ad.findById(id);
		admin.setIndexOrder(index);
		admin=ad.save(admin);
		return "1";
	}
	
	//管理员界面按键顺序
	public char[] getAdminPage(int id){
		return ad.findById(id).getIndexOrder();
	}
	public Administrators searchById(int id){
		return ad.findById(id);
	}
	
	public String editAndminInfo(int adminId,String name,char sex){
		Administrators admin=ad.findById(adminId);
		admin.setName(name);
		admin.setSex(sex);
		ad.save(admin);
		return "1";
	}
	public String updateRandomSubject(RandomSubjectBean rsb){
		for(int i=0;i<rsb.getMark().length;i++){
			List<RandomSubject> result=rsd.findByProfessionIdAndType(rsb.getProfessionId(), rsb.getType()[i]);
			if(result.size()==0){
				RandomSubject random=new RandomSubject();
				random.setGrade(rsb.getMark()[i]);
				random.setNum(rsb.getNum()[i]);
				random.setProfessionId(rsb.getProfessionId());
				random.setType(rsb.getType()[i]);
			}else{
				RandomSubject random=result.get(0);
				random.setGrade(rsb.getMark()[i]);
				random.setNum(rsb.getNum()[i]);
			}
		}
		return "1";
		
	}
}
