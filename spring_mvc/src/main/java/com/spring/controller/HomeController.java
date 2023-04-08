package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String home(Model model) {
		// here we will use Model to send data to view
		model.addAttribute("name", "chirag");
		model.addAttribute("roll no", 001);
		return "home";
	}

	@RequestMapping("/about")
	public String about() {
		return "about";
	}

	@RequestMapping("/help")
	public ModelAndView help() {
		// here we will use ModelAndView to send data to view
		ModelAndView modelview = new ModelAndView();
		modelview.addObject("name", "Helping Chirag");
		modelview.addObject("id", 101);
		modelview.setViewName("help");
		return modelview;
	}

}
