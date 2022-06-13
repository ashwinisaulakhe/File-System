package com.filesystem.springapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.filesystem.springapp.entities.Registration;

@Repository
public interface UserRepository extends JpaRepository<Registration, Long>{

}
