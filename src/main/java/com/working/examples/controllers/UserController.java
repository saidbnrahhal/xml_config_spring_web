package com.working.examples.controllers;

import java.util.List;

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
	
	@Autowired
	UserService userService ;
	
	
	@RequestMapping(value="user",method=RequestMethod.GET)
	public String getUserPage(Model model){
		List<User> users =userService.getAllUsers();
		model.addAttribute("users",users);
		model.addAttribute("user",new User());
		return "user";
	};
	
	@RequestMapping(value="user",method=RequestMethod.POST)
	public String doUserAction(@ModelAttribute("user") User user){
		userService.addUser(user);
		return "redirect:user.html";
	};
	
}
