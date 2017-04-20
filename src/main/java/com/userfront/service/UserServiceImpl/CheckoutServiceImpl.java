package com.userfront.service.UserServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userfront.dao.checkoutDao;
import com.userfront.domain.Checkout;

@Service
public class CheckoutServiceImpl {

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

}
