package com.game.mybatis.daobean;

import com.game.mybatis.bean.Question;

/**
 * ������Ŀ�Ĳ�����
 * ��Ҫ����Ϊ��
 * 1.��Ŀ������ getQuestion
 * 2.��ʵ��id��Ŀ�Ƿ���� exit_Question
 * 3.�Ƚϴ�����id��key�Ƿ���ȷ
 * 
 * 1,2,3�ظ�,�������ǿ����ظ����û���ʵ�֣�����2,3��Ϊ�Ժ���չ���ã����ܻ�����������ܻ���֤���裬���������ʹ��1��ʵ��ȫ������
 * @author Administrator
 * @since 1.0
 * @version 2014/3/23
 */

public interface QuestionDao {
	
	/**
	 * ��Ӧ������Ŀ
	 * @param question_id
	 * @return ��������Ա���ҳ����ʾ
	 * @exception  mybatis sqlexception
	 */
	public Question getQuestion (String question_id) ;
	
	/**
	 * �ж������Ƿ����
	 * @exception mybatis sqlexception
	 * @param question_id
	 * @return boolean ���������Ƿ��м�¼,���У���Ϊtrue����֮Ϊnull
	 */
	public Boolean exit_question (String question_id) ;
	
	/**
	 * �ж��ύ����key�Ƿ���ȷ
	 * @exception mybatis sqlexception
	 * @param key
	 * @return Boolean �������� ���޼�¼
	 */
	public Boolean compact_key (String question_id) ;
	
}







