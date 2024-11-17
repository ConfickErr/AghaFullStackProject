package com.agha.comp_store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.agha.comp_store.service.CartItemService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CartController {

	@Autowired
	private CartItemService cartItemService;
	
	@GetMapping("/cart")
	public String getCardPage(Model model, HttpServletRequest request) {
		model.addAttribute("cartItems", cartItemService.getAllCartItems(request.getRemoteUser()));
		model.addAttribute("totalPrice", cartItemService.getTotalPrice(request.getRemoteUser()));
		System.out.println(cartItemService.getAllCartItems(request.getRemoteUser()));
		return "cart";
	}

	@GetMapping("/cart/delete/{id}")
	public String deleteCartItem(@PathVariable(name = "id") Integer id, HttpServletRequest request) {
		cartItemService.deleteCartItem(id, request.getRemoteUser());
		return "redirect:/cart";
	}
	
}
