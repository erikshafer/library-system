package com.userfront.controller;

import java.security.Principal;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.userfront.dao.RoleDao;
import com.userfront.domain.User;
import com.userfront.domain.security.UserRole;
import com.userfront.service.AppointmentService;
import com.userfront.service.BookService;
import com.userfront.service.CheckoutService;
import com.userfront.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@Autowired
	private BookService bookService;

	@Autowired
	private CheckoutService checkoutService;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private AppointmentService appointmentService;

	@RequestMapping("/")
	public String home() {
		return "redirect:/landing";
	}

	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/login")
	public String loginRouteToUserFront() {
		return "redirect:/userFront";
	}

	@RequestMapping("/landing")
	public String landing() {
		return "landing";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signupPost(@ModelAttribute("user") User user, Model model) {

		if (userService.checkUserExists(user.getUsername(), user.getEmail())) {
			if (userService.checkEmailExists(user.getEmail())) {
				model.addAttribute("emailExists", true);
			}
			if (userService.checkUsernameExists(user.getUsername())) {
				model.addAttribute("usernameExists", true);
			}
			return "signup";
		} else {
			Set<UserRole> userRoles = new HashSet<>();
			// Standard naming convention for Spring Security. ROLE, underscore,
			// ROLE NAME in all caps.
			// This is important as it'll be the basis for user authentication.
			// "ROLE_USER" needs to be added to the `role` table otherwise
			// registration will not work.
			// 04-04-2017: I've added code to schema.sql and data.sql that will
			// take care of this.
			userRoles.add(new UserRole(user, roleDao.findByName("ROLE_USER")));
			userService.createUser(user, userRoles);
			return "redirect:/index"; // go to user profile
		}
	}

	// The 'userFront' is basically what the user sees once logged in. 
	// It's their new homepage, of sorts.
	@RequestMapping("/userFront")
	public String userFront(Principal principal, Model model) {

		User user = userService.findByUsername(principal.getName());

		java.sql.Date today = new java.sql.Date(Calendar.getInstance().getTime().getTime());

		model.addAttribute("books", bookService.findAll());
		model.addAttribute("checkedout", checkoutService.findByUser(user));
		model.addAttribute("pastdue", checkoutService.findByDateDueBeforeAndUser(today, user));
		model.addAttribute("appointments", appointmentService.findByUser(user));

		return "userFront";
	}
}
