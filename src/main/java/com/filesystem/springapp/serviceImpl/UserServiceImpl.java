package com.filesystem.springapp.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.filesystem.springapp.entities.User;
import com.filesystem.springapp.entities.UserPrincipal;
import com.filesystem.springapp.repositories.UserRepository;
import com.filesystem.springapp.services.UserService;

@Service
@Component
public class UserServiceImpl implements UserService {

	@Autowired(required=false)
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

