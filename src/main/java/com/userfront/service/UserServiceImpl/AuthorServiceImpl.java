package com.userfront.service.UserServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.userfront.dao.AuthorDao;
import com.userfront.domain.Author;
import com.userfront.service.AuthorService;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService{
	
	@Autowired
	private AuthorDao authorDao;

	@Override
	public Author findById(Long id) {
		return authorDao.findById(id);
	}

	@Override
	public Author findByName(String name) {
		return authorDao.findByName(name);
	}

	@Override
	public List<Author> findAll() {
		return authorDao.findAll();
	}

	@Override
	public Author findByCountry(Long id) {
		return authorDao.findByCountry(id);
	}

}
