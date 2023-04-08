package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.dao.StudentDao;
import com.spring.entity.Student;

/**
 * STEPS TO CREATE SPRING_JDBC APPLICATION 1. Create database and table in
 * database 2. Create java project in eclipse 3. Create spring bean class (POJO
 * or Entity) 4. Create a DAO class 5. Configure datasource and spring
 * configuration XML file 6. Create spring container by Application context
 *
 */
//Spring JDBC is used to build data access layer of enterprise application. It is a mechanism to connect to the database and execute SQL queries. The databse related logic has to be placed in separate classes called DAO class. 
//This example demonstrate CRUD operation in Spring_JDBC :: https://youtu.be/qzF_M0p48Rg
//There should be student table in DB 
public class App {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ApplicationContext ap = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
		//ApplicationContext ap = new AnnotationConfigApplicationContext("com/spring/jdbc/config.xml");
		StudentDao studentDao = (StudentDao) ap.getBean("studentDao");

//		Student s = new Student();
//		s.setId(104);
//		s.setName("Keral");
//		s.setCity("Rajkot");
//		int result = studentDao.insert(s);
//		System.out.println("Student added " + result);

//		Student student = studentDao.readStudent(102);
//		System.out.println(student);

//		Student s = new Student();
//		s.setId(104);
//		s.setName("Keral");
//		s.setCity("NorthYork");
//		int result = studentDao.update(s);
//		System.out.println("Student changed " + result);

//		int result = studentDao.delete(104);
//		System.out.println("Student deleted " + result);

		List<Student> students = studentDao.readAllStudent();
		for (Student s : students) {
			System.out.println(s);
		}

	}
}
