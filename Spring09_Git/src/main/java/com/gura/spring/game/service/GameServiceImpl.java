package com.gura.spring.game.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring.game.dao.GameDao;
import com.gura.spring.game.dto.GameDto;

@Component
public class GameServiceImpl implements GameService {

	//�쓽議� 媛앹껜 二쇱엯
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
	public ModelAndView updateScoreList(GameDto dto) {
		
		gameDao.insert(dto);
		
		List<GameDto> list = gameDao.list();
		 
		 ModelAndView mView = new ModelAndView();
		 mView.addObject("list", list);
		 mView.setViewName("game/main");
		
		
		return mView;
	}

	

}
