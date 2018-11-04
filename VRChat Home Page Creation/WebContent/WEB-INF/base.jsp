<%-- 新しいページを作成する場合使用する基本的な枠組み --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<%@ include file="/cssjs.jsp" %>
<link type="text/css" rel="stylesheet" href="../css/Index.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/header.jsp" %>
<div>
	Please enter the response code you sent each day.
	<form>
		Response Code <input type="text" name="makeCode" />
		<input type="submit" value="Confirm" />
	</form>
</div>
<%@ include file="/footer.jsp" %>
</body>
</html>