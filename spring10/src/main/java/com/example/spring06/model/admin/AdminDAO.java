package com.example.spring06.model.admin;

import com.example.spring06.model.member.dto.MemberDTO;

public interface AdminDAO {
	public String loginCheck(MemberDTO dto);
}
