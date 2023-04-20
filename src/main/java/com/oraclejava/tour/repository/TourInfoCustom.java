package com.oraclejava.tour.repository;

import java.util.List;

import com.oraclejava.tour.model.TourInfo;

public interface TourInfoCustom {
	// Custom 인터페이스 => Criteria를 활용하여 실제 검색을 수행하는 메서드 정의
	
	List<TourInfo> findToursByCriteria(TourInfoCriteria criteria);//매개변수로 TourInfoCriteria를 준다
	
}
