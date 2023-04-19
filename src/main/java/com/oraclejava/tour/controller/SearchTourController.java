package com.oraclejava.tour.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.oraclejava.tour.model.TourInfo;
import com.oraclejava.tour.service.TourinfoService;



@Controller
@RequestMapping(value = "/tours")
public class SearchTourController {

	@Autowired
	private TourinfoService tourinfoService;
	
	@RequestMapping(method=RequestMethod.GET) //value를 생략하면 젤 위에 tours로 간다
	public String searchAll(Model model) {
		List<TourInfo> tours = tourinfoService.searchTourAll();
		model.addAttribute("tours", tours);
		
		return "searchTour";
	}

	
}


















