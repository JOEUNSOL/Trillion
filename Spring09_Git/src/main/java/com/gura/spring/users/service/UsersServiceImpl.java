package com.gura.spring.users.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring.users.dao.UsersDao;
import com.gura.spring.users.dto.UsersDto;
// component 스켄시 bean 이 될수 있도록 
@Component 
public class UsersServiceImpl implements UsersService{
	//비밀번호 인코더 객체 
	private PasswordEncoder pEncoder=new BCryptPasswordEncoder();
	
	@Autowired
	private UsersDao usersDao;
	
	@Override
	public void insert(UsersDto dto) {
		//암호화된 비밀번호를 얻어낸다. 
		String encodedPwd=pEncoder.encode(dto.getPwd());
		//Dto 객체에 다시 넣어준다.
		dto.setPwd(encodedPwd);
		usersDao.insert(dto);
	}

	@Override
	public boolean isValid(UsersDto dto) {
		
		return usersDao.isValid(dto);
	}

	@Override
	public void update(UsersDto dto) {
		usersDao.update(dto);
	}

	@Override
	public void delete(String id) {
		usersDao.delete(id);
	}

	@Override
	public Map<String, Object> canUseId(String id) {
		//아이디 사용가능 여부를 리턴 받는다. 
		boolean canUse = usersDao.canUseId(id);
		//결과 값을 Map 에 담는다.
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("canUse", canUse);
		//Map 리턴해주기 
		return map;
	}

	@Override
	public ModelAndView getData(String id) {
		//Dao 를 이용해서 회원정보를 얻어온다.
		UsersDto dto=usersDao.getData(id);
		//ModelAndView 객체를 생성해서
		ModelAndView mView=new ModelAndView();
		//회원정보를 "dto" 라는 키값으로 담는다. (request 에 자동으로 담긴다)
		mView.addObject("dto", dto);
		//ModelAndView 객체를 리턴해준다. 
		return mView;
	}

}









