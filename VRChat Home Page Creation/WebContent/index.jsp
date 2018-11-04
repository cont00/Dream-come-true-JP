<%-- ホームページの最もメインになっている画面を設定するためのファイル --%>

<%@page import="com.kb.org.MemberService"%>
<%@page import="com.kb.org.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kb.org.FreeboardService"%>
<%@page import="com.kb.org.FreeboardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <% page language %> 페이지 디렉티브 (ページ·ディレクティブ) --%> 
<%-- <% page import %> --%>
<%-- <% page tlb="" %> --%>
<%--
	jsp 내장객체
		- request	getParameter("이름"); getParameters("이름"); setAttribute();
		- response	sendRedirect(); // 페이지 이동 (ページ移動)
		- out		출력하는 것 (出力すること)
		- session	로그인 할 때, ID PW를 브라우저단에 저장시켜놓고 창 닫기 전까지 로그인체크 할 때 사용 (ログインするとき,ID PWをブラウザに保存して閉じる前までログインチェックするとき使用)
		-include	공통적인 부분을 포함하는 것 (共通点を含めるもの)
--%>
<%
	MemberService ms = new MemberService();
	ArrayList<MemberDTO> al = (ArrayList<MemberDTO>) ms.getMemberAllThree();
		
	FreeboardService fbs = new FreeboardService();
	ArrayList<FreeboardDTO> array_freeboard = (ArrayList<FreeboardDTO>) fbs.getFreeboardAllThree();
	
	String status = request.getParameter("status");
	if (status != null && status.equals("Logout")) {
		out.print("<script>alert('You have successfully Logout.');</script>");
	}
%>
<!DOCTYPE>
	<html> <%-- HTMLの開始宣言 --%>
		<head>
			<%@ include file="cssjs.jsp" %> <%-- css設定が入っているファイルを持ってくるための宣言文 --%>
			<link type="text/css" rel="stylesheet" href="/css/Index.css"/>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>DoubleScarlet VRChat</title>
		</head>
		<body>
		<%@ include file="/header.jsp" %> <%-- Headerファイルを持ってくるための宣言文 --%>
		<div id="mainslider">
			<div id="left"><a><img src="왼쪽.jpg"></a></div>  <%-- divの中にイメージを入れるための宣言文 --%>
			<div id="right"><a><img src="오른쪽.jpg"></a></div>  <%-- divの中にイメージを入れるための宣言文 --%>
			<div id="bottom"> <%-- 番号をクリックするとそのイメージをもたらすため作ったdiv --%>
				<span class="a">01</span>
				<span class="b">02</span>
				<span class="c">03</span>
				<span class="d">04</span>
				<span class="e">05</span>
				<span class="f">06</span>
			</div>
			<div id="move"> <%-- メイン画面にアップする絵を入れるためのdiv --%>
				<a><img src="VRChat00.jpg" width="750" height="400" alt="VRChatScreenshot"></a>
				<a><img src="VRChat01.jpg" width="750" height="400" alt="VRChatScreenshot"></a>
				<a><img src="VRChat02.jpg" width="750" height="400" alt="VRChatScreenshot"></a>
				<a><img src="VRChat03.jpg" width="750" height="400" alt="VRChatScreenshot"></a>
				<a><img src="VRChat04.jpg" width="750" height="400" alt="VRChatScreenshot"></a>
				<a><img src="VRChat05.jpg" width="750" height="400" alt="VRChatScreenshot"></a>
			</div>
		</div>
			<div class="body">
			<%
				String Login = (String)session.getAttribute("Login");
			%>
			<br/>
				<div id="member"> <%-- MemberのCname, Sex, Languageを見せてくれるテーブルためのdiv --%>
					<h2>Recently registered members</h2><hr/><hr/>
					<span><a href=""><h2>+</h2></a></span>
					<table id="membertable">
						<colgroup> <%-- 1行のテーブルごとに横の長さを設定するための宣言文 --%>
							<col width="100">
							<col width="50">
							<col width="150">
						</colgroup>
						<tr>
							<th>Cname</th>
							<th>Sex</th>
							<th>Language</th>
						</tr>
						<tr>
						<%
						for(int i = 0; i < al.size(); i++) {
						%>
							<th><% out.print( al.get(i).getCname() ); %></th>
							<th><% out.print( al.get(i).getSex() ); %></th>
							<th><% out.print( al.get(i).getLang() ); %></th>
						</tr>
						<% } %>
					</table>
				</div>
				<div id="freeboard"> <%-- 一番最近のFreeBoardの掲示文を表示するテーブルためのdiv --%>
					<h2>FreeBoard</h2><hr/><hr/>
					<span><a href=""><h2>+</h2></a></span>
					<table id="freeboardtable">
						<colgroup> <%-- 1行のテーブルごとに横の長さを設定するための宣言文 --%>
							<col width="10">
							<col width="250">
							<col width="150">
							<col width="100">
						</colgroup>
						<tr>
							<th>Num</th>
							<th>Title</th>
							<th>Cname</th>
							<th>Time</th>
						</tr>
						<tr>
						<%
						for(int i = 0; i < array_freeboard.size(); i++) {
						%>
							<th><% out.print( array_freeboard.get(i).getFreeboard_idx() ); %></th>
							<th><% out.print( array_freeboard.get(i).getTitle() ); %></th>
							<th><% out.print( array_freeboard.get(i).getCname() ); %></th>
							<th><% out.print( array_freeboard.get(i).getWritetime() ); %></th>
						</tr>
						<% } %>
					</table>
				</div>
			</div>
		<%@ include file="/footer.jsp" %> <%-- Footerファイルを持ってくるための宣言文 --%>
		</body>
	</html> <%-- HTMLの終了宣言 --%>