package com.gura.spring.shop.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ShopDaoImpl implements ShopDao{
	//의존 객체 주입 
	@Autowired
	private SqlSession session;
	
	@Override
	public void deposit(String id, int money) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void widthDraw(String id, int money) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPoint(String id, int point) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deliveryRequest() {
		// TODO Auto-generated method stub
		
	}

}
