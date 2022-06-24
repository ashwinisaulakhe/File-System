package com.filesystem.springapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.filesystem.springapp.controller.UserAlreadyExistException;
import com.filesystem.springapp.dao.UserData;
import com.filesystem.springapp.entities.UserEntity;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Long>{

	UserEntity findByEmail(String email);
	public boolean checkIfUserExist(String email);
	 public void register(UserData userData) throws UserAlreadyExistException;

}
