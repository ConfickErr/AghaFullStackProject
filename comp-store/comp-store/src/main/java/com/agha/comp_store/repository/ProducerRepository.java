package com.agha.comp_store.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.agha.comp_store.model.Producer;

public interface ProducerRepository extends JpaRepository<Producer, Integer>{

	Page<Producer> findAll(Pageable pageable);
	
	Producer findByName(String name);
	
//	@Query(value = "SELECT producer.name, count(producer.name) AS 'number' FROM comp_store.computer INNER JOIN comp_store.producer ON computer.producer_id = producer.id GROUP BY(producer.name)")
//	List<Object[]> findWithNumber();
	
}
