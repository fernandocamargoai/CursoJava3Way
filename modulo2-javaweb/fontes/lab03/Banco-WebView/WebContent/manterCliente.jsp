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
					onclick="window.location='./operacoesBancarias.jsp'">Operações
					Bancarias</button>
			</div>
		</div>
		<!-- 	</div> -->
		<!-- Fim Panel menu -->
		<div class="panel-body">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">Cadastrar Cliente</h3>
				</div>
				<div class="panel-body">
					<form class="form-horizontal" role="form">
						<div class="form-group">
							<div class="form-group">
								<label class="col-sm-2 control-label">Nome</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" placeholder="Nome">
								</div>
								<label class="col-sm-2 control-label">Telefone</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" placeholder="Telefone">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Endereço</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" placeholder="Endereço">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Registro Geral</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" placeholder="RG">
								</div>
							</div>
							<div class="row">
								<p class="text-right" style="padding-right: 5%;">
									<button type="button" class="btn btn-primary">Limpar</button>
									<button type="button" class="btn btn-primary">Salvar</button>
									<button type="button" disabled="disabled"
										class="btn btn-primary">Atualizar</button>
									<button type="button" disabled="disabled"
										class="btn btn-primary">Excluir</button>
								</p>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class=“panelbody”>
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">Clientes Cadastrados</h3>
					</div>
					<div class="table-responsive">
						<table class="table table-bordered table-hover">
							<thead>
								<tr>
									<th>#</th>
									<th>Nome</th>
									<th>Endereço</th>
									<th>Telefone</th>
									<th>RG</th>
									<th>CPF</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>--</td>
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
	<!-- /container -->
</body>
</html>