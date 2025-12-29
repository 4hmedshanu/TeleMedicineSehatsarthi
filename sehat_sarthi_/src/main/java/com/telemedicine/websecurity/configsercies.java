package com.telemedicine.websecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.telemedicine.backendrepository.backend_services;
import com.telemedicine.entity.user;

@Service
public class configsercies implements UserDetailsService {
	@Autowired
	backend_services services;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		user u=services.getusernameby(username);
		if(u==null) {
			return null;
		}
		
		return User.withUsername(u.getEmail()).password(u.getPasswordHash()).roles(u.getRole()).build();
	}
	

}
