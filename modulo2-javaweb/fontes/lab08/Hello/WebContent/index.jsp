<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> Olá, meu nome é JSP. Qual é o seu?</h2>
	<form method="get">
		<input type="text" name="nome" size="25"> <br>
		<input type="text" name="hobby" size="25">
		<p></p>
		<input type="submit" value="Enviar" >
		<input type="reset" value="Resetar">
	</form>
	<%
		String nome = request.getParameter("nome");
		if (nome != null && nome.length() > 0) {
	%>
		<%@include file="response.jsp" %>		
	<%
		} 
	%>

</body>
</html>