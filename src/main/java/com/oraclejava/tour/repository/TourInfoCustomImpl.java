package com.oraclejava.tour.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.oraclejava.tour.model.TourInfo;

public class TourInfoCustomImpl implements TourInfoCustom{

	@PersistenceContext
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
		
		
		
		
		List<TourInfo> tourInfoList = query.getResultList();
		
		return tourInfoList;
	}

}























