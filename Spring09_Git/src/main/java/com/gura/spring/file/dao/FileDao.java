package com.gura.spring.file.dao;



import org.springframework.web.servlet.ModelAndView;

import com.gura.spring.file.dto.FileDto;



public interface FileDao {
	public void insert(FileDto dto);
	public void delete(int num);
	public ModelAndView List();
	public FileDto getData(int num);
}
