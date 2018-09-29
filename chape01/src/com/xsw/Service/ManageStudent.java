package com.xsw.Service;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;
import com.xsw.dao.StudentMapper;
import com.xsw.pojo.Student;
import com.xsw.test.test;
import com.xsw.utils.MybatisUtils;

public class ManageStudent {
	
	/**
	 * 用户修改信息的方法
	 */
	
	
	test t=new test();
	
	public void update() {
		userid=list.get(0).getId();
		System.out.println("请输入你的账号");
		String usernum=in.next();
		System.out.println("请输入你的密码");
		String userpassword=in.next();
		Student stu=new Student();
		stu.setUsernum(usernum);
		stu.setUserpassword(userpassword);
		stu.setId(userid);
		System.out.println("userid的id"+userid);
		SqlSession session=MybatisUtils.getSqlsession();
	int numss=session.getMapper(StudentMapper.class).updateStudent(stu);
		if(numss>0){
			System.out.println("修改成功");
		}
		
		
	}
	int userid;
	List<Student> list;
	Scanner in=new Scanner(System.in);
	//验证登陆
	public void login(Student stu) {
		// TODO Auto-generated method stub
		SqlSession session=MybatisUtils.getSqlsession();
		list=session.getMapper(StudentMapper.class).getUserListByMap(stu);
	
		
		if(list.size()>0){
			if(list.get(0).getStatus()==0){
				System.out.println("你的管理员该续费了,赶紧发红包给肖某"+list.get(0).getUsernum()+"你可以进行增加删除操作");
				
				
				
				boolean bool=true;
				while(bool){
					System.out.println("<------------------------------------->");
					System.out.println("0添加 \t 1 删除  2查询 3退出 ");	
					int num=in.nextInt();
					if(num==0){
						this.addStu();
					}else if(num==1){
						this.testdeleteStu();
					}else if(num==2){
						this.SelectStudent();
					}else if(num==3){
						bool=false;
					}else{
						System.out.println("你特码是个傻逼吗，瞎几把乱打,这么大个字看不清");
					}
				}	
			}else{
				System.out.println("你的智商已不足,请赶紧发红包给肖某");	
				System.out.println("请输入你的修改信息");
				this.update();
			
				
			}		
		}else{
			System.out.println("登录失败");
		}
		
		
	}

	private void addStu() {
		System.out.println("请输入你的账号");
		String usernum=in.next();
		System.out.println("请输入你的密码");
		String userpassword=in.next();
		System.out.println("请输入用户类型");
		int status=in.nextInt();
		Student stu=new Student();
		stu.setStatus(status);
		stu.setUsernum(usernum);
		stu.setUserpassword(userpassword);
		
		System.out.println("*****************************************\n");
		SqlSession session=MybatisUtils.getSqlsession();
		int size=session.getMapper(StudentMapper.class).addStudent(stu);
		if(size>0){
			System.out.println("添加成功");
		}
		MybatisUtils.closeSqlSession(session);	
	}
	
	@Test
	private void testdeleteStu() {
		System.out.println("以下是用户");
		SqlSession session=MybatisUtils.getSqlsession();
		List<Student> stu=session.getMapper(StudentMapper.class).selectAllStudent();
		for(Student stus:stu){
			System.out.println(stus);
		}
		
		System.out.println("请输入你要删除的id");
		String nums=in.next();
		String ss=nums.trim().replace("", ",");
		String wc=ss.substring(1,ss.length()-1);
		Object[] obj=new Object[nums.length()];
		String [] result=wc.split(",");
		
		for(int i=0;i<result.length;i++){
			System.out.println(i);
			obj[i]=result[i];
		}
		
		
		
		
	int num=session.getMapper(StudentMapper.class).deleteStudent(obj);
	System.out.println(num);
	if(num>0){
		System.out.println("删除成功");
	}
	
	MybatisUtils.closeSqlSession(session);
	}

	private void SelectStudent() {
		
		SqlSession session=MybatisUtils.getSqlsession();
		List<Student> stu=session.getMapper(StudentMapper.class).selectAllStudent();
		for(Student stus:stu){
			System.out.println(stus);
		}
		MybatisUtils.closeSqlSession(session);
	}
	
	
	
	

}
