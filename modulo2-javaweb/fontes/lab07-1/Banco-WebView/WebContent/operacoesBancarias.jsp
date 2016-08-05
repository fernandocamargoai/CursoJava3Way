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
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-body">
				<!-- Implementação conteudo da pagina operações bancarias -->
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">Operações Bancarias</h3>
					</div>
					<div class="panel-body">
						<form role="form">

							<div class="container">
								<div class="col-md-12">
									<h3>
										Cliente: <span style="color: #990000">${conta.titular.nome}</span>
									</h3>
									<h2>Dados Bancarios</h2>
									<p>
										Nº conta: <span style="color: #990000"><input disabled="disabled" value="${conta.numero}"></span>
										Data da abertura: <span style="color: #990000"><input disabled="disabled" value="${conta.dataFormatada}"></span>
										Saldo: <span style="color: #990000"><input disabled="disabled" value="${conta.saldo}"></span>
									</p>
								</div>
							</div>
							<hr>
							<div class="row">
								<p class="text-right" style="padding-right: 5%;">
									<button class="btn btn-sn btn-primary" data-toggle="modal"
										data-target="#modalConta">Abrir Conta</button>
									<button class="btn btn-sn btn-success" data-toggle="modal"
										data-target="#modalSaque">Deposito</button>
									<button class="btn btn-sn btn-danger" data-toggle="modal"
										data-target="#modalDeposito">Saque</button>
									<button class="btn btn-sn btn-warning" data-toggle="modal"
										data-target="#modalTransferencia">Transferencia</button>
								</p>
							</div>
						</form>
					</div>
				</div>

				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">Transações</h3>
					</div>
					<div class="table-responsive">
						<table class="table table-bordered table-hover">
							<thead>
								<tr>
									<th>Tipo Transação</th>
									<th>Titular/Conta Afetada</th>
									<th>Data</th>
									<th>Valor</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>--</td>
									<td>--</td>
									<td>--</td>
									<td>--</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>