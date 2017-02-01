package com.gura.spring.file.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.gura.spring.file.dto.FileDto;

public interface FileService {
	public void insert(HttpServletRequest request, FileDto dto);
	public ModelAndView list();
	public void delete(HttpServletRequest request, int num);
	public ModelAndView getData(int num);
}
