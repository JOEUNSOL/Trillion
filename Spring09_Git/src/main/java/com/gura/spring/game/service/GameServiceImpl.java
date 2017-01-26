package com.gura.spring.game.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring.game.dao.GameDao;
import com.gura.spring.game.dto.GameDto;

@Component
public class GameServiceImpl implements GameService {

	//의존 객체 주입
	@Autowired
	private GameDao gameDao;
	
	@Override
	public ModelAndView list() {
		
		 List<GameDto> list = gameDao.list();
		 
		 ModelAndView mView = new ModelAndView();
		 mView.addObject("list", list);
		 mView.setViewName("game/main");
		return mView;
	}

	@Override
	public void updateScoreList(String id, int score) {
		// TODO Auto-generated method stub
		
	}

}
