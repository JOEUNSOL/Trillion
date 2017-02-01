package com.gura.spring.controller.email;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gura.spring.model.email.EmailVo;
import com.gura.spring.service.email.EmailService;
import com.gura.spring.users.dto.UsersDto;

@Controller
@RequestMapping("/*")
public class EmailController {
    @Inject
    EmailService emailService;
	
	@RequestMapping("write.do")
	public String write(){
		return "/email/write";
	}
	@RequestMapping("/")
	@ResponseBody
	public String send(@RequestParam String senderName,@RequestParam String senderMail
			,@RequestParam String subject,@RequestParam String message,@RequestParam String receiveMail){
		EmailVo vo=new EmailVo();
		vo.setMessage(message);
		vo.setSenderMail(senderMail);
	    vo.setReceiveMail(receiveMail);
		vo.setSubject(subject);
		vo.setSenderName(senderName);
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
