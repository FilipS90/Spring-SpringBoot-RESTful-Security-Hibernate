<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Denied</title>
</head>
<body>

	<h1>You have been denied access for the requested page.</h1>
	
	<hr>
	
	<h3>This is likely due to the inadequate level of authority.</h3>
	
	<hr>
	
	<h5>Consult your admin if you think this is a mistake.</h5>
	
	<hr>
	
	<p><a href="${pageContext.request.contextPath}/">Back to home page</a><p>

</body>
</html>