package com.agha.comp_store.dto;

import lombok.Data;

@Data
public class ComputerDTO {

	private Integer id;
	private String name;
	private ProducerDTO producer;
	private String state;
	private Double price;
	private String descrition;
	private Integer ram;
	private CPUDTO cpu;
	private Integer rom;
	private String romType;
	private OSDTO os;
	private GPUDTO gpu;
	private String imgURL; 
	private UserDTO user;
}
