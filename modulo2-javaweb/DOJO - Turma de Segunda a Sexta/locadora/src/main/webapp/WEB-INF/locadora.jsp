<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fernandocamargo
  Date: 24/07/17
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Locadora</title>
</head>
<body>
<form method="post" action="filmes">

	<input type="hidden" name="id" value="${filme.id}"/>
	<label>Nome</label>
	<input type="text" name="nome" value="${filme.nome}"/>
	<label>Tipo</label>
	<select name="tipo">
		<c:forEach items="${tipos}" var="tipo">

			<option value="${tipo}" ${filme.tipo == tipo ? "selected" : ""}>${tipo.nome}</option>

		</c:forEach>

	</select>
	<input type="submit" value="Cadastrar"/>

</form>

<h5>Lista de Filmes</h5>
<table>
	<thead>
	<tr>
		<td>Nome</td>
		<td>Tipo</td>
		<td>Ações</td>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${filmes}" var="filme">
		<tr>
			<td>${filme.nome}</td>
			<td>${filme.tipo.nome}</td>
			<td><a href="filmes?id=${filme.id}">Editar</a><a href="filmes?id=${filme.id}&deletar">Deletar</a></td>


		</tr>
	</c:forEach>
	</tbody>
</table>
</body>
</html>
