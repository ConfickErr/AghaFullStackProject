package com.agha.comp_store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agha.comp_store.model.CartItem;
import com.agha.comp_store.model.User;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
	
	List<CartItem> findByUser(User user);
}
