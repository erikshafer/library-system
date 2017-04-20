package com.userfront.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.userfront.domain.Genre;

//Spring Boot automatically will create methods in the container that
//are based off of the `findBy` prefix.
//I.E. `findbyAuthor` will create an author-searching method
public interface GenreDao extends CrudRepository<Genre, Long>{
	Genre findById(Long id);
	Genre findByName(String name);
	List<Genre> findAll();
}
