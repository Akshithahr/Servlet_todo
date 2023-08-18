<%-- <!-- This is discriptive tag-->
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!-- This is html-->
<h1>This is HTML Tag</h1>


<!-- This is comment-->
<!-- System.out.println("this is java code"); -->

<!-- This is Scriptlet Tag-->
<% System.out.println("this is java code");%>

 <!-- This is Declarative Tag-->
<%! int a=10;%>
<%System.out.println(a); %>

<!-- This is Expression Tag-->
  <%=new Random().nextInt(100)%>  --%>
  
 
 


</body>
</html>