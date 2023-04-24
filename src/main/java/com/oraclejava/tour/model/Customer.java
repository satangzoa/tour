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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
	
	@NotEmpty//공란으로 두면 안된다는 뜻 string에만 쓰인다
//	@Column(nullable = false)//디비에서 널이 아님이 되게한다
	private String customerName; //이름
	
	@NotEmpty
	private String customerPass; //비밀번호
	
	@NotNull//공란으로 두면 안된다는 뜻 date타입일때 쓰인다
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date customerBirth; //생년월일
	
	@NotEmpty
	private String customerJob; //직업
	
	@NotEmpty
	private String customerMail; //이메일
	
	@NotEmpty
	private String customerTel; //전화번호
	
	private String customerPost; //우편번호
	private String customerAdd; //주소
	private String role;//권한
	
	@NotEmpty
	@Transient//디비에서 관리하지 않는다
	private String customerPassConfirm;
}













