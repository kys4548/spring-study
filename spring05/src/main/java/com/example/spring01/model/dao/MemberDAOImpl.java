package com.example.spring01.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.spring01.model.dto.MemberDTO;

//현재 클래스를 메모리에 자동으로 올려줌으로 @Inject를 사용해 외부에서 사용 가능
@Repository
public class MemberDAOImpl implements MemberDAO {

	private static final Logger logger=
			LoggerFactory.getLogger(MemberDAOImpl.class);
	
	@Inject //의존관계 주입
	SqlSession sqlSession;
	
	@Override
	public List<MemberDTO> memberList() {
		logger.info("memberList called...");
		//sql mapper에 작성된 sql코드가 실행됨(auto commot& close)
		return sqlSession.selectList("member.memberList");
	}

	@Override
	public void insertMember(MemberDTO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert("member.insertMember",vo);

	}

	@Override
	public MemberDTO viewMember(String userid) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("member.viewMember",userid);
	}

	@Override
	public void deleteMember(String userid) {
		// TODO Auto-generated method stub
		sqlSession.delete("member.deleteMember",userid);

	}

	@Override
	public void updateMember(MemberDTO vo) {
		// TODO Auto-generated method stub
		sqlSession.update("member.updateMember",vo);

	}

	@Override
	public boolean checkPw(String userid, String passwd) {
		// TODO Auto-generated method stub
		boolean result=false;
		Map<String,String> map = new HashMap<>();
		map.put("userid",userid);
		map.put("passwd",passwd);
		int count=sqlSession.selectOne("member.checkPw",map);
		if(count==1) result=true;
		return result;
	}

}
