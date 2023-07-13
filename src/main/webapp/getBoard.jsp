<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.mysite.board.BoardDTO"%>

<%
	// 세션에 저장된 변수의 값을 불러옴.
	BoardDTO board = (BoardDTO) session.getAttribute("board");
	
	//	out.println(board.getSeq()+"<br>");
	//	out.println(board.getTitle()+"<br>");
	//	out.println(board.getWrite()+"<br>");
	//	out.println(board.getContent()+"<br>");
	//	out.println(board.getRegdate()+"<br>");
	//	out.println(board.getCnt()+"<br>");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세</title>

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
		<h1>글 상세 - From 태그 내부에 value 값에 출력 (수정을 바로 할수있도록)</h1>

		<hr>
		<br> <br>

		<form action="updateBoard.do" method="post">
		
			<!-- 글 수정시 seq 변수 값을 서버로 전송 -->
			<input type = "hidden" name="seq" value="<%=board.getSeq() %>">
		
			<table border="1px" cellspacing="0" cellpadding="0">
				<tr>
					<th bgcolor="orange">제목</th>
					<td><input type="text" name="title" value="<%=board.getTitle()%>"></td>
				</tr>
				<tr>
					<th bgcolor="orange">작성자</th>
					<td><%=board.getWrite()%></td>
				</tr>
				<tr>
					<th bgcolor="orange">내용</th>
					<td><textarea rows="10" cols="50" name="content"><%=board.getContent()%></textarea>
					</td>
				</tr>
				<tr>
					<th bgcolor="orange">등록일</th>
					<td><%=board.getRegdate()%></td>
				</tr>
				<tr>
					<th bgcolor="orange">조회수</th>
					<td><%=board.getCnt()%></td>
				</tr>
				<tr>
					<th colspan="2"><input type="submit" value="글 수정"></th>
				</tr>
			</table>
		</form>
		
		<br><br>
		<a href = "getBoardList.do">글 목록 보기</a>
		<br><br>
		<a href = "insertBoard.jsp">글 쓰기</a>
		<br><br>
		<a href = "deleteBoard.do?seq=<%=board.getSeq()%>&write=<%=board.getWrite()%>">글 삭제</a>
		<br><br>
		<a href="/JSP_Study_MVC_M2">처음으로 이동</a>
	</div>
</body>
</html>