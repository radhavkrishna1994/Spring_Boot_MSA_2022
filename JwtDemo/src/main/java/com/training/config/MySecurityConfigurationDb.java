package com.training.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.training.filters.JwtFilter;
import com.training.services.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class MySecurityConfigurationDb extends WebSecurityConfigurerAdapter {
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private JwtFilter jwtFilter;

	/*
	 * does not work for mysql
	 * 
	 * @Bean public PasswordEncoder passwordEncoder() { return new
	 * BCryptPasswordEncoder(); }
	 */
	@Bean 
	public PasswordEncoder passwordEncoder() { 

		return new PasswordEncoder()
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

	}

	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(userDetailsService)
		/* calls loadUserByUsername(String username), returns the User object with other values */
		.passwordEncoder(passwordEncoder());


	}

	/*
	 * public void configure(HttpSecurity httpSecurity) throws Exception {
	 * httpSecurity .authorizeRequests() .antMatchers("/user/**") //.hasRole("USER")
	 * .hasAnyRole("USER","ADMIN") .and() .authorizeRequests()
	 * .antMatchers("/admin/**") .hasRole("ADMIN") .anyRequest() .authenticated()
	 * .and() .formLogin();
	 * 
	 * }
	 */

	protected void configure(HttpSecurity httpSecurity) throws Exception {

		httpSecurity
		.csrf()
		.disable()
		.authorizeRequests()
		.antMatchers("/authenticate")
		.permitAll()
		.and()
		.authorizeRequests()
		.antMatchers("/user/**")
		.hasAnyRole("USER","ADMIN")
		.and()
		.authorizeRequests()
		.antMatchers("/admin/**")
		.hasRole("ADMIN")
		.anyRequest()
		.authenticated();
		
		httpSecurity.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}


}
