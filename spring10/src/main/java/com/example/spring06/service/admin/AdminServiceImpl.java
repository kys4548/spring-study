package com.example.spring06.service.admin;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.spring06.model.admin.AdminDAO;
import com.example.spring06.model.member.dto.MemberDTO;

@Service
public class AdminServiceImpl implements AdminService {

	@Inject
	AdminDAO adminDao;
	
	@Override
	public String loginCheck(MemberDTO dto) {
		// TODO Auto-generated method stub
		return adminDao.loginCheck(dto);
	}

}
