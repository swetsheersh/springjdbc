package com.spring.jdbc.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entites.Student;

@Component("impl")
public class StudentDaoImpl implements StudentDao{
	//@Value("#{jdbcTemplate}")
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public int insert(Student student) {
		String query="insert into student(id,name,city) values(?,?,?)";
		int r=this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		return r;
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public int updatetable(Student student) {
		String q="update student set name=?,city=? where id=?";
		int r=this.jdbcTemplate.update(q,student.getName(),student.getCity(),student.getId());
		return r;
	}
	public int deletedata(Student student) {
		String q="Delete from student where id=?";
		int r = this.jdbcTemplate.update(q,student.getId());
		return r;
	}
	public Student getfromtable(int studentId) {
		//selecting single Data
		String q="select * from Student where id=?";
		RowMapper<Student> rowMapper=new RowMapperImpl();
		Student student=this.jdbcTemplate.queryForObject(q,rowMapper,studentId);
		return student;
	}
	public List<Student> getallfromtable() {
		//Feteching all Data
		String q="select * from Student";
		List<Student> students=jdbcTemplate.query(q, new RowMapperImpl());
		return students;
	}
	

}
