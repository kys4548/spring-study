package com.example.spring06.controller.admin;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring06.model.member.dto.MemberDTO;
import com.example.spring06.service.admin.AdminService;

@Controller
@RequestMapping("/admin/*")
public class adminController {

	@Inject
	AdminService adminService;
	
	@RequestMapping("login.do")
	public String login() {
		return "admin/login";
	}
	
	@RequestMapping("login_check.do")
	public ModelAndView login_check(@ModelAttribute MemberDTO dto,
			HttpSession session, ModelAndView mav) {
		String name=adminService.loginCheck(dto);
		if(name !=null) { //로그인 성공
			session.setAttribute("admin_userid",dto.getUserid());
			session.setAttribute("admin_name",name);
			//관리자 정보
			
			session.setAttribute("userid",dto.getUserid());
			session.setAttribute("name",name);
			//관리자페이지 뿐만 아니라 모든 페이지를 보기 위해
			
			mav.setViewName("admin/admin");
			mav.addObject("message","success");
		}else {
			mav.setViewName("admin/login");
			mav.addObject("message","error");
		}
		return mav;
	}
	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/admin/login.do";
	}
}
