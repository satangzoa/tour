package com.oraclejava.tour.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.oraclejava.tour.model.Customer;
import com.oraclejava.tour.repository.CustomerRepository;

@Transactional//진행이 기록이 되고 자동 롤백이 된다. 다끝나면 커밋된다.
@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private CustomerRepository customerRepository;
	
	
	@Override
	public Customer findOne(int customerCode) {
		return customerRepository.findById(customerCode).orElse(null);
	}

	@Override
	public Customer register(Customer customer) {
		//TODO : 추후 비번 암호화 추가
		String old_pass = customer.getCustomerPass();
		customer.setCustomerPass(passwordEncoder.encode(old_pass));
		
		return customerRepository.save(customer);
	}
	
	
	
}



















