<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String inputDan = request.getParameter("dan");
	String inputLimit = request.getParameter("limit");
	String inputColor= request.getParameter("color");
	
	if (inputDan == null) {
		inputDan = "1";
	}
	if (inputLimit == null) {
		inputLimit = "1";
	}
	if (inputColor == null) {
		inputColor = "black";
	}
	
	int dan = Integer.parseInt(inputDan);
	int limit = Integer.parseInt(inputLimit);
	
%>    
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 페이지</title>
</head>
<body>
	<h1>구구단</h1>

	<div>==<%= dan %> 단 ==</div>
	
	<% for (int i = 1; i <= limit; i++ ) { %>
		<div style= "color: <%= inputColor %>;"><%= dan %> * <%= i %> = <%= dan * i %></div>
	<% } %>
	
	

</body>
</html>