package com.gura.spring.cafe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring.cafe.dao.CafeDao;
import com.gura.spring.cafe.dto.CafeDto;

@Component
public class CafeServiceImpl implements CafeService{
	//한 페이지에 나타낼 로우의 갯수
	private static final int PAGE_ROW_COUNT=5;
	//하단 디스플레이 페이지 갯수
	private static final int PAGE_DISPLAY_COUNT=5;	
	
	@Autowired
	private CafeDao cafeDao;
	
	@Override
	public ModelAndView getList(int pageNum) {
		
		//보여줄 페이지 데이터의 시작 ResultSet row 번호
		int startRowNum=1+(pageNum-1)*PAGE_ROW_COUNT;
		//보여줄 페이지 데이터의 끝 ResultSet row 번호
		int endRowNum=pageNum*PAGE_ROW_COUNT;
		//전체 row 의 갯수를 DB 에서 얻어온다.
		int totalRow = cafeDao.getCount();
		//전체 페이지의 갯수 구하기
		int totalPageCount=
				(int)Math.ceil(totalRow/(double)PAGE_ROW_COUNT);
		//시작 페이지 번호
		int startPageNum=
			1+((pageNum-1)/PAGE_DISPLAY_COUNT)*PAGE_DISPLAY_COUNT;
		//끝 페이지 번호
		int endPageNum=startPageNum+PAGE_DISPLAY_COUNT-1;
		//끝 페이지 번호가 잘못된 값이라면 
		if(totalPageCount < endPageNum){
			endPageNum=totalPageCount; //보정해준다. 
		}
		
		//시작 row 번호와 끝 row 번호를 CafeDto 에 담는다.
		CafeDto dto=new CafeDto();
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);
		
		//Dao 객체를 이용해서 글목록을 얻어온다. 
		List<CafeDto> list=cafeDao.getList(dto);
		//ModelAndView 객체를 생성해서 글목록을 담는다.
		ModelAndView mView=new ModelAndView();
		mView.addObject("list", list);
		mView.addObject("pageNum", pageNum);
		mView.addObject("startPageNum", startPageNum);
		mView.addObject("endPageNum", endPageNum);
		mView.addObject("totalPageCount", totalPageCount);
		
		//리턴해주기 
		return mView;
	}

	@Override
	public void insert(CafeDto dto) {
		cafeDao.insert(dto);
	}

	@Override
	public ModelAndView getData(int num) {
		//1. 글정보를 얻어온다.
		CafeDto dto=cafeDao.getData(num);
		//2. 조회수를 올린다.
		cafeDao.increaseViewCount(num);
		//3. 글정보를 ModelAndView 객체에 담는다.
		ModelAndView mView=new ModelAndView();
		mView.addObject("dto", dto);
		//리턴해준다.
		return mView;
	}

	@Override
	public void update(CafeDto dto) {
		cafeDao.update(dto);
	}

	@Override
	public void delete(int num) {
		cafeDao.delete(num);
	}

	@Override
	public ModelAndView updateForm(int num) {
		//수정할 글정보를 얻어온다. 
		CafeDto dto=cafeDao.getData(num);
		//수정할 글정보를 ModelAndView 객체에 담고 
		ModelAndView mView=new ModelAndView();
		mView.addObject("dto", dto);
		//리턴해준다. 
		return mView;
	}

}











