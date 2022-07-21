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
@Table(name = "employees")

public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "name")
	private String name;
	@Column(name = "lastname")
	private String lastname;
	@Column(name = "user")
	private String user;
	@Column(name = "password")
	private String password;
	@Column(name = "salary")
	private int salary;
	@Column(name = "status")
	private boolean status;
	
	@Column(name="rol_id", insertable=false, updatable=false, nullable=false)
	private long rol_id;
	
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "rol_id", nullable = false)
	private Roles rol;
	
	//constructor
	public Employee() {
	}

	public Employee(String name, String lastname, String user, String password, int salary, boolean status, Roles rol,
			long rol_id) {
		this.name = name;
		this.lastname = lastname;
		this.user = user;
		this.password = password;
		this.salary = salary;
		this.status = status;
		this.rol = rol;
		this.rol_id = rol_id;
	}

	//Getters and Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Roles getRol() {
		return rol;
	}

	public void setRol(Roles rol) {
		this.rol = rol;
	}

	public long getRol_id() {
		return rol_id;
	}

	public void setRol_id(long rol_id) {
		this.rol_id = rol_id;
	}
	
		
}
