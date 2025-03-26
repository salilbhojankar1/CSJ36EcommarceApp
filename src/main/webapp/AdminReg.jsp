<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<center>
<h2>kindly give your personal information</h2>
<body bgcolor='green'>
<form action="AdminReg" method="post">
<label for="adminId">Enter Admin ID</label>
<input type = "text" name="id"><br>

<label for="adminName">Enter Admin NAME</label>
<input type = "text" name="name"><br>

<label for="adminAddress">Enter Admin Address</label>
<textarea rows = "10" cols="10" name="address"></textarea><br>

<label for="adminEmail">Enter Admin mail ID</label>
<input type = "text" name="mail"><br>

<label for="adminPhone">Enter Admin phone</label>
<input type = "text" name="phone"><br>

<label for="adminDOB">Enter Admin DOB</label>
<input type = "date" name="dob"><br>

<input type="submit" value="signup">

</form>

<body>

</body>
</center>
</html>