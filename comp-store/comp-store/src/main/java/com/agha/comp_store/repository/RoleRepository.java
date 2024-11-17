package com.agha.comp_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agha.comp_store.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

	Role findByName(String name);
}
