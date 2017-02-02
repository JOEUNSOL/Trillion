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
		session.insert("users.insert", dto);
	}
	@Override
	public boolean isValid(UsersDto dto) {
		UsersDto resultDto=session.selectOne("users.isValid", dto);
		if(resultDto==null){//select 된 정보가 없으면
			return false;//잘못된 아이디 혹은 비밀번호 
		}else{//select 된 정보가 있으면
			return true;//맞는 정보 
		}
	}  

	@Override
	public void update(UsersDto dto) {
		session.update("users.update",dto);
		
	}

	@Override
	public void delete(String id) {
		session.delete("users.delete", id);
	}

	@Override
	public boolean canUseId(UsersDto dto) {
		//인자로 전달된 아이디를 DB 에서 select 해본다. 
		UsersDto selectedId=session.selectOne("users.isExistId",dto);
		System.out.println(selectedId);
		if(selectedId==null){//select 된 정보가 없으면
			return false;//잘못된 아이디 혹은 비밀번호 
		}else{//select 된 정보가 있으면
			return true;//맞는 정보 
		}
	}

	@Override
	public boolean canUseId2(String id) {
		//인자로 전달된 아이디를 DB 에서 select 해본다. 
		String selectedId=session.selectOne("users.isExistId2", id);
		if(selectedId==null){//없으면
				return true;//사용가능한 아이디이다. 
		}else{
			return false;
		}
	}
	@Override
	public UsersDto getData(String id) {
		UsersDto dto=session.selectOne("users.getData", id);
		return dto;
	}
	@Override
	public String getPassword(String id) {
        String password=session.selectOne("users.getPwd", id);
		
		return password;
	}

}












