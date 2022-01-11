<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%!
	String m_name;
	String m_pass;
	String[] m_hobbys;
	%>
	
	<%
	m_name = request.getParameter("m_name");
	m_pass = request.getParameter("m_pass");
	m_hobbys = request.getParameterValues("m_hobby");
	%>
	
	m_name : <%= m_name %> </br>
	m_pass : <%= m_pass %> </br>
	m_hobbys : 
	<%
	for(int i=0; i<m_hobbys.length; i++){
	%>
	<%= m_hobbys[i] %>
	<%
	}
	%> <br>
</body>
</html>