package com.agha.comp_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.agha.comp_store.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	@Query(value = "SELECT * FROM users WHERE username=?1", nativeQuery = true)
	User findByUsername(String username);
}
