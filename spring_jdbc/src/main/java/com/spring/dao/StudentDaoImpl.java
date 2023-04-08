package com.spring.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.entity.Student;

public class StudentDaoImpl implements StudentDao {

	private JdbcTemplate jdbcTemplate;

	public int insert(Student student) {
		String query = "insert into student(id,name,city) values(?,?,?)";
		int i = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
		return i;
	}

	public Student readStudent(int studentId) {
		String query = "select * from student where id=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student = this.jdbcTemplate.queryForObject(query, rowMapper, studentId);
		return student;
	}
	
	public int update(Student student) {
		String query = "update student set name=?,city=? where id=?";
		int u = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
		return u;
	}

	public int delete(int studentId) {
		String query = "delete from student where id=?";
		int d = this.jdbcTemplate.update(query, studentId);
		return d;
	}

	public List<Student> readAllStudent() {
		String query = "select * from student";
		List<Student> students = this.jdbcTemplate.query(query, new RowMapperImpl());
		return students;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}



}
