package com.oraclejava.tour.service;

import java.util.List;

import com.oraclejava.tour.model.TourInfo;
import com.oraclejava.tour.repository.TourInfoCriteria;

public interface TourinfoService {
	
	//모든 여행 정보 불러오기 사용하지 않을 예정
	List<TourInfo> searchTourAll();
	
	//여행 정보 검색
	List<TourInfo> searchTour(TourInfoCriteria criteria);
	
}
