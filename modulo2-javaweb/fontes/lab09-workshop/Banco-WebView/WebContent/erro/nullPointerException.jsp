<%@ page isErrorPage="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-U-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="descrition" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">
<title>Sticky Footer template for Bootstrap</title>

<link href="resources/css/bootstrap.css" rel="stylesheet">
<link href="resources/css/footer.css" rel="stylesheet">
</head>

<body>
	<div id="wrap">
		<div class="container">
			<div class="page-header">
				<h1>
					<fmt:message key="erro.nullPointer.titulo" />
				</h1>
			</div>
			<p class="lead">
				<fmt:message key="erro.nullPointer.aviso" />
			</p>
			<p style="color: red;"><%= exception %></p>
		</div>
	</div>

	<div id="footer">
		<div class="container">
			<p class="text-muted">
				<fmt:message key="erro.footer" />
		</div>
	</div>
</body>
</html>