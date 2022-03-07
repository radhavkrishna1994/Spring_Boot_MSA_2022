package com.training.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



//@Configuration
//@EnableWebSecurity
public class MySecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
		
	Logger log = LoggerFactory.getLogger(MySecurityConfiguration.class);
	//Authentication
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{		
		log.info("Authentication");
		String userPassword = passwordEncoder().encode("user1");
		String adminPassword = passwordEncoder().encode("admin");
		
		log.info(userPassword);
		log.info(adminPassword);
		
		auth
		.inMemoryAuthentication()     // UserDetailsService   loadByUserName(String username)
		.withUser("user1")
		.password(userPassword)
		.roles("USER")
		.and()
		.withUser("admin")
		.password(adminPassword)
		.roles("ADMIN");
			
	}
	
	//Authorization
	
		public void configure(HttpSecurity httpSecurity) throws Exception
		{
			log.info("Authorization");
			httpSecurity
			.authorizeRequests()
			.antMatchers("/user/**")   // gets Principal 
			.hasAnyRole("USER","ADMIN")
			.and()
			.authorizeRequests()
			.antMatchers("/admin/**")
			.hasRole("ADMIN")
			.anyRequest()
			.authenticated()
			.and()
			.formLogin();
			
			
		}
	
	

}
