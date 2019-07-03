package com.example.spring01.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.spring01.model.dto.MemberDTO;
import com.example.spring01.service.MemberService;

@Controller
public class MemberController {
	private static final Logger logger=
			LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	MemberService memberService;
	
	@RequestMapping("member/list.do")
	public String memberList(Model model) {
		List<MemberDTO> list=memberService.memberList();
		logger.info("회원 목록:"+list);
		model.addAttribute("list",list);
		return "member/member_list";
	}
	@RequestMapping("member/write.do")
	public String write() {
		return "member/write";
	}
	@RequestMapping("member/insert.do")
	public String insert(@ModelAttribute MemberDTO dto) {
		memberService.insertMember(dto);
		return "redirect:/member/list.do";
	}
	@RequestMapping("member/view.do")
	public String view(@RequestParam String userid, Model model) {
		model.addAttribute("dto",memberService.viewMember(userid));
		return "member/view";
	}
	@RequestMapping("member/update.do")
	public String update(@ModelAttribute MemberDTO dto, Model model) {
		boolean result=memberService.checkPw(dto.getUserid(),dto.getPasswd());
		logger.info("비밀번호 확인:"+result);

		if(result) {
			memberService.updateMember(dto);
			return "redirect:/member/list.do";
		}else {
			MemberDTO dto2=memberService.viewMember(dto.getUserid());
			dto.setJoin_date(dto2.getJoin_date());
			model.addAttribute("dto",dto);
			model.addAttribute("message","비밀번호가 일치하지 않습니다.");
			return "member/view";
		}
	}
	
	@RequestMapping("member/delete.do")
	public String delete(@RequestParam String userid, 
			@RequestParam String passwd, Model model){
		boolean result=memberService.checkPw(userid,passwd);
		if(result) {
			memberService.deleteMember(userid);
			return "redirect:/member/list.do";
		}else {
			model.addAttribute("message", "비밀번호가 일치하지 않습니다.");
			model.addAttribute("dto",memberService.viewMember(userid));
			return "member/view";
		}
	}
	
}
