package com.userfront.controller;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.userfront.domain.Checkout;
import com.userfront.domain.User;
import com.userfront.service.BookService;
//import com.userfront.service.AppointmentService;
import com.userfront.service.CheckoutService;
import com.userfront.service.UserService;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {

	@Autowired
	private CheckoutService checkoutService;

	@Autowired
	private BookService bookService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String createCheckout(@ModelAttribute("id") Long id, Model model) {
		Checkout checkout = new Checkout();
		model.addAttribute("checkout", checkout);
		model.addAttribute("book", bookService.findById(id));
		model.addAttribute("dateString", "");
		
		boolean checkedOut = false;
//		List<Book> checkedOutBooks = bookService.findByInStock(false);
//		for (Book currentBook : checkedOutBooks) {
			if (!bookService.findById(id).isInStock()) {
				checkedOut = true;	// it's checked out
				model.addAttribute("checkedOutBook", bookService.findById(id));	// add book to model
//				break;
			}
//		}
		model.addAttribute("checkedOutBool", checkedOut);	// available or not
		return "checkoutConfirm";
	}

	// While not necessary hard to follow, the following code is messy as it's my first true
	// foray into dealing with Date and Time in Java and SQL. - Erik
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String createCheckoutPost(@ModelAttribute("checkout") Checkout checkout,
	        @ModelAttribute("dateString") String date, Model model, Principal principal) throws ParseException {

		// Double checks at transaction the book is in stock.
		// If it isn't, will re-direct to checkout which will generate
		// the not-in-stock message.
		if(!checkout.getBook().isInStock()) {
			return "redirect:/checkout/" + checkout.getBook().getId();
		}
		
		// Java 8 methodology of getting date and time
		LocalDateTime now = LocalDateTime.now();

		// Ugly code. format1 is from the initial tutorial I learned Spring MVC from while
		// formatter is what Stack Overflow suggested. Both feel over-the-top.
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		// Format everything to the proper, uh, format.
		String formatDateTime = now.format(formatter);
		Date d0 = format1.parse(formatDateTime);
		Date d1 = format1.parse(date);

		// Insert into entity.
		checkout.setDateBorrowed(d0);
		checkout.setDateDue(d1);
		checkout.setCheckedOut(true);

		// Wrap things up. Use two services.
		User user = userService.findByUsername(principal.getName());
		checkout.setUser(user);
		checkoutService.createCheckout(checkout);

		// This should go to their checked out books
		return "redirect:/books/all";
	}

}
