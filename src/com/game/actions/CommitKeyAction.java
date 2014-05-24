package com.game.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.game.mybatis.springdao.CommitKey;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * ���ڴ����û��ύkey
 * @since 1.0
 * @version 2013/3/24
 * @author Administrator
 *
 */
public class CommitKeyAction extends ActionSupport{
	/**
	 * ���л�Ψһ���
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * commitkey��������Ƚ�key�࣬����Ƚ��������
	 */
	private CommitKey commitkey;
	
	private String question_id;
	private String question_key;
	/**
	 * ���ش������
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
	 * �����ύkey����
	 * @return ��ͼ ajax����
	 * @exception sql null point exception
	 *  
	 */
	public String execute() throws Exception {
	
		String user_ip=ServletActionContext.getRequest().getRemoteAddr().trim();
		//String user_ip=user_ip="192.168.0.2";
		try{
		int bool=getCommitkey().compact_key(user_ip,getQuestion_id().trim(),getQuestion_key().trim());
		if(bool==1){
			inputstream=new ByteArrayInputStream("�û�ip�ڲ�����Χ��,��ʹ��ָ��ip���Դ���".getBytes("utf-8"));
		}
		if(bool==2){
			inputstream=new ByteArrayInputStream("�ش����ⲻ���ڣ��벻Ҫ�޸�question_id".getBytes("utf-8"));
		}
		if(bool==3){
			inputstream=new ByteArrayInputStream("�ѻش���ȷ���벻Ҫ�ظ�����".getBytes("utf-8"));
		}
		if(bool==4){
			inputstream=new ByteArrayInputStream("�ύkey����ȷ".getBytes("utf-8"));
		}
		if(bool==5){
			inputstream=new ByteArrayInputStream("�ش���ȷ".getBytes("utf-8"));
		}
		
		
		return SUCCESS;
		}
		catch(Exception e) {
			clearMessages();
			addActionMessage("�ύkey��ϵͳ����");
			
			return ERROR;
		}
		
		
	}
	
	
}










