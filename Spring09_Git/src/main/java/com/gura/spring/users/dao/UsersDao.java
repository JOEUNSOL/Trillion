package com.gura.spring.users.dao;

import com.gura.spring.users.dto.UsersDto;

public interface UsersDao {
	public void insert(UsersDto dto);
	public boolean isValid(UsersDto dto);
	public void update(UsersDto dto);
	public void delete(String id);
	public boolean canUseId(String id);
}
