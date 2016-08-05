<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>.:: Projeto Banco 3Way NetWorks::.</title>
<link href="resources/css/bootstrap.css" rel="stylesheet">
<link href="resources/css/geral.css" rel="stylesheet">
<script type="text/javascript">
 	function getCookie() {
 		
 		var cookie = document.cookie;
 		var arrayCookies = cookie.split(";");
 		for(i=0;i<arrayCookies.length; i++){
	 		 
	 		 pos = arrayCookies[i].split("=");
	 		 
	 		 if(pos[0]=="usuario") {
	 		   return pos[1];	 		   
	 		 }
 		} 		
 		return " "
 	}
</script>
</head>

<body>	
	<!-- Static navbar -->
	<jsp:include page="/templates/cabecalho.jsp"/>
	<!-- /Static navbar -->
	
	<!-- container -->
	<div class="container">
		<div class="page-header">
			<h4>Banco: <span style="font-size: 14px; color: red;"> ${agencia.nome}</span></h4>
			<h4>Agência: <span style="font-size: 14px; color: red;"> ${agencia.banco.nome}</span></h4>
		</div>
		
		<div class="panel panel-default">
			<!-- Panel referente ao menu -->
		
			<jsp:include page="/templates/menu.jsp"></jsp:include>

			<!-- Fim panel menu -->
		</div>
	</div>
	<!-- /container -->
	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
</body>
</html>