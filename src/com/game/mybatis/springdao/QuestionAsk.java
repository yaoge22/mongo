package com.game.mybatis.springdao;

import com.game.mybatis.bean.Question;
import com.game.mybatis.daobean.QuestionDao;


/**
 * �����࣬������֤��ͳһ��ѯ
 * ҵ���������
 * �����������󣬷�����Ŀ���飬ֱ�Ӵӻ�����ȡ���������ٵ���sql���������action������֤��Ŀ����Ƿ����
 * @author Administrator
 * @since 1.0
 * @version 2014/3/24
 * 
 */
public class QuestionAsk {
	/**
	 * ע�����questiondao�����࣬���帺��sql������
	 */
	private QuestionDao questiondao;
	
	
	public QuestionDao getQuestiondao() {
		return questiondao;
	}


	public void setQuestiondao(QuestionDao questiondao) {
		this.questiondao = questiondao;
	}

	/**
	 * ������������
	 * @exception mybatis sql exception
	 * @return ������󣬷��ص�actionʱ����Ҫ������������ֻ��Ҫquestion_id��question_content��question_grade
	 * @param String question_id��������ID��ȡ
	 */
	public Question get_question(String question_id) {
		return questiondao.getQuestion(question_id);
	}
	
	
	
}














