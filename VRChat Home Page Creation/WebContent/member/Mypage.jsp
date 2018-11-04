<%--
	Mypage設定 (DBと連動している)
	情報を修正できるように設定されています。
 --%>

<%@page import="com.kb.org.MemberService"%>
<%@page import="com.kb.org.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = (String)session.getAttribute("ID");
	String pw = (String)session.getAttribute("PW");
// 	out.println("ID : " + id);
// 	out.println("PW : " + pw);

	MemberService ms = new MemberService();
	MemberDTO md = ms.getMemberOne(id, pw);
	
	if (md == null) {
		response.sendRedirect("/index.jsp");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
		<head>
			<%@ include file="/cssjs.jsp" %>
			<link type="text/css" rel="stylesheet" href="../css/Index.css"/>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>Mypage</title>
			<script type="text/javascript">
				function doSubmit(){
					if($('#id').val().length < 1) {
						alert('Please enter a ID.');
						$('#id').focus();
					} else if ($('#pw').val().length < 1) {
						alert('Please enter a Password.')
						$('#pw').focus();
					} else if ($('#name').val().length < 1) {
						alert('Please enter a Name.')
						$('#name').focus();
					} else if ($('#cname').val().length < 1) {
						alert('Please enter a Character Name.')
						$('#cname').focus();
					} else if ($('#sex').val().length < 1) {
						alert('Please enter a Sex.')
						$('#sex').focus();
					} else if ($('#ad').val().length < 1) {
						alert('Please enter a Address.')
						$('#ad').focus();
					} else if ($('#em').val().length < 1) {
						alert('Please enter a E-Mail.')
						$('#em').focus();
					} else {
						$('#frm').attr('action','Mypageproc.jsp');
						$('#frm').submit();
					}
				}
			</script>
		</head>
		<body>
			<%@ include file="/header.jsp" %>
			<form id="frm" action = "Mypageproc.jsp">
				<input type="hidden" name="member_idx" value="<% out.print(md.getMember_idx()); %>">
					<h1>My Page</h1>
				 	<table>
				 		<tr>
				 			<td align="center">ID</td>
				 			<td><input id="id" type="text" name="id" value="<% out.print(md.getId()); %>"/></td>
				 		</tr>
				 		<tr>
				 			<td align="center">Password</td>
				 			<td><input id="pw" type="text" name="pw" value="<% out.print(md.getPw()); %>"/></td>
				 		</tr>
				 		<tr>
				 			<td align="center">Change Password</td>
				 			<td><input id="cpw" type="text" name="cpw" placeholder="CPW"/></td>
				 		</tr>
				 		<tr>
				 			<td align="center">Change Password Check</td>
				 			<td><input id="cpwc" type="text" name="cpwc" placeholder="CPWC"/></td>
				 		</tr>
				 		<tr>
				 			<td align="center">Name</td>
				 			<td><input id="name" type="text" name="name" value="<% out.print(md.getName()); %>"/></td>
				 		</tr>
				 		<tr>
				 			<td align="center">Character Name</td>
				 			<td><input id="cname" type="text" name="cname" value="<% out.print(md.getCname()); %>"/></td>
				 		</tr>
				 		<tr>
				 			<td align="center">Sex</td>
				 			<td><input id="sex" type="text" name="sex" value="<% out.print(md.getSex()); %>"/></td>
				 		</tr>
				 		<tr>
				 			<td align="center">Address</td>
				 			<td><input id="ad" type="text" name="ad" value="<% out.print(md.getAd()); %>"/></td>
				 		</tr>
				 		<tr>
				 			<td align="center">E-mail Address</td>
				 			<td><input id="em" type="text" name="em" value="<% out.print(md.getEm()); %>"/></td>
				 		</tr>
				 		<tr>
				 			<td align="center">Language</td>
				 			<td>
				 				<input type="checkbox" name="lang" value="English" <%= md.getLang().contains("English")?"checked":"" %>/>English
				 				<input type="checkbox" name="lang" value="Japanese" <%= md.getLang().contains("Japanese")?"checked":"" %>/>Japanese
				 				<input type="checkbox" name="lang" value="Korean" <%= md.getLang().contains("Korean")?"checked":"" %>/>Korean <br/>
				 				<input type="checkbox" name="lang" value="Chinese" <%= md.getLang().contains("Chinese")?"checked":"" %>/>Chinese
				 				<input type="checkbox" name="lang" value="German" <%= md.getLang().contains("German")?"checked":"" %>/>German
				 				<input type="checkbox" name="lang" value="Portuguese" <%= md.getLang().contains("Portuguese")?"checked":"" %>/>Portuguese <br/>
				 				<input type="checkbox" name="lang" value="Etc" <%= md.getLang().contains("Etc")?"checked":"" %>/>Etc
				 				<input type="text" name="lang" value="" />
				 			</td>
				 		</tr>
				 		<tr>
				 			<td align="center">About Me</td>
				 			<td><texarea></texarea></td>
				 		</tr>
				 	</table>
				 	<input onclick="doSubmit();" type="button" value="Update"/>
		 			<input onclick="/member/Mypage.jsp" type="submit" value="Cancel"/>
			 	</form>
			<%@ include file="/footer.jsp" %>
		</body>
	</html>
	<%
	String status = request.getParameter("status");
	
	if (status != null && status.equals("UPDATEOK")) {
		out.println("<script>alert('Edit Member');</script>");
	}
	else if (status != null && status.equals("UPDATEFAIL")) {
		out.println("<script>alert('Failed to edit member');</script>");
	}
	%>