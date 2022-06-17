package com.filesystem.springapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.filesystem.springapp.entities.UserLogin;
@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin, Long> {

	UserLogin findByUsername(String username);

}
