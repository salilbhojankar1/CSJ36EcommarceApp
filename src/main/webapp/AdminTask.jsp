<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="model.*"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%User user=(User)session.getAttribute("loginInfo");%>
<h3><font color='blue'>Hello<%=user.getUserName()%> 1111</font></h3><br>

<h3><font color='red'>You logged in as <%=user.getUserType() %></font></h3>

<a href="addProduct.jsp">ADD PRODUCT</a><br>

<a href="viewProduct.jsp">VIEW ALL PRODUCT</a><br>

<a href="viewById">VIEW BY PRODUCT ID</a><br>
</body>
</html>