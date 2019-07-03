package com.example.spring01;

//import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OracleConnectionTest {
	private static final Logger  logger=
			LoggerFactory.getLogger(OracleConnectionTest.class);
	private static final String DRIVER=
			"oracle.jdbc.driver.OracleDriver";
	private static final String URL=
			"jdbc:oracle:thin:@localhost:1521/xe";
	private static final String USER="spring";
	private static final String PW="1234";
	
	//일반적으로는 별도의 파일에다가 db연결 정보를 적어두고 거기서 사용한다.


	@Test
	public void testConnection() throws Exception{
		Class.forName(DRIVER); //드라이버 로딩
		//try~ with 원래는 final을 해서 닫아주는 작업을해야하는데 없으면 자동으로 된다.
		try(Connection conn=
			DriverManager.getConnection(URL,USER,PW)){
			System.out.println("오라클에 연결되었습니다");
			logger.info("오라클에 연결");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}