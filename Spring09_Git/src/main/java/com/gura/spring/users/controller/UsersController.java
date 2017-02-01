package com.gura.spring.users.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring.model.email.EmailVo;
import com.gura.spring.service.email.EmailService;
import com.gura.spring.users.dto.UsersDto;
import com.gura.spring.users.service.UsersService;

@Controller
public class UsersController {
	//의존 객체 주입 되도록 
	@Autowired
	private UsersService usersService;
	
	@Inject
    EmailService emailService;
	// "/users/private/delete.do" 개인정보 삭제 요청 처리
	@RequestMapping("/users/private/delete")
	public ModelAndView authDelete(HttpSession session){
		//세션에 저장된 아이디 값을 읽어온다.
	    String id=(String)session.getAttribute("id");
		//서비스를 이용해서 DB 에서 회원정보 삭제하고
	    usersService.delete(id);
	    //세션에 로그인 정보 삭제
	    session.invalidate();
	    ModelAndView mView=new ModelAndView();
	    mView.addObject("msg", "회원 탈퇴 처리 하였습니다.");//홈으로 보내겟다 /spring
	    mView.addObject("redirectUri", session.getServletContext().getContextPath());
	    mView.setViewName("users/alert");
		return mView;
	}
	  
	// "users/private/update.do" 개인정보 수정 요청 처리
	@RequestMapping("/users/private/update")
	public ModelAndView authUpdate(@ModelAttribute UsersDto dto,HttpServletRequest request){
		usersService.update(dto);
		ModelAndView mView=new ModelAndView();
		mView.addObject("msg", dto.getId()+" 님 회원정보 수정했습니다.");
		String path=request.getContextPath()+"/users/private/info.do";
		mView.addObject("redirectUri",path );
		mView.setViewName("users/alert");
		return mView;
	}
	
	// "/users/private/updateform.do" 개인정보 수정 폼 요청 처리
	@RequestMapping("/users/private/updateform")
	public ModelAndView updateFrom(HttpSession session){
		//1. 세션에서 아이디 정보를 읽어온다.
		String id=(String)session.getAttribute("id");
		//2. 수정할 회원의 정보를 담고 있는 ModelAndView 객체를 얻어온다.
		ModelAndView mView=usersService.getData(id);
		//3. forward 이동할 정보를 담아서
		mView.setViewName("users/private/updateform");
		//4. 리턴해준다.
		return mView;
	}
	

	  
	// "/users/signout.do" 로그 아웃 요청 처리
	@RequestMapping("/users/signout")
	public ModelAndView signout(HttpSession session){
		//세션 초기화
		//session.invalidate();
		//세션에서 아이디 정보 삭제   
		session.removeAttribute("id");
		ModelAndView mView=new ModelAndView();
		mView.addObject("msg", "로그 아웃 되었습니다.");
		mView.addObject("redirectUri", 
				session.getServletContext().getContextPath());
		mView.setViewName("users/alert");
		return mView;
	}
	
	
	// "/users/signup.do" 요청처리
	@RequestMapping("/mail/signup")
	public ModelAndView signup(HttpServletRequest request,
			@ModelAttribute UsersDto dto){
		usersService.insert(dto);
		ModelAndView mView=new ModelAndView();
		mView.addObject("msg", dto.getId()+" 회원님 가입되었습니다.");
		mView.addObject("redirectUri", request.getContextPath());
		mView.setViewName("users/alert");
		
		return mView;
	}
	
	
	// "/users/signin.do" 로그인 요청 처리  
	@RequestMapping("signin")
	public ModelAndView signin(@ModelAttribute UsersDto dto,
			@RequestParam String uri, HttpSession session){
		
		//아이디가 비밀번호가 유효한지 여부를 확인한다. 
		boolean isValid=usersService.isValid(dto);
		ModelAndView mView=new ModelAndView();
		if(isValid){ //아이디 비밀번호가 맞는 정보인 경우
			//로그인 처리를 해준다.
			session.setAttribute("id", dto.getId());
			
		}
		String id = (String)session.getAttribute("id");
		
		mView=usersService.getData(id);
		//알림 페이지로 forward 이동 시킨다. 
		mView.setViewName("home");
		return mView;
	}
	
	// ajax "/users/checkid.do" 요청 처리
	@RequestMapping("/checkid")
	@ResponseBody
	public Map<String, Object> checkid(@RequestParam String inputId,@RequestParam String inputPwd){
		boolean canUse = false;
		UsersDto dto=new UsersDto();
		dto.setId(inputId);
		dto.setPwd(inputPwd);
		//아이디 사용가능 여부 
		boolean getId=usersService.isValid(dto);
		 if(getId){//사용할수 없는 아이디 라고 가정  
			canUse=true;
		}else{
			canUse=false;
		}
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("canUse", canUse);
		// Map 를 리턴해주면 응답되는 json 문자열은 
		// {"canUse":true}  or {"canUse":false} 가 된다. 
		return map;
	}
	
	// ajax "/users/checkid.do" 요청 처리
		@RequestMapping("/checkid2")
		@ResponseBody
		public Map<String, Object> checkid2(@RequestParam String inputId2){
			Map<String, Object> map=usersService.canUseId2(inputId2);
			// json 문자열 응답하기 
			return map;
		}
	
	
	@RequestMapping("/mail/write")
	public String signupForm(){
		
		return "mail/write";
	}
	

	
	  
	@RequestMapping("/send")
	@ResponseBody
	public String send(@RequestParam String senderName,@RequestParam String senderMail,
			@RequestParam String receiveMail,@RequestParam String subject,
			@RequestParam String message){
		EmailVo vo=new EmailVo();
		
	    vo.setSenderName(senderName);
		vo.setSenderMail(senderMail);
		vo.setReceiveMail(receiveMail);
		vo.setSubject(subject);
		vo.setMessage(message);
		try {
			emailService.sendMail(vo);
			//model.addAttribute("message","메일 발송되었습니다");
		} catch (Exception e) {
			e.printStackTrace();
			//model.addAttribute("message","이메일 발송 실패..");
		}
		return "home";
	}
}





















