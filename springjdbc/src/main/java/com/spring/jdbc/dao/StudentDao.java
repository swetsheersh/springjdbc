package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.entites.Student;

public interface StudentDao {
	public int insert(Student student);
	public int updatetable(Student student);
	public int deletedata(Student student);
	public Student getfromtable(int studentId);
	public List<Student> getallfromtable();
}
