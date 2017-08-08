package com.example.Controllers;

import com.example.Domain.Roles;
import com.example.Domain.user;
import com.example.Repositories.RolesRepository;
import com.example.Services.NotificationService;
import com.example.Services.OrderDetailservice;
import com.example.Services.UserServices;
import com.sun.xml.internal.messaging.saaj.util.FinalArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

@Controller
public class LoginController {
	
	@Autowired
	private UserServices userService;
	@Autowired
	private RolesRepository rolesRepository;

	@Autowired
	private OrderDetailservice orderDetailservice;

	@Autowired
    private NotificationService notificationService;

	private Logger logger = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
	public String login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return "login";
	}


	@RequestMapping(value="/registration")
	public String registration(Model model){
		user user = new user();
		model.addAttribute("user",user);
		List<Roles> allroles=rolesRepository.findAll();
		//modelAndView.addObject("roleslist",allroles);
		model.addAttribute("roleslist",allroles);
		//modelAndView.setViewName("registration");
		return "registration";
	}
	@RequestMapping("/registeract")
	public ModelAndView createNewUser(@Valid user user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		String rolee = user.getRoleselected();
		logger.info(rolee);
		user userExists = userService.findByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult
					.rejectValue("email", "error.user",
							"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {

			try {
			notificationService.sendNotificaitoin(user);
			}catch( Exception e ){
				// catch error
				logger.info("Error Sending Email: " + e.getMessage());
			}

			userService.save(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new user());
			modelAndView.setViewName("registration");
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/admin/home", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		user user = userService.findByEmail(auth.getName());
		modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
		modelAndView.setViewName("admin/home");
		return modelAndView;
	}

	@RequestMapping(value = "/allusers/{surname}", method = RequestMethod.GET)
	public String showGuestList(Model model, @PathVariable("surname") String surname) {
		model.addAttribute("userslist",userService.findByEmail(surname));
		return "User/userresults :: resultsList";
	}

	@RequestMapping(value = "/allusers", method = RequestMethod.GET)
	public String showGuestList(Model model) {
		model.addAttribute("userslist", userService.findAllUsers());
		return "User/userresults :: resultsList";
	}

	@RequestMapping(value = "/usersinfo",method = RequestMethod.GET)
	public String allusers(){
     return "User/searchuser";

	}


	@RequestMapping(value = "/access-denied",method = RequestMethod.GET)
	public String AccessDenied (){ return "notfound";}
}
