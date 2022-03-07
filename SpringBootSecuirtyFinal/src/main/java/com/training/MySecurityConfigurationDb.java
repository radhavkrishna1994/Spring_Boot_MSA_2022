package com.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.training.services.MyUserDetailsService;

//@Configuration
//@EnableWebSecurity
public class MySecurityConfigurationDb extends WebSecurityConfigurerAdapter {
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	/*
	 * does not work in mysql
	 * 
	 * @Bean public PasswordEncoder passwordEncoder() { return new
	 * BCryptPasswordEncoder(); }
	 */
	  @Bean 
	  public PasswordEncoder passwordEncoder() { 
		  
		  PasswordEncoder encoder = new PasswordEncoder()
		  {
	  		  @Override 
			  public String encode(CharSequence userEntered) { 
				   return userEntered.toString(); }
	  
			  @Override 
			  public boolean matches(CharSequence userEntered, String password) {
				  System.out.println("UserEntered "+userEntered);
				  System.out.println("password"+password);
				  if(password.equals(userEntered))	
				  return true; 
				  return false;
				  	
			  } };
			  return encoder;
	  }
	
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(userDetailsService)
		/* calls loadUserByUsername(String username), returns the User object with other values */
		.passwordEncoder(passwordEncoder());
			
		
	}
	
	public void configure(HttpSecurity httpSecurity) throws Exception
	{
	      httpSecurity
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
		  .formLogin();
		 
	}
	

}
