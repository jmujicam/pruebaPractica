
package com.crud.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.crud.model.DetailHours;
import com.crud.repository.DetailHoursRepository;
import com.crud.repository.EmployeeRepository;

import exception.ResourceNotFoundException;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class DetailHoursController {
	
	  @Autowired
	  private DetailHoursRepository detailHoursRepository;
	  @Autowired
	  EmployeeRepository employeeRepository;
	  
	  @GetMapping("/employee/{employeeId}/detailHours")
	  public ResponseEntity<List<DetailHours>> getAllHoursByEmployeeId(@PathVariable(value = "employeeId") Long employeeId) {
	    if (!employeeRepository.existsById(employeeId)) {
	    	
	    	//throw new ResourceNotFoundException("No se encontro Empleado con id = " + employeeId);
	    }
	    List<DetailHours> detailHour = detailHoursRepository.findByEmployeeId(employeeId);
	    return new ResponseEntity<>(detailHour, HttpStatus.OK);
	  }
	  
	  @GetMapping("/detailHours/{id}")
	  public ResponseEntity<DetailHours> getDetailHoursByEmployeeId(@PathVariable(value = "id") Long id) {
	    DetailHours detailHours = detailHoursRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("No se encontro Detalle de Hora con id = " + id));
	    return new ResponseEntity<>(detailHours, HttpStatus.OK);
	  }
	  
	  @PostMapping("/employee/{employee_id}/detailHours")
	  public ResponseEntity<DetailHours> createDetailHours(@PathVariable(value = "employee_id") Long employee_id,
	      @RequestBody DetailHours detailHoursRequest) {
		  DetailHours detailHours = employeeRepository.findById(employee_id).map(employee -> {
		  detailHoursRequest.setEmployee(employee);
	      return detailHoursRepository.save(detailHoursRequest);
	    }).orElseThrow(() -> new ResourceNotFoundException("No se encontro empleado con id = " + employee_id));
	    return new ResponseEntity<>(detailHours, HttpStatus.CREATED);
	  }
	  
	  @PutMapping("/detailHours/{id}")	
	  public ResponseEntity<DetailHours> updateDetailHours(@PathVariable("id") long id, @RequestBody DetailHours detailHoursRequest) {
	    DetailHours detailHours = detailHoursRepository.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("DetalleHoraTd " + id + "not encontrado"));
	    //detailHours.setContent(detailHoursRequest.getContent());
	    return new ResponseEntity<>(detailHoursRepository.save(detailHours), HttpStatus.OK);
	  }
	  
	  /*@DeleteMapping("/employee/{employee_id}/detailHours")
	  public ResponseEntity<List<DetailHours>> deleteAllHoursOfEmployee(@PathVariable(value = "employee_id") Long employee_id) {
	    if (!employeeRepository.existsById(employee_id)) {
	      throw new ResourceNotFoundException("Not found Tutorial with id = " + employee_id);
	    }
	    detailHoursRepository.deleteByEmpleyeeId(employee_id);
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  }*/
	  
		@DeleteMapping("employee/{employee_id}/detailHours")
		public ResponseEntity<HttpStatus> deleteHoursOfEmployee(@PathVariable("id") long id) {
			try {
				employeeRepository.deleteById(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

}
