package com.oraclejava.tour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oraclejava.tour.model.Customer;
import com.oraclejava.tour.service.CustomerService;

@Controller
@RequestMapping(value = "/customers")
public class CostomerController {

	@Autowired 
	private CustomerService customerService;
	
	@Autowired
	private CustomerPassEqualsValidator customerPassEqualsValidator;
	
	@Autowired
	private EmailCheckValidator emailCheckValidator;
	
	//@InitBinder선언
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(customerPassEqualsValidator, emailCheckValidator);
	}
	
	
	
	
	
	
	@RequestMapping(value = "/create" , method = RequestMethod.GET)
	public String createForm(Model model) {
		model.addAttribute("customer", new Customer());
		
		return "createCustomerForm";
	}
	
	@RequestMapping(value = "/create" , method = RequestMethod.POST)
	public String create(@Validated Customer customer, BindingResult result) {//binding된 결과가 나온다 @Valid 사용해도 결과는 같다
		
		if(result.hasErrors()) {
			return "createCustomerForm";
		}
		
		customer.setRole("ROLE_USER");
		customerService.register(customer);
		
		return "redirect:/login";
	}
}





















