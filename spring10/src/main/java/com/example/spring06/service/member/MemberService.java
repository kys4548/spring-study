package com.example.spring06.service.member;

import javax.servlet.http.HttpSession;

import com.example.spring06.model.member.dto.MemberDTO;

public interface MemberService {
	public String loginCheck(MemberDTO dto, HttpSession session);
	public void logout(HttpSession session);
}
