package com.userfront.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.userfront.service.BookService;

@Controller
@RequestMapping("/library")
public class BookController {

	@Autowired
	private BookService bookService;

	// View the entire inventory
	@RequestMapping(value = "/inventory", method = RequestMethod.GET)
	public String viewInventory(Model model) {
		model.addAttribute("inventory", bookService.findAll());
		return "inventory";
	}
	
	// Single book view
	@RequestMapping(value = "/inventory/id/{id}", method = RequestMethod.GET)
	public String viewItem(@PathVariable Long id, Model model) {
		if (id == null) {
			return "redirect:/library/inventory";
		}
		model.addAttribute("unit", bookService.findById(id));
		return "itemView";
	}

}
