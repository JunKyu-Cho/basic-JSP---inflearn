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
		String adminId, adminId2;
		String adminPw;
		
		String imgDir, imgDir2;
		String testServerIP;
		
		String str;
		%>
		
		<!--  config 객체 => <init-param> -->
		<%
		adminId = config.getInitParameter("adminId");
		adminId2 = getServletConfig().getInitParameter("adminId");
		adminPw = config.getInitParameter("adminPw");
		%>
		
		<p>adminId : <%= adminId %></p>
		<p>adminId2 : <%= adminId2 %></p>
		<p>adminPw : <%= adminPw %></p>
		
		<!-- application 객체 => <context-param> -->
		<%
		imgDir = application.getInitParameter("imgDir");
		imgDir2 = getServletContext().getInitParameter("imgDir");
		
		testServerIP = application.getInitParameter("testServerIP");
		%>
		
		<p>imgDir : <%= imgDir %></p>
		<p>imgDir2 : <%= imgDir2 %></p>
		<p>testServerIP : <%= testServerIP %></p>
		
		<%
		application.setAttribute("connectedIP", "123.123.123.1");
		application.setAttribute("connectedUser", "mainUser");		
		%>
		
		<!--  exception 객체 -->
		<%
		// out.print(str.toString());
		%>
		
	</body>
</html>