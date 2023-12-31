<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import = "java.util.*" %>
<%@ page import = "com.mysite.users.UsersDTO" %>

<%
	// session에 저장된 값을 꺼낸다.
	List<UsersDTO> usersList = new ArrayList<UsersDTO>();
	
	usersList = (List) session.getAttribute("usersList");
%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>users 목록</title>
<style>
	div {
		width: 700px;
		margin: 0 auto;
	}
</style>
</head>
<body>
	<div>
		<h1>users 목록</h1>

		<table border="1px" cellpading="0" cellspacing="0" width="700px">
			<tr>
				<th bgcolor="orange" width="100px">ID</th>
				<th bgcolor="orange" width="200px">PASS</th>
				<th bgcolor="orange" width="150px">NAME</th>
				<th bgcolor="orange" width="150px">ROLE</th>
			</tr>

			<!-- DB의 값을 가져와서 루프 시작 -->
			<%
				for (UsersDTO k : usersList) {
					
			%>
			<tr>
				<td><%=k.getId() %></td>
				<td><%=k.getPassword() %></td>
				<td>
				<a href = "getUsers.do?id=<%=k.getId()%>">
				<%=k.getName() %>
				</a>
				</td>
				<td><%=k.getRole() %></td>
			</tr>
			<%
				};
				session.removeAttribute("usersList");
			%>
			<!-- 루프 종료 -->
			
		</table>
		<br><br>
		<a href="insertUsers.jsp">새 글 등록</a><p/>
		<a href="/JSP_Study_MVC_M2">처음으로 이동</a>
	</div>
</body>
</html>