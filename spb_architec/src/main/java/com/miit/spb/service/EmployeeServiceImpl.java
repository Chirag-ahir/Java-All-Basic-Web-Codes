package com.miit.spb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.miit.spb.exception.ResourceNotFoundException;
import com.miit.spb.model.Employee;
import com.miit.spb.repository.EmployeeRepository;

//Service classes as the business logic layer. Calculations, data transformations, data processes, and cross-record validations (business rules) are usually done at this layer. They get called by the controller classes and might call repositories or other services. Service classes are usually put in a service package.

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository empRep;
	
	public EmployeeServiceImpl(EmployeeRepository empRep) {
		super();
		this.empRep = empRep;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return empRep.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return empRep.findAll();
	}

	@Override
	public Employee getEmployeById(long id) {
		Optional<Employee> employee = empRep.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}
		else {
			throw new ResourceNotFoundException("Not found any");
		}
	}

}
