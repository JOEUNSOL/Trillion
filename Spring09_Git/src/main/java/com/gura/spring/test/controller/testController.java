package com.gura.spring.test.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class testController {

	
	@RequestMapping("/test/test")
	public String test(){
		
		return "test/test";
	}
	@RequestMapping("/test/lab")
	@ResponseBody
	public String text(@RequestParam String text){
		
		return "incodeing 안댐시바?";
	}
}
