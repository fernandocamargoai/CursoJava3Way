<%@  taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Exemplo JSP 2.0 - Exibe Produtos Tag File</title>
</head>
<body>
	<h1>Exemplo JSP 2.0 - Exibe Produtos Tag File</h1>
	<hr>
	<h2>Produtos</h2>
	<tags:produtos>
		<jsp:attribute name="precoNormal">
			Item: ${nome}<br/>
			Preco: ${preco}
		</jsp:attribute>
		<jsp:attribute name="avenda">
			Item: ${nome}<br/>
			<font color="red"><strike>Era: ${precoOriginal}</strike></font><br/>
			<b>Agora: ${precoVenda}</b>
		</jsp:attribute>	
	</tags:produtos>
	<tags:produtos>
		<jsp:attribute name="precoNormal">
			<b>${nome}</b><br/> @ ${preco} ea.
		</jsp:attribute>
		<jsp:attribute name="avenda">
			<b>${nome}</b><br/> @ ${precoVenda} ea. (era: ${precoOriginal})
		</jsp:attribute>
	</tags:produtos>
</body>
</html>