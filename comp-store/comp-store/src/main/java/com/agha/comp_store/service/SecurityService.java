package com.agha.comp_store.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.agha.comp_store.model.Role;
import com.agha.comp_store.model.User;
import com.agha.comp_store.repository.UserRepository;

@Service
public class SecurityService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		
		if (user != null) {
			System.out.println("User: " + user.getUsername() + " " + user.getPassword());
			
			Collection<Role> roles = user.getRoles();
				if(roles != null && !roles.isEmpty()) {
					for (Role role : roles) {
						System.out.println(role.getName());
					}
				}
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
					mapRolesToAuthorities(user.getRoles()));
		}
		throw new UsernameNotFoundException("Invalid username or password.");
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		Collection<? extends GrantedAuthority> mapRoles = roles.stream()
				.map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
		return mapRoles;
	}

}
