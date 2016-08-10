package com.working.examples.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.working.examples.models.User;

@Controller
public class UserController {

	@RequestMapping(value="user",method=RequestMethod.GET)
	public String getUserPage(Model model){
		model.addAttribute("user",new User());
		return "user";
	};
	
	@RequestMapping(value="user",method=RequestMethod.POST)
	public String doUserAction(@ModelAttribute("user") User user){
		System.out.println(user.toString());
		return "redirect:user.html";
	};
}
