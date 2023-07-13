package com.mysite.test;

import com.mysite.users.UsersDAO;
import com.mysite.users.UsersDTO;

public class Login_Test {
	public static void main(String[] args) {
		
		UsersDTO dto = new UsersDTO();
		dto.setId("user2");
		dto.setPassword("1234");
		
		UsersDAO dao = new UsersDAO();
		
		// 반환받은 user가 null 인 경우 : 인증실패
		// 반환받은 user가 null 이 아닌 경우 : 인증성공
		UsersDTO user = dao.login(dto);
		
		if (user == null) {
			System.out.println("해당 ID와 Password가 DB에 존재하지 않습니다.");
		} else {
			System.out.println("로그인 성공되었습니다.");
		}
	}
}
