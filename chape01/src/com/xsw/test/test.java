package com.xsw.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.xsw.dao.StudentMapper;
import com.xsw.pojo.Student;
import com.xsw.utils.MybatisUtils;

public class test {

	
	@Test
	public void testGetStu2(){
		SqlSession session=MybatisUtils.getSqlsession();
		try{
		List<Student>	student=session.selectList("student.selectOne");
		
		//用foreach遍历
		for(Student stu:student){
			System.out.println(stu);
		}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		MybatisUtils.closeSqlSession(session);	
		}
		
		
		
	}
	
	/*@Test*/
	/*public void testStudentMapper(){
		SqlSession session=MybatisUtils.getSqlsession();
		try{
			Student stu=new Student();
			stu.setGender('1');
			stu.setStuName("逼神");
			int s=session.getMapper(StudentMapper.class).addStudent(stu);
			
			
		}catch(Exception e){
			e.printStackTrace();
			
			
		}finally{
			MybatisUtils.closeSqlSession(session);
		}
		
		
		
	}
	
	@Test
	public void testSelect(){
		//获取mybatis-config.xml inputStream对象
		InputStream is=null;
	
	//	is=test.class.getClassLoader().getResourceAsStream("mybatus-config.xml");
	try {
		is=Resources.getResourceAsStream("mybatis-config.xml");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		SqlSessionFactory session=new SqlSessionFactoryBuilder().build(is);
		SqlSession se=session.openSession(true);
		List<Student>	student=se.selectList("student.selectOne");

		//用foreach遍历
		for(Student stu:student){
			System.out.println(stu);
		}
		
		
	}*/
	
	
	
}
