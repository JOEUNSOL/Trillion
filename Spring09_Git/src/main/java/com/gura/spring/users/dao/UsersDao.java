package com.gura.spring.users.dao;

import com.gura.spring.users.dto.UsersDto;

public interface UsersDao {
	public void insert(UsersDto dto);
	public String getPassword(String id);
	public void update(UsersDto dto);
	public void delete(String id);

	public UsersDto getData(String id);
	public boolean isValid(UsersDto dto);
	public boolean canUseId(UsersDto dto);
	public boolean canUseId2(String id);
}
