package com.game.mybatis.bean;


/**
 * 构造答题情况持久化对象
 * @author Administrator
 * @version 2014/3/23 
 * @since 1.0
 * 
 */

public class Record {
	/**
	 * amount 答题数量编号
	 * user_ip 用户ip
	 * quesion_id 问题id
	 * question_grade 问题分值
	 * commit_time 提交时间
	 * 以下为属性定义以及set,get操作,并以question_id为例
	 */
	
	private String amount ;
	private String user_ip ;
	private String question_id ;
	private String question_grade ;
	private String commit_time ;
	
	
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getUser_ip() {
		return user_ip;
	}
	public void setUser_ip(String user_ip) {
		this.user_ip = user_ip;
	}
	public String getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(String question_id) {
		this.question_id = question_id;
	}
	public String getQuestion_grade() {
		return question_grade;
	}
	public void setQuestion_grade(String question_grade) {
		this.question_grade = question_grade;
	}
	public String getCommit_time() {
		return commit_time;
	}
	public void setCommit_time(String commit_time) {
		this.commit_time = commit_time;
	}
	
	
	
}
