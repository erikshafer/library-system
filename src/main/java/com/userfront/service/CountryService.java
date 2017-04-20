package com.userfront.service;

import java.util.List;

import com.userfront.domain.Country;

public interface CountryService {
	Country findById(Long id);
	Country findByName(String name);
	List<Country> findAll();
	void save (Country country);
}
