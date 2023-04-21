package com.oraclejava.tour.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import org.thymeleaf.util.StringUtils;
import com.oraclejava.tour.model.TourInfo;
import com.oraclejava.tour.repository.TourInfoCriteria;
import com.oraclejava.tour.service.TourinfoService;




@Controller
@RequestMapping(value = "/tours")
public class SearchTourController {

	@Autowired
	private TourinfoService tourinfoService;
	
	@RequestMapping(method=RequestMethod.GET) //value를 생략하면 젤 위에 tours로 간다
	public String searchAll(@RequestParam(required = false, value = "tourName")String tourName,
	
			@RequestParam(required = false, value = "tourDays") Integer tourDays,
			@RequestParam(required = false, value = "depStartDay") String depStartDay,
			@RequestParam(required = false, value = "depEndDay") String depEndDay,
			@RequestParam(required = false, value = "baseStartPrice") Integer baseStartPrice,
			@RequestParam(required = false, value = "baseEndPrice") Integer baseEndPrice
			
			,Model model) throws ParseException {
			
		
		TourInfoCriteria criteria = new TourInfoCriteria();
		
		criteria.setTourName(tourName);
		criteria.setTourDays(tourDays);
		
		criteria.setBaseStartPrice(baseStartPrice);
		criteria.setBaseEndPrice(baseEndPrice);
		
		
		//날자 포맷터
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		//StringUtils 스프링부트에 포함되어 있는 라이브러리
//		if(depStartDay != null && depEndDay != null) {
			
		if(!StringUtils.isEmpty(depStartDay) &&   !StringUtils.isEmpty(depEndDay)) {
			
		criteria.setDepStartDay(formatter.parse(depStartDay));
		criteria.setDepEndDay(formatter.parse(depEndDay));
		
		}
		
//		List<TourInfo> tours = tourinfoService.searchTourAll();
		List<TourInfo> tours = tourinfoService.searchTour(criteria);
		model.addAttribute("tours", tours);
		
		//검색값 유지
		model.addAttribute("tourName", tourName);
		model.addAttribute("tourDays", tourDays);
		
		model.addAttribute("depStartDay", depStartDay);
		model.addAttribute("depEndDay", depEndDay);
		
		
		model.addAttribute("baseStartPrice", baseStartPrice);
		model.addAttribute("baseEndPrice", baseEndPrice);
		
		return "searchTour";
	}

	
}


















