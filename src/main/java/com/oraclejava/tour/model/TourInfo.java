package com.oraclejava.tour.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "tourinfo") 
public class TourInfo {

	@Id
	@Column(name="tour_code")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tourinfo_seq")
	@SequenceGenerator(name = "tourinfo_seq", sequenceName = "tourinfo_seq", allocationSize = 1)
	private int tourCode; //순번
	private String tourName; //투어이름
	private int tourDays; //여행기간
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date depDay; //출발일
	private int basePrice; //가격
	private String conductor; //안내자
	private String tourAbs; //여행내용
	//private int accomCode; //호텔아이디 fkey사용
	
	@JoinColumn(name = "accom_code", referencedColumnName = "accom_code") //referencedColumnName은 참조하는 칼럼이름
	@ManyToOne(optional = false, fetch = FetchType.LAZY ) //다대일 optional이 null값이 오면 안된다
	private Accommodation accommodation; //테이블조인
	
	
}










