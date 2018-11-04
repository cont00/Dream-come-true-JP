<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
		<head>
			<%@ include file="/cssjs.jsp" %>
			<link type="text/css" rel="stylesheet" href="../css/Index.css"/>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>WriteCheck page</title>
		</head>
		<body>
			<%@ include file="/header.jsp" %>
			<div id="write">
				<form id="frm" action="/Freeboard/writeForm.jsp">
					<table>
						<tr>
							<td>
								Title&emsp;:&emsp;<input type="text" name="title" size="60" />
							</td>
						</tr>
						<tr>
							<td><textarea name="content" ></textarea></td>
						</tr>
						<tr>
							<td align="right">
								<input type="submit" value="Return" /> &emsp;
								<input type="button" value="To the board" onclick="Freeboard()"/>
							</td>
						</tr>
					</table>
				</form>
			</div>
			<%@ include file="/footer.jsp" %>
		</body>
	</html>