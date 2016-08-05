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
</head>
<body>
	<!-- Static navbar -->
	<div class="navbar navbar-default navbar-static-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Projeto Banco 3Way NetWorks!</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a>
							<form action="Logout" id="form" method="get">
								Bem vindo, sr(a). <b> <script type="text/javascript">
									document.write(getCookie());
								</script>
								</b> <input type="submit" name="action"
									class="btn btn-xs btn-danger" value="sair">
								<button type="submit" name="action"
									class="btn btn-xs btn-default" value="info">
									<img alt="informações" name="info"
										src="resources/img/information2.png" />
								</button>
							</form>
					</a></li>
				</ul>
			</div>
		</div>
	</div>
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
				<button type="button" class="btn btn-default"
					onclick="window.location='./manterCliente.jsp'">Manter
					Clientes</button>
				<button type="button" class="btn btn-default"
					onclick="window.location='. /operacoesBancarias.jsp'">Operações
					Bancarias</button>
			</div>
		</div>
	</div>
		<!-- Fim Panel menu -->
</body>
</body>
</html>