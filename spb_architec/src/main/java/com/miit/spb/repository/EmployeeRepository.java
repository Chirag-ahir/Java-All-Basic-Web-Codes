package com.miit.spb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miit.spb.model.Employee;

//This layer’s responsibility is limited to Create, Retrieve, Update, and Delete (CRUD) operations on a data source, which is usually a relational or non-relational database.

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
