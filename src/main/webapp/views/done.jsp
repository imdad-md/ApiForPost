<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="get">
		<h1>here showing added details of the lead</h1>

		<h1>your name is: ${saved.firstName }</h1>
		<h1>your city is: ${saved.lastName }</h1>
		<h1>your address is:${saved.email }</h1>
		<h1>your address is:${saved.mobile }</h1>

		<br> <input type="submit" value="Submit">

	</form>
</body>
</html>