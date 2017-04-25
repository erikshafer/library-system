package com.userfront.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.userfront.domain.Author;
import com.userfront.domain.Book;
import com.userfront.domain.Genre;

// Spring Boot automatically will create methods in the container that
// are based off of the `findBy` prefix.
// I.E. `findbyAuthor` will create an author-searching method
public interface BookDao extends CrudRepository<Book, Long> {
	Book findById(Long id);
	Book findByBookTitle(String bookTitle);
    List<Book> findByAuthor(Author author);			// multiple
    Book findByIsbn(Long isbn);
    List<Book> findAll();							// multiple
    List<Book> findByGenre(Genre genre);			// multiple
    List<Book> findByInStock(boolean available);	// multiple
}
