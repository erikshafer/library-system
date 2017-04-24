package com.userfront.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.userfront.domain.Book;
import com.userfront.domain.Checkout;
import com.userfront.domain.User;

public interface checkoutDao extends CrudRepository<Checkout, Long>{

	List<Checkout> findAll();
	List<Checkout> findByUser(User user);
	Checkout findByBookId(Long id);
	List<Checkout> findByDateBorrowed(Date date);
	List<Checkout> findByDateDue(Date date);
	List<Checkout> findByDateReturned(Date date);

}
