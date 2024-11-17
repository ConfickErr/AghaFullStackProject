package com.agha.comp_store.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agha.comp_store.dto.ComputerDTO;
import com.agha.comp_store.model.Computer;
import com.agha.comp_store.repository.*;
import com.agha.comp_store.utility.ConverterUtility;
import com.agha.comp_store.utility.ObjectFinder;

@Service
public class ComputerService {

	@Autowired
	private ComputerRepository computerRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private ObjectFinder objectFinder;

	public List<ComputerDTO> getAllUserComputers(String user) {
		return computerRepository.findAllComputerByUserId(userService.findUserByUsername(user).getId()).stream()
				.map(ConverterUtility::convertEntityToDTO).collect(Collectors.toList());
	}

	public List<ComputerDTO> getAllComputersByProducer(String producer) {
		if(producer.equalsIgnoreCase("all")) {
			return getAllComputers();
		}
		return computerRepository.findAllComputersByProducer(objectFinder.findObjectId(producer)).stream()
				.map(ConverterUtility::convertEntityToDTO).collect(Collectors.toList());
	}

	public List<ComputerDTO> getAllComputers() {
		return computerRepository.findAll().stream().map(ConverterUtility::convertEntityToDTO)
				.collect(Collectors.toList());
	}

	public List<ComputerDTO> findBySearch(String res) {
		System.out.println(res);
		System.out.println(computerRepository.findBySearch(res).stream().map(ConverterUtility::convertEntityToDTO)
				.collect(Collectors.toList()));
		return computerRepository.findBySearch(res).stream().map(ConverterUtility::convertEntityToDTO)
				.collect(Collectors.toList());
	}
	
	public Computer save(ComputerDTO computerDTO) {
		computerDTO.setCpu(objectFinder.findObject(computerDTO.getCpu()));
		computerDTO.setGpu(objectFinder.findObject(computerDTO.getGpu()));
		computerDTO.setOs(objectFinder.findObject(computerDTO.getOs()));
		computerDTO.setProducer(objectFinder.findObject(computerDTO.getProducer()));
		computerDTO.setUser(objectFinder.findObject(computerDTO.getUser()));
		System.out.println("After:" + computerDTO);
		return computerRepository.save(ConverterUtility.convertDTOToEntity(computerDTO));
	}

	public Computer getElementById(Integer id) {
		for (ComputerDTO c : getAllComputers()) {
			System.out.println(c);
		}
		return computerRepository.getReferenceById(id);
	}

	public void removeComputer(Integer id) {
		computerRepository.deleteById(id);
	}

}
