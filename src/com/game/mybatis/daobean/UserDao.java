package com.game.mybatis.daobean;

import java.util.HashMap;
import java.util.List;

import com.game.mybatis.bean.User;

/**
 * �û�ip��ȡ��������ȡ�÷����
 * 1.��֤�û��Ƿ����
 * 2.����û�����ʼ������Ϊ0
 * 3.��ӷ���
 * 4.��ȡ�÷����
 * @author Administrator
 * @version 2014/3/23
 * @since 1.0
 */

public interface UserDao {
	/**
	 * �ж��û��Ƿ����
	 * @exception mybatis sql exception
	 * @param user_ip �û�ip
	 * @return User 
	 */
	public User exit_user(String user_ip);
	/**
	 * ����û�����
	 * @exception mybatis sql exception
	 * @param usermap ������Ϣ
	 * 
	 */
	public void add_user(User user);
	
	/**
	 * �����û��÷�
	 * @param usergrade �û�ip����Ŀ��ֵ,user_ip,user_grade
	 * 
	 * @exception mybatis sql exception
	 */
	public void add_grade(HashMap<String,String> usergrade);
	
	/**
	 * ���ص÷����
	 * @exception mybatis sql exception
	 * @return ���������û���ֵ��Ϣ
	 */
	public List<User> getUser() ;
}







