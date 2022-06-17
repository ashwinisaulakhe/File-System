package com.filesystem.springapp.serviceImpl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserLoginServiceImpl {

	UserDetails loadUserLoginByUsername(String username) throws UsernameNotFoundException;

}
