package com.gura.spring.talk.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TalkController {

	
	@RequestMapping()
	public ModelAndView talk(HttpServletRequest request){
		request.getLocalAddr();
		ModelAndView mview = new ModelAndView(); 
		return mview;
	}
}
