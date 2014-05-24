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
 * �����ѯ�ɼ����
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
	 * ���崦���ѯ�ɼ�������
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
	 * ���ط�ֵ���
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
	 * 1.�ɹ�������Ϣ��sucess
	 * 2�����쳣 erorrs	 
	 * @exception sql exeption
	 * @return������ͼ
	 * 
	 */
	public String execute() throws Exception {
		List<User> user_list = gradeask.get_grades();
		List<String> trans_list=new ArrayList<String>();
		try{
			//�˴�ʹ���﷨�ǣ�����Ҫ���Ч�ʣ���չ����trans_list�û�ת����ȡ���������list���ؽ��棬�ֶ�user_ip,user_grade,user_starttime
			for(User user:user_list) {
				trans_list.add(user.getUser_ip());
				trans_list.add(user.getUser_grade()+";�����Ŀ���:"+recorddao.question_all(user.getUser_ip()).toString());
			}
			setList(trans_list);
			return SUCCESS;
		}
		catch(Exception e){
			System.out.println(e.toString());
			clearErrors();
			addFieldError("gradeerrors","����������ϵͳ�ڲ�����");
			return ERROR;
		}
		
	}
	
}
