package com.userfront.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.userfront.domain.Author;
import com.userfront.domain.Country;

public interface AuthorDao extends CrudRepository<Author, Long> {
	Author findById(Long id);
	Author findByName(String name);
	Author findByCountry(Country country);
	List<Author> findAll();
}
