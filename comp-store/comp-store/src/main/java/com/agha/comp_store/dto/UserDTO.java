package com.agha.comp_store.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	private Integer id;

	@NotNull(message = "Please, input your username")
	@NotEmpty(message = "Please, input your username")
	private String username;
	
	@NotNull(message = "Please, input your name")
	@NotEmpty(message = "Please, input your name")
	private String name;
	
	@NotNull(message = "Please, input your surname")
	@NotEmpty(message = "Please, input your surname")
	private String surname;
	
	@Email
	@NotNull(message = "Please, input your email")
	@NotEmpty(message = "Please, input your email")
	private String email;
	
	@NotNull(message = "Please, input your password")
	@NotEmpty(message = "Please, input your password")
	private String password;
	
	@NotNull(message = "Please, input your password")
	@NotEmpty(message = "Please, input your password")
	private String confirmPassword;

	private String role;
}
