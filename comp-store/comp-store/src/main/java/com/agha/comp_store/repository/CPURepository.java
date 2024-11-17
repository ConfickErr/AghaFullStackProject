package com.agha.comp_store.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.agha.comp_store.model.CPU;

public interface CPURepository extends JpaRepository<CPU, Integer>{
	
	Page<CPU> findAll(Pageable pageable);

}
