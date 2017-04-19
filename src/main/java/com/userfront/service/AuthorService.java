package com.userfront.service;

import java.util.List;

import com.userfront.domain.Author;

public interface AuthorService {
	Author findById(Long id);
	Author findByName(String name);
	// TODO: Find by country
	List<Author> findAll();
}
