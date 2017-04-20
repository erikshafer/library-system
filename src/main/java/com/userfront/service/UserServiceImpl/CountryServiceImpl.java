package com.userfront.service.UserServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.userfront.dao.CountryDao;
import com.userfront.domain.Country;
import com.userfront.service.CountryService;

public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryDao countryDao; 
	
	@Override
	public Country findById(Long id) {
		return countryDao.findById(id);
	}

	@Override
	public Country findByName(String name) {
		return countryDao.findByName(name);
	}

	@Override
	public List<Country> findAll() {
		return countryDao.findAll();
	}

	@Override
	public void save(Country country) {
		countryDao.save(country);
	}

}
