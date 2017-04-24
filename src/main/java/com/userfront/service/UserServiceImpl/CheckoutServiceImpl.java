package com.userfront.service.UserServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userfront.dao.checkoutDao;
import com.userfront.domain.Book;
import com.userfront.domain.Checkout;
import com.userfront.domain.User;
import com.userfront.service.CheckoutService;

@Service
public class CheckoutServiceImpl implements CheckoutService {

	@Autowired
	private checkoutDao checkoutDao;

	public Checkout createCheckout(Checkout checkout) {
		return checkoutDao.save(checkout);
	}

	public List<Checkout> findAll() {
		return checkoutDao.findAll();
	}

	public Checkout findCheckout(Long id) {
		return checkoutDao.findOne(id);
	}

	public void confirmCheckout(Long id) {
		Checkout checkout = findCheckout(id);
		checkout.setCheckedOut(true);
		checkoutDao.save(checkout);
	}

	@Override
	public List<Checkout> findByUser(User user) {
		return checkoutDao.findByUser(user);
	}

	@Override
	public List<Checkout> findByBook(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Checkout> findByCheckedOut(Boolean out) {
		// TODO Auto-generated method stub
		return null;
	}

}
