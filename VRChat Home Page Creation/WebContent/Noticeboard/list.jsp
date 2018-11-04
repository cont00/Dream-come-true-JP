<%-- Noticeboardページのメイン画面とDBとつながった書き込みを表示させる設定。 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kb.org.noticeboard.NoticeBoardDTO" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE>
	<html>
		<head>
			<%@ include file="/cssjs.jsp" %>
			<link type="text/css" rel="stylesheet" href="../css/Index.css"/>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>Notice Board</title>
		</head>
		<body>
			<%@ include file="/header.jsp" %>
			<div class="body">
				<%
// 					ArrayList<NoticeBoardDTO> aaa = (ArrayList<NoticeBoardDTO>)request.getAttribute("al_nbd");
// 					for (int i = 0; i < aaa.size(); i++)
// 						out.print(aaa.get(i)+"<br/>");
				%>
				<br />
				<table id="noticeview" border="1" style="padding: 10px;">
					<tr align="center">
						<td width="30">Number</td>
						<td width="500">Title</td>
						<td width="150">Cname</td>
						<td width="100">Date</td>
						<td width="30">View</td>
					</tr>
					<c:forEach items="${al_nbd}" var="NoticeBoardDTO">
					<tr align="center">
						<td>${NoticeBoardDTO.idx}</td>
						<td><a href="/ViewOne?idx=${NoticeBoardDTO.idx}">${NoticeBoardDTO.title}</a></td>
						<td>${NoticeBoardDTO.cname}</td>
						<td>${NoticeBoardDTO.regdate}</td>
						<td>${NoticeBoardDTO.cnt}</td>
					</tr>
					</c:forEach>
					<tr>
						<td colspan="5" align="center">
						<%
// 							int pageNums = (Integer)request.getAttribute("pageNums");
// 							String pageNum = request.getParameter("pageNum");
// 							if (pageNum == null) {
// 								pageNum = "1";
// 							}
// // 							out.print(pageNums);
							
// 							for (int i = 1; i < pageNums+1; i++) {
// 								if ( Integer.parseInt(pageNum) == i )
// 									out.print("[ <a href=list?pageNum=" + i + ">" + i + "</a> ]");
// 								else
// 									out.print("[ <a href=list?pageNum=" + i + ">" + i + "</a> ]");
// 							}
						%>
						<c:forEach begin="1" end="${pageNums}" var="pagenum">
							<c:if test="${pagenum eq param.pageNum }">
								[ <a href="list?pageNum=${pagenum}" style="color:black;">${pagenum}</a> ]
							</c:if>
							<c:if test="${pagenum ne param.pageNum }">
								[ <a href="list?pageNum=${pagenum}">${pagenum}</a> ]
							</c:if>
						</c:forEach>
						</td>
					</tr>
				</table>
				<br/>
				
			</div>
			<%@ include file="/footer.jsp" %>
		</body>
	</html>