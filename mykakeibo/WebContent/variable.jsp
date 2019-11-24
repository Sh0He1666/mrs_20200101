<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kakeibo.Topic,java.util.List"%>
<%
// リクエストスコープからインスタンスを取得
Topic topic = (Topic) request.getAttribute("topic");

%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>variable costs</title>
</head>


<body>

<p><font size="5">①Variable Costs</font></p>
<p><font size="4">◯Food: ¥ <%=topic.getMonthlyFoodCost()%></font></p>
<p><font size="4">◯Book: ¥ <%=topic.getMonthlyBookCost()%></font></p>
<p><font size="4">◯Utility Cost: ¥ <%=topic.getMonthlyUtilityCost()%></font></p>
<p><font size="4">◯Else: ¥ <%=topic.getMonthlyElseCost()%></font></p>
<p><font size="5" color="blue">Total Costs①: ¥ <%=topic.getTotalVariableCost()%></font></p>


</body>
</html>