package com.oraclejava.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oraclejava.tour.model.TourInfo;

public interface TourInfoRepository extends JpaRepository<TourInfo, Integer>,
		TourInfoCustom{ //Repository에서 Custom 인터페이스를 상속 추가

	
	
	
}
