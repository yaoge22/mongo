package com.game.mybatis.springdao;

import java.util.List;

import com.game.mybatis.bean.User;
import com.game.mybatis.daobean.UserDao;


/**
 * 公共类，不含验证，统一查询
 * 返回比赛成绩查询情况
 * @version 2014/3/24
 * @since 1.0
 * @author Administrator
 *
 */
public class GradeAsk {
	private UserDao userdao;
	
	
	public UserDao getUserdao() {
		return userdao;
	}


	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}


	/**
	 * 返回比赛成绩
	 * @return List<String>
	 * @exception myabtis sql exception 
	 */
	public List<User> get_grades() {
		return userdao.getUser();
	}
	
}
