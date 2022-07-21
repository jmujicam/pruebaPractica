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
public class RolesController {
	
	@Autowired
	RolesRepository rolesRepository;
	
	//Todos los roles
	@GetMapping("/roles")
	public ResponseEntity<List<Roles>> getAllRoles(@RequestParam(required = false) String name) {
		try {
			List<Roles> roles = new ArrayList<Roles>();
			if (name == null)
				rolesRepository.findAll().forEach(roles::add);
			else
				rolesRepository.findByNameContaining(name).forEach(roles::add);
			if (roles.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(roles, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Rol por Id
	@GetMapping("/roles/{id}")
	public ResponseEntity<Roles> getRolesById(@PathVariable("id") long id) {
		Optional<Roles> rolData = rolesRepository.findById(id);
		if (rolData.isPresent()) {
			return new ResponseEntity<>(rolData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//Creaccion rol
	@PostMapping("/roles")
	public ResponseEntity<Roles> createRoles(@RequestBody Roles rol) {
		try {
			Roles _rol = rolesRepository
					.save(new Roles(rol.getName(), 
									  rol.getDescription(), 
									  true));
			return new ResponseEntity<>(_rol, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	//Editar Rol
	@PutMapping("/roles/{id}")
	public ResponseEntity<Roles> updateRoles(@PathVariable("id") long id, @RequestBody Roles rol) {
		Optional<Roles> rolData = rolesRepository.findById(id);
		if (rolData.isPresent()) {
			Roles _rol = rolData.get();
			_rol.setName(rol.getName());
			_rol.setDescription(rol.getDescription());
			return new ResponseEntity<>(rolesRepository.save(_rol), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//Eliminacion de Rol
	@DeleteMapping("/roles/{id}")
	public ResponseEntity<HttpStatus> deleteRol(@PathVariable("id") long id) {
		try {
			rolesRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
