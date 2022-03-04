package com.abcbank.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

import com.abcbank.services.MyUserDetailsService;

import com.abcbank.filters.MyJwtFilter;

@Configuration
@EnableWebSecurity
public class MySecurityConfigurationDb extends WebSecurityConfigurerAdapter {
	
	@Value("${server.port}")
	private int port;
	
	public int getPort()
	{
		return port;
	}
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private MyJwtFilter jwtFilter;

	/*
	 * does not work for mysql
	 * 
	 * @Bean public PasswordEncoder passwordEncoder() { return new
	 * BCryptPasswordEncoder(); }
	 */
	@Bean 
	public PasswordEncoder passwordEncoder() { 
		BCryptPasswordEncoder passwordEn = new BCryptPasswordEncoder();
		
		
		return new PasswordEncoder()
		{
			@Override 
			public String encode(CharSequence userEntered) { 
				
				return userEntered.toString(); }

			@Override 
			public boolean matches(CharSequence userEntered, String password) {
				
				System.out.println("UserEntered "+userEntered);
				System.out.println("password"+password);
				if(passwordEn.matches(userEntered, password))
				//if(password.equals(userEntered))	
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
	//	.antMatchers("/bank/login")
		.antMatchers("/getaccount1/accountno/**")
		.permitAll()
		.and()
		.authorizeRequests()
		.antMatchers("/swagger-ui.html")
		.permitAll()
		.and()
		.authorizeRequests()
		.antMatchers("/bank/customer/**")
		.hasAnyRole("CUSTOMER","ADMIN")
		.and()
		.authorizeRequests()
		.antMatchers("/bank/admin/**")
		.hasRole("ADMIN")
		.anyRequest()
		.authenticated();
		
	//	httpSecurity.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}


}
