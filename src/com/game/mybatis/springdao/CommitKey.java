package com.game.mybatis.springdao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import org.springframework.util.DigestUtils;

import com.game.mybatis.bean.Question;
import com.game.mybatis.bean.Record;
import com.game.mybatis.bean.User;
import com.game.mybatis.daobean.QuestionDao;
import com.game.mybatis.daobean.RecordDao;
import com.game.mybatis.daobean.UserDao;

/**
 * ������ �����û��ύkey�������ӷ�
 * 
 * ������ 1.����û�ip 2.��֤��Ŀ�Ƿ���� 3.��֤��Ŀ�Ƿ��Ѵ� 4.�Ƚ�key 5.���뵽record 6.�����û���ֵ ���õ��Ĳ���
 * userdao 1,6 questiondao 2,4 recorddao 3,5
 * 
 * @version 2014/3/24
 * @since 1.0
 * @author Administrator
 * 
 */
public class CommitKey {

	private UserDao userdao;
	private QuestionDao questiondao;
	private RecordDao recorddao;

	public UserDao getUserdao() {
		return userdao;
	}

	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}

	public QuestionDao getQuestiondao() {
		return questiondao;
	}

	public void setQuestiondao(QuestionDao questiondao) {
		this.questiondao = questiondao;
	}

	public RecordDao getRecorddao() {
		return recorddao;
	}

	public void setRecorddao(RecordDao recorddao) {
		this.recorddao = recorddao;
	}

	/**
	 * �Ƚ�key
	 * 
	 * @param question_id
	 * @param question_key
	 * @return ����boolean key�Ƚϣ�6�����������һ��ע����ν�Ժ���չ
	 * @throws NoSuchAlgorithmException
	 */

	public synchronized int compact_key(String user_ip, String question_id,
			String question_key) throws NoSuchAlgorithmException {
		//�ж��û����Ƿ����
		
		
		// @1.����û�ip,�������޲���
		User user = userdao.exit_user(user_ip);
		
		if (user == null) {
			/*user = new User();
			user.setUser_ip(user_ip);
			user.setUser_grade("0");
			user.setStart_time(new SimpleDateFormat("HH:mm:ss").format(Calendar
					.getInstance().getTime()));
			user.setEnd_time("00:00:00");
			userdao.add_user(user);*/
			return 1;
		} else {
			
		
		Question question = questiondao.getQuestion(question_id.trim());
		// �ж������Ƿ���ڣ���������ȡ������ //@2
		if (question == null) {
			System.out.println("last not");
			return 2;
		} else {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("user_ip", user_ip);
			map.put("question_id", question_id.trim());
			// @3
			Record record_exit = recorddao.exit_record(map);
			if (record_exit != null) {
				// �Ѵ��ڣ�˵���ظ�����
				System.out.println("last have bean" );
				return 3;
			} else {// @4
				/*
				 * MessageDigest message=MessageDigest.getInstance("MD5");
				 * message.update(question_key.getBytes()); new
				 * String(message.digest());
				 */
				question_key = DigestUtils.md5DigestAsHex(question_key
						.getBytes());
				if (question.getQuestion_key().equals(question_key) == false) {
					// key����
					System.out.println("last key");
					return 4;
				} else {
					// @5
					Record record = new Record();
					record.setUser_ip(user_ip);
					record.setQuestion_id(question.getQuesion_id());
					record.setQuestion_grade(question.getQuestion_grade());
					record.setCommit_time(new SimpleDateFormat("HH:mm:ss")
							.format(Calendar.getInstance().getTime()));
					recorddao.add_record(record);
					// @6
					// ���ķ�ֵ
					HashMap<String, String> mapgrade = new HashMap<String, String>();

					mapgrade.put("user_ip", user_ip);
					mapgrade.put("start_time", new SimpleDateFormat("HH:mm:ss")
							.format(Calendar.getInstance().getTime()));
					int grade = Integer.parseInt(user.getUser_grade())
							+ Integer.parseInt(question.getQuestion_grade());
					mapgrade.put("user_grade", Integer.toString(grade));
					userdao.add_grade(mapgrade);
					System.out.println("last");
					return 5;
				}

			}
		}
		}
	
	}

}
