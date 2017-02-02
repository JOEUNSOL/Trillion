package com.gura.spring.game.service;

import org.springframework.web.servlet.ModelAndView;

import com.gura.spring.game.dto.GameDto;

public interface GameService {
	public ModelAndView list();
	public ModelAndView updateScoreList(GameDto dto);
}
