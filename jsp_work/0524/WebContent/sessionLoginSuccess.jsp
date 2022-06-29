<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<html>
<head>
<title>Session Login</title>
</head>
<body>
<h3> 로그인이 되었습니다 </h3>
<h3> 로그인 아이디: <%= (String)session.getAttribute("id") %></h3>
</body>
</html>
