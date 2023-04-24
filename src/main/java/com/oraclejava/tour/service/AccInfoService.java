package com.oraclejava.tour.service;

import java.util.List;


import com.oraclejava.tour.model.Accommodation;
import com.oraclejava.tour.model.TourInfo;
import com.oraclejava.tour.repository.AccInfoCriteria;
import com.oraclejava.tour.repository.TourInfoCriteria;

public interface AccInfoService {

	
	List<Accommodation> searchAcc();
}
