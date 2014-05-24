package com.game.mybatis.daobean;

import com.game.mybatis.bean.Question;

/**
 * 对于题目的操作类
 * 主要功能为：
 * 1.题目的请求 getQuestion
 * 2.核实此id题目是否存在 exit_Question
 * 3.比较此问题id的key是否正确
 * 
 * 1,2,3重复,本质上是可以重复利用缓存实现，但是2,3可为以后扩展留用，可能会添加其他功能或验证步骤，但总体可以使用1来实现全部功能
 * @author Administrator
 * @since 1.0
 * @version 2014/3/23
 */

public interface QuestionDao {
	
	/**
	 * 响应请求题目
	 * @param question_id
	 * @return 问题对象，以便在页面显示
	 * @exception  mybatis sqlexception
	 */
	public Question getQuestion (String question_id) ;
	
	/**
	 * 判断问题是否存在
	 * @exception mybatis sqlexception
	 * @param question_id
	 * @return boolean 类型正误是否含有记录,若有，则为true，反之为null
	 */
	public Boolean exit_question (String question_id) ;
	
	/**
	 * 判断提交可以key是否正确
	 * @exception mybatis sqlexception
	 * @param key
	 * @return Boolean 类型正误 有无记录
	 */
	public Boolean compact_key (String question_id) ;
	
}







