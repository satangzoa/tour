package com.oraclejava.tour.service;

import java.util.List;

import com.oraclejava.tour.model.TourInfo;

public interface TourinfoService {
	
	//모든 여행 정보 불러오기
	List<TourInfo> searchTourAll();
	
	
}
