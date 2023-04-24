package com.oraclejava.tour.controller;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.oraclejava.tour.model.Customer;

// 6. 비번과 비번확인이 일치한지 체크하는 벨리데이터 작성
@Component
public class CustomerPassEqualsValidator 
	implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return (Customer.class).isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Customer customer = (Customer) target;
		//기존 비밀번호와 비밀번호 확인과 비교해서 다르면 에러를 출력
		String oldPass = customer.getCustomerPass();
		String passConfirm = customer.getCustomerPassConfirm();
		
		if (oldPass == null || passConfirm == null) {
			return;
		}
		
		if (!oldPass.equals(passConfirm)) {
			//패스워드가 서로 다르면 에러 출력
			errors.rejectValue("customerPass", 
					"NotEquals.customerPass", 
					"Password and password confirm is not same.");
		}
		
		
	}

}