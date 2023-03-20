package com.universe;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.universe.service.AddService;

@Controller

public class AddController {
	@RequestMapping("add")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
//		System.out.println("I'm here");
		String fName = request.getParameter("namaDepan");
		String lName = request.getParameter("namaBelakang");
		
//		String fullName = fName + " " + lName;
		
		AddService as = new AddService();
		String fullName = as.add(fName, lName);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display.jsp");
		mv.addObject("fullName", fullName);

		return mv;
	}
}
