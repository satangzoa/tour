package com.oraclejava.tour.repository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter 
public class AccInfoCriteria {
	//Criteria 검색을 위한 클래스
	
	
	private int accomCode;// 숙박시설 코드
	private String accomName; // 숙박업소이름
	private String accomTel; //전화번호
}
