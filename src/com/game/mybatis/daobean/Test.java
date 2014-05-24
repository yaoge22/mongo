package com.game.mybatis.daobean;

import java.io.IOException;
import java.io.Reader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.DigestUtils;

import com.game.actions.AskGradesAction;
import com.game.actions.AskQuestionAction;
import com.game.actions.CommitKeyAction;
import com.game.mybatis.bean.Question;
import com.game.mybatis.bean.Record;
import com.game.mybatis.bean.User;
import com.game.mybatis.springdao.CommitKey;
import com.game.mybatis.springdao.GradeAsk;
import com.game.mybatis.springdao.QuestionAsk;

public class Test {
	static ApplicationContext app=new ClassPathXmlApplicationContext("applicationmybatis.xml");
	public static void main(String args[]) throws IOException, NoSuchAlgorithmException {
		Test test=new Test();
		try {
			test.testcommitkey();
			//test.testrecord();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 String user=DigestUtils.md5DigestAsHex("Y0u_a_w4ll_c0m4_0n".getBytes());
		
		System.out.println(user);
	}
	
	public void testcommitaction() {
		CommitKeyAction key=(CommitKeyAction) app.getBean("commitkeyaction");
		key.setQuestion_id("2");
		key.setQuestion_key("sharefly");
		try {
			System.out.println(key.execute());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testcommitkey() throws Exception{
	   CommitKey key=(CommitKey) app.getBean("commitkey");
	   System.out.println(key.compact_key("0:0:0:0:0:0:0:1", "1", "Y0u_a_w4ll_c0m4_0n"));
	   System.out.println("----");
	   System.out.println(key.compact_key("127.1.0.3", "1", "hellokitty"));
		
	}
	
	public void testaskgrafeaction() throws Exception {
		AskGradesAction grade=(AskGradesAction)app.getBean("askgradesaction");
		System.out.println(grade.execute());
	}
	
	public void testquestionaskaction() throws Exception {
		
		AskQuestionAction ask=	(AskQuestionAction) app.getBean("askquestionaction");
		ask.setQuestion_id("2");
		System.out.println(ask.execute());
	//	System.out.println(ask.getQuestion().getQuestion_content()+"::"+ask.getQuestion().getQuestion_key());
	}
	
	public void testgradeask() {
		GradeAsk ask=(GradeAsk) app.getBean("gradeask");
		
		
		for(User user : ask.get_grades()){
			System.out.println(user.getUser_grade()+"<"+user.getUser_ip());
		}
		
	}
	
	public void testquestionask() {
		QuestionAsk ask=(QuestionAsk) app.getBean("questionask");
		Question question=ask.get_question("2");
		if(question==null){
			System.out.println("null");
		}
	}
	
	public void testrecord() {
	
		RecordDao dao=(RecordDao) app.getBean("recorddao");
		System.out.println(dao.question_all("172.18.93.29").toString());
	/*	Record record=new Record();
		record.setUser_ip("127.0.0.1");
		record.setQuestion_id("1");
		record.setQuestion_grade("100");
		record.setCommit_time("10:10:10");
		dao.add_record(record);*/
		
		/*HashMap<String,String> map=new HashMap<String,String>();
		map.put("user_ip", "127.0.0.1");
		map.put("question_id","2");
		System.out.println(dao.exit_record(map));*/
		
	}
	
	public void testuserdao() {
		UserDao userdao=(UserDao) app.getBean("userdao");
		/*User user=new User();
		user.setUser_ip("192.168.0.1");
		user.setStart_time(new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()));
		user.setEnd_time("");
		user.setUser_grade("0");
		userdao.add_user(user);*/
		List<User> list=userdao.getUser();
		for(User user:list){
			System.out.println(user.getUser_ip()+">>"+user.getUser_grade());
		}
		
		
	}
	
	public void testspringmybatis() {
		QuestionDao questiondao=(QuestionDao) app.getBean("questiondao");
	/*	Question question=questiondao.getQuestion("1");
		System.out.println(question.getQuestion_key());*/
		System.out.println(questiondao.exit_question("3"));
		
		
	}
	
	public void testmybatis() throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis.xml");		
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(reader);
		SqlSession sqlsession=factory.openSession();
		QuestionDao dao=sqlsession.getMapper(QuestionDao.class);
		//Question question=(Question) dao.getQuestion("1");
	//	System.out.println(question.getQuestion_key());
		sqlsession.close();
	}
}
