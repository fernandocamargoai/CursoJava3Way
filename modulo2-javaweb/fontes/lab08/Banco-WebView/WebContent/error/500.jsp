<%@ page isErrorPage="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title><fmt:message key="erro.title" /></title>

<!-- Bootstrap core CSS -->
<link href="resources/css/bootstrap.css" rel="stylesheet">
<link href="resources/css/footer.css" rel="stylesheet">

</head>

<body>

	<!-- Wrap all page content here -->
	<div id="wrap">
		<!-- Begin page content -->
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
				<%= exception.getCause()%>
			</p>

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