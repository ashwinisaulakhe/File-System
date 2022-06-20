package com.filesystem.springapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.filesystem.springapp.entities.User;
import com.filesystem.springapp.entities.UserPrincipal;
import com.filesystem.springapp.repositories.UserRepository;
import com.filesystem.springapp.serviceImpl.UserServiceImpl;


public class UserService implements UserServiceImpl {

	@Autowired
	private UserRepository loginRepository;
	
	@Override
	public UserDetails loadUserLoginByUsername (String username) throws UsernameNotFoundException {
		User user=loginRepository.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		
		return new UserPrincipal(user);
		
	}
}
