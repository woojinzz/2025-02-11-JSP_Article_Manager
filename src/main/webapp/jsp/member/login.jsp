<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map, java.util.HashMap, java.util.ArrayList" %>

<%
	String loginChk = null;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
	
<body>
	<div>
		<a href="<%= request.getContextPath() %>/home/main">메인</a>
	</div>
	<script>
		const loginFormSubmit = function(form) {
			form.loginId.value = form.loginId.value.trim();
			form.loginPw.value = form.loginPw.value.trim();
			
			if (form.loginId.value.length == 0) {
				alert('아이디를 입력해 주세요.');
				form.loginId.focus();
				return;
			}
			if (form.loginPw.value.length == 0) {
				alert('비밀번호를 입력해 주세요.');
				form.loginPw.focus();
				return;
			}
			form.submit();
		}
	</script>
	<form action="doLogin" method="post" onSubmit="loginFormSubmit(this); return false;">
		<div>
			<h2>로그인</h2>
			<div>아이디 : <input type="text" name="loginId"  placeholder = "아이디를 입력해 주세요"/></div>
			<div>비밀번호 : <input type="password" name="loginPw" placeholder = "비밀번호를 입력해 주세요"/></div>
		</div>
		<button>로그인</button>
		<a href="../home/main"> 취소</a>
	</form>

	
</body>
</html>



