package com.oraclejava.tour.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "accommodation") // ==> accommodation 테이블로 맵핑
public class Accommodation { // Accommodation 숙박업소 테이블 

	@Id
	@Column(name="accom_Code")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accom_seq") //generator는 여기서 사용하는 이름//generator와 아래 name은 이름이 동일해야한다
	@SequenceGenerator(name = "accom_seq", sequenceName = "accom_seq", allocationSize = 1)//sequenceName는 디비에서 사용하는 이름//name은 여기서 사용하는 이름
	private int accomCode; // 숙박시설 코드
	private String accomName; // 숙박업소이름
	private String accomTel; //전화번호
	
}
