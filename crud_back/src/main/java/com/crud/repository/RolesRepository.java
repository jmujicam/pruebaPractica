package com.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.model.Roles;

public interface RolesRepository extends JpaRepository<Roles, Long> {
	List<Roles> findByNameContaining(String name);
}
