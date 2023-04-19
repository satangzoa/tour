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
@Table(name = "reserve") 
public class Reserve { //reserve 테이블

	@Id
	@Column(name="reserveNo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reserve_seq")
	@SequenceGenerator(name = "reserve_seq", sequenceName = "reserve_seq", allocationSize = 1)
	private int reserveNo;
	//private int tourCode; //fkey
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date reserveDay;
	private int adultCount;
	private int childCount;
	//private int customerCode;//fkey
	private int sumPrice;
	private String remarks; //예약할때 쓰는 메시지
	
	@JoinColumn(name = "tour_code", referencedColumnName = "tour_code")
	@ManyToOne(optional =  false, fetch = FetchType.LAZY)
	private TourInfo  tourInfo;
	
	
	@JoinColumn(name = "customer_code", referencedColumnName = "customer_code")
	@ManyToOne(optional =  false, fetch = FetchType.LAZY)
	private Customer  customer;
	
	
}














