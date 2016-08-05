<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Verifica</title>
</head>
<body>
	<h1>Verifica se o campo nome foi preenchido</h1>
	<hr>
	<c:if test="${empty param.nome}">
		Você não preencheu o seu nome!
	</c:if>
	<c:if test="${not empty param.nome}">
		O seu nome é ${param.nome}
	</c:if>
</body>
</html>