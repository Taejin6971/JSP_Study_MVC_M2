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
<title>관리자 상품 입력 페이지</title>
</head>
<body>
	<center>
		<h1>상품 입력</h1>
		<%
		if (sessionRole.equals("Admin")){
		%>
		<h1>이 페이지는 관리자만 접근 할수있는 페이지 입니다.</h1>
		
		<a href="logout.do">Log-out</a>
		<hr>
		<form action="insertProducts.do" method="post">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange" width="70">상품코드</td>
					<td align="left"><input type="text" name="p_code" /></td>
				</tr>
				<tr>
					<td bgcolor="orange" width="70">상품이름</td>
					<td align="left"><input type="text" name="p_name" /></td>
				</tr>
				<tr>
					<td bgcolor="orange" width="70">kind</td>
					<td align="left"><input type="text" name="p_kind" /></td>
				</tr>
				<tr>
					<td bgcolor="orange" width="70">상품가격</td>
					<td align="left"><input type="text" name="p_price" /></td>
				</tr>
				<tr>
					<td bgcolor="orange">상품내용</td>
					<td align="left"><textarea name="p_content" cols="40" rows="10"></textarea></td>
				</tr>
				<tr>
					<td bgcolor="orange" width="70">상품수량</td>
					<td align="left"><input type="text" name="p_quantity" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value=" 새 상품 등록 " /></td>
				</tr>
			</table>
		</form>
		<a href="getProductList.do">상품 리스트 페이지</a>
		<%
		} else if (sessionRole.equals("User")){
		%>
		<h1>이 페이지는 일반유저는 접근할수 없는 페이지 입니다.</h1>
		<%
		}		
		%>
		<hr>
		<a href="/JSP_Study_MVC_M2">처음으로 이동</a>
	</center>
</body>
</html>