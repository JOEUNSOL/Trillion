package com.gura.spring.users.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring.users.dto.UsersDto;

// Component 스켄시 bean 으로 만들기 위한 어노테이션 
@Repository
public class UsersDaoImpl implements UsersDao{
	
	@Autowired // 의존객체를 주입 받기 위한 어노 테이션 
	private SqlSession session;
	
	@Override
	public void insert(UsersDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(UsersDto dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update(UsersDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean canUseId(String id) {
		//인자로 전달된 아이디를 DB 에서 select 해본다. 
		String selectedId=session.selectOne("users.isExistId", id);
		if(selectedId==null){//없으면
			return true;//사용가능한 아이디이다. 
		}else{
			return false;
		}
	}

}











