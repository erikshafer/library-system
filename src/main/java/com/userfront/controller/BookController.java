package com.userfront.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.userfront.domain.Book;
import com.userfront.service.AuthorService;
import com.userfront.service.BookService;
import com.userfront.service.CountryService;
import com.userfront.service.GenreService;

@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private GenreService genreService;
	
	@Autowired
	private CountryService countryService;
	
	// Re-route
	@RequestMapping(value = "/")
	public String routeToAllBooksFromRoot() {
		return "redirect:/books/available";
	}

	// View the entire inventory
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String viewAllBooks(Model model) {
		model.addAttribute("information", "Listed below are all books owned by the library. Click on the title, author, or genre to get more information.");
		model.addAttribute("inventory", bookService.findAll());
		model.addAttribute("authors", authorService.findAll());
		model.addAttribute("genres", genreService.findAll());
		return "viewBooks";
	}
	
	// View the entire inventory
	@RequestMapping(value = "/available", method = RequestMethod.GET)
	public String viewAllAvailableBooks(Model model) {
		model.addAttribute("information", "Listed below are all books available in the library. Click on the title, author, or genre to get more information.");
		model.addAttribute("inventory", bookService.findByInStock(true));
		model.addAttribute("authors", authorService.findAll());
		model.addAttribute("genres", genreService.findAll());
		return "viewBooks";
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
	public String individualStockEdit(@PathVariable("id") Long id, Model model) {
		model.addAttribute("unit", bookService.findById(id));
		model.addAttribute("authors", authorService.findAll());
		model.addAttribute("genres", genreService.findAll());
		model.addAttribute("countries", countryService.findAll());
		return "editBook";
	}

	// Save edit
	@RequestMapping(value = "saveEdit", method = RequestMethod.POST)
	public String saveEdit(Book book) {
		bookService.save(book);
		return "redirect:/books/all";
	}
	
	// New book
	@RequestMapping(value = "/add")
	public String addNewBook(Model model) {
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
	
	// Delete
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBookNonAdminController(@PathVariable("id") Long id, Model model) {
		return "redirect:/admin/delete/" + id;
	}

	// Save
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book) {
		bookService.save(book);
		return "redirect:/books/all";
	}

	
}
