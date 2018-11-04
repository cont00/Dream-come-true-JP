<%--
	ID,PWを入力した後,Loginボタンをクリックする場合に発生するイベントがあるページです。
	IDまたはPWが間違える場合は,エラーメッセージと共に,再びLoginメインページに移動するように設定されています。
  --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.kb.org.MemberService" %>
<%
// 	ID와 PW를 가지고 DB(oracle) Member table에서 해당되는 ID와 PW가 있으면 성공
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");

	MemberService ms = new MemberService();
	
// 	out.println(id);
// 	System.out.println(pw);

	String dbCheck = ms.loginCheck(id, pw);
	
	if(dbCheck.equals("Login success")) {
		out.println("Login success");
		session.setAttribute("Login", "OK");
		session.setAttribute("ID", id);
		session.setAttribute("PW", pw);
		response.sendRedirect("/index.jsp");	//	session(세선)
	}
	else if (dbCheck.equals("Not PW")) {
		out.println("Login fail. Please check PW.");
	}
	else if (dbCheck.equals("Not ID")) {
		out.println("Login fail. Please check ID.");
	}
	else {
		out.println("An exception occurred. Please check the server.");
	}
%>