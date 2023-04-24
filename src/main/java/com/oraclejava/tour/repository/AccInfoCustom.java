package com.oraclejava.tour.repository;

import java.util.List;

import com.oraclejava.tour.model.Accommodation;

public interface AccInfoCustom {

	List<Accommodation> findAccByCriteria(AccInfoCriteria criteria);
	
}
