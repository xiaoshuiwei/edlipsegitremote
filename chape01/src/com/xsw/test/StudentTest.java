package com.xsw.test;

import java.util.Scanner;

import com.xsw.Service.ManageStudent;
import com.xsw.pojo.Student;

public class StudentTest {

	public static void main(String[] args) {
		System.out.println("请选择登录类型 0,管理员登录,1用户登录");
		System.out.println("-------------------------------\n\n");
		
		Scanner in=new Scanner(System.in);
		int num=in.nextInt();
		System.out.println("请输入你的账号");
		String usernum=in.next();
		System.out.println("请输入你的密码");
		String userpassword=in.next();
		Student stu=new Student();
		stu.setStatus(num);
		stu.setUsernum(usernum);
		stu.setUserpassword(userpassword);
		ManageStudent man=new ManageStudent();
		man.login(stu);
	}

}
