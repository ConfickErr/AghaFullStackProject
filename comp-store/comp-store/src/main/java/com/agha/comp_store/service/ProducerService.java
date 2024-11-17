package com.agha.comp_store.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.agha.comp_store.dto.ProducerCount;
import com.agha.comp_store.dto.ProducerDTO;
import com.agha.comp_store.model.Producer;
import com.agha.comp_store.repository.CustomComputerRepository;
import com.agha.comp_store.repository.ProducerRepository;
import com.agha.comp_store.utility.ConverterUtility;

@Service
public class ProducerService {

	@Autowired
	private ProducerRepository producerRepository;

	@Autowired
	private CustomComputerRepository customComputerRepository;
	
	public List<ProducerDTO> findAll() {
		return producerRepository.findAll().stream().map(ConverterUtility::convertEntityToDTO).collect(Collectors.toList());
	}
	
	public Producer save(ProducerDTO producerDTO) {
		return producerRepository.save(ConverterUtility.convertDTOToEntity(producerDTO));
	}

	public List<ProducerCount> getProducerCount() {
		return customComputerRepository.getComputerCountByProducer();
	}
	
	public Page<Producer> getPaginatedElements(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return producerRepository.findAll(pageable);
	}
	
	public ProducerDTO getElementById(Integer id) {
		return ConverterUtility.convertEntityToDTO(producerRepository.getReferenceById(id));
	}
	
	
	public void deleteById(Integer id) {
		producerRepository.deleteById(id);
	}
	
}
