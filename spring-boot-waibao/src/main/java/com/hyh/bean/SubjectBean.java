package com.hyh.bean;

public class SubjectBean {
	
	private String content;
	//题目类型（选择、填空、判断）
	private String type;
	//题目正确答案
	//private String []realAnswer;
	//注释
	private String tip;
	
	//职业ID
	private Integer professionId;
	//选项
	//private ArrayList<SubjectOptionsBean> options;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public Integer getProfessionId() {
		return professionId;
	}
	public void setProfessionId(Integer professionId) {
		this.professionId = professionId;
	}


	
	
	
	
}
