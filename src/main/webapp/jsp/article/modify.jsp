<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map, java.util.HashMap, java.util.ArrayList" %>

<%
	Map<String, Object> articleMap = (Map<String, Object>) request.getAttribute("articleMap");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 수정</title>
</head>
	
<body>
	<div>
		<a href="<%= request.getContextPath() %>/home/main">메인</a>
	</div>
	
	<form action="doModify" method="post">
		<div>
			<h2>글수정</h2>
			<input type="hidden" name="id" value="<%= articleMap.get("id") %>"/>
			<div>수정할 제목 : <input type="text" name="title"  value ="<%= articleMap.get("title") %>"></div>
			<div>수정할 내용 : </div>
			<div><textarea name="body" id="" cols="30" rows="10" ><%= articleMap.get("body") %></textarea></div>
		</div>
		
		<button>글 수정</button>
		<a href="list"> 취소</a>
	</form>

	
</body>
</html>

