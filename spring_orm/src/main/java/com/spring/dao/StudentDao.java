package com.spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.entities.Student;

public class StudentDao {

	private HibernateTemplate hibernatetemplate;
//	sysout

	@Transactional
	public int insert(Student student) {
		Integer i = (Integer) this.hibernatetemplate.save(student);
		return i;
	}
	
	public Student readStudent(int studentId) {
		Student s = this.hibernatetemplate.get(Student.class, studentId);
		return s;
	}
	
	public List<Student> readStudents(){
		List<Student> s = this.hibernatetemplate.loadAll(Student.class);
		return s;
	}
	
	@Transactional
	public void update(Student student) {
		this.hibernatetemplate.update(student);
	}
	
	@Transactional
	public void delete(int studentId) {
		Student s = this.hibernatetemplate.get(Student.class, studentId);
		this.hibernatetemplate.delete(s);
	}

	public HibernateTemplate getHibernatetemplate() {
		return hibernatetemplate;
	}

	public void setHibernatetemplate(HibernateTemplate hibernatetemplate) {
		this.hibernatetemplate = hibernatetemplate;
	}
	
}
