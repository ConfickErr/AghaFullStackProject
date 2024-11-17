package com.agha.comp_store.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.agha.comp_store.dto.GPUDTO;
import com.agha.comp_store.model.GPU;
import com.agha.comp_store.repository.GPURepository;
import com.agha.comp_store.utility.ConverterUtility;

@Service
public class GPUService {

	@Autowired
	private GPURepository gpuRepository;
	
	public List<GPUDTO> findAll() {
		return gpuRepository.findAll().stream().map(ConverterUtility::convertEntityToDTO).collect(Collectors.toList());
	}
	
	public GPU save(GPUDTO gpudto) {
		return gpuRepository.save(ConverterUtility.convertDTOToEntity(gpudto));
	}
	
	public Page<GPU> getPaginatedElements(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return gpuRepository.findAll(pageable);
	}
	
	public GPUDTO getElementById(Integer id) {
		return ConverterUtility.convertEntityToDTO(gpuRepository.getReferenceById(id));
	}
	
	public void deleteById(Integer id) {
		gpuRepository.deleteById(id);
	}
	

}
