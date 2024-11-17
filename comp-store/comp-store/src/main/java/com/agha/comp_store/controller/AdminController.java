package com.agha.comp_store.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.agha.comp_store.dto.CPUDTO;
import com.agha.comp_store.dto.GPUDTO;
import com.agha.comp_store.dto.OSDTO;
import com.agha.comp_store.dto.ProducerDTO;
import com.agha.comp_store.model.CPU;
import com.agha.comp_store.model.GPU;
import com.agha.comp_store.model.OS;
import com.agha.comp_store.model.Producer;
import com.agha.comp_store.service.CPUService;
import com.agha.comp_store.service.GPUService;
import com.agha.comp_store.service.OSService;
import com.agha.comp_store.service.ProducerService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private CPUService cpuService;
	
	@Autowired 
	private GPUService gpuService;
	
	@Autowired
	private OSService osService;
	
	@Autowired
	private ProducerService producerService;
	
	@GetMapping("/main")
	public String getMainPage() {
		return "admin-main";
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/cpu")
	public String getCPUMainPage(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, Model model) {
		Page<CPU> elementPage = cpuService.getPaginatedElements(page, size);
		model.addAttribute("cpus", elementPage.getContent());
		model.addAttribute("currentPage", page);
		model.addAttribute("currentPageI", page++);
		model.addAttribute("currentPageD", page--);
		model.addAttribute("totalPage", elementPage.getTotalPages());
		model.addAttribute("cpuNumber", cpuService.findAll().size());
		return "cpu-page";
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/cpu/add")
	public String getCPUAddPage(Model model) {
		CPUDTO cpu = new CPUDTO();
		model.addAttribute("cpu", cpu);
		return "add-cpu";
	}
	
	@GetMapping("/cpu/change/{id}")
	public String getCPUChangePage(@PathVariable(name="id") Integer id, Model model) {
		model.addAttribute("cpu", cpuService.getElementById(id));
		return "add-cpu";
	}
	
	@GetMapping("/cpu/delete/{id}")
	public String deleteCpu(@PathVariable(name="id") Integer id) {
		cpuService.deleteById(id);
		return "redirect:/admin/cpu";
	}
	
	
	@PostMapping("/cpu/save")
	public String saveCPU(@Valid @ModelAttribute(name = "cpu") CPUDTO cpudto, BindingResult result) {
		if (result.hasErrors()) {
			return "add-cpu";
		}
		cpuService.save(cpudto);
		return "redirect:/admin/cpu";
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/gpu")
	public String getGPUMainPage(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, Model model) {
		Page<GPU> elementPage = gpuService.getPaginatedElements(page, size);
		model.addAttribute("gpus", elementPage.getContent());
		model.addAttribute("currentPage", page);
		model.addAttribute("currentPageI", page++);
		model.addAttribute("currentPageD", page--);
		model.addAttribute("totalPage", elementPage.getTotalPages());
		model.addAttribute("gpuNumber", gpuService.findAll().size());
		return "gpu-page";
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/gpu/add")
	public String getGPUAddPage(Model model) {
		GPUDTO gpu = new GPUDTO();
		model.addAttribute("gpu", gpu);
		return "add-gpu";
	}
	
	@GetMapping("/gpu/change/{id}")
	public String getGPUChangePage(@PathVariable(name="id") Integer id, Model model) {
		model.addAttribute("gpu", gpuService.getElementById(id));
		return "add-gpu";
	}
	
	@GetMapping("/gpu/delete/{id}")
	public String deleteGPU(@PathVariable(name="id") Integer id) {
		gpuService.deleteById(id);
		return "redirect:/admin/gpu";
	}
	
	@PostMapping("/gpu/save")
	public String saveGPU(@Valid @ModelAttribute(name = "gpu") GPUDTO cpudto, BindingResult result) {
		if (result.hasErrors()) {
			return "add-gpu";
		}
		gpuService.save(cpudto);
		return "redirect:/admin/gpu";
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/os")
	public String getOSMainPage(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, Model model) {
		Page<OS> elementPage = osService.getPaginatedElements(page, size);
		model.addAttribute("oses", elementPage.getContent());
		model.addAttribute("currentPage", page);
		model.addAttribute("currentPageI", page++);
		model.addAttribute("currentPageD", page--);
		model.addAttribute("totalPage", elementPage.getTotalPages());
		model.addAttribute("osNumber", osService.findAll().size());
		return "os-page";
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/os/add")
	public String getOSAddPage(Model model) {
		OSDTO os = new OSDTO();
		model.addAttribute("os", os);
		return "add-os";
	}
	
	@GetMapping("/os/change/{id}")
	public String getOSChangePage(@PathVariable(name="id") Integer id, Model model) {
		model.addAttribute("os", osService.getElementById(id));
		return "add-os";
	}
	
	@GetMapping("/os/delete/{id}")
	public String deleteOS(@PathVariable(name="id") Integer id) {
		osService.deleteById(id);
		return "redirect:/admin/os";
	}
	
	@PostMapping("/os/save")
	public String saveOS(@Valid @ModelAttribute(name = "os") OSDTO osdto, BindingResult result) {
		if (result.hasErrors()) {
			return "add-gpu";
		}
		osService.save(osdto);
		return "redirect:/admin/os";
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/producer")
	public String getProducerMainPage(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, Model model) {
		Page<Producer> elementPage = producerService.getPaginatedElements(page, size);
		model.addAttribute("producers", elementPage.getContent());
		model.addAttribute("currentPage", page);
		model.addAttribute("currentPageI", page++);
		model.addAttribute("currentPageD", page--);
		model.addAttribute("totalPage", elementPage.getTotalPages());
		model.addAttribute("producerNumber", producerService.findAll().size());
		return "producer-page";
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/producer/add")
	public String getProducerAddPage(Model model) {
		ProducerDTO producerDTO = new ProducerDTO();
		model.addAttribute("producer", producerDTO);
		return "add-producer";
	}
	
	@GetMapping("/producer/change/{id}")
	public String getProducerChangePage(@PathVariable(name="id") Integer id, Model model) {
		model.addAttribute("producer", producerService.getElementById(id));
		return "add-producer";
	}
	
	@GetMapping("/producer/delete/{id}")
	public String deleteProducer(@PathVariable(name="id") Integer id) {
		producerService.deleteById(id);
		return "redirect:/admin/producer";
	}
	
	@PostMapping("/producer/save")
	public String saveOS(@Valid @ModelAttribute(name = "os") ProducerDTO producerDto, BindingResult result) {
		if (result.hasErrors()) {
			return "add-gpu";
		}
		producerService.save(producerDto);
		return "redirect:/admin/producer";
	}

}
