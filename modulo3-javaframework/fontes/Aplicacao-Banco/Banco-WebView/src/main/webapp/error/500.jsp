<%@ page isErrorPage="true"%>
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
		<div class="container" style="text-align: center; top:50px;">
			<img  src="./resources/img/ops.gif" style="text-align: center;">
			<div class="page-header">
				<h3>
					<fmt:message key="erro.500.titulo" />
				</h3>
			</div>
			<p class="lead">
				<fmt:message key="erro.500.aviso" />
			</p>
			<div style="height:400px;color:red;overflow: scroll;text-align: left;font-size:12px;">
				<jsp:scriptlet>
	  			 	exception.printStackTrace(new java.io.PrintWriter(out));   			 		
				</jsp:scriptlet>
			</div>

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
