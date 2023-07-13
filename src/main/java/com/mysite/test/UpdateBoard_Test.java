package com.mysite.test;

import com.mysite.board.BoardDAO;
import com.mysite.board.BoardDTO;

public class UpdateBoard_Test {
	public static void main(String[] args) {
		
		// DTO에 값 할당
		BoardDTO dto = new BoardDTO();
		dto.setTitle("제목 테스트14");
		dto.setContent("내용 테스트14");
		dto.setSeq(14);
		
		// DAO 에서 updateBoard(dto)
		BoardDAO dao = new BoardDAO();
		dao.updateBoard(dto);
	}
}
