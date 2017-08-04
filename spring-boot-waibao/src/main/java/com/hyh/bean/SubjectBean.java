package com.hyh.bean;

import java.util.List;

public class SubjectBean {
	private String content;
	//题目类型（选择、填空、判断）
	private String type;
	//题目正确答案
	private String []realAnswer;
	//注释
	private String tip;
	//职业ID
	private Integer professionId;
	//选项
	private List<SubjectOptionsBean> options;

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

	public int getProfessionId() {
		return professionId;
	}

	public void setProfessionId(int professionId) {
		this.professionId = professionId;
	}

	public String[] getRealAnswer() {
		return realAnswer;
	}

	public void setRealAnswer(String[] realAnswer) {
		this.realAnswer = realAnswer;
	}

	public void setProfessionId(Integer professionId) {
		this.professionId = professionId;
	}

	public List<SubjectOptionsBean> getOptions() {
		return options;
	}

	public void setOptions(List<SubjectOptionsBean> options) {
		this.options = options;
	}
	
	
	
}
