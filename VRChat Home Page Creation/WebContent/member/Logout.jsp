<%-- Logoutボタンをクリックした後,確認を押したとき,適用されるページです。 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 세션에 Login 이라는 키를 가진 값을 삭제
	session.removeAttribute("Login");
	// 페이지를 이동
	response.sendRedirect("/index.jsp?status=Logout");
%>