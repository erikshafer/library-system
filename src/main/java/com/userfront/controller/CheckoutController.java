package com.userfront.controller;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.userfront.domain.Book;
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

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String createCheckout(@ModelAttribute("id") Long id, Model model) {
    	Checkout checkout = new Checkout();
    	model.addAttribute("checkout", checkout);
    	model.addAttribute("book", bookService.findById(id));
        model.addAttribute("dateString", "");

        return "checkoutConfirm";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String createCheckoutPost(@ModelAttribute("checkout") Checkout checkout, @ModelAttribute("dateString") String date, Model model, Principal principal) throws ParseException {

        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date d1 = format1.parse( date );
        checkout.setDateDue(d1);

        User user = userService.findByUsername(principal.getName());
        checkout.setUser(user);
        checkoutService.createCheckout(checkout);

        // This should go to their checked out books
        return "redirect:/books/all";
    }


}
