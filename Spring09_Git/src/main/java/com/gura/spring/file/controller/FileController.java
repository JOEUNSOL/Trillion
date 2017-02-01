package com.gura.spring.file.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring.file.dto.FileDto;
import com.gura.spring.file.service.FileService;

@Controller
public class FileController {
	
	@Autowired
	private FileService service;
	
	// "/file/delete.do" 요청 처리
	@RequestMapping("/file/delete")
	public ModelAndView delete	(HttpServletRequest request, @RequestParam int num){
	ModelAndView mview =new ModelAndView();
	String id=  (String)request.getSession().getAttribute("id");
	if(id == null){
		mview.addObject("redirectUri", "file/fileList.do");
		mview.setViewName("alert");
	}else{
	//FileService 를 이용해서 파일을 삭제하는 작업을 한다.
		service.delete(request, num);
		mview.setViewName("file/fileList");
	}
	//리다일렉트 이동 
	return mview;
	}
	
	
	
	@RequestMapping("/file/insertform")
	public ModelAndView insertform(HttpSession session){
		ModelAndView mview =new ModelAndView();
		String id = (String)session.getAttribute("id");
		if(id == null){
			mview.setViewName("alert");
		}else{
			mview.setViewName("file/insertform");
			mview.addObject("id",id);
		}
		return mview;
	}
	@RequestMapping("/file/insert")
	public String insert(HttpServletRequest request, @ModelAttribute FileDto dto){
		ModelAndView mview =new ModelAndView();
		service.insert(request,dto); 
		
		
		return "redirect:/file/fileList.do";
	}
	@RequestMapping("/file/fileList")
	public ModelAndView list(){
		ModelAndView mview = service.list();
		mview.setViewName("file/fileList");
		return mview;
	}
	@RequestMapping("/file/download")
	public ModelAndView download(@RequestParam int num){
		ModelAndView mView=service.getData(num);
		/*
		 *  view 페키지에 DownloadView class 에 지정한
		 *  @Component("downloadView") 를 가리킨다. 
		 */
		mView.setViewName("downloadView");
		return mView;
	}
}
