package com.filesystem.springapp.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {
	
	UserDetails loadUserLoginByUsername(String username) throws UsernameNotFoundException;
}
