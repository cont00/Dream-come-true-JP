<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
	<html>
		<head>
			<%@ include file="/cssjs.jsp" %>
			<link type="text/css" rel="stylesheet" href="../css/Index.css"/>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>New Posts</title>
			<script type="text/javascript">
				$(document).ready( function() {
					$('#doGet').click( function() {
						if( $('#title').val() == '' ) {
							alert('Please enter title');
							$('#title').focus();
						}
						else if( $('#content').val() == '') {
							alert('Please enter content');
							$('#content').focus();
						}
						else if( $('#cname').val() == '') {
							alert('Please enter Name');
							$('#cname').focus();
						}
						else if( $('#pw').val() == '') {
							alert('Please enter PW');
							$('#pw').focus();
						}
						else {
// 							alert('Please enter title and content and Name and PW')
							$('#frm').submit();
						}
					});
				});
			</script>
		</head>
		<body>
			<%@ include file="/header.jsp" %>
			<div id="write">
				<form id="frm" action="/Freeboard/writeProc.jsp" method="post">
					<table>
						<tr>
							<td colspan="2">
								Title&emsp;:&emsp;<input type="text" name="title" size="60" placeholder="Title"/>
							</td>
						</tr>
						<tr>
							<td colspan="2"><textarea name="content" placeholder="Please enter your details."></textarea></td>
						</tr>
						<tr>
							<td>
								Name : <input type="text" name="cname" size="15" placeholder="Character Name">
								PW : <input type="text" name="pw" size="10" placeholder="Password">
							</td>
							<td align="right">
								<input id="doGet" type="button" value="Confirm" /> &emsp;
								<input type="reset" value="Cancel"/>
							</td>
						</tr>
					</table>
				</form>
			</div>
			<%@ include file="/footer.jsp" %>
		</body>
	</html>