package com.example.spring01;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//mybatis에서 참조하는 설정파일의 위치를 알려줌
@ContextConfiguration(locations= {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"
})
public class MybatisTest {
	private static final Logger logger =
			LoggerFactory.getLogger(MybatisTest.class);
	
	@Inject //root-context.xml 파일에 정의 메모리에 올라와있어 Inject를 이용해 바로 사용 가능
	private SqlSessionFactory sqlFactory;
	
	@Test
	public void testFactory() {
		logger.info(" "+sqlFactory);
	}
	@Test
	public void testSession() {
		try(SqlSession sqlSession = sqlFactory.openSession()){
			logger.info(" "+sqlSession);
			logger.info("mybatis 연결 성공");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
