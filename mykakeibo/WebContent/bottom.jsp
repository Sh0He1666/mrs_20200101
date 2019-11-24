<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kakeibo.Topic"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
Topic topic = (Topic) request.getAttribute("topic");
int totalFixed = Integer.valueOf(topic.getTotalFxCost());
int totalVariable = Integer.valueOf(topic.getTotalVariableCost());
int totalExpense = totalFixed + totalVariable;
int availExpense = 200000 - totalExpense;
%>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p><font size="5" color="red">Total Expenses = </font>
<font size="5" color="blue">¥ <%=totalVariable%></font>
<font size="5" color="red"> +</font>
<font size="5" color="orange">¥ <%=totalFixed%></font></p>
<p><font size="5" color="white">Total Expenses </font>
<font size="6" color="red">= ¥ <%=totalExpense%></font></p>
<p><font size="5" color="red">※You can spend ¥ <%=availExpense%> in the rest of this month... </font></p>
<br>
<a href="http://localhost:8080/mykakeibo/Home.jsp" target="_top"><font size="4">Reload (Click here!)</font></a>
<br><a href="http://localhost:8080/mykakeibo/Wizard01.jsp" target="_top"><font size="4">Go to Registor Form (Click here!)</font></a>
<!-- Must Fix below -->
</body>
</html>