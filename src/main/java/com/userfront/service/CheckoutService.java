package com.userfront.service;

import java.sql.Date;
import java.util.List;

import com.userfront.domain.Book;
import com.userfront.domain.Checkout;
import com.userfront.domain.User;

public interface CheckoutService {
	Checkout createCheckout(Checkout appointment);
	List<Checkout> findAll();
	List<Checkout> findByBook(Book book);
	List<Checkout> findByUser(User user);
	List<Checkout> findByCheckedOut(Boolean out);
	List<Checkout> findByDateDueBeforeAndUser(Date date, User user);
	Checkout findCheckout(Long id);
	void confirmCheckout(Long id);
	void save(Checkout checkout);
}
