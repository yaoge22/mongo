package com.game.mybatis.bean;

/**
 * ����user�־û�����
 * @author Administrator
 * @since 1.0
 * @version 2014/3/23 
 */
public class User {
	/**
	 * user_ip �û�ip
	 * user_grade �û��ܵ÷�
	 * start_time �û����ε�½ʱ��
	 * end_time �û�����ʱ��
	 * ����Ϊ���Զ����Լ�set,get����,����user_ipΪ��
	 */
	private String user_ip;
	private String user_grade;
	private String start_time;
	private String end_time;
	
	/**
	 * 
	 * @return string
	 * @exception no
	 * ��ȡip
	 */
	
	public String getUser_ip() {
		return user_ip;
	}
	
	/**
	 * 
	 * @param user_ip ����ֲ��
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
