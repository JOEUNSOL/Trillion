package com.gura.spring.game.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring.game.dto.GameDto;

@Repository
public class GameDaoImpl implements GameDao {
	
	@Autowired
	private SqlSession session;

	

	@Override
	public List<GameDto> list() {
		List<GameDto> list = session.selectList("game.list");
		return list;
	}



	@Override
	public void insert(GameDto dto) {
		session.insert("game.insert", dto);
		
	}

}
