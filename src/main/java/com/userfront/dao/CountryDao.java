package com.userfront.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.userfront.domain.Country;

public interface CountryDao extends CrudRepository<Country, Long> {
	Country findById(Long id);
	Country findByName(String name);
	List<Country> findAll();
}
