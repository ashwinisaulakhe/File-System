package com.filesystem.springapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.filesystem.springapp.entities.UserLogin;
import com.filesystem.springapp.entities.UserPrincipal;
import com.filesystem.springapp.repositories.UserLoginRepository;
import com.filesystem.springapp.serviceImpl.UserLoginServiceImpl;

public class UserLoginService implements UserLoginServiceImpl {

	@Autowired
	private UserLoginRepository userLoginRepository;
	
	@Override
	public UserDetails loadUserLoginByUsername (String username) throws UsernameNotFoundException {
		UserLogin user=userLoginRepository.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		
		return new UserPrincipal(user);
		
	}
}
