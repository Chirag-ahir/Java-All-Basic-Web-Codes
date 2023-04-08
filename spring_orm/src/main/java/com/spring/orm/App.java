package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.dao.StudentDao;
import com.spring.entities.Student;

public class App {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean go = true;

		while (go) {
			System.out.println(" ");
			System.out.println("Press 1 for add new student");
			System.out.println("Press 2 for read all student");
			System.out.println("Press 3 for read single student");
			System.out.println("Press 4 for delete student");
			System.out.println("Press 5 for update student");
			System.out.println("Press 6 for exit");

			try {
				int input = Integer.parseInt(br.readLine());

				switch (input) {
	
					case 1:
						System.out.print("Enter student id: ");
						int id = Integer.parseInt(br.readLine());
						System.out.print("Enter student name: ");
						String name = br.readLine();
						System.out.print("Enter student city: ");
						String city = br.readLine();
	
						Student s = new Student(id, name, city);
						int i = studentDao.insert(s);
						System.out.println("Student added: " + i);
						break;
						
					case 2:
						List<Student> allStudents = studentDao.readStudents();
						for(Student st:allStudents) {
							System.out.println(" ");
							System.out.println("ID: " + st.getStudentId());
							System.out.println("Name: "+ st.getStudentName());
							System.out.println("City: "+ st.getStudentCity());
							System.out.println("_____________________________");
						}
						break;
						
					case 3:
						System.out.print("Enter student id: ");
						int sid = Integer.parseInt(br.readLine());
						Student st = studentDao.readStudent(sid);
						System.out.println(" ");
						System.out.println("ID: " + st.getStudentId());
						System.out.println("Name: "+ st.getStudentName());
						System.out.println("City: "+ st.getStudentCity());
						System.out.println("_____________________________");
						break;
						
					case 4:
						System.out.print("Enter student id: ");
						int did = Integer.parseInt(br.readLine());
						studentDao.delete(did);
						System.out.println("Student " + did + " deleted");
						break;
						
					case 5:
						System.out.print("Enter student id: ");
						int uid = Integer.parseInt(br.readLine());
						System.out.print("Enter student name: ");
						String uname = br.readLine();
						System.out.print("Enter student city: ");
						String ucity = br.readLine();
						
						Student ust = new Student();
						ust.setStudentId(uid);
						ust.setStudentName(uname);
						ust.setStudentCity(ucity);
						
						studentDao.update(ust);
						System.out.println("Student updated");
						break;
						
					case 6:
						go = false;
						break;
				}
			} catch (Exception e) {
				System.out.println("Invalid input, Try with anothe ome!!");
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Program exit");
	}
}
