<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String sessionId = (String) session.getAttribute("id");
	String sessionRole = (String) session.getAttribute("role");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
</head>
<body>
	<%
		if (sessionRole.equals("Admin")){
	%>
	<h1>이 페이지는 관리자만 접근 할수있는 페이지 입니다.</h1>
	<%
		} else if (sessionRole.equals("User")){
	%>
	<h1>이 페이지는 일반유저는 접근할수 없는 페이지 입니다.</h1>
	<%
		}
	%>
</body>
</html>