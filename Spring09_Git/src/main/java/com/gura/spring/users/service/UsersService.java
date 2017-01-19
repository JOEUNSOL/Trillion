package com.gura.spring.users.service;

import org.springframework.web.servlet.ModelAndView;

import com.gura.spring.users.dto.UsersDto;

public interface UsersService {
	public void insert(UsersDto dto);
	public ModelAndView isValid(UsersDto dto);
	public void update(UsersDto dto);
	public void delete(String id);
	public ModelAndView canUseId(String id);
}
