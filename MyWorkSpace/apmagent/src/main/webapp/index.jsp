<%@page import="com.cs.jeff.apmagent.util.APMAgentUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jeff Wang APMAgent Docker Web</title>
<%
String sysId = APMAgentUtil.getSystemId();
%>
</head>
<body>
<h1>Jeff Wang APMAgent Web</h1>
<p>System Id:</p><%=sysId%>
</body>
</html>