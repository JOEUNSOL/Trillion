package com.gura.spring.cafe.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring.cafe.dto.CafeDto;
import com.gura.spring.cafe.service.CafeService;

@Controller
public class CafeController {
	
	@Autowired
	private CafeService cafeService;
	
	//파라미터로 페이지 번호가 넘어올수도 있고 안넘어 올수도 있다.
	//만일 안넘어 오면 default 값으로 1 을 넣어준다. 
	@RequestMapping("/cafe/list")
	public ModelAndView list(HttpServletRequest request, @RequestParam(defaultValue="1") int pageNum){
		
		//글목록이 담겨 있는 ModelAndView 객체를 리턴 받는다.
		ModelAndView mView=cafeService.getList(request, pageNum);
		//뷰페이지의 정보 설정하고
		mView.setViewName("cafe/list");
		//리턴해준다.
		return mView;
	}
	//새글 입력 폼 요청 처리 
	@RequestMapping("/cafe/private/insertform")
	public ModelAndView authInsertForm(){
		
		return new ModelAndView("cafe/private/insertform");
	}
	
	//새글 저장 요청 처리 
	@RequestMapping("/cafe/private/insert")
	public ModelAndView authInsert(@ModelAttribute CafeDto dto){
		cafeService.insert(dto);
		return new ModelAndView("redirect:/cafe/list.do");
	}
	
	@RequestMapping("/cafe/detail")
	public ModelAndView detail(@RequestParam int num){
		ModelAndView mView=cafeService.getData(num);
		mView.setViewName("cafe/detail");
		return mView;
	}
	//글 삭제 요청 처리 
	@RequestMapping("/cafe/private/delete")
	public ModelAndView authDelete(@RequestParam int num){
		cafeService.delete(num);
		return new ModelAndView("redirect:/cafe/list.do");
	}
	//글 수정폼 요청 처리
	@RequestMapping("/cafe/private/updateform")
	public ModelAndView authUpdateform(@RequestParam int num){
		//수정할 글 정보가 담긴 ModelAndView 객체를 리턴 받는다. 
		ModelAndView mView=cafeService.updateForm(num);
		//view 페이지의 정보 설정하고  
		mView.setViewName("cafe/private/updateform");
		//리턴해주기
		return mView;
	}
	@RequestMapping("/cafe/private/update")
	public ModelAndView authUpdate(@ModelAttribute CafeDto dto){
		cafeService.update(dto);
		return new ModelAndView("redirect:/cafe/list.do");
	}
}
































