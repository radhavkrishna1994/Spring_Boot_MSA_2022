package com.training;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class MySecurityConfiguration extends WebSecurityConfigurerAdapter {
	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.requiresChannel().anyRequest().requiresSecure(); }
	 */
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	//authentication
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
					
		String userPassword = passwordEncoder().encode("user1");
		String adminPassword = passwordEncoder().encode("admin123");
		System.out.println(userPassword);
		System.out.println(adminPassword);
				
		auth
		.inMemoryAuthentication()
		.withUser("user1")
		.password(userPassword) // encrypted 
		.roles("USER")
		.and()
		.withUser("admin")
		.password(adminPassword)
		.roles("ADMIN");
	}		//authorization
	
	public void configure(HttpSecurity httpSecurity) throws Exception
	{
	      httpSecurity
	      .authorizeRequests()
		  .antMatchers("/", "/home").permitAll()
		  .and()
		  .authorizeRequests() 
		  .antMatchers("/user/**")
		  //.hasRole("USER")
		  .hasAnyRole("USER","ADMIN")
		  .and()
		  .authorizeRequests()
		  .antMatchers("/admin/**")
		  .hasRole("ADMIN")
		  .anyRequest()
		  .authenticated()
		  .and()
		  .formLogin()
		  .loginPage("/login")
		 // .failureUrl(null)
		  .permitAll();
		 
	}

}
