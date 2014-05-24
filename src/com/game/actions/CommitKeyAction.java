package com.game.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.game.mybatis.springdao.CommitKey;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 用于处理用户提交key
 * @since 1.0
 * @version 2013/3/24
 * @author Administrator
 *
 */
public class CommitKeyAction extends ActionSupport{
	/**
	 * 序列化唯一标记
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * commitkey具体操作比较key类，具体比较详见此类
	 */
	private CommitKey commitkey;
	
	private String question_id;
	private String question_key;
	/**
	 * 返回答题情况
	 */
	private InputStream inputstream;
	
	
	public InputStream getInputstream() {
		return inputstream;
	}
	public void setInputstream(InputStream inputstream) {
		this.inputstream = inputstream;
	}
	public CommitKey getCommitkey() {
		return commitkey;
	}
	public void setCommitkey(CommitKey commitkey) {
		this.commitkey = commitkey;
	}
	
	public String getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(String question_id) {
		this.question_id = question_id;
	}
	public String getQuestion_key() {
		return question_key;
	}
	public void setQuestion_key(String question_key) {
		this.question_key = question_key;
	}
	/**
	 * 处理提交key操作
	 * @return 视图 ajax请求
	 * @exception sql null point exception
	 *  
	 */
	public String execute() throws Exception {
	
		String user_ip=ServletActionContext.getRequest().getRemoteAddr().trim();
		//String user_ip=user_ip="192.168.0.2";
		try{
		int bool=getCommitkey().compact_key(user_ip,getQuestion_id().trim(),getQuestion_key().trim());
		if(bool==1){
			inputstream=new ByteArrayInputStream("用户ip在不允许范围内,请使用指定ip电脑答题".getBytes("utf-8"));
		}
		if(bool==2){
			inputstream=new ByteArrayInputStream("回答问题不存在，请不要修改question_id".getBytes("utf-8"));
		}
		if(bool==3){
			inputstream=new ByteArrayInputStream("已回答正确，请不要重复答题".getBytes("utf-8"));
		}
		if(bool==4){
			inputstream=new ByteArrayInputStream("提交key不正确".getBytes("utf-8"));
		}
		if(bool==5){
			inputstream=new ByteArrayInputStream("回答正确".getBytes("utf-8"));
		}
		
		
		return SUCCESS;
		}
		catch(Exception e) {
			clearMessages();
			addActionMessage("提交key，系统出错");
			
			return ERROR;
		}
		
		
	}
	
	
}










