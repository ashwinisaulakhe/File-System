package com.filesystem.springapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.filesystem.springapp.entities.UserRegistration;

@Repository
public interface UserRegRepository extends JpaRepository<UserRegistration, Long>{

	
//	<S> S save(UserRegistration userRegistration);

	UserRegistration findByEmail(String userMailid); 
}
