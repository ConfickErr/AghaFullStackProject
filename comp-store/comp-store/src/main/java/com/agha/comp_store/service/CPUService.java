package com.agha.comp_store.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.agha.comp_store.dto.CPUDTO;
import com.agha.comp_store.model.CPU;
import com.agha.comp_store.repository.CPURepository;
import com.agha.comp_store.utility.ConverterUtility;

@Service
public class CPUService {

	@Autowired
	private CPURepository cpuRepository;
	
	public List<CPUDTO> findAll() {
		return cpuRepository.findAll().stream().map(ConverterUtility::convertEntityToDTO).collect(Collectors.toList());
	}
	
	public Page<CPU> getPaginatedElements(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return cpuRepository.findAll(pageable);
	}
	
	public CPU save(CPUDTO cpuDto) {
		return cpuRepository.save(ConverterUtility.convertDTOToEntity(cpuDto));
	}
	
	public CPUDTO getElementById(Integer id) {
		return ConverterUtility.convertEntityToDTO(cpuRepository.getReferenceById(id));
	}
	
	public void deleteById(Integer id) {
		cpuRepository.deleteById(id);
	}
	
	
	
}
