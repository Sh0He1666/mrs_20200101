<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kakeibo.Topic,java.util.List"%>
<%
// リクエストスコープからインスタンスを取得
Topic topic = (Topic) request.getAttribute("topic");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<!--
Featears to add below
* Creating JavaBeans depending on the role of each class
* Adding caution which enable you to realize you entered wrong type of sentences
* Creating pop up feature to make you confirm the inputs you enter
* Add password function
-->

<head>
<meta http-equiv="Content-Type" content="text/html;
	  charset=UTF-8">
<title>Monthly Purchase History</title>
</head>
<title>Frame Sample</title>
<frameset rows="80,*,300" frameborder="0">
<frame src="title.jsp">
<frameset cols="50%,50%" frameborder="0">
<frame src="toVariable"> <!--サーブレットクラスを指定-->
<frame src="toFixed">
</frameset>
<frame src="toBottom">
</frameset>

</html>


