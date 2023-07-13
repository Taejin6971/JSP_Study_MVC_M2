<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.mysite.users.UsersDTO"%>

<%
	// 세션에 저장된 변수의 값을 불러옴.
	UsersDTO user = (UsersDTO) session.getAttribute("user");

//		out.println(user.getId()+"<br>");
//		out.println(user.getPassword()+"<br>");
//		out.println(user.getName()+"<br>");
//		out.println(user.getRole()+"<br>");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Users 상세</title>

<style>
	div {
		width: 700px;
		margin: 0 auto;
	}
	
	td {
		padding: 10px;
	}
</style>
</head>
<body>
	<div>
		<h1>user 상세 페이지</h1>

		<hr>
		<br> <br>

		<form action="updateUsers.do" method="post">
		
			<!-- 글 수정시 seq 변수 값을 서버로 전송 -->
			<input type = "hidden" name="id" value="<%=user.getId() %>">
		
			<table border="1px" cellspacing="0" cellpadding="0">
				<tr>
					<th bgcolor="orange">ID</th>
					<td><%=user.getId()%></td>
				</tr>
				<tr>
					<th bgcolor="orange">PASS</th>
					<td><input type="text" name="password" value="<%=user.getPassword()%>"></td>
				</tr>
				<tr>
					<th bgcolor="orange">NAME</th>
					<td><input type="text" name="name" value="<%=user.getName()%>"></td>					</td>
				</tr>
				<tr>
					<th bgcolor="orange">ROLE</th>
					<td><input type="text" name="role" value="<%=user.getRole()%>"></td>
				</tr>
				<tr>
					<th colspan="2"><input type="submit" value="user 수정"></th>
				</tr>
			</table>
		</form>
		
		<br><br>
		<a href = "getUsersList.do">User 목록 보기</a>
		<br><br>
		<a href = "insertUsers.jsp">User 작성</a>
		<br><br>
		<a href = "deleteUsers.do?id=<%=user.getId()%>">글 삭제</a>
		<br><br>
		<a href="/JSP_Study_MVC_M2">처음으로 이동</a>
	</div>
</body>
</html>