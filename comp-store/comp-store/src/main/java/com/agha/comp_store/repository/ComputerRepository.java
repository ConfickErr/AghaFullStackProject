package com.agha.comp_store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.agha.comp_store.model.Computer;

public interface ComputerRepository extends JpaRepository<Computer, Integer>{
	
	@Query(value = "SELECT * FROM computer WHERE user_id=?1", nativeQuery = true)
	List<Computer> findAllComputerByUserId(Integer id);
	
	@Query(value = "SELECT * FROM computer WHERE producer_id=?1", nativeQuery = true)
	List<Computer> findAllComputersByProducer(Integer id);
	
	@Query(value = "SELECT * FROM comp_store.computer "
			+ "WHERE computer.name LIKE %?1%", nativeQuery = true)
	List<Computer> findBySearch(String val);

}
