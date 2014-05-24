package com.game.mybatis.bean;


/**
 * 构造question持久化对象
 * @author Administrator
 * @version 2014/3/23 
 * @since 1.0
 * 
 */
public class Question {
	
	/**
	 * quesion_id 问题id
	 * question_key 问题key
	 * question_content 问题描叙
	 * question_grade 问题分值
	 * 以下为属性定义以及set,get操作,并以question_id为例
	 */
	private String question_id ;
	private String question_key ;
	private String question_content ;
	private String question_grade;
	
	/** 
	 * 获取问题id
	 * @return string
	 * @exception no
	 */
	
	public String getQuesion_id() {
		return question_id;
	}
	
	/**
	 * 设置问题    --->禁止此操作，暂时由数据库录入
	 * @exception  no
	 * @param quesion_id
	 */
	
	public void setQuesion_id(String quesion_id) {
		this.question_id = quesion_id;
	}
	public String getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(String question_id) {
		this.question_id = question_id;
	}

	public String getQuestion_key() {
		return question_key;
	}
	public void setQuestion_key(String question_key) {
		this.question_key = question_key;
	}
	public String getQuestion_content() {
		return question_content;
	}
	public void setQuestion_content(String question_content) {
		this.question_content = question_content;
	}
	
	public String getQuestion_grade() {
		return question_grade;
	}

	public void setQuestion_grade(String question_grade) {
		this.question_grade = question_grade;
	}
	
	
	
}
