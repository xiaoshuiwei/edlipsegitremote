package com.xsw.dao;

import java.util.List;
import java.util.Map;

import com.xsw.pojo.Student;
//hello
//afasfa

public interface StudentMapper {
		//测试git更新
		int addStudent(Student stu);
		
		//修改
		int updateStudent(Student stu);
		//删除
		int deleteStudent(Object[] obj);
		//查询
		List<Student> selectAllStudent();
		//哈哈
		
	 public List<Student> getUserListByMap(Student stu);
		
}
