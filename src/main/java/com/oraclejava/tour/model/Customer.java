package com.oraclejava.tour.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customer") 
public class Customer { //customer 테이블
	
	@Id
	@Column(name ="customer_code")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
	@SequenceGenerator(name = "customer_seq", sequenceName = "customer_seq", allocationSize = 1)
	private int customerCode; //
	private String customerName; //이름
	private String customerPass; //비밀번호
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date customerBirth; //생년월일
	private String customerJob; //직업
	private String customerMail; //이메일
	private String customerTel; //전화번호
	private String customerPost; //우편번호
	private String customerAdd; //주소

	//권한
	private String role;
	
	@Transient//디비에서 관리하지 않는다
	private String customerPassConfirm;
}







