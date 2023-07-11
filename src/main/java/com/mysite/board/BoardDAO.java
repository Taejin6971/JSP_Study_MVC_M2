package com.mysite.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
	
	private final String BOARD_LIST = 
			"select * from board order by seq desc";

	// 1. board 테이블에 값을 넣는 메소드 : insert
		// BOARD_INSERT = "insert into board(seq, title, write, content) "
		// + "values((select nvl(max(seq),0) + 1 from board), ?, ?, ?)";
	public void insertBoard(BoardDTO dto) {
		System.out.println("===== insertBoard 기능처리 =====");
		
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

	// 2. UPDATE
	
	// 3. DELETE
	
	// 4. 상세 페이지 (GET) : 레코드 1개
	
	// 5. 리스트 페이지 (BOARD_LIST) : 레코드 여러개
		// BOARD_LIST = "select * from board order by seq desc";
	public List<BoardDTO> getBoardList(BoardDTO dto) {
		System.out.println("getBoardList 메소드 호출 - 게시판 리스트 페이지");
		// 주의 : try 블락 밖에서 선언되어야 한다.
		List<BoardDTO> boardList = new ArrayList<BoardDTO>();
		
		try {
			conn = JDBCUtill.getConnction();
			pstmt = conn.prepareStatement(BOARD_LIST);
			rs = pstmt.executeQuery();		// rs에는 select한 결과 레코드셋을 담고 있다.
			
			// rs의 값을 꺼내어 DTO에 저장
			while (rs.next()) {
				// 주의 : while 블락 내에서 DTO 객체를 생성해야 board(dto)의 heap주소가 새로생성됨.
				BoardDTO board = new BoardDTO();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setwrite(rs.getString("write"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
				
				// boardList에 DTO를 추가
				boardList.add(board);
			}
			
			System.out.println("boardList에 모든 레코드 추가 성공");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("boardList에 모든 레코드 추가 실패");
			
		} finally {
			// 사용한 객체 모두 제거
			JDBCUtill.close(rs, pstmt, conn);
		}
		
		return boardList;	// boardList : board 테이블의 각각의 레코드를 dto에 담아서 boardList에 저장.
	}
}
