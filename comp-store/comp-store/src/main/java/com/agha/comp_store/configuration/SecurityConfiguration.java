package com.agha.comp_store.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration {

	@Autowired
    private UserDetailsService userDetailsService;
	
	@Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
	
	@SuppressWarnings("removal")
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeHttpRequests((authorize) -> 
		authorize
		.requestMatchers("/registration/**", "/catalog/**").permitAll()
		.requestMatchers("/image/**", "/js/**", "/style/**").permitAll()
		.requestMatchers("/main").permitAll()
		.requestMatchers("/profile/computers").hasRole("USER")
		.requestMatchers("/computer/**").hasRole("USER")
		.requestMatchers("/cart/**").hasRole("USER")
		.requestMatchers("/admin/**").hasRole("ADMIN"))
		.formLogin(form ->
				form
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/main", true)
				.failureUrl("/login?error=true")
                .permitAll()
                )
		.logout(
				logout -> logout
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.permitAll()
        );
		
		return http.build();
	}
	
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
	
}
