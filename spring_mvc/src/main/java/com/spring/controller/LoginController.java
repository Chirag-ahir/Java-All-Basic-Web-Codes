package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping("login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "validate", method = RequestMethod.POST)
	public String isValidUser(@RequestParam("username") String username, @RequestParam("password") String password,
			ModelMap map) {

		String page = "login";

		if (username.equalsIgnoreCase("miit") && password.equalsIgnoreCase("1234")) {
			map.addAttribute("firstname", username);
			page = "profile";
		} else {
			map.addAttribute("errorMessage", "Invalid Login credentials! Try again");
		}
		return page;
	}

}
