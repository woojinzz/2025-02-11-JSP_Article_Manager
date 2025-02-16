<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map, java.util.HashMap, java.util.ArrayList" %>

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
	
	<form action="doJoin" method="post">
		<div>
			<h2>회원가입</h2>
			<div>이름 : <input type="text" name = "memberName" placeholder = "이름을 입력해 주세요"/></div>
			<div>아이디 : <input type="text" name = "memberId" placeholder = "아이디를 입력해 주세요"/>  </div>
			<div>비밀번호 : <input type="password" name = "memberPw"  placeholder = "비밀번호를 입력해 주세요"/></div>
			<div>비밀번호 확인 : <input type="password" name = "memberPwCHk"  placeholder = "비밀번호 체크를 입력해 주세요" /></div>
		</div>
		<button>회원 가입</button>
		<a href="../home/main"> 취소</a>
	</form>

	
</body>
</html>

