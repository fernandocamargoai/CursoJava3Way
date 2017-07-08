<%@ page import="br.com.threeway.locadora.domain.TipoFilme" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fernandocamargo
  Date: 08/07/17
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form method="post" action="filmes">
	<input type="hidden" name="id" value="${filme.id}">
	<label>Nome</label>
	<input type="text" name="nome" value="${filme.nome}">
	<label>Tipo</label>
	<select name="tipo">

		<c:forEach items="${TipoFilme.values()}" var="tipo">
			<option value="${tipo}" ${tipo == filme.tipo ? "selected":""}>${tipo}</option>
		</c:forEach>

    </select>
<button type="submit">Cadastrar</button>
</form>
