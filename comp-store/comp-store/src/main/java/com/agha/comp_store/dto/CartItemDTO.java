package com.agha.comp_store.dto;

import lombok.Data;

@Data
public class CartItemDTO {

	private Integer id;
	private ComputerDTO computer;
	private int quantity;
	private UserDTO user;
}
