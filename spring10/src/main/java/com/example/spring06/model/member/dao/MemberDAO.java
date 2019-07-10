package com.example.spring06.model.member.dao;


import com.example.spring06.model.member.dto.MemberDTO;

public interface MemberDAO {
	public String loginCheck(MemberDTO dto);
}
