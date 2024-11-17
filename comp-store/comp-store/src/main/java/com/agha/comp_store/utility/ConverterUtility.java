package com.agha.comp_store.utility;

import org.springframework.stereotype.Service;

import com.agha.comp_store.dto.CPUDTO;
import com.agha.comp_store.dto.CartItemDTO;
import com.agha.comp_store.dto.ComputerDTO;
import com.agha.comp_store.dto.GPUDTO;
import com.agha.comp_store.dto.OSDTO;
import com.agha.comp_store.dto.ProducerDTO;
import com.agha.comp_store.dto.UserDTO;
import com.agha.comp_store.model.CPU;
import com.agha.comp_store.model.CartItem;
import com.agha.comp_store.model.Computer;
import com.agha.comp_store.model.GPU;
import com.agha.comp_store.model.OS;
import com.agha.comp_store.model.Producer;
import com.agha.comp_store.model.User;

@Service
public class ConverterUtility {

	public static Computer convertDTOToEntity(ComputerDTO computerDTO) {
		Computer computer = new Computer();
		computer.setId(computerDTO.getId());
		computer.setName(computerDTO.getName());
		computer.setProducer(convertDTOToEntity(computerDTO.getProducer()));
		computer.setPrice(computerDTO.getPrice());
		computer.setDescrition(computerDTO.getDescrition());
		computer.setRam(computerDTO.getRam());
		computer.setCpu(convertDTOToEntity(computerDTO.getCpu()));
		computer.setRom(computerDTO.getRom());
		computer.setOs(convertDTOToEntity(computerDTO.getOs()));
		computer.setGpu(convertDTOToEntity(computerDTO.getGpu()));
		computer.setImgURL(computerDTO.getImgURL());
		computer.setUser(convertDTOToEntity(computerDTO.getUser()));
		return computer;
	}
	
	public static CPU convertDTOToEntity(CPUDTO cpuDto) {
		CPU cpu = new CPU();
		cpu.setId(cpuDto.getId());
		cpu.setName(cpuDto.getName());
		cpu.setGeneration(cpuDto.getGeneration());
		cpu.setPower(cpuDto.getPower());
		cpu.setCore(cpuDto.getCore());
		return cpu;
	}
	
	
	public static GPU convertDTOToEntity(GPUDTO gpuDto) {
		GPU gpu = new GPU();
		gpu.setId(gpuDto.getId());
		gpu.setName(gpuDto.getName());
		gpu.setMemory(gpuDto.getMemory());
		gpu.setPrototype(gpuDto.getPrototype());
		
		return gpu;
	}
	
	public static OS convertDTOToEntity(OSDTO osDto) {
		OS os = new OS();
		os.setId(osDto.getId());
		os.setName(osDto.getName());
		os.setVersion(osDto.getVersion());
		return os;
	}
	
	public static Producer convertDTOToEntity(ProducerDTO producerDTO) { 
		Producer producer = new Producer();
		producer.setId(producerDTO.getId());
		producer.setName(producerDTO.getName());
		
		return producer;
	}
	
	public static User convertDTOToEntity(UserDTO userDTO) { 
		User user = new User();
		user.setId(userDTO.getId());
		user.setName(userDTO.getName());
		user.setSurname(userDTO.getSurname());
		user.setUsername(userDTO.getUsername());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		return user;
	}

	public static CartItem convertDTOToEntity(CartItemDTO cartItemDTO) {
		CartItem cartItem = new CartItem();
		cartItem.setId(cartItemDTO.getId());
		cartItem.setComputer(convertDTOToEntity(cartItemDTO.getComputer()));
		cartItem.setQuantity(cartItemDTO.getQuantity());
		cartItem.setUser(convertDTOToEntity(cartItemDTO.getUser()));
		return cartItem;
	}

	
	public static ComputerDTO convertEntityToDTO(Computer computer) {
		ComputerDTO computerDTO = new ComputerDTO();
		computerDTO.setId(computer.getId());
		computerDTO.setName(computer.getName());
		computerDTO.setProducer(convertEntityToDTO(computer.getProducer()));
		computerDTO.setPrice(computer.getPrice());
		computerDTO.setDescrition(computer.getDescrition());
		computerDTO.setRam(computer.getRam());
		computerDTO.setCpu(convertEntityToDTO(computer.getCpu()));
		computerDTO.setRom(computer.getRom());
		computerDTO.setOs(convertEntityToDTO(computer.getOs()));
		computerDTO.setGpu(convertEntityToDTO(computer.getGpu()));
		computerDTO.setImgURL(computer.getImgURL());
		return computerDTO;
	}
	
	public static CPUDTO convertEntityToDTO(CPU cpu) {
		CPUDTO cpuDTO = new CPUDTO();
		cpuDTO.setId(cpu.getId());
		cpuDTO.setName(cpu.getName());
		cpuDTO.setGeneration(cpu.getGeneration());
		cpuDTO.setPower(cpu.getPower());
		cpuDTO.setCore(cpu.getCore());
		return cpuDTO;
	}
	
	public static GPUDTO convertEntityToDTO(GPU gpu) {
		GPUDTO gpuDTO = new GPUDTO();
		gpuDTO.setId(gpu.getId());
		gpuDTO.setName(gpu.getName());
		gpuDTO.setMemory(gpu.getMemory());
		gpuDTO.setPrototype(gpu.getPrototype());
		
		return gpuDTO;
	}
	
	public static OSDTO convertEntityToDTO(OS os) {
		OSDTO osDTO = new OSDTO();
		osDTO.setId(os.getId());
		osDTO.setName(os.getName());
		osDTO.setVersion(os.getVersion());
		return osDTO;
	}

	public static ProducerDTO convertEntityToDTO(Producer producer) { 
		ProducerDTO producerDTO = new ProducerDTO();
		producerDTO.setId(producer.getId());
		producerDTO.setName(producer.getName());
		
		return producerDTO;
	}

	public static UserDTO convertEntityToDTO(User user) { 
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setName(user.getName());
		userDTO.setSurname(user.getSurname());
		userDTO.setUsername(user.getUsername());
		userDTO.setEmail(user.getEmail());
		userDTO.setPassword(user.getPassword());
		return userDTO;
	}

	public static CartItemDTO convertEntityToDTO(CartItem cartItem) {
		CartItemDTO cartItemDTO = new CartItemDTO();
		cartItemDTO.setId(cartItem.getId());
		cartItemDTO.setComputer(convertEntityToDTO(cartItem.getComputer()));
		cartItemDTO.setQuantity(cartItem.getQuantity());
		cartItemDTO.setUser(convertEntityToDTO(cartItem.getUser()));
		return cartItemDTO;
	}
	
}
