<%-- Loginボタンを押した場合,移動するLoginのメインページです。 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<html>
			<head>
				<link type="text/css" rel="stylesheet" href="../css/Index.css"/>
				<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
				<title>Login</title>
			</head>
			<body>
				<%@ include file="/header.jsp" %>
				<form action="/member/Login.jsp">
					<div id="Loginform">
						<h2>Login</h2>
						<table>
							<tr>
								<td>ID</td>
								<td><input type="text" name="id" placeholder="ID"/></td>
								<td rowspan="2"><input type="submit" value="Login"/></td>
							</tr>
							<tr>
								<td>PW</td>
								<td><input type="text" name="pw" placeholder="PW"/></td>
							</tr>
						</table>
						<input type="checkbox" name="auto_Login"/>Auto-Login
						<a href="/member/Informationform.jsp">SignUp</a>
						<a href="/member/IdpwFindForm.jsp">FindID/PW</a>
					</div>
				</form>
				<%@ include file="/footer.jsp" %>
			</body>
		</html>