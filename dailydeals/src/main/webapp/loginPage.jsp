<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<style type="text/css">
   body {
     margin: 0;
     padding: 0;
     background: url(https://images.fineartamerica.com/images-medium-large/shopping-bags-on-colorful-wood-background-natthawut-punyosaeng.jpg);
     background-size: cover;
     background-position: center;
     font-family: sans-serif;
     
   }
   .loginbox{
   		width: 320px;
   		height: 420px;
   		background: #000;
   		color: #fff;
   		top: 50%;
   		left: 50%;
   		position: absolute;
   		transform: translate(-50%, -50%);
   		box-sizing: border-box;
   		padding: 70px 30px;
   }
   .avatar{
   		width: 100px;
   		height: 100px;
        border-radius: 50%;
        position: absolute;
        top: -9%;
        left: calc(50% - 50px);
   }
   
   h1 { 
      text-align: center;
      font-family: Papyrus, fantasy; font-size: 64px; font-style: normal; font-variant: normal; font-weight: 700; line-height: 26.4px; 
   }
   h2{
   	margin: 0;
   	padding: 0 0 20px;
   	text-align: center;
   	font-size: 22px
   }
   
   .loginbox p{
      	margin: 0;
   		padding: 0 0 20px;
   		font-weight: bold;
   }
   .loginbox input{
   		width: 100%;
   		margin-bottom: 20px; 
   }
   .loginbox input[type="email"], input[type="password"]
   {
   	border: none;
   	border-bottom: 1px solid #fff;
   	background: transparent;
   	outline: none;
   	height: 40px;
   	color: #fff;
   	font-size: 16px;
   }   
   .loginbox input[type="submit"]
   {
   	border: none;
   	outline: none;
   	height: 40px;
   	background: #fb2525;
   	color: #fff;
   	font-size: 18px;
   	border-radius: 20px
   }
   .loginbox input[type="submit"]:hover
   {
   	cursor: pointer;
   	background: #ffc107;
   	color: #000;
   }
   .loginbox a{
   		text-decoration: none;
   		font-size: 12px;
   		line-height: 20px;
   		color: darkgrey
   }
   
   .loginbox a:hover{
   		color: #ffc107;
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
	.signin-btn
	{
		background-color: #fb2525;
	}

</style>



<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>

<body>
    <h1>Welcome to Daily Deals</h1>
	<form action="LoginServlet" method="post">
    <div class="loginbox">
      <img src = "https://img.pngio.com/parent-directory-avatar-2png-avatar-png-256_256.png" class="avatar">
	  <h2>Login Here</h2>
	  <%
	  	try{
	  		boolean authResult = (Boolean)session.getAttribute("authResult");
		  	if(!authResult) {
		  		out.println("<p>email and password didn't match</p>");
		  	}
	  	}
	  	catch(Exception e){
	  	}
	  %>
	  
	  <form>
	  	<p>Email</p>
	  	<input type = "email" name ="user_email" placeholder="Enter Email">
	  	<p>Password</p>
	  	<input type = "password" name="user_pass" placeholder="Enter Password"  minlength="8">
	  	<button type="submit" name="" class="signin-btn" value="LoginServlet">Sign In</button>
	  	<a href ="#">Lost your password?</a><br>
	  	<a href = "/dailydeals/signUpPage.jsp">Don't have an account?</a>
	  </form>
	</div>
</form>

</body>
</html> 