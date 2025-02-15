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
<title>게시물 삭제</title>


</head>
<body>
	<div>
		<a href="<%= request.getContextPath() %>/home/main">메인</a>
	</div>
	<div>
		<h2><%= articleMap.get("id") %> 번 상세보기</h2>
		<div><%= articleMap.get("updateDate") %></div>
		<div><%= articleMap.get("title") %></div>
		<div><%= articleMap.get("body") %> </div>

	</div>
	<div>
		<a href="list">목록</a>
	</div>
	<div>
		<a href="delete?id=<%= articleMap.get("id") %>" onclick = "if(confirm('정말 삭제하시겠습니까?') == false) return false;" >삭제</a>
	</div>

</body>
</html>
<script>
	
</script>