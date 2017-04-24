package com.userfront.service;

import java.util.List;

import com.userfront.domain.Checkout;
import com.userfront.domain.User;

public interface CheckoutService {
	Checkout createCheckout(Checkout appointment);

    List<Checkout> findAll();
    
    List<Checkout> findByBookId(Long bookId);
    
    List<Checkout> findByUser(User user);

    Checkout findCheckout(Long id);

    void confirmCheckout(Long id);
}
