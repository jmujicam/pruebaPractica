package com.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.model.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee, Long>{
	List<Employee> findByNameContaining(String name);
	
	Employee findByUser(String user);

}
