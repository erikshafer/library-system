package com.userfront.service;

import java.util.List;

import com.userfront.domain.Genre;

public interface GenreService {
	Genre findById(long id);
	Genre findByName(String name);
	List<Genre> findAll();
	void save (Genre genre);
}
