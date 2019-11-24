<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<h2><big>Register Form ~Fixed Costs~</big></h2>
<a href="Wizard02.jsp">Reload</a>
<br>
</center>
<form action="/mykakeibo/postf" method="post">
<!-- Input fx_name -->
<br>Input fixed_cost name that you want to add.
   <br>Enter the name:<input type="text" name="fx_name">
<!-- Input fx_cost -->
<br>Input the fixed_cost.
   <br>Enter the cost:<input type="text" name="fx_cost">
<br>Completed? Smash the right buttom →
	<input type="submit" value="submit"><input type="reset" value="Reset">
<br><a href="http://localhost:8080/mykakeibo/Home.jsp">Go to Home page.</a>
<br><a href="http://localhost:8080/mykakeibo/Wizard01.jsp">Go Input Variable Costs</a>
</form>

</body>
</html>