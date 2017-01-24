package com.gura.spring.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.gura.spring.shop.service.ShopService;

@Controller
public class ShopController {
	
	//의존 객체 주입 받기 
	@Autowired
	private ShopService shopService;
	
}











