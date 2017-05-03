package com.userfront.service.UserServiceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userfront.dao.BookDao;
import com.userfront.domain.Author;
import com.userfront.domain.Book;
import com.userfront.domain.Genre;
import com.userfront.service.BookService;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;

	@Override
	public Book findByTitle(String title) {
		return bookDao.findByBookTitle(title);
	}

	@Override
	public Book findByIsbn(long isbn) {
		return bookDao.findByIsbn(isbn);
	}

	@Override
	public Book findById(long id) {
		return bookDao.findById(id);
	}

	@Override
	public List<Book> findAll() {
		return bookDao.findAll();
	}

	@Override
	public void save(Book book) {
		bookDao.save(book);

	}

	@Override
	public List<Book> findByGenre(Genre genre) {
		return bookDao.findByGenre(genre);
	}

	@Override
	public List<Book> findByAuthor(Author author) {
		return bookDao.findByAuthor(author);
	}

	@Override
	public List<Book> findByInStock(boolean available) {
		return bookDao.findByInStock(available);
	}

	@Override
	public void deleteById(long id) {
		bookDao.delete(id);
	}

}
