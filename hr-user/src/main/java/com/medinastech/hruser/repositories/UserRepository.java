package com.medinastech.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medinastech.hruser.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String email);
}
