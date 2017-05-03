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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.userfront.domain.Book;
import com.userfront.domain.Checkout;
import com.userfront.domain.User;
import com.userfront.service.AuthorService;
import com.userfront.service.BookService;
import com.userfront.service.CheckoutService;
import com.userfront.service.CountryService;
import com.userfront.service.GenreService;
import com.userfront.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private GenreService genreService;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private CheckoutService checkoutService;
	
	@Autowired
	private UserService userService;

	// View the entire inventory
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String viewAllBooksAdmin(Model model) {
		model.addAttribute("information", "Listed below are all books owned by the library. Click on the title, author, or genre to get more information.");
		model.addAttribute("inventory", bookService.findAll());
		model.addAttribute("authors", authorService.findAll());
		model.addAttribute("genres", genreService.findAll());
		return "viewBooksAdmin";
	}
	
	// Single book view
	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	public String viewBook(@PathVariable Long id, Model model) {
		if (id == null) {
			return "redirect:/books/all";
		}
		model.addAttribute("unit", bookService.findById(id));
		return "viewBook";
	}
	
	// Single stock edit
	@RequestMapping(value = "/edit/{id}")
	public String individualBookEditAdmin(@PathVariable("id") Long id, Model model) {
		model.addAttribute("unit", bookService.findById(id));
		model.addAttribute("authors", authorService.findAll());
		model.addAttribute("genres", genreService.findAll());
		model.addAttribute("countries", countryService.findAll());
		return "editBook";
	}
	
	// New book
	@RequestMapping(value = "/add")
	public String addNewBookAdmin(Model model) {
		Book newBook = new Book();
		
		// Java 8 methodology of getting date and time
		LocalDateTime now = LocalDateTime.now();

		// Ugly code. format1 is from the initial tutorial I learned Spring MVC from while
		// formatter is what Stack Overflow suggested. Both feel over-the-top.
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		// Format everything to the proper, uh, format.
		String formatDateTime = now.format(formatter);
		Date d0;
		try {
			d0 = format1.parse(formatDateTime);
			newBook.setLastModified(d0);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		newBook.setInStock(true); 	// automatically in stock after being added
		
		model.addAttribute("unit", newBook);
		model.addAttribute("authors", authorService.findAll());
		model.addAttribute("genres", genreService.findAll());
		model.addAttribute("countries", countryService.findAll());
		return "editBook";
	}

	// Save
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book) {
		bookService.save(book);
		return "redirect:/books/available";
	}
	
	@RequestMapping(value = "/return/{id}", method = RequestMethod.GET)
	public String createCheckout(@ModelAttribute("id") Long id, Model model) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime currentDateTime = LocalDateTime.now();
		String returnString = currentDateTime.format(formatter);
		
		Checkout checkout = checkoutService.findCheckout(id);
		model.addAttribute("checkout", checkout);
		model.addAttribute("book", checkout.getBook());
		model.addAttribute("dateString", returnString);
		
		return "returnBook";
	}
	
	// Delete
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBookViaAdminController(@PathVariable("id") Long id, Model model) {
		bookService.deleteById(id);
		return "redirect:/books/all";
	}
	
	// While not necessary hard to follow, the following code is messy as it's my first true
	// foray into dealing with Date and Time in Java and SQL. - Erik
	@RequestMapping(value = "/return/save", method = RequestMethod.POST)
	public String createCheckoutPost(@ModelAttribute("checkout") Checkout checkout,
	        @ModelAttribute("dateString") String date, Model model, Principal principal) throws ParseException {
		
		// Grab book, set inStock to true, and save
		Book book = bookService.findById(checkout.getBook().getId());
		book.setInStock(true);
		bookService.save(book);
		
		// Java 8 methodology of getting date and time
		LocalDateTime now = LocalDateTime.now();

		// Ugly code. format1 is from the initial tutorial I learned Spring MVC from while
		// formatter is what Stack Overflow suggested. Both feel over-the-top.
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		// Format everything to the proper, uh, format.
		String formatDateTime = now.format(formatter);
		Date d0 = format1.parse(formatDateTime);

		// Insert details into the Checkout entity
		// Please note using Book and Checkout is not an ideal structure for any of this.
		checkout.setDateBorrowed(d0);
		checkout.setDateDue(d0);
		checkout.setDateReturned(d0);
		checkout.setCheckedOut(false);
		User user = userService.findByUsername(principal.getName());
		checkout.setUser(user);
		checkoutService.save(checkout);

		// This should go to their checked out books
		return "redirect:/books/available";
	}
	
	// View the entire inventory
	@RequestMapping(value = "/checkedout/list", method = RequestMethod.GET)
	public String viewAllBooks(Model model) {
		model.addAttribute("information", "Listed below are the books currently checked out. By clicking on a book's name on the list, you are confirming the book has been returned to the library.");
		model.addAttribute("checkedoutBooks", checkoutService.findByCheckedOut(true));
		model.addAttribute("inventory", bookService.findAll());
		model.addAttribute("users", userService.findUserList());
		return "viewCheckedout";
	}

	
}
