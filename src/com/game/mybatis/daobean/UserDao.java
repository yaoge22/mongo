package com.game.mybatis.daobean;

import java.util.HashMap;
import java.util.List;

import com.game.mybatis.bean.User;

/**
 * 用户ip获取操作，获取得分情况
 * 1.验证用户是否存在
 * 2.添加用户，初始化分数为0
 * 3.添加分数
 * 4.获取得分情况
 * @author Administrator
 * @version 2014/3/23
 * @since 1.0
 */

public interface UserDao {
	/**
	 * 判断用户是否存在
	 * @exception mybatis sql exception
	 * @param user_ip 用户ip
	 * @return User 
	 */
	public User exit_user(String user_ip);
	/**
	 * 添加用户对象
	 * @exception mybatis sql exception
	 * @param usermap 对象信息
	 * 
	 */
	public void add_user(User user);
	
	/**
	 * 更改用户得分
	 * @param usergrade 用户ip，题目分值,user_ip,user_grade
	 * 
	 * @exception mybatis sql exception
	 */
	public void add_grade(HashMap<String,String> usergrade);
	
	/**
	 * 返回得分情况
	 * @exception mybatis sql exception
	 * @return 返回所有用户分值信息
	 */
	public List<User> getUser() ;
}







