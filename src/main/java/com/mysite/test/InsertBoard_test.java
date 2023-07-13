package com.mysite.test;

import com.mysite.board.BoardDAO;
import com.mysite.board.BoardDTO;

public class InsertBoard_test {
	public static void main(String[] args) {
		
		// 1. DTO 객체 생성후 Setter에 값을 주입
		
		// DTO 객체생성
		BoardDTO dto = new BoardDTO();
		
		// setter를 사용해 필드값 입력
		dto.setTitle("글 제목을 입력 합니다. -5");
		dto.setWrite("admin");
		dto.setContent("글 내용 입니다. -5");
				
		// 2. DAO 객체 생성후 insertBoard(dto) 호출	<== DB에 insert
		
		// DAO 객체생성
		BoardDAO dao = new BoardDAO();
		
		// dao 객체의 insert() 호출시 dto를 매개변수로 던짐
		dao.insertBoard(dto);	// DB에 값이 insert 됨.
		
	}
}
