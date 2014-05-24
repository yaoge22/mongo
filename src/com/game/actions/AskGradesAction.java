package com.game.actions;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.game.mybatis.bean.User;
import com.game.mybatis.daobean.RecordDao;
import com.game.mybatis.springdao.GradeAsk;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 处理查询成绩情况
 * @version 2014/3/24
 * @since 1.0
 * @author Administrator
 *
 */
public class AskGradesAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * ajax
	 * 具体处理查询成绩操作类
	 */
	private GradeAsk gradeask;
	private RecordDao recorddao;
	public RecordDao getRecorddao() {
		return recorddao;
	}
	public void setRecorddao(RecordDao recorddao) {
		this.recorddao = recorddao;
	}
	/**
	 * 返回分值情况
	 */
	private List<String> list;
	
	
	public List<String> getList() {
		return list;
	}
	@JSON(name="list")
	public void setList(List<String> list) {
		this.list = list;
	}

	public GradeAsk getGradeask() {
		return gradeask;
	}

	public void setGradeask(GradeAsk gradeask) {
		this.gradeask = gradeask;
	}
	/**
	 * 1.成功返回信息，sucess
	 * 2错误异常 erorrs	 
	 * @exception sql exeption
	 * @return返回视图
	 * 
	 */
	public String execute() throws Exception {
		List<User> user_list = gradeask.get_grades();
		List<String> trans_list=new ArrayList<String>();
		try{
			//此处使用语法糖，如需要提高效率，可展开，trans_list用户转换获取结果集，已list返回界面，字段user_ip,user_grade,user_starttime
			for(User user:user_list) {
				trans_list.add(user.getUser_ip());
				trans_list.add(user.getUser_grade()+";答对题目标号:"+recorddao.question_all(user.getUser_ip()).toString());
			}
			setList(trans_list);
			return SUCCESS;
		}
		catch(Exception e){
			System.out.println(e.toString());
			clearErrors();
			addFieldError("gradeerrors","请求积分情况系统内部错误");
			return ERROR;
		}
		
	}
	
}
