package com.game.mybatis.daobean;

import java.util.HashMap;
import java.util.List;

import com.game.mybatis.bean.Record;

/**
 * 对于答题的操作类
 * 主要功能为：
 * 1.记录已答题情况
 * 2.验证此题是否已答
 * @author Administrator
 * @since 1.0
 * @version 2014/3/23
 */


public interface RecordDao {
	
	/**
	 * @exception mybatis sql exception
	 * @param record 记录情况
	 * @return 验证添加情况
	 */
	public boolean add_record(Record record);
	
	/**
	 * 
	 * @param map user_ip,question_id
	 * @return 反馈记录是否存在的情况，避免重复添加分数
	 * @exception mybatis sql exception
	 */
	public Record exit_record(HashMap<String,String> map);
	/**
	 * 统计，某个用户的答题情况
	 */
	
	public List<String> question_all(String user_ip);
	
}
