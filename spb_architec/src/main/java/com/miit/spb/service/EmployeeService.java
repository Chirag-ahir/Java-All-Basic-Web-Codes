package com.miit.spb.service;

import java.util.List;

import com.miit.spb.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeById(long id);
}
