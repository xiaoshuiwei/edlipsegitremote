package com.xsw.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {
private static SqlSessionFactory factory;
	
	static{
	

		try {
			InputStream is=Resources.getResourceAsStream("mybatis-config.xml");
		factory=new SqlSessionFactoryBuilder().build(is);
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	/**
	 * 获取SqlSession执行对象
	 */
	
	public static SqlSession getSqlsession(){
		
		return factory.openSession(true);
		
	}
	
	/**
	 * 关闭
	 */
	
	public static void closeSqlSession(SqlSession session){
		if(session!=null){
			session.close();
		}
		
	}
	
}
