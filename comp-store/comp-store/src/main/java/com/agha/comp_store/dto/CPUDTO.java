package com.agha.comp_store.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CPUDTO {

	private Integer id;

	@NotEmpty(message = "Please, input CPU name")
	@NotNull(message = "Please, input CPU name")
	private String name;
	
	@NotEmpty(message = "Please, input CPU generetion")
	@NotNull(message = "Please, input CPU generetion")
	private String generation;
	
	@NotNull(message = "Please, input CPU power")
	@Min(value = 500, message = "Can't be less than 500")
	@Max(value = 1000000, message = "Can't be more than 1000000")
	private Integer power;
	
	@NotNull(message = "Please, input CPU core")
	@Min(value = 2, message = "Can't be less than 2")
	@Max(value = 10, message = "Can't be more than 10")
	private Integer core;
}
