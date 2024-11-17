package com.agha.comp_store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.agha.comp_store.dto.CartItemDTO;
import com.agha.comp_store.service.CartItemService;

@RestController
public class CartRestController {

	@Autowired
	private CartItemService cartItemService;
	
	
	@PostMapping("/cart/add")
	public void addToCart(@RequestBody CartItemDTO cartItemDTO) {
		System.out.println(cartItemDTO);
		cartItemService.addToCard(cartItemDTO.getComputer().getId(), cartItemDTO.getQuantity(), cartItemDTO.getUser().getUsername());
	}
}
