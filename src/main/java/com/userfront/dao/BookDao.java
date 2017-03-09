package com.userfront.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.userfront.domain.Book;

// Spring Boot automatically will create methods in the container that
// are based off of the `findBy` prefix.
// I.E. `findbyAuthor` will create an author-searching method
public interface BookDao extends CrudRepository<Book, Long> {
	Book findByBookTitle(String bookTitle);
    Book findByAuthor(String author);
    Book findByIsbn(Long isbn);
    List<Book> findAll();
}