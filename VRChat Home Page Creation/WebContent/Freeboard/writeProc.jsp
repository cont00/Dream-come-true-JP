<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kb.org.FreeboardService" %>
<%@ page import="com.kb.org.FreeboardDTO" %>
<%
	request.setCharacterEncoding("UTF-8");
	FreeboardService fbs = new FreeboardService();
	FreeboardDTO fbdto = new FreeboardDTO();

	fbdto.setTitle(request.getParameter("title"));
	fbdto.setCname(request.getParameter("cname"));
	fbdto.setContent(request.getParameter("content"));
	
	boolean chk = fbs.insertFreeboard(fbdto);
	
	if (chk) {
		out.println("<script>alert('Your writing is complete.');location.href='/Freeboard/Freeboard.jsp';</script>");
	} else {
		out.println("Server Error");
	}
// 	out.println("writeProc.jsp");
%>