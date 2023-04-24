package com.oraclejava.tour.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oraclejava.tour.model.Accommodation;
import com.oraclejava.tour.repository.AccInfoCriteria;
import com.oraclejava.tour.repository.AccommodationRepository;

@Transactional
@Service
public class AccServiceImpl implements AccInfoService {
	
	@Autowired
	private AccommodationRepository accommodationRepository;

	@Override
	public List<Accommodation> searchAcc() {
		// TODO Auto-generated method stub
		return accommodationRepository.findAll();
	}

	


	

	

}
