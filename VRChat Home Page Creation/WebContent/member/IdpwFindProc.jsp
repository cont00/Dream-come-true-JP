<%--
	ID,PWを探すためにE-mailを入力し,認証番号の発送をする場合に発生するイベントの集まり
	(入力したE-mailで,認証番号と一緒に送信させるためのイベント)
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kb.org.MailService" %>
<%@ page import="com.kb.org.MemberService" %>
<%@page import="com.kb.org.MemberDTO"%>

<%
	String MD = request.getParameter("meailaddress");
	String selfCode = request.getParameter("selfCode");
	
	String sendCode = null;
	MemberDTO md = null;
	
	MailService ms = new MailService();
	MemberService mbs = new MemberService();
	
	if (MD != null && (!MD.equals(""))) {
		if(selfCode == null) {
			sendCode = ms.sendMail(MD);
			session.setAttribute("Code", sendCode);
		}
		else {
// 			out.println("E-mail Adress : " + MD);
// 			out.println("makeCode : " + selfCode);
// 			out.println("Check makeCode emailed : " + session.getAttribute("code"));
			String sendcode = (String)session.getAttribute("code");
			if (selfCode.equals(sendcode)) {
				// DB에서 해당되는 E-mail Address에 ID, PW를 넘겨주기
				md = mbs.getIDPW(MD);
				out.print(md);
			}
			else {
				// E-mail로 보내진 Code와 다릅니다. 다시 입력해주세요
				out.print("<script>alert('This is not an emailed code. Please re-enter')</script>");
			}
		}
	}
	else {
		out.print("<script>alert('You did not write email well. Please check');</script>");
// 		response.sendRedirect("/member/IdpwFindForm.jsp");
	}
%>

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
			<div id="makecode">
				Please enter the response code you sent each day. <br />
				If the response code matches, we will inform you of ID and PW. <br />
				<% if (md == null) { %>
				<form>
					<input type="hidden" name="Emailaddress" value="<%= MD%>" />
					Response Code <input type="text" name="selfCode" />
					<input type="submit" value="Confirm" />
				</form>
				<% } else {
					out.println("<br/>ID = " + md.getId() + "<br/>");
					out.println("PW = " + md.getPw());
				} %>
			</div>
			<%@ include file="/footer.jsp" %>
		</body>
	</html>