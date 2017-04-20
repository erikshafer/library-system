package com.userfront.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.userfront.service.AuthorService;
import com.userfront.service.BookService;

@Controller
@RequestMapping("/authors")
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;

	// Re-route
	@RequestMapping(value = "/")
	public String routeToAuthorAll() {
		return "redirect:/authors/all";
	}

	// View all authors
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String viewAuthorAll(Model model) {
		model.addAttribute("authors", authorService.findAll());
		return "viewAuthors";
	}

	// Single author view
	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	public String viewAuthorSingle(@PathVariable Long id, Model model) {
		if (id == null) {
			return "redirect:/authors/all";
		}
		model.addAttribute("unit", authorService.findById(id));
		return "viewAuthor";
	}

}
