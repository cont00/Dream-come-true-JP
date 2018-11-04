<%--
	FreeBoardのメインページです。
	DBに連結されています。
	新しい掲示文を作成したり,掲示されている文にコメントを入力したりすることができる設定を持っています。
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kb.org.FreeboardService" %>
<%@ page import="com.kb.org.FreeboardDTO" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
		<head>
			<%@ include file="../cssjs.jsp" %>
			<link type="text/css" rel="stylesheet" href="/css/Index.css"/>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>FreeBoard List</title>
			<style>
				#dialog-background {
				    display: none;
				    position: fixed;
				    top: 0; left: 0;
				    width: 100%; height: 100%;
				    background: rgba(0,0,0,.3);
				    z-index: 10;
				}
				#my-dialog {
				    display: none;
				    position: fixed;
				    left: calc( 40% - 160px ); top: calc( 50% - 70px );
				    width: 700px; height: 80px; 
				    background: #fff;
				    z-index: 11;
				    padding: 10px;
				}
			</style>
			<script>
			$(function(){
				$("#btn-open-dialog,#dialog-background,#btn-close-dialog").click(function () {
					$("#my-dialog,#dialog-background").slideToggle();
				});
				$('#btn').click(function() {
					$('#test').append('<h2>New Comment</h2>');
				});
			});
			function dapWrite (group_idx, group_idx_fk, level_idx) {
				console.log('group_idx = ' + group_idx);
				console.log('group_idx_fk = ' + group_idx_fk);
				console.log('level_idx = ' + level_idx);
			}
			function deleteProc ( group_idx ) {
				console.log('group_idx = ' + group_idx);
				var result = confirm()
				if (result)	{
					location.href='delete';
				}
			}
			</script>
		</head>
		<body>
			<div id="my-dialog">
				<Form>
			    	Comment &nbsp; : &nbsp;
					    	<input type="text" name="comment" size="60"> &nbsp;
					    	<input type="button" value="Confirm">
			    	<button id="btn-close-dialog">Close</button>
				</Form>
			</div>
			<div id="dialog-background"></div>
			<%@ include file="/header.jsp" %>
			<%
				FreeboardService fbs = new FreeboardService();
				ArrayList<FreeboardDTO> al = fbs.getFreeboardAllten();
			%>
			<div id="Freeboardlist">
				<h1><a href="/Freeboard/Freeboard.jsp">FreeBoard</a></h1>
				<div><input type="button" id="btn" value="btnButton"/></div>
				<% 
					for (int i = 0; i < al.size(); i++) {
						if (al.get(i).getGroup_idx_fk() == 0) {
				%>
				<hr/>
				<div>
					<span>
						No.<%= al.get(i).getFreeboard_idx() %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						Title : <%= al.get(i).getTitle() %>
					</span>
					<span>
						Writer : <%= al.get(i).getCname() %> &nbsp;&nbsp;&nbsp;&nbsp;
						<%= al.get(i).getWritetime() %>
					</span>
					<br />
					<div id="text"><%= al.get(i).getContent() %></div>
					<div></div>
				</div>
				<hr />
				<form>
					<input id="btn-open-dialog" type="button" value="Comment" onclick="dapWrite(
					<%=al.get(i).getGroup_idx() %>, 
					<%=al.get(i).getGroup_idx_fk() %>,
					<%=al.get(i).getLevel_idx() %> );"/>
					<input type="button" value="Edit post" onclick="updateForm();" />
					<input type="button" value="Delete posts" onclick="deleteForm(<%  %>);" />
					<input type="button" value="New" onclick="writeForm();" />
				</form>
				<%
					} else {
						out.println(" <script> " 
						+ "$(function() { "
							+ " $('#content')"
						+ ")" );
						}
					}
				%>
			</div>
			<%@ include file="/footer.jsp" %>
		</body>
	</html>