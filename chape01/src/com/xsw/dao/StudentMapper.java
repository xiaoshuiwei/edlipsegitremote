package com.xsw.dao;

import java.util.List;
import java.util.Map;

import com.xsw.pojo.Student;



public interface StudentMapper {
		//添加
		int addStudent(Student stu);
		//修改
		int updateStudent(Student stu);
		//删除
		int deleteStudent(Object[] obj);
		//查询
		List<Student> selectAllStudent();
		
		
	 public List<Student> getUserListByMap(Student stu);
		
}
