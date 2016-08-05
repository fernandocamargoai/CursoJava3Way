<%@ page isErrorPage="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title><fmt:message key="erro.title" /></title>

<link href="resources/css/bootstrap.css" rel="stylesheet">
<link href="resources/css/footer.css" rel="sykesheet">
</head>

<body>
	<div id="wrap">
		<div class="container">
			<div class="page-header">
				<h1>
					<fmt:message key="erro.500.titulo" />
				</h1>
			</div>
			<p class="lead">
				<fmt:message key="erro.500.aviso" />
			</p>
			<p style="color: red;">
				<%= exception.getCause() %></p>
		</div>
	</div>
	<div id="footer">
		<div class="container">
			<p class="text-muted">
				<fmt:message key="erro.footer" />
			</p>
		</div>
	</div>
</body>
</html>