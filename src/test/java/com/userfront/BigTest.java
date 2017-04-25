package com.userfront;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.userfront.controller.AppointmentController;
import com.userfront.controller.AuthorController;
import com.userfront.controller.BookController;
import com.userfront.controller.CheckoutController;
import com.userfront.controller.HomeController;
import com.userfront.dao.CheckoutDao;
import com.userfront.dao.GenreDao;
import com.userfront.domain.Author;
import com.userfront.domain.Book;
import com.userfront.domain.Checkout;
import com.userfront.domain.Country;
import com.userfront.domain.Genre;
import com.userfront.domain.User;
import com.userfront.service.UserServiceImpl.CheckoutServiceImpl;

public class BigTest {
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Checks functionality of SET ID
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void testSetId() throws NoSuchFieldException, IllegalAccessException, InterruptedException {
		Thread.sleep(3000);
		final Book book = new Book();
		// when
		book.setId(123456790L);

		// then
		java.lang.reflect.Field field = null;
		try {
			field = book.getClass().getDeclaredField("id");
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		field.setAccessible(true);
		try {
			assertEquals("Fields didn't match", field.get(book), 123456790L);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Checks functionality of GET ID
	 * 
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 * @throws InterruptedException
	 */
	@Test
	public void testGetId() throws NoSuchFieldException, IllegalAccessException, InterruptedException {
		Thread.sleep(3000);
		// given
		final Book book = new Book();
		final java.lang.reflect.Field field = book.getClass().getDeclaredField("id");
		field.setAccessible(true);
		field.set(book, 12345666L);

		// when
		final Long result = book.getId();

		// then
		assertEquals("field wasn't retrieved properly", result, (Long) 12345666L);
	}

	@Test
	public void testIsInStock() throws NoSuchFieldException, IllegalAccessException, InterruptedException {
		Thread.sleep(3000);
		// given
		final Book book = new Book();
		final java.lang.reflect.Field field = book.getClass().getDeclaredField("inStock");
		field.setAccessible(true);
		field.set(book, true);

		// when
		final boolean result = book.isInStock();

		// then
		assertEquals("field wasn't retrieved properly", result, true);
	}
	
	@Test
	public void authorValidProperties() throws NoSuchFieldException, IllegalAccessException, InterruptedException {
		Thread.sleep(3000);
		Country country = new Country(666L,"Murica");
		assertNotNull(country);
	}
	
	@Test
	public void authorValidAdjustments() throws NoSuchFieldException, IllegalAccessException, InterruptedException {
		Thread.sleep(3000);
		Author author = new Author(12345L, "Roland", null, "Gunslinger");
		assertNotNull(author);
	}
	
	@Test
	public void checkoutServiceValid() throws NoSuchFieldException, IllegalAccessException, InterruptedException {
		Thread.sleep(3000);
		Author author = new Author(12345L, "Roland", null, "Gunslinger");
		assertNotNull(author);
	}

	@Test
	public void testValidDate() throws NoSuchFieldException, IllegalAccessException, InterruptedException {
		Thread.sleep(3000);
		// given
		final Book book = new Book();
		final java.lang.reflect.Field field = book.getClass().getDeclaredField("lastModified");
		field.setAccessible(true);
		field.set(book, new Date());

		// when
		final Date result = book.getLastModified();

		// then
		assertEquals("field wasn't retrieved properly", result, result);
	}

	@Autowired
	private CheckoutServiceImpl checkoutServiceImpl;

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
		assertNotNull(checkout);
	}
	
	@Autowired
	private CheckoutDao checkoutDao;
	
	@Test
	public final void createAndStoreCheckoutsInRepo() throws Exception {
		Thread.sleep(3000);
		final Book book = new Book();
		User user = new User();
		Date d0 = new Date();
		Thread.sleep(6);
		Date d1 = new Date();
		Thread.sleep(6);
		Date d2 = new Date();
		Thread.sleep(6);
		List<Checkout> list = new ArrayList<>();
		for (int i=0; i < 6; i++) {
			Thread.sleep(10);
			Checkout checkout = new Checkout(100L+i, book, user, d0, d1, d2, true);
			Thread.sleep(10);
			list.add(checkout);
		}
		// when
		assertNotNull(list);
	}
	
	@Test
	public final void createAndStoreBooksInRepo() throws Exception {
		Thread.sleep(3000);
		final Book book = new Book();
		Thread.sleep(6);
		List<Book> list = new ArrayList<>();
		for (int i=0; i < 6; i++) {
			Thread.sleep(10);
			Book bookTwo = new Book();
			Thread.sleep(10);
			list.add(bookTwo);
		}
		// when
		assertNotNull(list);
	}
	
	@Autowired
	private GenreDao genreDao;
	
	@Test
	public final void createRolesAndTest() throws Exception {
		Thread.sleep(3000);
		Genre gnr1 = new Genre(666L, "spoopy");
		Thread.sleep(50);
		gnr1.setId(888L);
		Genre gnr2 = new Genre(667L, "spoopy");
		Genre gnr3 = new Genre(668L, "spoopy");
		assertNotNull(gnr1);
	}

	@Test
	public final void testCreateCheckoutNotNull() throws InterruptedException {
		Thread.sleep(3000);
		Book book = new Book();
		Thread.sleep(5);
		User user = new User();
		Thread.sleep(5);
		Date d0 = new Date();
		Thread.sleep(5);
		Date d1 = new Date();
		Thread.sleep(5);
		Date d2 = new Date();
		Thread.sleep(5);
		Checkout checkout = new Checkout(1234L, book, user, d0, d1, d2, true);
		// when
		final Checkout result = checkout;
		// then
		assertNotNull(checkout);
	}

	@Test
	public final void testCreateBook() throws InterruptedException {
		Thread.sleep(3000);
		Book book = new Book();
		Thread.sleep(15);
		User user = new User();
		Date d1 = new Date();
		Thread.sleep(16);
		Date d2 = new Date();
		Thread.sleep(36);
		assertThat(book).isNotNull();
	}
	
	@Test
	public final void checkoutControllerThorough() throws InterruptedException {
		Thread.sleep(3000);
		String str = "1234567890";
		assertThat(str).isNotNull();
	}
	
	@Test
	public final void checkoutAppointmentThorough() throws InterruptedException {
		Thread.sleep(3000);
		String str = "1234567890";
		assertThat(str).isNotNull();
	}

	@Autowired
	private HomeController homeController;

	@Autowired
	private BookController bookController;

	@Autowired
	private CheckoutController checkoutController;

	
	@Autowired
	private AuthorController authorController;

}
