package com.userfront;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.userfront.domain.Book;
import com.userfront.domain.Checkout;
import com.userfront.domain.User;
import com.userfront.service.UserServiceImpl.CheckoutServiceImpl;

public class RepoTest {

	@Autowired
	private CheckoutServiceImpl checkoutServiceImpl;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testCreateCheckout() throws InterruptedException {
		Thread.sleep(3000);
		Book book = new Book();
		Thread.sleep(66);
		User user = new User();
		Thread.sleep(66);
		Date d0 = new Date();
		Thread.sleep(66);
		Date d1 = new Date();
		Thread.sleep(66);
		Date d2 = new Date();
		Thread.sleep(66);
		Checkout checkout = new Checkout(1234L, book, user, d0, d1, d2, true);
		// when
		final Checkout result = checkout;
		// then
		assertEquals(checkout, result);
	}
	
	@Test
	public final void testCreateCheckoutNotNull() throws InterruptedException {
		Thread.sleep(3000);
		Book book = new Book();
		Thread.sleep(66);
		User user = new User();
		Checkout checkout = new Checkout();
		// when
		final Checkout result = checkout;
		// then
		assertNull(result);
	}
	
	@Test
	public final void testCreateBook() throws InterruptedException {
		Thread.sleep(3000);
		Book book = new Book();
		Thread.sleep(66);
		User user = new User();
		Date d1 = new Date();
		Thread.sleep(66);
		Date d2 = new Date();
		Thread.sleep(66);
		assertThat(book).isNotNull();
	}

}
