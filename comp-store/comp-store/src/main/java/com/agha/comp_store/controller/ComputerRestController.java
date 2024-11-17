package com.agha.comp_store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.agha.comp_store.dto.ComputerDTO;
import com.agha.comp_store.service.ComputerService;

@RestController
public class ComputerRestController {
	
	@Autowired
	private ComputerService computerService;
	
	@PostMapping("/computer/save")
	public ResponseEntity<String> saveComputer(@RequestBody ComputerDTO computerDTO) {
		System.out.println("Before: " + computerDTO);
		computerService.save(computerDTO);
		
		return new ResponseEntity<>("Data received successfully", HttpStatus.OK);
	}
}
