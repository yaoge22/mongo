package com.game.mybatis.bean;


/**
 * ����question�־û�����
 * @author Administrator
 * @version 2014/3/23 
 * @since 1.0
 * 
 */
public class Question {
	
	/**
	 * quesion_id ����id
	 * question_key ����key
	 * question_content ��������
	 * question_grade �����ֵ
	 * ����Ϊ���Զ����Լ�set,get����,����question_idΪ��
	 */
	private String question_id ;
	private String question_key ;
	private String question_content ;
	private String question_grade;
	
	/** 
	 * ��ȡ����id
	 * @return string
	 * @exception no
	 */
	
	public String getQuesion_id() {
		return question_id;
	}
	
	/**
	 * ��������    --->��ֹ�˲�������ʱ�����ݿ�¼��
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
