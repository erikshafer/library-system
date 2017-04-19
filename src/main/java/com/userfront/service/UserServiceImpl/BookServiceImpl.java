package com.userfront.service.UserServiceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userfront.dao.BookDao;
import com.userfront.domain.Book;
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
	// TODO: Everything else

	@Override
	public Book findById(long id) {
		return bookDao.findById(id);
	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return bookDao.findAll();
	}
}
