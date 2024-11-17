package com.agha.comp_store.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.agha.comp_store.dto.OSDTO;
import com.agha.comp_store.model.OS;
import com.agha.comp_store.repository.OSRepository;
import com.agha.comp_store.utility.ConverterUtility;

@Service
public class OSService {

	@Autowired
	private OSRepository osRepository;
	
	
	public List<OSDTO> findAll() {
		return osRepository.findAll().stream().map(ConverterUtility::convertEntityToDTO).collect(Collectors.toList());
	}
	
	public OS save(OSDTO osDto) {
		return osRepository.save(ConverterUtility.convertDTOToEntity(osDto));
	}
	
	public Page<OS> getPaginatedElements(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return osRepository.findAll(pageable);
	}
	
	public OSDTO getElementById(Integer id) {
		return ConverterUtility.convertEntityToDTO(osRepository.getReferenceById(id));
	}
	
	public void deleteById(Integer id) {
		osRepository.deleteById(id);
	}
	
	
	
}
