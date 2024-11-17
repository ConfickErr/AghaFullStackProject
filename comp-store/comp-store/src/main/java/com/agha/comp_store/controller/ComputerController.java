package com.agha.comp_store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.agha.comp_store.service.CPUService;
import com.agha.comp_store.service.ComputerService;
import com.agha.comp_store.service.GPUService;
import com.agha.comp_store.service.OSService;
import com.agha.comp_store.service.ProducerService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ComputerController {
	
	@Autowired
	private ComputerService computerService;
	
	@Autowired
	private CPUService cpuService;
	
	@Autowired 
	private GPUService gpuService;
	
	@Autowired
	private OSService osService;
	
	@Autowired
	private ProducerService producerService;
	
	
	@GetMapping("/profile/computers")
	public String getMyComputersPage(Model model, HttpServletRequest request) {
		model.addAttribute("computers", computerService.getAllUserComputers(request.getRemoteUser()));
		model.addAttribute("computersCount", computerService.getAllUserComputers(request.getRemoteUser()).size());
		model.addAttribute("producers", producerService.findAll());
		model.addAttribute("cpus", cpuService.findAll());
		model.addAttribute("oses", osService.findAll());
		model.addAttribute("gpus", gpuService.findAll());
		model.addAttribute("user", request.getRemoteUser());
		return "my-computers";
	}
	
	@GetMapping("/profile/computer/remove/{id}")
	public String removeComputer(@PathVariable(name = "id") Integer id) {
		computerService.removeComputer(id);
		return "redirect:/profile/computers";
	}
	
	


}
