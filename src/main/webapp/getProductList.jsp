<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "java.util.*" %>
<%@ page import = "com.mysite.products.ProductsDTO" %>

<%
// session에 저장된 값을 꺼낸다.
	List<ProductsDTO> productsList = new ArrayList<ProductsDTO>();
	
	productsList = (List) session.getAttribute("productsList");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 상품 목록 페이지</title>
</head>
<body>
	<center>
		<h1>상품 목록</h1>
		<table border="1px" cellpading="0" cellspacing="0" width="700px">
			<tr>
				<th bgcolor="orange" width="100px">상품코드</th>
				<th bgcolor="orange" width="200px">상품이름</th>
				<th bgcolor="orange" width="150px">kind</th>
				<th bgcolor="orange" width="150px">상품가격</th>
				<th bgcolor="orange" width="100px">상품수량</th>
				<th bgcolor="orange" width="100px">등록일</th>
			</tr>
			
			<%
			for (ProductsDTO k : productsList) {
			%>
			<tr>
				<td><%=k.getP_code() %></td>
				<td><%=k.getP_name() %></td>
				<td><%=k.getP_kind() %></td>
				<td><%=k.getP_price() %></td>
				<td><%=k.getP_quantity() %></td>
				<td><%=k.getIndate() %></td>
			</tr>
			<%
			};
			session.removeAttribute("productsList");
			%>
		</table>
	</center>
</body>
</html>