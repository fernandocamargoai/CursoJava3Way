<html>
<head>
<title>JSP 2.0 Expression Language (EL) - Objetos Implícitos</title>
</head>
<body>
Este exemplo ilustra alguns dos objetos implícitos disponíveis na EL. Os seguintes objetos estão implicitamente
disponíveis (não todos ilustrados aqui):
<table cellpadding="0" cellspacing="0" border="1" style="font-size: 12px; font-family: Verdana;" align="center">
	<tr style="font-weight: bold;" align="center" bgcolor="#CCCCCC">
		<td>EL Map</td>
		<td>Mapeia nome de</td>
		<td>Para seu</td>
		<td>Corresponde na API</td>
	</tr>
	<tr>
		<td>pageScope</td>
		<td>Atributo no escopo da página</td>
		<td>Valor</td>
		<td>PageContext.getAttribute(String nome)</td>
	</tr>
	<tr>
		<td>requestScope</td>
		<td>Atributo no escopo da requisição</td>
		<td>Valor</td>
		<td>ServletRequest.getAttributes(String nome)</td>
	</tr>
	<tr>
		<td>sessionScope</td>
		<td>Atributo no escopo da sessão</td>
		<td>Valor</td>
		<td>ServletContext.getAttribute(String nome)</td>
	</tr>
	<tr>
		<td>param</td>
		<td>Parâmetro da Requisição</td>
		<td>Valor único String</td>
		<td>ServletRequest.getParameter(String nome)</td>
	</tr>
	<tr>
		<td>paramValues</td>
		<td>Parâmetr da Requisição</td>
		<td>String[] de valores</td>
		<td>ServletRequest.getParameterValues(String nome)</td>
	</tr>
	<tr>
		<td>header</td>
		<td>Cabeçalho da Requisição</td>
		<td>Valor único String</td>
		<td>HttpServletRequest.getHeader(String nome)</td>
	</tr>
	<tr>
		<td>headerValues</td>
		<td>Cabeçalho da Requisição</td>
		<td>String[] de Valores</td>
		<td>HttpServletRequest.getHeaders(String nome)</td>
	</tr>
	<tr>
		<td>cookie</td>
		<td>Cookie</td>
		<td>Objeto Cookie</td>
		<td>Primeiro cookie em HttpServletRequest.getCookies() c/ o nome dado</td>
	</tr>
	<tr>
		<td>initParam</td>
		<td>Parâmetro de inicialização Contexto</td>
		<td>Valor String</td>
		<td>ServletContext.getInitParameter(String nome)</td>
	</tr>
</table>

<blockquote><u><b>Alterar Parâmetro</b></u>
<form action="objetos-implicitos.jsp" method="GET">foo = 
	<input type="text" name="foo" value="${param["foo"]}">
	<input type="submit">
</form>
<br>
<code>
<table border="1" style="font-size: 12px; font-family: Verdana;" align="center">
	<thead>
		<td><b>EL Expression</b></td>
		<td><b>Result</b></td>
	</thead>
	<tr>
		<td>\${param.foo}</td>
		<td>${param["foo"]} &nbsp;</td>
	</tr>
	<tr>
		<td>\${param.["foo"]}</td>
		<td>${param["foo"]} &nbsp;</td>
	</tr>
	<tr>
		<td>\${header["host"]}</td>
		<td>${header["host"]}&nbsp;</td>
	</tr>
	<tr>
		<td>\${header["accept"]}</td>
		<td>${header["accept"]}&nbsp;</td>
	</tr>
	<tr>
		<td>\${header["user-agent"]}</td>
		<td>${header["user-agent"]}&nbsp;</td>
	</tr>
</table>
</code>
</blockquote>

</body>
</html>