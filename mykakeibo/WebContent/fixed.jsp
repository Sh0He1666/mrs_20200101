<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kakeibo.Topic,java.util.List"%>
<%
// リクエストスコープからインスタンスを取得
List<Topic> fixed = (List<Topic>) request.getAttribute("fixed");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
<p><font size="5">②Fixed Costs</font></p>
<%
if (fixed != null) {
	for (int i=0; i < fixed.size();i++) {
		Topic fix = fixed.get(i);
		if (fix.getFxName() != null && fix.getFxCost() != null) {
%>

<p><font size="4"><%=fix.getFxName()%>: ¥ <%=fix.getFxCost()%></font></p>

<%
		}
		if (fix.getTotalFxCost() != null){
%>
<p><font size="4" color="orange">Total Costs②: ¥ <%=fix.getTotalFxCost()%></font></p>

<%
		}
	}
}
%>

</body>
</html>