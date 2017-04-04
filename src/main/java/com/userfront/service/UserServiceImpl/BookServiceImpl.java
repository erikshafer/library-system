package com.userfront.service.UserServiceImpl;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book findByIsbn(long isbn) {
		// TODO Auto-generated method stub
		return null;
	}
	// TODO: Everything else
}
