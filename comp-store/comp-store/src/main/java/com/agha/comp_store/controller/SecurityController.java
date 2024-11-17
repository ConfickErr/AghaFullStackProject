package com.agha.comp_store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.agha.comp_store.dto.UserDTO;
import com.agha.comp_store.service.UserService;

@Controller
public class SecurityController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String getLoginPage() {
		return "login";
	}

	@GetMapping("/registration")
	public String getRegistrationPage(Model model) {
		UserDTO user = new UserDTO();
		user.setRole("user");
		model.addAttribute("user", user);
		return "registration";
	}
	
	@PostMapping("/registration/save")
	public String saveUser(@ModelAttribute(name="user") UserDTO user) {
		userService.save(user);
		return "redirect:/login";
	}

	@GetMapping("/registration/admin") 
	public String getAdminRegistrationPage(Model model) {
		UserDTO user = new UserDTO();
		user.setRole("admin");
		model.addAttribute("user", new UserDTO());
		return "registrasion";
	}
}
