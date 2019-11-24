<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--< page import="kakeibo.Topic" -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//
 EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;
	  charset=UTF-8">
<title>Input surface</title>
</head>

<body>

<center>
<h2><big>Register Form ~Variable Costs~</big></h2>
<a href="Wizard01.jsp">Reload</a>
<br>
</center>
<form action="/mykakeibo/post" method="post">
<!-- input password -->
<!-- <p>Enter your password:<input type="password" name="password"></p> -->
<!-- choose genre -->
<br>Enter a genre:<select name="genre">
<option value="Food">Food</option>
<option value="Book">Book</option>
<option value="Utility Cost">Utility Cost</option>
<option value="Else">Else</option>
</select>

<!-- input a product name -->
<br>What did you buy?
	<br> Enter the name:<input type="text" name="prname">
<!-- input cost -->
<br>How much money did you pay?
	<br>Enter the cost:<input type="text" name="cost">
<br>Completed? Smash the right buttom →
	<input type="submit" value="submit"><input type="reset" value="Reset">
<br><a href="http://localhost:8080/mykakeibo/Home.jsp">Go to Home page.</a>
<br><a href="http://localhost:8080/mykakeibo/Wizard02.jsp">Go Input Fixed Costs</a>
</form>

</body>
</html>