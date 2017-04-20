package com.userfront.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.userfront.domain.Book;
import com.userfront.service.AuthorService;
import com.userfront.service.BookService;
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
	
	// Re-route
	@RequestMapping(value = "/")
	public String routeToAllBooksFromRoot() {
		return "redirect:/books/all";
	}

	// View the entire inventory
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String viewAllBooks(Model model) {
		model.addAttribute("inventory", bookService.findAll());
		model.addAttribute("authors", authorService.findAll());
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
		return "editBook";
	}

	// Save edit
	@RequestMapping(value = "saveEdit", method = RequestMethod.POST)
	public String saveEdit(Book book) {
		bookService.save(book);
		return "redirect:/books/all";
	}

	// Save
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(Book book) {
		bookService.save(book);
		return "redirect:/books/all";
	}
	
	// View all books in a specific genre (id)
	@RequestMapping(value = "/genre/id/{id}", method = RequestMethod.GET)
	public String viewGenres(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("inventory", bookService.findByGenre(id));
//		model.addAttribute("authors", authorService.findAll());
		return "viewBooks";
	}
	
}
