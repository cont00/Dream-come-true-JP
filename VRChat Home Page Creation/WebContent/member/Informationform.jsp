<%--
	会員加入ボタンを押して入れば見えるメイン画面
	会員加入に成功するか失敗する場合のイベント発生
 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String status = request.getParameter("status");
if (status != null && status.equals("JOINOK")) {
	out.println("<script>alert('회원가입이 완료되었습니다.')</script>");
}
else if (status != null && status.equals("JOINFAIL")) {
	out.println("<script>alert('회원가입에 실패하였습니다.')</script>");
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
		<head>
			<%@ include file="/cssjs.jsp" %>
			<link type="text/css" rel="stylesheet" href="../css/Index.css"/>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>Sign Up</title>
			<script>
				function doSubmit() {
// 					var name = document.getElementById("name");
// 					alert(name.value);
// 					alert($('#name').val());
					if($('#id').val().length < 0) {
						alert('Please enter a ID.');
						$('#name').focus();
					} else if ($('#pw').val().length < 0) {
						alert('Please enter a Password.')
					} else if ($('#pwc').val().length < 0) {
						alert('Password verification and Password are different.')
					} else if ($('#name').val().length < 0) {
						alert('Please enter a Name.')
					} else if ($('#cname').val().length < 0) {
						alert('Please enter a Character Name.')
					} else if ($('#sex').val().length < 0) {
						alert('Please enter a Sex.')
					} else if ($('#ad').val().length < 0) {
						alert('Please enter a Address.')
					} else if ($('#em').val().length < 0) {
						alert('Please enter a E-Mail.')
					} else if ($('#em').val().length < 0) {
						alert('Please enter a E-Mail.')
					} else {
// 						$('#frm').attr('action', 'Joinproc.jsp');
						$('#frm').submit();
					}
// 					if(true) {
// 						frm.submit();
// 					}
				}
			</script>
		</head>
		<body>
		<%@ include file="/header.jsp" %>
		<form id="frm" action = "/member/Joinproc.jsp">
			<h1>Sign Up</h1>
		 	<table>
		 		<tr>
		 			<td align="center">ID</td>
		 			<td><input id="id" type="text" name="id" placeholder="ID"/></td>
		 		</tr>
		 		<tr>
		 			<td align="center">Password</td>
		 			<td><input id="pw" type="text" name="pw" placeholder="PW"/></td>
		 		</tr>
		 		<tr>
		 			<td align="center">Password Check</td>
		 			<td><input id="pwc" type="text" name="pwc" placeholder="PWC"/></td>
		 		</tr>
		 		<tr>
		 			<td align="center">Name</td>
		 			<td><input id="name" type="text" name="name" placeholder="NAME"/></td>
		 		</tr>
		 		<tr>
		 			<td align="center">Character Name</td>
		 			<td><input id="cname" type="text" name="cname" placeholder="CHARACTER NAME"/></td>
		 		</tr>
		 		<tr>
		 			<td align="center">Sex</td>
		 			<td><input id="sex" type="text" name="sex" placeholder="SEX"/></td>
		 		</tr>
		 		<tr>
		 			<td align="center">Address</td>
		 			<td><input id="ad" type="text" name="ad" placeholder="ADDRESS"/></td>
		 		</tr>
		 		<tr>
		 			<td align="center">E-mail Address</td>
		 			<td><input id="em" type="text" name="em" placeholder="E-MAIL ADDRESS"/></td>
		 		</tr>
		 		<tr>
		 			<td align="center">Language</td>
		 			<td>
		 				<input type="checkbox" name="lang" value="English"/>English
		 				<input type="checkbox" name="lang" value="Japanese"/>Japanese
		 				<input type="checkbox" name="lang" value="Korean"/>Korean <br/>
		 				<input type="checkbox" name="lang" value="Chinese"/>Chinese
		 				<input type="checkbox" name="lang" value="German"/>German
		 				<input type="checkbox" name="lang" value="Portuguese"/>Portuguese <br/>
		 				<input type="checkbox" name="lang" value="Etc"/>Etc
		 				<input type="text" name="lang" placeholder="ETC"/>
		 			</td>
		 		</tr>
		 		<tr>
		 			<td align="center">About Me</td>
		 			<td><texarea></texarea></td>
		 		</tr>
		 		<tr>
		 			<td align="center"><input onclick="doSubmit();" type="button" value="Confirm"/></td>
		 			<td><input type="reset" value="Cancel"/></td>
		 		</tr>
		 	</table>
	 	</form>
	 	<%@ include file="/footer.jsp" %>
		</body>
	</html>