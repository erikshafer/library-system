package com.userfront.service.UserServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.userfront.dao.GenreDao;
import com.userfront.domain.Genre;
import com.userfront.service.GenreService;

@Service
@Transactional
public class GenreServiceImpl implements GenreService {
	
	@Autowired
	private GenreDao genreDao;

	@Override
	public Genre findById(long id) {
		return genreDao.findById(id);
	}

	@Override
	public Genre findByName(String name) {
		return genreDao.findByName(name);
	}

	@Override
	public List<Genre> findAll() {
		return genreDao.findAll();
	}

	@Override
	public void save(Genre genre) {
		genreDao.save(genre);
	}
	
}
