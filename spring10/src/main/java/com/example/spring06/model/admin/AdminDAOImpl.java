package com.example.spring06.model.admin;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.spring06.model.member.dto.MemberDTO;

@Repository
public class AdminDAOImpl implements AdminDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public String loginCheck(MemberDTO dto) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("admin.login_check",dto);
	}

}
