<%@page import="com.cs.jeff.util.DockerUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jeff Wang Docker Web</title>
<%
String sysId = DockerUtil.getSystemId();
%>
</head>
<body>
<h1>Jeff Wang Docker Web</h1>
<p>System Id:</p><%=sysId%>
</body>
</html>