<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page errorPage="errorPage.jsp" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>Insert title here</title>
	</head>
	
	<body>
		<%!
		String adminId;
		String adminPw;
		
		String imgDir;
		String testServerIP;
		
		String str;
		%>
		
		<!--  config 객체 -->
		<%
		adminId = config.getInitParameter("adminId");
		adminPw = config.getInitParameter("adminPw");
		%>
		
		<p>adminId : <%= adminId %></p>
		<p>adminPw : <%= adminPw %></p>
		
		<!-- application 객체 -->
		<%
		imgDir = application.getInitParameter("imgDir");
		testServerIP = application.getInitParameter("testServerIP");
		%>
		
		<p>imgDir : <%= imgDir %></p>
		<p>testServerIP : <%= testServerIP %></p>
		
		<%
		application.setAttribute("connectedIP", "123.123.123.1");
		application.setAttribute("connectedUser", "mainUser");		
		%>
		
		<!--  exception 객체 -->
		<%
		out.print(str.toString());
		%>
		
	</body>
</html>