<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map, java.util.HashMap, java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 작성</title>
</head>
	
<body>
	<div>
		<a href="<%= request.getContextPath() %>/home/main">메인</a>
	</div>
	
	<form action="doWrite" method="post">
		<div>
			<h2>글작성</h2>
			<div>제목 : <input type="text" name = "title" placeholder = "제목을 입력해주세요."/></div>
			<div>내용 : </div>
			<div><textarea name="body" id="" cols="30" rows="10"></textarea></div>
		</div>
		<button>글 작성</button>
		<a href="list"> 취소</a>
	</form>

	
</body>
</html>

