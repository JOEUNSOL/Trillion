package com.gura.spring.cafe.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring.cafe.dto.CafeDto;

@Repository
public class CafeDaoImpl implements CafeDao{
	
	@Autowired
	private SqlSession session;
	
	@Override
	public List<CafeDto> getList() {
		List<CafeDto> list=session.selectList("cafe.getList");
		return list;
	}

	@Override
	public void insert(CafeDto dto) {
		session.insert("cafe.insert", dto);
	}

	@Override
	public CafeDto getData(int num) {
		CafeDto dto=session.selectOne("cafe.getData", num);
		return dto;
	}

	@Override
	public void increaseViewCount(int num) {
		session.update("cafe.increaseViewCount", num);
	}

	@Override
	public void update(CafeDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int num) {
		session.delete("cafe.delete", num);
	}

}











