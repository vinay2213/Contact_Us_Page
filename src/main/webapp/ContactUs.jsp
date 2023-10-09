<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Contact Us Page</title>
<link rel="stylesheet" href="style.css">
</head>

<body>
		
		<div class="abcd">
			<div>
				<h1>Contact Us</h1>
				</div>
				Please fill this form in a descent manner
			
		</div>
		
		
	
	<form action="contactus" method="post">
	
		<label> <h3> Full Name <span style='color: red'> * </span> </h3> </label> 
		<input type="text" name="name1" required /> <br /> <br /> 
		
		<label><h3>E-mail <span style='color: red'> * </span></h3></label> 
		<input type="text" name="email1" required /> <br />
		example@example.com <br /> <br /> 
		
		<label><h3> Message <span style='color: red'> * </span></h3></label> 
		<input type="text" name="message" required /> <br /> <br /> 
		<input type="submit" value="SUBMIT">
		
		
	</form>


</body>
</html>
