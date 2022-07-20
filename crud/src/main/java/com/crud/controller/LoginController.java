package com.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.model.Employee;
import com.crud.model.LoginDto;
import com.crud.repository.EmployeeRepository;

import exception.ResourceNotFoundException;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class LoginController {

	@Autowired
    private EmployeeRepository employeeResposity;

	//login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
    	try {
    		Employee userEmployee = employeeResposity.findByUser(loginDto.getUser());
            if(userEmployee == null) {
                throw new ResourceNotFoundException("Usuario no Existe." + loginDto);   
            }
            
            if(!userEmployee.getPassword().equals(loginDto.getPassword())){
                throw new ResourceNotFoundException("Password Incorrecto.");
            }
            return new ResponseEntity<String>("Login Success",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Error al Logearse",HttpStatus.INTERNAL_SERVER_ERROR);
		}
    	
    }
}
