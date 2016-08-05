<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="author" content="3WAY">

<title>.:: Projeto Banco 3Way NetWorks ::.</title>

<link href="resources/css/bootstrap.css" rel="stylesheet">
<link href="navbar-static-top.css" rel="stylesheet">

<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script type="text/javascript">
      function getCookie() { 
			
			//pega os cookies e coloca em um a array
		var cookie = document.cookie;

		//separa os cookies pelo ";"
		var arrayCookies = cookie.split(";");
		
		//percorre o array de cookkies
		for (i=0; i<arrayCookies.length; i++) {
			
			//pega o cookie na posiçao atual e  separa em 
			//um array contendo o nome do cookie e o valor
			pos = arrayCookies[i].split("=");
			
			//se a primeira posiçao do array criado for equivalente ao nome do cookie ("usuario")
			//retornamos o valor dele, correspondente a segunda posição do array
			if(pos[0] =="usuario") {
				return pos[1];
			}
		}
		return ""
       }
    </script>
</head>
<body>
	<!-- Static navbar -->
		<jsp:include page="/templates/cabecalho.jsp"></jsp:include>
	<!-- /Static navbar -->
	<!-- Container -->

	<div class="container">
		<div class="page-header">
			<h4>Banco:</h4>
			<h4>Agência:</h4>
		</div>

		<div class="panel panel-default">
			<!-- Panel referente ao menu -->
			<div class="panel-body">
			<jsp:include page="/templates/menu.jsp"/>
			</div>
		</div>
	</div>
		<!-- Fim Panel menu -->
</body>
</body>
</html>