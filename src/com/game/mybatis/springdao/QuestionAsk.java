package com.game.mybatis.springdao;

import com.game.mybatis.bean.Question;
import com.game.mybatis.daobean.QuestionDao;


/**
 * 公共类，不含验证，统一查询
 * 业务处理控制器
 * 接受问题请求，返回题目详情，直接从缓存中取出，若无再调用sql语句请求，在action里面验证题目序号是否存在
 * @author Administrator
 * @since 1.0
 * @version 2014/3/24
 * 
 */
public class QuestionAsk {
	/**
	 * 注入操作questiondao操作类，具体负责sql交互层
	 */
	private QuestionDao questiondao;
	
	
	public QuestionDao getQuestiondao() {
		return questiondao;
	}


	public void setQuestiondao(QuestionDao questiondao) {
		this.questiondao = questiondao;
	}

	/**
	 * 返回请求问题
	 * @exception mybatis sql exception
	 * @return 问题对象，返回到action时，不要返回整个对象，只需要question_id，question_content，question_grade
	 * @param String question_id根据问题ID获取
	 */
	public Question get_question(String question_id) {
		return questiondao.getQuestion(question_id);
	}
	
	
	
}














