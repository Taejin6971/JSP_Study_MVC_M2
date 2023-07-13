<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>users 등록</title>
</head>
<body>
	<center>
		<h1>users 등록</h1>
		<a href="logout.do">Log-out</a>
		<hr>
		<form action="insertUsers.do" method="post">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange" width="70">ID</td>
					<td align="left"><input type="text" name="id" /></td>
				</tr>
				<tr>
					<td bgcolor="orange">PASS</td>
					<td align="left"><input type="text" name="password" size="10" /></td>
				</tr>
				<tr>
					<td bgcolor="orange">NAME</td>
					<td align="left"><input type="text" name="name" size="10" /></td>
				</tr><tr>
					<td bgcolor="orange">ROLE</td>
					<td align="left"><input type="text" name="role" size="10" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="submit" value=" 등록 " />
					</td>
				</tr>
			</table>
		</form>
		<hr>
		<a href="getUsersList.do">목록 가기</a>
	</center>
</body>
</html>