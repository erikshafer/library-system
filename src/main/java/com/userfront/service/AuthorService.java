package com.userfront.service;

import java.util.List;

import com.userfront.domain.Author;
import com.userfront.domain.Country;

public interface AuthorService {
	Author findById(Long id);
	Author findByName(String name);
	Author findByCountry(Country country);
	List<Author> findAll();
}
