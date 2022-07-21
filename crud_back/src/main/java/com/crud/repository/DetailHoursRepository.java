package com.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.crud.model.DetailHours;

public interface DetailHoursRepository extends JpaRepository<DetailHours, Long>{
	List<DetailHours> findByEmployeeId(Long postId);
}
