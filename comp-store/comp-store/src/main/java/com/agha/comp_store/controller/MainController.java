package com.agha.comp_store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.agha.comp_store.service.ComputerService;
import com.agha.comp_store.service.ProducerService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MainController {
	
	@Autowired
	private ComputerService computerService;
	
	@Autowired
	private ProducerService producerService;

	@GetMapping("/main")
	public String getMainPage(Model model, HttpServletRequest httpRequest) {
		// System.out.println(httpRequest.getRemoteUser());
		model.addAttribute("user", httpRequest.getRemoteUser());
		return "index";
	}

	@GetMapping("/catalog")
	public String getCatalogPage(Model model) {

		return "redirect:/catalog/all";
	}
	
	@GetMapping("/catalog/{producer}")
	public String getCatalogPage(@PathVariable(value = "producer") String producer, Model model, HttpServletRequest httpRequest) {
		System.out.println(producerService.getProducerCount());
		model.addAttribute("computersNumber", computerService.getAllComputersByProducer(producer).size());
		model.addAttribute("computers", computerService.getAllComputersByProducer(producer));
		model.addAttribute("producers", producerService.getProducerCount());
		model.addAttribute("allProducers", computerService.getAllComputers().size());
		model.addAttribute("prod", producer);
		model.addAttribute("user", httpRequest.getRemoteUser());
		return "catalog";
	}
	
	@GetMapping("/catalog/search")
	public String getCatalogSearchPage(@RequestParam("res") String result, Model model, HttpServletRequest httpRequest) {
		System.out.println(producerService.findAll());
		model.addAttribute("computers", computerService.findBySearch(result));
		model.addAttribute("producers", producerService.findAll());
		model.addAttribute("user", httpRequest.getRemoteUser());
		return "catalog";
	}
	
	@GetMapping("/catalog/product/{id}")
	public String getProduct(@PathVariable(name = "id") Integer id, Model model, HttpServletRequest request) {
		model.addAttribute("product", computerService.getElementById(id));
		model.addAttribute("username", request.getRemoteUser());
		return "product";
	}
}
