package com.gura.spring.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// /users/private/하위의 모든 요청에 대해서 이 Filter 가 동작하도록 
// /cafe/private/하위의 모든 요청에 대해서 이 Filter 가 동작하도록 
@WebFilter({"/users/private/*","/cafe/private/*"})
public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, 
			FilterChain chain)
			throws IOException, ServletException {
		//원래 type 으로 casting 
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)res;
		
		//HttpSession 객체
		HttpSession session=request.getSession();
		
		//Context name 읽어오기 
		String contextPath=request.getContextPath();
		
		//원래 요청 uri 정보 얻어오기
		String uri=request.getRequestURI();
		
		//세션에 로그인 정보가 있는지 여부를 확인해서 
		if(session.getAttribute("id")==null){
			String path=contextPath+"/users/signin_form.do?uri="+uri;
			System.out.println(path);
			//로그인 페이지로 이동 시킨다.
			response.sendRedirect(path);
		}else{
			//원래 하려던 작업 진행 시키기 
			chain.doFilter(req, res);
		}		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
