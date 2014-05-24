package com.game.actions;

import com.game.mybatis.bean.Question;
import com.game.mybatis.springdao.QuestionAsk;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * �������������action
 * 
 * @author Administrator
 * @version 2014/3/24
 * @sicne 1.0
 */
public class AskQuestionAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ����question_id
	 */

	private String question_id;
	/**
	 * ����spring dao����
	 */
	private QuestionAsk questionask;
	public Question question;

	
	public QuestionAsk getQuestionask() {
		return questionask;
	}

	public void setQuestionask(QuestionAsk questionask) {
		this.questionask = questionask;
	}

	public String getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(String question_id) {
		this.question_id = question_id;
	}

	/**
	 * ��������question
	 * 
	 */
	public String execute() throws Exception {
		Question resourcequestion = questionask.get_question(getQuestion_id().trim());
		try {
			if (resourcequestion == null) {// ���޶����û��Ƿ�����
				clearFieldErrors();
				addFieldError("questionaskbug", "����������������Ŀ���"
						+ getQuestion_id());
				return INPUT;
			} else {
				question=new Question();
				question.setQuesion_id(resourcequestion.getQuesion_id());
				question.setQuestion_content(resourcequestion.getQuestion_content());
				question.setQuestion_grade(resourcequestion.getQuestion_grade());
				
				question.setQuestion_key(null);
				return SUCCESS;
			}
		} catch (Exception e) {
			//clearFieldErrors();
			clearActionErrors();
			addActionError("����ϵͳ�쳣");
			//addFieldError("questionaskerror", );
			return ERROR;
		}

	}
}
