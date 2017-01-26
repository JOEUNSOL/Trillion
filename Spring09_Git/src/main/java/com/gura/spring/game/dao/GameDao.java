package com.gura.spring.game.dao;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.gura.spring.game.dto.GameDto;

public interface GameDao {
	public void insert(GameDto dto);
	public List<GameDto> list();
}
