<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="precoNormal" fragment="true" %>
<%@ attribute name="avenda" fragment="true"%>
<%@ variable name-given="nome"%>
<%@ variable name-given="preco"%>
<%@ variable name-given="precoOriginal"%>
<%@ variable name-given="precoVenda"%>

<table border="1">
<tr>
	<td>
		<c:set var="nome" value="Hand-held Color PDA"/>
		<c:set var="preco" value="$298.86"/>
		<jsp:invoke fragment="precoNormal"/>
	</td>
	<td>
		<c:set var="nome" value="4-pack 150 Watt Light Bulbs"/>
		<c:set var="precoOriginal" value="R$12.98"/>
		<c:set var="precoVenda" value="R$12.32"/>
		<jsp:invoke fragment="avenda"/>
	</td>
	<td>
		<c:set var="nome" value="Telefone Celuar Digital"/>
		<c:set var="preco" value="R$968.74"/>
		<jsp:invoke fragment="precoNormal"/>
	</td>
	<td>
		<c:set var="nome" value="Carro Luxuoso"/>
		<c:set var="precoOriginal" value="R$523.980.00"/>
		<c:set var="precoVenda" value="R$421.070.00"/>
		<jsp:invoke fragment="avenda"/>
	</td>
	<td>
		<c:set var="nome" value="Piano"/>
		<c:set var="preco" value="R$10.800.00"/>
	</td>
</tr>
</table>