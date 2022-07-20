package com.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "detailhours")
public class DetailHours {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "hours")
	private int hours;
	@Column(name = "hourlyValue")
	private float hourlyValue;
	@Column(name = "month")
	private int month;
	@Column(name = "status")
	private boolean status;
	
	@Column(name="employee_id", insertable=false, updatable=false, nullable=false)
	private long employee_id;

	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "employee_id",insertable=false, updatable=false,nullable = false)
	private Employee employee;
	
	//constructor
	public DetailHours() {

	}
	
	public DetailHours(int hours, float hourlyValue, int month, boolean status, Employee employee) {

		this.hours = hours;
		this.hourlyValue = hourlyValue;
		this.month = month;
		this.status = status;
		this.employee = employee;
	}
	
	//Getters and Setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public float getHourlyValue() {
		return hourlyValue;
	}
	public void setHourlyValue(float hourlyValue) {
		this.hourlyValue = hourlyValue;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

	public long getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(long employee_id) {
		this.employee_id = employee_id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}
