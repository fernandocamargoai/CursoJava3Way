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

		//separa os cookies pelo “;”
		var arrayCookies = cookie.split(";");
		
		//percorre o array de cookkies
		for (i=0; i<arrayCookies.length; i++) {
			
			//pega o cookie na posiçao atual e  separa em 
			//um array contendo o nome do cookie e o valor
			pos = arrayCookies[i].split("=");
			
			//se a primeira posiçao do array criado for equivalente ao nome do cookie (“usuario”)
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
		<!-- Fim Panel menu -->
		<div class="panel-body">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">Cadastrar Cliente</h3>
				</div>
				<div class="panel-body">
					<form class="form-horizontal" role="form" action="ManterCliente"
						method="post">
						<div class="form-group">
							<div class="form-group">
								<label class="col-sm-2 control-label">Nome</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" name="nome"
										placeholder="Nome">
								</div>
								<label class="col-sm-2 control-label">Telefone</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" name="telefone"
										placeholder="Telefone">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Endereço</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="endereco"
										placeholder="Endereço">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Registro Geral</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="rg"
										placeholder="RG">
								</div>
							</div>
							<div class="row">
								<p class="text-right" style="padding-right: 5%;">
									<button type="reset" class="btn btn-primary">Limpar</button>
									<button type="submit" class="btn btn-primary">Salvar</button>
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