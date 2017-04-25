package com.userfront;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.userfront.controller.BookController;
import com.userfront.controller.CheckoutController;
import com.userfront.controller.HomeController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserFrontApplicationTests {

	@Autowired
	private HomeController homeController;

	@Autowired
	private BookController bookController;

	@Autowired
	private CheckoutController checkoutController;

	@Test
	public void contextLoadsGeneral() throws Exception {
		Thread.sleep(3000);
	}

	@Test
	public void contextLoadsHome() throws Exception {
		Thread.sleep(3000);
		assertThat(homeController).isNotNull();
	}

	@Test
	public void contextLoadsBook() throws Exception {
		Thread.sleep(3000);
		assertThat(bookController).isNotNull();
	}

	@Test
	public void contextLoadsCheckout() throws Exception {
		Thread.sleep(3000);
		assertThat(checkoutController).isNotNull();
	}

}
