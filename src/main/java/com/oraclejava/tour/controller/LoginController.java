package com.oraclejava.tour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
//
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public ModelAndView login(Model model) {
//		
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("loginPage");
//		return mav;
//	}
	
	@RequestMapping( method = RequestMethod.GET)
	public String login() {
		
		return "loginPage";
	}
	

	
	
}
