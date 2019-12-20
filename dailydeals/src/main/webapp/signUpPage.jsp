<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<style type="text/css">

	body
	{
		margin: 0;
		padding: 0;
		font-family: sans-serif;
		background-image: url(https://images.fineartamerica.com/images-medium-large/shopping-bags-on-colorful-wood-background-natthawut-punyosaeng.jpg);
		background-size: cover;
		background-position: center; 
	}
	.sign-up-form
	{
		width: 300px;
		box-shadow: 0 0 3px 0 rgba(0,0,0,0.3);
		background: #fff;
		padding: 20px;
		margin: 8% auto 0;
		text-align: center;
		
	}
	.sign-up-form h1
	{
		color: #1c8adb;
		margin-bottom: 30px;
	}
	.input-box 
	{
		border-radius: 20px;
		padding: 6.7px;
		margin: 10px 0;
		width: 100%;
		border: 1px solid #999;
		outline: none;
	}
	button
	{
		color: #fff;
		width: 100%;
		padding: 10px;
		border-radius: 20ps;
		font-size: 15px;
		margin:  10px 0;
		border: none;
		outline: none;
		cursor: pointer;
	}
	.signup-btn
	{
		background-color: #fb2525;
	}
	hr
	{
		margin-top: 50px;
		width: 80%;
	}
	.or
	{
		backgroung: #fff;
		width: 30px;
		margin: -33px auto 10px; 
	}
	img
	{
		width: 70 px;
		margin-top: -50px;
	}
</style>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
	<body>
	
	<div class="sign-up-form">
	    <img src ="https://img.pngio.com/parent-directory-avatar-2png-avatar-png-256_256.png">
		<h1>Sign Up Here</h1>
		<%
			try{
				boolean emailIsUsed = (Boolean)session.getAttribute("emailIsUsed");
				if(emailIsUsed){
					out.println("<p>This email has been used.</p>");
				}
			}
			catch(Exception e){
				
			}
		%>
		<form action="SignUpServlet" method="post">
		    <input type="text" class="input-box" name="user_fn" placeholder="First Name">
		    <input type="text" class="input-box" name="user_ln" placeholder="Last Name">
			<input type="email" class="input-box" name="user_email" placeholder="Your Email">
			<input type="text" class="input-box" name="user_username" placeholder="Your Username">
			<input type="password" class="input-box" name="user_pass" placeholder="Your Password"  minlength="8">
			<p> </p>
			<button type="submit" class="signup-btn" value="SignUpServlet">Sign up</button>
			<hr>
			<p class="or">OR</p>
			<p>Do you have an account ? 
				<a href="/dailydeals/loginPage.jsp">Sign in</a>
			</p>
					
		</form>
	</div>
	</body>
</html>