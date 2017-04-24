package com.working.examples.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.working.examples.models.User;
import com.working.examples.services.UserService;

@Controller
public class UserController {
	
	private static final Logger LOGGER =LoggerFactory.getLogger(UserController.class);
	@Autowired
	UserService userService ;
	
	
	@RequestMapping(value="user",method=RequestMethod.GET)
	public String getUserPage(Model model){
		List<User> users =userService.getAllUsers();
		model.addAttribute("users",users);
		model.addAttribute("user",new User());
		LOGGER.debug("getting all the user");
		return "user";
	};
	
	@RequestMapping(value="user",method=RequestMethod.POST)
	public String doUserAction(@ModelAttribute("user") User user){
		userService.addUser(user);
		LOGGER.debug("adding a new user"+user.toString());
		return "redirect:user.html";
	};
	
}
