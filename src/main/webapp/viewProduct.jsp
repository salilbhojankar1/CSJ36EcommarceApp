<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*,model.*,Dao.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="2" cellpadding="2" cellspacing="2">
		<thead>
			<th>ID</th>
			<th>NAME</th>
			<th>CATEGORY</th>
			<th>PRICE</th>
			<th>BRAND</th>
			<th>MFD</th>
			<th>EDIT</th>
			<th>DELETE</th>
		</thead>
		<% ProductDao daO = new ProductDao();
		List<Product> list = daO.getAllProduct();
		for(Product p:list)
		{
			%>
			<tr>
			<td><%=p.getProductId() %></td>
			<td><%=p.getProductName() %></td>
			<td><%=p.getProductCategory() %></td>
			<td><%=p.getProductPrice() %></td>
			<td><%=p.getProductBrand() %></td>
			<td><%=p.getProductMfd() %></td>
			<td><a href='EditProduct?p1=<%=p.getProductId()%>'>EDIT</a></td>
			<td><a href='DeleteProduct?p1=<%=p.getProductId()%>'>DELETE</a></td>
			</tr>
			<% 
		}
		%>
	</table>
</body>
</html>
