package com.training.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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



@Configuration
@EnableWebSecurity
public class MySecurityConfigurationDb extends WebSecurityConfigurerAdapter{
	Logger log = LoggerFactory.getLogger(MySecurityConfigurationDb.class);
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	//Does not support Mysql
	/* 
	 * @Bean public PasswordEncoder passwordEncoder() { return new
	 * BCryptPasswordEncoder(); }
	 */
		
	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new PasswordEncoder()
				{
					@Override
					public String encode(CharSequence rawPassword) {
			
						return rawPassword.toString();
					}

					@Override
					public boolean matches(CharSequence rawPassword, String encodedPassword) {
		
						return rawPassword.equals(encodedPassword);
					}
			
				};
				return encoder;
		
	}
	
	//Authentication
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{		
		log.info("Authentication");
		String userPassword = passwordEncoder().encode("user1");
		String adminPassword = passwordEncoder().encode("admin");
		
		log.info(userPassword);
		log.info(adminPassword);
		
		auth
		.userDetailsService(userDetailsService)
		.passwordEncoder(passwordEncoder());
			
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
