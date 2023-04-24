package com.oraclejava.tour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.oraclejava.tour.model.Customer;
import com.oraclejava.tour.repository.CustomerRepository;

@Component
public class EmailCheckValidator implements Validator{
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return (Customer.class).isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Customer customer = (Customer) target;
		Customer oldCustomer = customerRepository
				.findByCustomerMail(customer.getCustomerMail()).orElse(null);
		
		if (oldCustomer != null) {
			//이메일을 이미 사용하고 있다
			errors.rejectValue("customerMail", "mail.already.exists", "already exists mail");
			
		}
	}

}

















