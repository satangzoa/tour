package com.oraclejava.tour.repository;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TourInfoCriteria {
	//Criteria 검색을 위한 클래스
	
	private String tourName; //투어이름
	private Integer tourDays; //여행기간
	private Date depDay; //출발일
	private int basePrice; //가격
	private String conductor; //안내자
	private String tourAbs; //여행내용
	
	
}
