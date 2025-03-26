<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="sky blue">
	<form action="SaveProduct" method="post">
		<label for="pname">Enter Product Name</label>
		<input type="text" name="t1"><br>
		
		<label for="pcategory">Enter Product Category</label>
		<select name="t2">
			<option value="electronics">Electronics</option>
			<option value="cloths">Cloths</option>
			<option value="sports">Sports</option>
		</select><br>
		
		<label for="price">Enter Product Price</label>
		<input type="text" name="t3"><br>
		
		<label for="pbrand">Enter Product Brand</label>
		<select name="t4">
			<option value="lg">LG</option>
			<option value="sony">SONY</option>
			<option value="samsung">SAMSUNG</option>
			<option value="peter-england">PETER ENGLAND</option>
			<option value="max">MAX</option>
		</select><br>
		<label for="date">Enter Date</label>
		<input type="date" name="t5"><br>
		
		<input type="submit" value="ADD PRODUCT">
	</form>
</body>
</html>
