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
<title>회원 가입 페이지</title>
</head>
	
<body>
	<div>
		<a href="<%= request.getContextPath() %>/home/main">메인</a>
	</div>
	<script>
		const joinFormSubmit = function(form) {
			form.loginName.value = form.loginName.value.trim();
			form.loginId.value = form.loginId.value.trim();
			form.loginPw.value = form.loginPw.value.trim();
			form.loginPwChk.value = form.loginPwChk.value.trim();
			
			if (form.loginName.value.length == 0) {
				alert('이름은 필수 입력 정보입니다.');
				form.loginName.focus();
				return;
			}
			if (form.loginId.value.length == 0) {
				alert('아이디는 필수 입력 정보입니다.');
				form.loginId.focus();
				return;
			}
			if (form.loginPw.value.length == 0) {
				alert('비밀번호는 필수 입력 정보입니다.');
				form.loginPw.focus();
				return;
			}
			
			if (form.loginPw.value != form.loginPwChk.value) {
				alert('비밀번호를 확인해주세요');
				form.loginPw.focus();
				form.loginPw.value = "";
				form.loginPwChk.value = "";
				
				return;
			}
	
			form.submit();
			
		}
	</script>
	<form action="doJoin" method="post" onSubmit="joinFormSubmit(this); return false;">
		<div>
			<h2>회원가입</h2>
			<div>이름 : <input type="text" name="loginName"  placeholder = "이름을 입력해 주세요"/></div>
			<div>아이디 : <input type="text" name="loginId"  placeholder = "아이디를 입력해 주세요"/></div>
			<div>비밀번호 : <input type="password" name="loginPw" placeholder = "비밀번호를 입력해 주세요"/></div>
			<div>비밀번호 확인 : <input type="password" name="loginPwChk" placeholder = "비밀번호 체크를 입력해 주세요" /></div>
		</div>
		<button>회원 가입</button>
		<a href="../home/main"> 취소</a>
	</form>

	
</body>
</html>



