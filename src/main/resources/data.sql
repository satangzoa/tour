insert into accommodation (accom_code, accom_name, accom_tel)
values (accom_seq.nextval,'롯데시티호텔 구로','02-5323-4565');
insert into accommodation (accom_code, accom_name, accom_tel)
values (accom_seq.nextval,'포시즌즈 인천','032-2344-4565');
insert into accommodation (accom_code, accom_name, accom_tel)
values (accom_seq.nextval,'헬로우키티 부산','051-3433-4565');
insert into accommodation (accom_code, accom_name, accom_tel)
values (accom_seq.nextval,'그랜드하야트 제주','064-9032-4565');

-- customer
insert into customer
	(customer_code,customer_name,customer_pass,
	customer_birth, customer_job,  customer_mail,  customer_tel,
	customer_post,  customer_add, role)
VALUES(customer_seq.NEXTVAL,
'장보고',
'$2y$10$8Ova4FvnUX3IbcuHul2Tz.8u4U.hT0Ph2WlANHb54gQlciiDLii.W',
'1965-09-28',
'수산업',
'fish@daum.net',
'010-1111-2222',
'12345',
'서울시 구로구 구로3동 구로맨션 101호','ROLE_USER'
);

insert into customer
	(customer_code,customer_name,customer_pass,
	customer_birth, customer_job,  customer_mail,  customer_tel,
	customer_post,  customer_add, role)
VALUES(customer_seq.NEXTVAL,
'이순신',
'$2y$10$8Ova4FvnUX3IbcuHul2Tz.8u4U.hT0Ph2WlANHb54gQlciiDLii.W',
'1970-01-30',
'군인',
'egija@naver.com',
'010-1234-5678',
'12345',
'인천시 부평구 장제로 153번길','ROLE_USER'
);

insert into customer
	(customer_code,customer_name,customer_pass,
	customer_birth, customer_job,  customer_mail,  customer_tel,
	customer_post,  customer_add, role)
VALUES(customer_seq.NEXTVAL,
'펭수',
'$2y$10$8Ova4FvnUX3IbcuHul2Tz.8u4U.hT0Ph2WlANHb54gQlciiDLii.W',
'2021-08-08',
'ebs연습생',
'peng@ebs.com',
'010-8888-8888',
'12345',
'경기도 고양시 일산동 장항동 1775','ROLE_USER'
);

insert into customer
	(customer_code,customer_name,customer_pass,
	customer_birth, customer_job,  customer_mail,  customer_tel,
	customer_post,  customer_add, role)
VALUES(customer_seq.NEXTVAL,
'ADMIN',
'$2y$10$8Ova4FvnUX3IbcuHul2Tz.8u4U.hT0Ph2WlANHb54gQlciiDLii.W',
'2021-08-08',
'관리자',
'admin@naver.com',
'010-5555-8888',
'12345',
'경기도 고양시 일산동 장항동 1775','ROLE_ADMIN'
);

--tourinfo
insert into tourinfo
(tour_code, tour_name, tour_days, dep_day, base_price, conductor, tour_abs, accom_code)
values 
	(tourinfo_seq.nextval, '괌 자유여행', 4, 
		to_date('2023-04-25', 'YYYY-MM-DD'),
		80000, '나가자','괌에서 가장 유명한 곳에서 자유롭게 여행을 즐기실 수 있습니다', 1);
insert into tourinfo
(tour_code, tour_name, tour_days, dep_day, base_price, conductor, tour_abs, accom_code)
values 
	(tourinfo_seq.nextval, '금까기 서유럽 여행', 5, 
		to_date('2024-1-25', 'YYYY-MM-DD'),
		8000000, '이시열',' 세느강 유람선 탑승권 제공!', 1);
insert into tourinfo
(tour_code, tour_name, tour_days, dep_day, base_price, conductor, tour_abs, accom_code)
values 
	(tourinfo_seq.nextval, '단체배낭 비바체 16일', 2, 
		to_date('2023-06-25', 'YYYY-MM-DD'),
		9000000, '정진숙','미국의 주요도시를 한번에 다녀오실 수 있는 즐겁고 안전한 단체배낭여행', 1);
insert into tourinfo
(tour_code, tour_name, tour_days, dep_day, base_price, conductor, tour_abs, accom_code)
values 
	(tourinfo_seq.nextval, '몰디브 홀로여행', 4, 
		to_date('2023-04-25', 'YYYY-MM-DD'),
		4500000, '신상훈','조식&석식 포함 특가, 올인클루시브 특가 제공', 1);

--reserve

insert into reserve (reserve_no, reserve_day, 
	adult_count,child_count,tour_code,customer_code, 
	sum_price,remarks)
values
	(reserve_seq.nextval, sysdate, 4, 0, 1, 1, 3200000, '잘 부탁드립니다');

insert into reserve (reserve_no, reserve_day, 
	adult_count,child_count,tour_code,customer_code, 
	sum_price,remarks)
values
	(reserve_seq.nextval, sysdate, 2, 1, 2, 1, 900000, '잘놀다 오겠습니다');

insert into reserve (reserve_no, reserve_day, 
	adult_count,child_count,tour_code,customer_code, 
	sum_price,remarks)
values
	(reserve_seq.nextval, sysdate, 5, 2, 1, 1, 3500000, '즐거운 여행 되겠습니다');

























