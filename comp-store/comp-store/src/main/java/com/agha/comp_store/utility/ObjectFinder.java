package com.agha.comp_store.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agha.comp_store.dto.*;
import com.agha.comp_store.repository.*;

@Service
public class ObjectFinder {
	
	@Autowired
	private CPURepository cpuRepository;
	
	@Autowired
	private GPURepository gpuRepository;
	
	@Autowired
	private OSRepository osRepository;
	
	@Autowired
	private ProducerRepository producerRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public CPUDTO findObject(CPUDTO cpuDto) {
		return ConverterUtility.convertEntityToDTO(cpuRepository.getReferenceById(cpuDto.getId()));
	}
	
	public GPUDTO findObject(GPUDTO gpuDto) {
		return ConverterUtility.convertEntityToDTO(gpuRepository.getReferenceById(gpuDto.getId()));
	}
	
	public OSDTO findObject(OSDTO osDto) {
		return ConverterUtility.convertEntityToDTO(osRepository.getReferenceById(osDto.getId()));
	}
	
	public ProducerDTO findObject(ProducerDTO producerDto) {
		return ConverterUtility.convertEntityToDTO(producerRepository.getReferenceById(producerDto.getId()));
	}
	
	public UserDTO findObject(UserDTO userDTO) {
		return ConverterUtility.convertEntityToDTO(userRepository.findByUsername(userDTO.getUsername()));
	}
	
	public Integer findObjectId(String producer) {
		return producerRepository.findByName(producer).getId();
	}
}
