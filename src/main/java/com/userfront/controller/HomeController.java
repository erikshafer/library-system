package com.userfront.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.userfront.domain.BooksCheckedOut;	// TODO: fix
import com.userfront.domain.BooksInCart;		// TODO: fix
import com.userfront.domain.PrimaryAccount;
import com.userfront.domain.User;
import com.userfront.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	
	// Having nothing at the root redirects to index.
	@RequestMapping("/")
	public String home() {
		return "redirect:/index";
	}
	
	
	// Note that we do not need `value = "/index"`. This is short hand.
	@RequestMapping("/index")
    public String index() {
        return "index";
    }
	
	// Model is essentially the DOM.
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(Model model) {
        User user = new User();

        model.addAttribute("user", user);

        return "signup";
    }
	
	// ModelAttribute grabs the variable user, and gives it to the User Object (Java)
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signupPost(@ModelAttribute("user") User user,  Model model) {

		// If username and e-mail exists...
        if(userService.checkUserExists(user.getUsername(), user.getEmail()))  {

        	// If the e-mail exists... 
            if (userService.checkEmailExists(user.getEmail())) {
                model.addAttribute("emailExists", true);		// return true boolean
            }

            // If the username exists...
            if (userService.checkUsernameExists(user.getUsername())) {
                model.addAttribute("usernameExists", true);		// return true boolean
            }

            return "signup";
        } else {
        	// Else, save to database
            userService.save(user);        	// Used to be .createUser

            return "redirect:/";			// When done, redirect to the index page
        }
    }
	
//	@RequestMapping("/userFront")
//	public String userFront(Principal principal, Model model) {
//        User user = userService.findByUsername(principal.getName());
//        PrimaryAccount primaryAccount = user.getPrimaryAccount();
//        SavingsAccount savingsAccount = user.getSavingsAccount();
//
//        model.addAttribute("primaryAccount", primaryAccount);
//        model.addAttribute("savingsAccount", savingsAccount);
//
//        return "userFront";
//    }
}
