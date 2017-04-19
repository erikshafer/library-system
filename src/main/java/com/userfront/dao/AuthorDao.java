package com.userfront.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.userfront.domain.Author;

public interface AuthorDao extends CrudRepository<Author, Long> {
	Author findById(Long id);
	Author findByName(String name);
	Author findByCountry(Long id);
	// TODO: Find by country
	List<Author> findAll();
}
