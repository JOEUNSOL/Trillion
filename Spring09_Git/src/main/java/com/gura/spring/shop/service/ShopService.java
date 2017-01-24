package com.gura.spring.shop.service;

public interface ShopService {
	public void deposit(String id, int money);
	public void buy(String id, int price);
}
