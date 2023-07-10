package com.mysite.common;

import java.sql.*;

public class JDBCUtill {
	// 모든 도메인(패키지) 에서 공통으로 사용 : 작업을 분리하는 바운더리
	// DB 연결하는 클래스
	
	public JDBCUtill() { // 기본 생성자
		System.out.println("JDBCUtill 클래스 호출 성공");
	}

	// 3개 메소드 모두 Static 키워드를 사용해서 객체 생성없이 클래스이름으로 바로 호출해서 사용
	
	// 1. 메소드 : DataBase 를 Connection 하는 메소드 생선
	public static Connection getConnction () {
		Connection conn=null;
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		
		try {
			Class.forName(driver);		// 해당경로에 OracleDriver 클래스가 존재하는지 확인
			conn = DriverManager.getConnection(url, "C##HR2", "1234");
			
			System.out.println("DateBase가 연결되었습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DateBase가 연결실패했습니다.");
		}
		
		return conn;
	}
	
	// 2. 메소드 : 사용한 메소드를 제거하는 메소드 (PreparedStatement, Connection)
		// Insert, Update, Delete 문을 사용했을시 
	public static void close (PreparedStatement pstmt, Connection conn) {
		
		// PreparedStatement 객체 제거
		if (pstmt != null) {	// pstmt 가 null 이 아닐때
			try {
				if (!pstmt.isClosed()) {	// pstmt 가 close 가 아닐때
					pstmt.close();
				}
				System.out.println("PreparedStatement 가 제거되었습니다.");
				
			} catch (Exception e) {
				System.out.println("PreparedStatement 가 제거중 오류발생되었습니다.");
			}
		}
		
		// Connection 객체 제거
		if (conn != null) {	// conn 가 null 이 아닐때
			try {
				if (!conn.isClosed()) {	// conn 가 close 가 아닐때
					conn.close();
				}
				System.out.println("Connection 가 제거되었습니다.");
				
			} catch (Exception e) {
				System.out.println("Connection 가 제거중 오류발생되었습니다.");
			}
		}
	}
	
	// 3. 메소드 : 사용한 메소드를 제거하는 메소드 (ResultSet, PreparedStatement, Connection)
		// Select 문일때
	public static void close (ResultSet rs, PreparedStatement pstmt, Connection conn) {
		
		// ResultSet 객체 제거
		if (rs != null) {		// rs 가 null 이 아닐때
			try {
				if (!rs.isClosed()) {		// rs 가 close 가 아닐때
					rs.close();
				}
				System.out.println("ResultSet 가 제거되었습니다.");
				
			} catch (Exception e) {
					System.out.println("ResultSet 가 제거중 오류발생되었습니다.");
			}
		}
				
		// PreparedStatement 객체 제거
		if (pstmt != null) {	// pstmt 가 null 이 아닐때
			try {
				if (!pstmt.isClosed()) {	// pstmt 가 close 가 아닐때
					pstmt.close();
				}
				System.out.println("PreparedStatement 가 제거되었습니다.");
				
			} catch (Exception e) {
				System.out.println("PreparedStatement 가 제거중 오류발생되었습니다.");
			}
		}
		
		// Connection 객체 제거
		if (conn != null) {		// conn 가 null 이 아닐때
			try {
				if (!conn.isClosed()) {		// conn 가 close 가 아닐때
					conn.close();
				}
				System.out.println("Connection 가 제거되었습니다.");
				
			} catch (Exception e) {
				System.out.println("Connection 가 제거중 오류발생되었습니다.");
			}
		}
	}
}
