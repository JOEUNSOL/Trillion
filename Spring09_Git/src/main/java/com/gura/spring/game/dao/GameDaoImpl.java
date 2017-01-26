package com.gura.spring.game.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.gura.spring.game.dto.GameDto;

@Repository
public class GameDaoImpl implements GameDao {
	
	private SqlSession session;

	@Override
	public void insert(String id, int score) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<GameDto> list() {
		List<GameDto> list = session.selectList("game.list");
		return list;
	}

}
