package com.example.spring06.controller.member;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring06.model.member.dto.MemberDTO;
import com.example.spring06.service.member.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	private static final Logger logger=
			LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	MemberService memberService;
	
	@RequestMapping("login.do")
	public String login() {
		return "member/login";
	}
	@RequestMapping("login_check.do")
	public ModelAndView login_check(@ModelAttribute MemberDTO dto,
			HttpSession session) {
		String name=memberService.loginCheck(dto,session);

		ModelAndView mav = new ModelAndView();
		if(name !=null) {
			mav.setViewName("home");
		}else {
			mav.setViewName("member/login");
			mav.addObject("message","error");
		}
		return mav;
	}
	
	@RequestMapping("logout.do")
	public ModelAndView logout(
			HttpSession session, ModelAndView mav) {
		memberService.logout(session);
		mav.setViewName("member/login");
		mav.addObject("message","logout");
		return mav;
	}
}
