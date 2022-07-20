package com.crud.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.model.Employee;
import com.crud.model.Roles;

import com.crud.repository.EmployeeRepository;
import com.crud.repository.RolesRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	RolesRepository rolesRepository;
	
	//Obtener Todos los Empleados
	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getAllEmployee(@RequestParam(required = false) String name) {
		try {
			List<Employee> employees = new ArrayList<Employee>();
			if (name == null)
				employeeRepository.findAll().forEach(employees::add);
			else
				employeeRepository.findByNameContaining(name).forEach(employees::add);
			if (employees.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(employees, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Crear Empleado
	@PostMapping("/employee")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		try {
			Optional<Roles> rolOpt =  rolesRepository.findById(employee.getRol_id());
			Roles rol = rolOpt.get();
			if(!rol.getName().contains("admin") && !rol.getName().contains("jefe"))
			{
				Employee _employee = employeeRepository
						.save(new Employee(employee.getName(), 
										  employee.getLastname(), 
										  employee.getUser(),
										  employee.getPassword(),
										  employee.getSalary(),
										  false,
										  rol,
										  employee.getRol_id()));
				return new ResponseEntity<>(_employee, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
			}
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//actualizar empleado
	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
		Optional<Employee> employeeData = employeeRepository.findById(id);
		Optional<Roles> rolOpt =  rolesRepository.findById(employee.getRol_id());
		Roles rol = rolOpt.get();
		Employee _employee = employeeData.get();
		
		if (employeeData.isPresent()) {
			if (!rol.getName().contains("jefe")  ) {
				_employee.setName(employee.getName());
				_employee.setLastname(employee.getLastname());
				_employee.setSalary(employee.getSalary());
				_employee.setRol(rol);
				_employee.setRol_id(employee.getRol_id());
				return new ResponseEntity<>(employeeRepository.save(_employee), HttpStatus.OK);
			}
			else {
				_employee.setName(employee.getName());
				_employee.setLastname(employee.getLastname());
				_employee.setSalary(employee.getSalary());
				_employee.setRol(rol);
				_employee.setRol_id(rol.getId());
				
				return new ResponseEntity<>(employeeRepository.save(_employee), HttpStatus.OK);
			}
			
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//eliminacion de empleado
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") long id) {
		employeeRepository.deleteById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
