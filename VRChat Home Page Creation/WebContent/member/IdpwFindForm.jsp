<%--
	ID,PWを失う場合,探すためにE-mailを入力し,E-mailの認証番号を入力する場合は,PW変更画面に移動します。
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
		<head>
			<%@ include file="/cssjs.jsp" %>
			<link type="text/css" rel="stylesheet" href="../css/Index.css"/>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>Find ID, PW</title>
		</head>
		<body>
			<%@ include file="/header.jsp" %>
				<form action="/member/IdpwFindProc.jsp">
					<div id="IdpwFind">
						Please enter your E-mail
						<table>
							<tr>
								<td>E-mail</td>
								<td><input type="text" name="meailaddress"></td>
							</tr>
						</table>
						<input type="submit" value="Confirm">
					</div>
				</form>
			<%@ include file="/footer.jsp" %>
		</body>
	</html>