<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">

   body {
     margin: 0;
     padding: 0;
     background: url(https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSm1pnmZoduJOLVdWdeaV2hPo-EyQSDcIdMCpNverqYdmLouctn_A);
     background-size: cover;
     background-position: center;
     font-family: sans-serif;
     
   }
   	.management
	{
		width: 300px;
		box-shadow: 0 0 3px 0 rgba(0,0,0,0.3);
		background: #fff;
		padding: 35px;
		margin: 8% auto 0;
		text-align: center;
		
	}
    h1
	{
		color: #000000
		font-family: sans-serif;
		margin-bottom: 62px;
		text-align: center;
	}
	img
	{
		width: 70 px;
		margin-top: -50px;
	}
   .management input[type="submit"]
   {
   	border: none;
   	outline: none;
   	height: 40px;
   	width: 150px;
   	background: #000000;
   	color: #fff;
   	font-size: 22px;
   	border-radius: 20px
   }
   .management input[type="submit"]:hover
   {
   	cursor: pointer;
   	background: #ffc107;
   	color: #000;
   }
   .management p{
      	margin: 0;
   		padding: 0 0 20px;
   		font-weight: bold;
   }
    .management input{
   		width: 100%;
   		margin-bottom: 20px; 
   }
    .management input[type="text"], input[type="password"], input[type="email"]
   {
   	border: 1px solid #000000;
   	border-bottom: 1px solid #000000;
   	background: transparent;
   	outline: none;
   	height: 40px;
   	color: #000000;
   	font-size: 16px;
   } 
	.inputbox 
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
		color: #fff00;
		width: 100%;
		padding: 10px;
		border-radius: 20ps;
		font-size: 15px;
		margin:  10px 0;
		border: none;
		outline: none;
		cursor: pointer;
	}
	.update-btn
	{
		background-color: #fb2525;
	}
</style>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <h1>Account Management</h1>

    <div class="management">
    
      <img src = "https://img.pngio.com/parent-directory-avatar-2png-avatar-png-256_256.png" class="avatar">
      <hr>
	  <form action="AccountManagementServlet" method="post">
	  
	    <p>Existing Email Address *</p>
	    <input type = "email" name="user_email" class = "inputbox" placeholder=" Enter Email" required>
	  
	  	<p>Current Password *</p>
	  	<input type = "text" name ="user_old_pass" class = "inputbox" placeholder=" Old Password" required>
	  	<p>New Password</p>
	  	<input type = "password" name="user_new_pass" class = "inputbox" placeholder=" New Password">
	  	<p>Country/Region</p>
	  	<select id="Region" name="region" class ="inputbox">
	  		  <option value =""></option>
	  		  <option value="US">United States</option>
  			  <option value="UK">United Kingdom</option>
              <option value="Canada">Canada</option>
	  	</select>
	  	<p> </p>
	  	<p>Street Address</p>
	  	<input type = "text" name="user_addr_1" class = "inputbox" placeholder=" Street and number, P.O. box, c/o">
	  	<p></p>
	  	<input type = "text" name="user_addr_2" class = "inputbox" placeholder=" Apartment, suite, unit, building, floor, ect.">
	  	
	  	<p>City</p>
	    <input type = "text" name="user_city" class = "inputbox">
	    
	    <p>State/Province</p>
	    <input type = "text" name="user_state" class = "inputbox">
	    
	    <p>Zip Code</p>
	    <input type = "text" name="user_zip" class = "inputbox">
	  	
	    <p>Credit Card Number</p>
	    <input type = "text" name="user_card" class = "inputbox" placeholder=" xxxx-xxxx-xxxx-xxxx">
	  	
	  	<p> </p>
	  	<button type= "submit" class="update-btn" name="" value="AccountManagementServlet">Update</button>
	  	<hr>
	  	<p> </p>
	  	<a href ="#">Lost your password?</a><br>
	  	<a href = "/dailydeals/mainGUI.jsp">Return to main page</a>
	  </form>
	</div>
</body>
</html>