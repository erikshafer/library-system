package com.userfront.dao;

import org.springframework.data.repository.CrudRepository;

import com.userfront.domain.User;

public interface UserDao extends CrudRepository<User, Long> {
	// No contract details
	// AKA, no implementation
	// Spring Boot is "smart enough" to generate the information
	
	// When Spring Boot sees 'findBy', it will look for the following word
	// and search for it. AKA, `username` and `email`.
	// It'll create the appropriate methods in the container.
	
	User findByUsername(String username);
	User findByEmail(String email);
}
