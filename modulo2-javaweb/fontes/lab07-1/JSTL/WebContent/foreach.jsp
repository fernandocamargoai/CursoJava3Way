<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exemplo - &lt; c:forEach</title>
</head>
<body>
	<h1>Exemplo - &lt; c:forEach</h1>
	<hr>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ page import="java.util.Vector" %>
	
	<h3>Interagindo sobre uma faixa de números</h3>
	<c:forEach var="item" begin="1" end="10">
		${item}	
	</c:forEach>
	
	<%	Vector<String> v = new Vector<String>();
		v.add("um"); v.add("dois"); v.add("tres"); v.add("quatro"); v.add("cinco");
		pageContext.setAttribute("vector", v);	
	%>
	
	<h3>Interagindo sobre um vetor</h3>
	<c:forEach items="${vector}" var="item">
		${item}	
	</c:forEach>
</body>
</html>