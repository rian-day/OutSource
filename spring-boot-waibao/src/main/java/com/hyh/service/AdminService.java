package com.hyh.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hyh.bean.RandomSubjectBean;
import com.hyh.entity.Administrators;
import com.hyh.entity.Message;
import com.hyh.entity.RandomSubject;
import com.hyh.entity.RequestAdmin;
import com.hyh.repository.AdministratorsDao;
import com.hyh.repository.MessageDao;
import com.hyh.repository.RandomSubjectDao;
import com.hyh.repository.RequestAdminDao;
@Service
public class AdminService {
	@Resource
	AdministratorsDao ad;
	@Resource
	RandomSubjectDao rsd;
	@Resource
	MessageDao md;
	@Resource
	RequestAdminDao rad;
	//获取申请信息
	public List<RequestAdmin> getAllRequest(){
		return rad.findByCorrect('0');
	}
	//消息推送
	public String saveMessage(String content){
		Message msg=new Message();
		msg.setContent(content);
		md.save(msg);
		return "1";
	}
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
