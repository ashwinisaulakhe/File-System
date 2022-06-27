package com.filesystem.springapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.filesystem.springapp.entities.UserEntity;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Long>{


	
}
