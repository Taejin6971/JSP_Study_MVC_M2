package com.mysite.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysite.common.JDBCUtill;

public class UsersDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private final String USERS_INSERT = "insert into users(id, password, name, role) " + "values(?, ?, ?, ?)";

	private final String USERS_LIST = "select * from users order by id desc";

	// 1. users 테이블의 값을 넣는 메소드
	public void insertusers(UsersDTO dto) {
		System.out.println("insert 기능");

		try {
			conn = JDBCUtill.getConnction();
			pstmt = conn.prepareStatement(USERS_INSERT);

			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getRole());

			pstmt.executeUpdate();

			System.out.println("insert 완료");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("insert 실패");

		} finally {
			JDBCUtill.close(pstmt, conn);
		}
	}

	// 2. users 테이블의 모든 레코드를 출력하는 메소드
	public List<UsersDTO> getUsersList(UsersDTO dto) {

		List<UsersDTO> usersList = new ArrayList<UsersDTO>();

		try {
			conn = JDBCUtill.getConnction();
			pstmt = conn.prepareStatement(USERS_LIST);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				UsersDTO dto1 = new UsersDTO();
				dto1.setId(rs.getString("id"));
				dto1.setPassword(rs.getString("password"));
				dto1.setName(rs.getString("name"));
				dto1.setRole(rs.getString("role"));
				
				usersList.add(dto1);
				
			}

			System.out.println("List 추가 완료");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("List 추가 실패");

		} finally {
			JDBCUtill.close(pstmt, conn);
		}

		return usersList;
	}
}
