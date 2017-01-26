package com.gura.spring.game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring.game.dto.GameDto;
import com.gura.spring.game.service.GameService;

@Controller
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@RequestMapping("/game/list")
	public ModelAndView list(){
		
		ModelAndView mView = gameService.list();
		
		return mView;
	}
	
	@RequestMapping("/game/insert")
	public ModelAndView insert(@ModelAttribute GameDto dto){
		
		ModelAndView mView = gameService.updateScoreList(dto);
		
		
		
		return mView;
	}
}
