package com.training.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.training.bean.MyUser;
import com.training.bean.MyUserDetails;
import com.training.bean.MyUser;
import com.training.repo.UserRepo;
import org.springframework.security.core.userdetails.User;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//System.out.println("Username Entered.."+username);
		 MyUser user=null;
		Optional<MyUser> opUser = userRepo.findById(username); // from db
		if(opUser.isPresent())
			user = opUser.get();
		//else
		//	throw new UsernameNotFoundException("error");
		
		/*
		 * ArrayList<SimpleGrantedAuthority> list = new ArrayList<>(); String users[] =
		 * user.getRoles().split(","); // "ROLE_USER,ROLE_ADMIN"
		 * System.out.println(user.getRoles());
		 * 
		 * for(String s:users) { list.add(new SimpleGrantedAuthority(s)); }
		 */
					
		//return new MyUserDetails(user);   // option 1
		
		/* option 2 */
		
		System.out.println("Roles:"+user.getPassword()+" "+user.getRoles());
		 List<GrantedAuthority> list ;
list= Arrays.stream(user.getRoles().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
		
		
		return new User(user.getUsername(), user.getPassword(), list);

		
	}

}
