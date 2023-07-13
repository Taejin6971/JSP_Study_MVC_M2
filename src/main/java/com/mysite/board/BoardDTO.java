package com.mysite.board;

import java.sql.Date;

public class BoardDTO {

	// DTO (VO) : 데이터를 받아서 전송해주는 객체
		// 1. 모든 접근 제어자는 private 로 설정.
		// 2. DataBase 테이블의 컬럼명을 변수명으로 사용.
		// 3. 변수의 자료형도 DataBase 테이블의 컬럼명의 자료형과 같게 생성.
		// 4. Getter / Setter
		// 5. 기본생성자

		// ROMBOK 어노테이션을 이용해서 Getter / Setter / 기본생성자 를 자동으로 생성
	
	// DAO : DataBase를 Insert / Update / Delete / Select 쿼리를 가지고있는 객체

	// MVC M2 : <== MVC로 개발
	
	// Client ==== DTO ====> Controller ==== DTO ====> DAO <====> DataBase
	
	// Board 테이블에 각 컬럼에 값을 저장할 DTO 생성
	private int seq;
	private String title;
	private String write;
	private String content;
	private Date regdate;
	private int cnt;
	
	// 기본 생성자
	public void BoardDTO() {}
	
	// getter / setter 생성
	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWrite() {
		return write;
	}

	public void setWrite(String write) {
		this.write = write;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	// toString 오버라이딩 객체 자체를 출력시 필드의 내용을 출력
	@Override
	public String toString() {
		return "BoardDTO [seq=" + seq + ", title=" + title + ", write=" + write + ", content=" + content
				+ ", regdate=" + regdate + ", cnt=" + cnt + "]";
	}

}
