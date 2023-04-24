package com.oraclejava.tour.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.oraclejava.tour.model.Accommodation;
import com.oraclejava.tour.repository.AccInfoCriteria;
import com.oraclejava.tour.service.AccInfoService;

@Controller
public class SearchAccController {

	@Autowired
	private AccInfoService accInfoService;
	
	
	@RequestMapping( value="/searchAcc" ,method=RequestMethod.GET)
	public String searchAll(
			
		
		
		Model model) throws ParseException {
		
		AccInfoCriteria criteria = new AccInfoCriteria();
		
		
		
		
		List<Accommodation> accommodation = accInfoService.searchAcc();
		
		model.addAttribute("accommodation", accommodation);
		
		
		return "searchAcc";
	}
	
	
}
