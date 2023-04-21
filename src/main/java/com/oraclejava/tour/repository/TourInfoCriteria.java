package com.oraclejava.tour.repository;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TourInfoCriteria {
	//Criteria 검색을 위한 클래스
	
	private String tourName; //투어이름
	private Integer tourDays; //여행기간
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date depStartDay; //여행 출발일
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date depEndDay; //여행 종료일
	private Integer baseStartPrice; //가격
	private Integer baseEndPrice; //가격
	private String conductor; //안내자
	private String tourAbs; //여행내용
	
	
}
