package com.game.mybatis.bean;

/**
 * 构造user持久化对象
 * @author Administrator
 * @since 1.0
 * @version 2014/3/23 
 */
public class User {
	/**
	 * user_ip 用户ip
	 * user_grade 用户总得分
	 * start_time 用户初次登陆时间
	 * end_time 用户结束时间
	 * 以下为属性定义以及set,get操作,并以user_ip为例
	 */
	private String user_ip;
	private String user_grade;
	private String start_time;
	private String end_time;
	
	/**
	 * 
	 * @return string
	 * @exception no
	 * 获取ip
	 */
	
	public String getUser_ip() {
		return user_ip;
	}
	
	/**
	 * 
	 * @param user_ip 参数植入
	 * @return no
	 */
	
	public void setUser_ip(String user_ip) {
		this.user_ip = user_ip;
	}
	public String getUser_grade() {
		return user_grade;
	}
	public void setUser_grade(String user_grade) {
		this.user_grade = user_grade;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	
}
