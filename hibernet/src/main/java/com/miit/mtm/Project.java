package com.miit.mtm;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {

	@Id
	@Column(name = "pid")
	private int Pid;
	@Column(name = "project_name")
	private String projectName;
	@ManyToMany(mappedBy = "projects") // many projects can be assigned to one employee
	private List<Emp> employees;

	public Project() {
		super();
	}

	public Project(int pid, String projectName, List<Emp> employees) {
		super();
		Pid = pid;
		this.projectName = projectName;
		this.employees = employees;
	}

	public int getPid() {
		return Pid;
	}

	public void setPid(int pid) {
		Pid = pid;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Emp> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Emp> employees) {
		this.employees = employees;
	}

}
