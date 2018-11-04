<%@page import="com.kb.org.MemberService"%>
<%@page import="com.kb.org.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/*
	1. 아이디 빈 공백이 들어오거나 패스워드 빈공백이 들어와도 회원가입 안되도록
		* 클라이언트에서 유효성 검사
			-> 자바스크립트로 form 값을 확인하고 서버 요청을 합니다.
		* 서버에서 유효성 검사
			-> 서버에다가 회원가입 요청을 할 시 서버단에서 아이디, 패스워드가 공백인지 확인
	2. 회원가입 완료 시 로그인화면으로 이동
	3. 회원 수정 마이페이지 화면.jsp -> 마이페이지proc.jsp
	
	1.IDの空白が入ったり,パスワードの空白が入っても会員加入できないように
		* クライアントで有効性検査
			-> ジャバスクリプトでフォーマット値を確認し,サーバーの要請をします。
		* サーバーで有効性検査
			-> サーバーが会員加入を要請する場合,サーバー団でID,パスワードが空白かどうかを確認
	2.会員加入完了時,ログイン画面に移動
	3.会員修正のマイページ画面。jsp-> マイページproc.jsp
 */

	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String pwc = request.getParameter("pwc");
	String name = request.getParameter("name");
	String cname = request.getParameter("cname");
	String sex = request.getParameter("sex");
	String ad = request.getParameter("ad");
	String em = request.getParameter("em");
	
	String[] lang = request.getParameterValues("lang");
	String Language = "";
	if (lang != null) {
		for (int i = 0; i < lang.length; i++) {
			out.println(lang[i]);
			Language = Language + lang[i] + ", ";
		}
	}
	else {
		Language = "No language you know.";
	}
// 	for (String la : lang) {
// 		out.println(la);
// 	}
	
	out.println(id  + "<br />");
	out.println(pw  + "<br />");
	out.println(pwc  + "<br />");
	out.println(name  + "<br />");
	out.println(cname  + "<br />");
	out.println(sex  + "<br />");
	out.println(ad  + "<br />");
	out.println(em  + "<br />");
	out.println(lang);
	
	MemberDTO md = new MemberDTO();
	md.setId(id);
	md.setPw(pw);
	md.setPwc(pwc);
	md.setName(name);
	md.setCname(cname);
	md.setSex(sex);
	md.setAd(ad);
	md.setEm(em);
	md.setLang(Language);
	
	MemberService ms = new MemberService();
	if (md.getPw().equals(md.getPwc())) {
		boolean ck = ms.insertMember(md);
		if (ck)
			response.sendRedirect("/member/Informationform.jsp?status=JOINOK");
		else
			response.sendRedirect("/member/Informationform.jsp?status=JOINFAIL");
	}
	else {
		out.println("The Password Check you entered is different from the Password.");
	}
%>