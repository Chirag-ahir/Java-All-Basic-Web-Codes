package com.spring.dao;
import java.util.List;

import com.spring.entity.Student;

public interface StudentDao {
	public int insert(Student student);
	public Student readStudent(int studentId);
	public int update(Student student);
	public int delete(int studentId);
	public List<Student> readAllStudent();
}
