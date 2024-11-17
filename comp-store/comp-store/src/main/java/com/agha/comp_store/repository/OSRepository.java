package com.agha.comp_store.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.agha.comp_store.model.OS;

public interface OSRepository extends JpaRepository<OS, Integer>{

	Page<OS> findAll(Pageable pageable);
}
