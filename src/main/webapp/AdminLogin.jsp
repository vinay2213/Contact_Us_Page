<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login Page</title>


<link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">

</head>

<body>
	<div class="abcd">
		<h1>Admin Login</h1>
	</div>
	
	<form action="${pageContext.request.contextPath}/admin/login" method="post">
		Email : <input type="text" name="email" required /> <br/> <br/>
		Password : <input type="password" name="password" required /> <br/> <br/>
		<input type="submit" value="LOGIN" />
	</form>
</body>
</html>