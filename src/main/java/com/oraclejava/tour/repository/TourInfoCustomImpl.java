package com.oraclejava.tour.repository;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.oraclejava.tour.model.TourInfo;

public class TourInfoCustomImpl implements TourInfoCustom{

	@PersistenceContext//jpql적용위해 사용
	private EntityManager em;
	
	
	@Override
	@Transactional
	public List<TourInfo> findToursByCriteria(TourInfoCriteria criteria) {
		//쿼리 작성 
		String jpql = "SELECT  t FROM TourInfo t WHERE 1 = 1 "; //TourInfo는 엔티티를 가리킨다
		//여행이름
		if (criteria.getTourName() != null ) {
			jpql +=  " AND t.tourName LIKE :tourName  ESCAPE '\\' ";
		}
		//여행기간
		if (criteria.getTourDays() != null) {
			jpql += " AND t.tourDays = :tourDays ";//tourDays앞에 :는 파마리터를 보내기 위해 써줘야한다. 
		}
		
		//여행 출발 일
		if ( criteria.getDepStartDay() != null ) {
			if( criteria.getDepEndDay() != null ) {
				jpql += " AND t.depDay BETWEEN :depStartDay AND :depEndDay";
			}
		jpql += " AND t.depDay >= :depStartDay ";
		} 
				
		if ( criteria.getDepEndDay() != null) {
			jpql += " AND t.depDay >= :depEndDay ";
		}
		
		//여행 가격
		if ( criteria.getBaseStartPrice() != null  && criteria.getBaseEndPrice() != null) {
			jpql += " AND t.basePrice BETWEEN :baseStartPrice AND :baseEndPrice";
		}
		
		
		jpql += " ORDER BY t.depDay "; // 출발일자 순으로 정렬
		
		
		
		//_와 %가 검색되게 한다 Replace 함수는 자신이 바꾸고싶은 문자로 문자열을 치환시켜주는 기능
		TypedQuery<TourInfo> query = em.createQuery(jpql, TourInfo.class);
		if (criteria.getTourName() != null ) {
			String name = criteria.getTourName().replace("_", "\\_");
			name = name.replace("%", "\\%");
			
			query.setParameter("tourName", "%" + name + "%");
			
		}
		
		//여행기간
		if (criteria.getTourDays() != null) {
			query.setParameter("tourDays",criteria.getTourDays());
		}
		
		//여행 종료 일
		if ( criteria.getDepStartDay() != null) {
			if (criteria.getDepEndDay() != null) {
				query.setParameter("depEndDay", criteria.getDepEndDay());
		} 	
		 query.setParameter("depStartDay", criteria.getDepStartDay());
		}
		
			if (criteria.getDepEndDay() != null) {
				query.setParameter("depEndDay", criteria.getDepEndDay());
		} 	
		
//		if ( criteria.getDepStartDay() != null && criteria.getDepEndDay() != null) {
//		 query.setParameter("depStartDay", criteria.getDepStartDay());
//		 query.setParameter("depEndDay", criteria.getDepEndDay());
//		 
//		}
		
		//여행 가격
				if ( criteria.getBaseStartPrice() != null && criteria.getBaseEndPrice() != null) {
				 query.setParameter("baseStartPrice", criteria.getBaseStartPrice());
				 query.setParameter("baseEndPrice", criteria.getBaseEndPrice());
				 
				}
		
		
		
		List<TourInfo> tourInfoList = query.getResultList();
		
		return tourInfoList;
	}

}























