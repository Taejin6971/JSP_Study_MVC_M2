package com.mysite.board;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BoardDTO2 {
	
	/*
		ROMBOK : 1. 라이브러리 등록 : webapp/WEB-INF/lid/lombok.jar
				 2. 리클립스 재부팅
				 3. 클래스 상단에 어노테이션 등록
					@Getter				:
					@Setter				:
					@NoArgsConstructor	: 기본생성자
					@ToString			: ToString 메소드 오버라이딩
					
					@Data : 모든걸 한꺼번에 생성
	*/
	
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regdate;
	private int cnt;
	
}
