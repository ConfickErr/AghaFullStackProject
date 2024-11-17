package com.agha.comp_store.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.agha.comp_store.dto.UserDTO;
import com.agha.comp_store.model.Role;
import com.agha.comp_store.model.User;
import com.agha.comp_store.repository.RoleRepository;
import com.agha.comp_store.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public void save(UserDTO userDTO) {

		User user = new User();
		user.setName(userDTO.getName());
		user.setSurname(userDTO.getSurname());
		user.setUsername(userDTO.getUsername());
		user.setEmail(userDTO.getEmail());
		user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

		Role role;

		if (userDTO.getRole().equals("admin")) {
			role = roleRepository.findByName("ROLE_ADMIN");
			
			if (role == null) {
				role = addRole("ROLE_ADMIN");
			}

		} else {
			role = roleRepository.findByName("ROLE_USER");
			
			if (role == null) {
				role = addRole("ROLE_USER");
			}
		}

		user.setRoles(Arrays.asList(role));
		userRepository.save(user);
	}

	private Role addRole(String roleStr) {
		Role role = new Role();
		role.setName(roleStr);
		return roleRepository.save(role);
	}

	public User findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}
