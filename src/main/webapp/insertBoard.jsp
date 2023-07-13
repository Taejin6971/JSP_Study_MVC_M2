<%@page contentType="text/html; charset=UTF-8"%>

<%
	String sessionId = (String) session.getAttribute("id");
	String sessionRole = (String) session.getAttribute("role");
%>

<!DOCTYPE html>
<html>
<head>
<title>새 글 등록</title>
</head>
<body>
	<center>
		<h1>글 등록</h1>
		
		<%
			if (sessionId != null) {
		%>
		
		<%=sessionId %> 님 환영합니다. 당신은 글을 쓸수있습니다.
		
		<a href="logout.do">Log-out</a>
		<hr>
		<form action="insertBoard.do" method="post">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange" width="70">제목</td>
					<td align="left"><input type="text" name="title" /></td>
				</tr>
				<tr>
					<td bgcolor="orange">작성자</td>
					<td align="left"><input type="text" name="writer" size="10" value="<%=sessionId%>"></td>
				</tr>
				<tr>
					<td bgcolor="orange">내용</td>
					<td align="left"><textarea name="content" cols="40" rows="10"></textarea></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value=" 새글 등록 " /></td>
				</tr>
			</table>
		</form>
		<%
			} else { // session 변수가 null 일때 출력 부분
		%>
			당신은 로그인 되지 않는 상태입니다. 먼저 로그인후 글을 쓸수 있습니다.
			<br><br>
			<a href="LoginForm.jsp">로그인 하기</a>
		<%
			}
		%>
		<hr>
		<a href="getBoardList.do">글 목록 가기</a>
		<br><br>
		<a href="/JSP_Study_MVC_M2">처음으로 이동</a>
	</center>
</body>
</html>