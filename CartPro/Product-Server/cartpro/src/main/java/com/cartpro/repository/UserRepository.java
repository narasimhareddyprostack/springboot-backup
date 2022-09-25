package com.cartpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cartpro.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
	
}
