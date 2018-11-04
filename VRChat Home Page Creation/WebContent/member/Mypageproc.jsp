<%@page import="com.kb.org.MemberService"%>
<%@page import="com.kb.org.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 	out.print("Mypageproc");
	
	String member_idx = request.getParameter("member_idx");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String pwc = request.getParameter("pwc");
	String name = request.getParameter("name");
	String cname = request.getParameter("cname");
	String sex = request.getParameter("sex");
	String ad = request.getParameter("ad");
	String em = request.getParameter("em");
	String lang[] = request.getParameterValues("lang");
	String langs = "";
	for (String temp : lang) {
		langs += temp;
	}
	MemberService ms = new MemberService();
	boolean result = ms.updateMemberOne(member_idx, id, pw, name, cname, sex, ad, em, langs);
	if (result) {
		session.setAttribute("ID", id);
		session.setAttribute("PW", pw);
		out.println("Edit Member");
		response.sendRedirect("/member/Mypage.jsp?status=UPDATEOK");
	}
	else {
		out.println("Failed to edit member");
		response.sendRedirect("/member/Mypage.jsp?status=UPDATEFAIL");
	}
%>