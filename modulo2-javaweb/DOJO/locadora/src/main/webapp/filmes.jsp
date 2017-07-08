<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fernandocamargo
  Date: 08/07/17
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Locadora</title>
</head>
<body>
<h1>Página inicial da locadora</h1>
<jsp:include page="cadastro.jsp"></jsp:include>
<table>
	<thead>
	<tr>
		<th>ID</th>
		<th>Nome</th>
		<th>Tipo</th>
		<th>Ações</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${filmes}" var="filme">
	<tr>
		<td>${filme.id}</td>
		<td>${filme.nome}</td>
		<td>${filme.tipo}</td>
		<td>
			<a href="filmes?id=${filme.id}">Editar</a> |
			<a href="filmes?id=${filme.id}&deletar">Deletar</a>
		</td>
	</tr>
	</c:forEach>
	</tbody>
</table>
</body>
</html>
