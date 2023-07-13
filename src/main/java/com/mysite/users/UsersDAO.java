package com.mysite.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysite.board.BoardDTO;
import com.mysite.common.JDBCUtill;

public class UsersDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private final String USERS_INSERT = 
			"insert into users(id, password, name, role) " + "values(?, ?, ?, ?)";
	
	private final String USERS_UPDATE = 
			"update users set password = ?, name = ?, role = ? where id=?";
	
	private final String USERS_GET = 
			"select * from users where id=?";

	private final String USERS_LIST = 
			"select * from users order by id desc";

	// 1. users 테이블의 값을 넣는 메소드
		// USERS_INSERT = "insert into users(id, password, name, role) " + "values(?, ?, ?, ?)";
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
		// USERS_LIST = "select * from users order by id desc";
	public List<UsersDTO> getUsersList(UsersDTO dto) {

		List<UsersDTO> usersList = new ArrayList<UsersDTO>();

		try {
			conn = JDBCUtill.getConnction();
			pstmt = conn.prepareStatement(USERS_LIST);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				UsersDTO user = new UsersDTO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
				
				usersList.add(user);
				
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
	
	// 3. 상세 페이지
		// USERS_GET = "select * from users where id=?";
	public UsersDTO getUsers(UsersDTO dto) {
		UsersDTO user = new UsersDTO();
		
		try {
			conn = JDBCUtill.getConnction();
			pstmt = conn.prepareStatement(USERS_GET);
			
			pstmt.setString(1, dto.getId());
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
			}
			System.out.println("Users 테이블에서 상세레코드가 처리되었습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Users 테이블에서 상세레코드가 처리실패했습니다.");
			
		} finally {
			JDBCUtill.close(rs, pstmt, conn);
		}
		
		return user;
	}
	
	// 4. update
		// USERS_UPDATE = "update users set password = ?, name = ?, role = ? where id=?";
	public void updateUsers(UsersDTO dto) {
		System.out.println("updateBoard 메소드 호출");
		
		try {
			conn = JDBCUtill.getConnction();
			pstmt = conn.prepareStatement(USERS_UPDATE);
			
			pstmt.setString(1, dto.getPassword());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getRole());
			pstmt.setString(4, dto.getId());
			
			pstmt.executeUpdate();
			
			System.out.println("update 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("update 실패");
		} finally {
			JDBCUtill.close(pstmt, conn);;
		}
	}
	
}
