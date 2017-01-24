package com.gura.spring.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.gura.spring.shop.dao.ShopDao;

@Component
public class ShopServiceImpl implements ShopService{
	
	//의존 객체 주입
	@Autowired
	private ShopDao shopDao;
	
	//가상의 입금 작업을 하는 메소드
	@Override
	public void deposit(String id, int money) {
		shopDao.deposit(id, money);
	}
	//가상의 구입 작업을 하는 메소드 
	
	@Transactional
	@Override
	public void buy(String id, int price) {
		//1. 구입 금액의 10% 를 포인트로 환산해서 적립하고
		int bonusPoint=(int)(price*0.1);
		shopDao.addPoint(id, bonusPoint);
		//2. 계좌 잔액을 줄이고
		shopDao.withDraw(id, price);
		//3. 배송 테이블에 배송 요청과 관련된 작업을 한다.
		shopDao.deliveryRequest();
	}

}
















