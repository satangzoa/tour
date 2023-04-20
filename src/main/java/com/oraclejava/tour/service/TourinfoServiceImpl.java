package com.oraclejava.tour.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oraclejava.tour.model.TourInfo;
import com.oraclejava.tour.repository.TourInfoCriteria;
import com.oraclejava.tour.repository.TourInfoRepository;

@Service
@Transactional
public class TourinfoServiceImpl implements TourinfoService{
	
	@Autowired
	private TourInfoRepository tourInfoRepository;

	@Override
	public List<TourInfo> searchTourAll() {
		return tourInfoRepository.findAll();
	}

	@Override
	public List<TourInfo> searchTour(TourInfoCriteria criteria) {
		return tourInfoRepository.findToursByCriteria(criteria);
	}
	

}












