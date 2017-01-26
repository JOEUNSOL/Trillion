package com.gura.spring.game.service;

import org.springframework.web.servlet.ModelAndView;

public interface GameService {
	public ModelAndView list();
	public void updateScoreList(String id , int score);
}
