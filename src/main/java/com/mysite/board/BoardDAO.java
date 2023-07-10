package com.mysite.board;

import java.sql.*;

import com.mysite.common.JDBCUtill;

public class BoardDAO {
	
	// DAO : Repository (JPA), DataBase를 직접 접근하는 객체
		// Insert / Update / Delete / Select <== 쿼리가 저장되어 직접 DB접근 자바 객체
	
	// 사용할 변수 선언 : private
		// Connection, PreparedStatement, ResultSet <== java.sql.*
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	// SQL 쿼리를 상수로 정의 후에 각각 필요한 메소드에서 사용
	private final String BOARD_INSERT = 
			"insert into board(seq, title, write, content) "
			+ "values((select nvl(max(seq),0) + 1 from board), ?, ?, ?)";
	
	private final String BOARD_UPDATE = "";
	private final String BOARD_DELETE = "";
	private final String BOARD_GET = "";
	private final String BOARD_LIST = "";

	// 1. board 테이블에 값을 넣는 메소드 : insert
	public void insertBoard(BoardDTO dto) {
		System.out.println("insertBoard 기능처리 ==========");
		
		try {
			conn = JDBCUtill.getConnction();	// conn 객체가 활성화 (Oracle / XE / HR2 / 1234)
			
			// prepareStatement 객체 활성화
			pstmt = conn.prepareStatement(BOARD_INSERT);	
			// ? 에 들어갈 변수의 값을 dto의 getter를 사용해서 값을 할당
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getwrite());
			pstmt.setString(3, dto.getContent());
			
			// prepareStatement 객체 실행 : DB에 값이 insert 됨
			pstmt.executeUpdate();	// insert/update/delete
			
			System.out.println("BOARD 테이블의 값이 insert 되었습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("BOARD 테이블의 값이 insert 실패했습니다.");
			
		} finally {
			//사용한 객체 제거
			JDBCUtill.close(pstmt, conn);
			
		}
		
	}
}
