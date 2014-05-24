package com.game.mybatis.daobean;

import java.util.HashMap;
import java.util.List;

import com.game.mybatis.bean.Record;

/**
 * ���ڴ���Ĳ�����
 * ��Ҫ����Ϊ��
 * 1.��¼�Ѵ������
 * 2.��֤�����Ƿ��Ѵ�
 * @author Administrator
 * @since 1.0
 * @version 2014/3/23
 */


public interface RecordDao {
	
	/**
	 * @exception mybatis sql exception
	 * @param record ��¼���
	 * @return ��֤������
	 */
	public boolean add_record(Record record);
	
	/**
	 * 
	 * @param map user_ip,question_id
	 * @return ������¼�Ƿ���ڵ�����������ظ���ӷ���
	 * @exception mybatis sql exception
	 */
	public Record exit_record(HashMap<String,String> map);
	/**
	 * ͳ�ƣ�ĳ���û��Ĵ������
	 */
	
	public List<String> question_all(String user_ip);
	
}
