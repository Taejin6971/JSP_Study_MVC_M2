package com.mysite.test;

import java.sql.Connection;

import com.mysite.common.JDBCUtill;

public class JDBCUtill_Test {
	
	public static void main(String[] args) {
		
		// getConnection() : static		<== 객체화 후 호출, 클래스 이름으로 호출
		// 1. 클래스명으로 메소드 호출 : static
		Connection conn=null;
		
		conn=JDBCUtill.getConnction();
		
		// 2. 객체 생성후 메소드 호출
		Connection conn2 = null;
		
		JDBCUtill jdbc = new JDBCUtill();
		conn2 = jdbc.getConnction();
	}
}
