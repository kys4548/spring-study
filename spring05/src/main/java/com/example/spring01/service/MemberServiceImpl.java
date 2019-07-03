package com.example.spring01.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.spring01.model.dao.MemberDAO;
import com.example.spring01.model.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	MemberDAO memberDao;
	
	@Override
	public List<MemberDTO> memberList() {
		return memberDao.memberList();
	}

	@Override
	public void insertMember(MemberDTO dto) {
		// TODO Auto-generated method stub
		memberDao.insertMember(dto);

	}

	@Override
	public MemberDTO viewMember(String userid) {
		// TODO Auto-generated method stub
		return memberDao.viewMember(userid);
	}

	@Override
	public void deleteMember(String userid) {
		// TODO Auto-generated method stub
		memberDao.deleteMember(userid);

	}

	@Override
	public void updateMember(MemberDTO dto) {
		// TODO Auto-generated method stub
		memberDao.updateMember(dto);

	}

	@Override
	public boolean checkPw(String userid, String passwd) {
		// TODO Auto-generated method stub
		return memberDao.checkPw(userid, passwd);
	}

}
