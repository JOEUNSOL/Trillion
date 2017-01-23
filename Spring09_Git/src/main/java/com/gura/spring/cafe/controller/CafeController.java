package com.gura.spring.cafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring.cafe.service.CafeService;

@Controller
public class CafeController {
	
	@Autowired
	private CafeService cafeService;
	
	@RequestMapping("/cafe/list")
	public ModelAndView list(){
		//글목록이 담겨 있는 ModelAndView 객체를 리턴 받는다.
		ModelAndView mView=cafeService.getList();
		//뷰페이지의 정보 설정하고
		mView.setViewName("cafe/list");
		//리턴해준다.
		return mView;
	}
}












