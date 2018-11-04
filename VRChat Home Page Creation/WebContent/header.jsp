<%-- すべてのページの全headerの基本となるファイル --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
    
<script>
function confirmLogout() {
	var con_test = confirm("Are you sure you want to Log out?");
	
	if (con_test) {
		location.href="/member/Logout.jsp";
		
	}
	else {
		alert('You have canceled your Log out.')
	}
}
function confirmSecession() {
	var con_test = confirm("Do you want to Secession?");
	
	if (con_test) {
		location.href="/member/Secession.jsp";
		
	}
	else {
		alert('You have canceled your Secession.')
	}
}
</script>
    
<div id="header">
	<%
		out.println("Hello ~ VRChat !");
	%>
	<div id="headermain"> <%-- ホームページの一番上の部分にあるメニューバー --%>
		<ul>
			<li><a href="/index.jsp">Home</a></li>
			<%-- sessionがLoginのときに表示されるメニューボタンとLogoutのときに表示されるメニューボタンの設定 --%>
			<%
			String LoginCK = (String)session.getAttribute("Login");
			if (LoginCK == null) {
			%>
			<li><a href="/member/Loginform.jsp">login</a></li>
			<li><a href="/member/Informationform.jsp">SignUp</a></li>
			<% } else { %>
			<li><a href="javascript:void(0)" onclick="confirmLogout();">logout</a></li>
			<li><a href="/member/Mypage.jsp">Mypage</a></li>
			<li><a href="javascript:void(0)" onclick="confirmSecession();">Secession</a></li>
			<% } %>
			<li><a href="https://www.vrchat.net/" target="_blank">VRChatHome</a></li>
			<li><a href="https://twitter.com/" target="_blank">Twitter</a></li>
			<li><a href="https://www.youtube.com/" target="_blank">Youtube</a></li>
			<li><a href="https://translate.google.co.kr/" target="_blank">translator</a>
		</ul>
	</div>
	<br/>
</div>
<div id="mainmenu"> <%-- メインメニューバーを見せてくれるdiv --%>
	<ul>
		<li><a href="/index.jsp">Home</a></li>
		<li><a href="/list">Notice Board</a></li>
		<li><a href="/Freeboard/Freeboard.jsp">Free Board</a></li>
		<li><a href="">Screenshot</a></li>
		<li><a href="">Suggestions</a></li>
	</ul>
</div>