package com.training.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.training.model.MyUser;
import com.training.repo.UserRepo;
import java.util.stream.Collectors;

@Service
public class MyUserDetailsService implements UserDetailsService{

	private Logger log = LoggerFactory.getLogger(MyUserDetailsService.class);

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<MyUser> opUser = userRepo.findById(username);
		//List<SimpleGrantedAuthority> listAuthorities=new ArrayList<>();
		MyUser userFound=null;
		if(opUser.isPresent())
		{
			userFound = opUser.get();
			log.info(userFound.getUsername()+ " "+userFound.getPassword()+" "+userFound.getRole());

			/*
			 * String roles = userFound.getRole(); // " ROLE_USER,ROLE_ADMIN"
			 * 
			 * 
			 * String rolesAr[] = roles.split(","); for(String role:rolesAr) {
			 * listAuthorities.add(new SimpleGrantedAuthority(role)); }
			 */

			List<SimpleGrantedAuthority> listAuthorities=Arrays.stream(userFound.getRole().split(","))
					.map(SimpleGrantedAuthority::new)
					.collect(Collectors.toList());
			
			return new org.springframework.security.core.userdetails.User(username, userFound.getPassword(),
					listAuthorities);

		}
		return null;

	}

}
