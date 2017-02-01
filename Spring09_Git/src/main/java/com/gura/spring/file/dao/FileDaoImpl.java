package com.gura.spring.file.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring.file.dto.FileDto;

@Repository
public class FileDaoImpl implements FileDao{
	
	@Autowired
	private SqlSession session;
	
	@Override
	public void insert(FileDto dto) {
		session.insert("file.insert", dto);
		
	}

	@Override
	public void delete(int num) {
		session.delete("file.delete", num);
		
	}

	@Override
	public ModelAndView List() {
		java.util.List<FileDto> list = session.selectList("file.getList");
		ModelAndView mview = new ModelAndView();
		mview.addObject("list",list);
		return mview;
	}

	@Override
	public FileDto getData(int num) {
		
		return session.selectOne("file.getData", num);
	}

}
