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

@Controller
@RequestMapping("/library")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private AuthorService authorService;
	
	// Re-route
	@RequestMapping(value = "/")
	public String routeToInventory() {
		return "redirect:/library/inventory";
	}

	// View the entire inventory
	@RequestMapping(value = "/inventory", method = RequestMethod.GET)
	public String viewInventory(Model model) {
		model.addAttribute("inventory", bookService.findAll());
		model.addAttribute("authors", authorService.findAll());
		return "inventory";
	}
	
	// Single book view
	@RequestMapping(value = "/inventory/id/{id}", method = RequestMethod.GET)
	public String viewItem(@PathVariable Long id, Model model) {
		if (id == null) {
			return "redirect:/library/inventory";
		}
		model.addAttribute("unit", bookService.findById(id));
		return "viewBook";
	}
	
	// View all authors
	@RequestMapping(value = "/authors", method = RequestMethod.GET)
	public String viewAuthors() {
		return "redirect:/authors/all";
	}
	
	// Single stock edit
	@RequestMapping(value = "/edit/{id}")
	public String individualStockEdit(@PathVariable("id") Long id, Model model) {
		model.addAttribute("unit", bookService.findById(id));
		return "editBook";
	}

	// Save edit
	@RequestMapping(value = "saveEdit", method = RequestMethod.POST)
	public String saveEdit(Book book) {
		bookService.save(book);
		return "redirect:/library/inventory";
	}

	// Save
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(Book book) {
		bookService.save(book);
		return "redirect:/library/inventory";
	}
	
	// View all books in a specific genre (id)
	@RequestMapping(value = "/genre/id/{id}", method = RequestMethod.GET)
	public String viewGenres(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("inventory", bookService.findByGenre(id));
//		model.addAttribute("authors", authorService.findAll());
		return "inventory";
	}
	
}
