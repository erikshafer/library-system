package com.userfront;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.userfront.domain.Book;

public class BookTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Checks functionality of SET ID
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

}
