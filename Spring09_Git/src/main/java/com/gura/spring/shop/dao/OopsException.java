package com.gura.spring.shop.dao;

import org.springframework.dao.DataAccessException;

/*
 *  Dao 에서 발생시킬 Exception 객체를 생성할 클래스 정의하기
 *  1. DataAccessException 클래스를 상속받는다.
 *  2. 부모 생성자에 예외 메세지를 전달하는 생성자를 정의한다. 
 */
public class OopsException extends DataAccessException{

	public OopsException(String msg) {
		super(msg);
		
	}

}
