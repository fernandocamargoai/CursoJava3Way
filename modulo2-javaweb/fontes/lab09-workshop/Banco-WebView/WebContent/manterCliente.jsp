<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="author" content="3Way">
<title>.:: Projeto Banco 3Way Networks::.</title>
<link href="resources/css/bootstrap.css" rel="stylesheet">
<link href="navbar-static-top.css" rel="stylesheet">
<link href="resources/css/geral.css" rel="stylesheet">
<!--<script type="text/javascript">
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
</script> -->

<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/jquery.maskedinput.js"></script>
<script type="text/javascript">
	JQuery(document).ready(function() {
		JQuery("input[name='telefone']").mask("(99)9999-9999");
		JQuery("input[name='cpf']").mask("999.999.999-99");
	});
</script>
</head>
<body>
	<!-- Static navbar -->
	<!-- 	<div class="navbar navbar-inverse navbar-static-top" role="navigation"> -->
	<!-- 		<div class="container"> -->
	<!-- 		<div class="navbar-header"> -->
	<!-- 		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"> -->
	<!-- 			<span class="sr-only"> Toggle navigation </span> -->
	<!-- 			<span class="icon-bar"></span> -->
	<!-- 			<span class="icon-bar"></span> -->
	<!-- 			<span class="icon-bar"></span> -->
	<!--  		</button> -->
	<!--  		<a class="navbar-brand" href="#">Projeto Banco 3WAY NetWorks!</a> -->
	<!--  		</div> -->
	<!--  			<div class="navbar-collapse collapse"> -->
	<!--  				<ul class="nav navbar-nav navbar-right"> -->
	<!--  				<li> -->
	<!--  				<a> -->
	<!--  				<form action="Logout" id="form" method="get"> -->
	<!--  					Bem vindo, sr(a). -->
	<!--  						<b> -->
	<!--  							<script type="text/javascript" > document.write(getCookie()); </script> -->
	<!--  						</b> -->
	<!--  				<input type="submit" name="action" class="btn btn-xs btn-danger" value="sair"> -->
	<!--  				<button type="submit" name="action" class="btn btn-xs btn-default" value="info"> -->
	<!--  					<img alt="informações" name="info" src="resources/img/information2.png"/> -->
	<!--  				</button> -->
	<!--  				</form> -->
	<!--  				</a> -->
	<!--  				</li> -->
	<!--  				</ul> -->
	<!--  			</div> -->
	<!--  		</div> -->
	<!--  		</div>	 -->
	<!-- /Static navbar -->
	<jsp:include page="/templates/cabecalho.jsp"></jsp:include>
	<!-- Container -->

	<div class="container">
		<div class="page-header">
			<h4>Banco: <span style="font-size: 14px; color: red;"> ${agencia.nome}</span></h4>
			<h4>Agência: <span style="font-size: 14px; color: red;"> ${agencia.banco.nome}</span></h4>
		</div>

		<div class="panel panel-defaul">
<!-- 			<!-- Panel referente ao menu --> 
<!-- 			<div class="panel-body"> -->
<!-- 				<button type="button" class="btn btn-default" disabled="disabled" -->
<!-- 					onclick="window.location='./manterCliente.jsp'">Manter -->
<!-- 					Clientes</button> -->
<!-- 				<button type="button" class="btn btn-default" -->
<!-- 					onclick="window.location='./operacoesbancarias.jsp'">Operações -->
<!-- 					Bancarias</button> -->
			<jsp:include page="/templates/menu.jsp"/>
			<c:if test="${msg != null }">
				<div class="alert alert-danger fade in" id="btnIndividual">
					<button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>
					<strong>${msg}</strong>				
				</div>
			</c:if>

	<div class="panel-body">
		<div class="panel panel-primary">
			<div class="panel-heading">
<!-- 				<h3 class="panel-title">Cadastrar Cliente</h3> -->
			</div>
			<div class="panel-body">
				<form class="form-horizontal" action="ManterCliente" method="post"
					role="form">
						<div class="form-group">
							<label class="col-sm-2 control-label">
								<fmt:message key="form.cliente.nome"/>: <a style="color: red;">*</a>
							</label>
							<div class="col-sm-4">
								<input type="text" name="nome" class="form-control" value="${cliente.nome}"
									placeholder="<fmt:message key="form.cliente.nome"/>">
							</div>
							<label class="col-sm-1 control-label"><fmt:message key="form.cliente.telefone"/>:</label>
							<div class="col-sm-4">
								<input type="text" name="telefone" class="form-control"
									placeholder="<fmt:message key="form.cliente.telefone"/>" value="${cliente.telefone}">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label"><fmt:message key="form.cliente.endereco"/>:</label>
							<div class="col-sm-10">
								<input type="text" name="endereco" class="form-control" value="${cliente.endereco}"
									placeholder="<fmt:message key="form.cliente.endereco"/>">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label"><fmt:message key="form.cliente.rg"/>:</label>
							<div class="col-sm-10">
								<input type="text" name="rg" class="form-control" value="${cliente.rg}"
									placeholder="<fmt:message key="form.cliente.rg"/>">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">
								<fmt:message key="form.cliente.cpf"/>: <a style="color: red;">*</a>
							</label>
							<div class="col-sm-10">
								<input type="text" name="cpf" value="${cliente.cpf}" class="form-control"
									placeholder="<fmt:message key="form.cliente.cpf"/>">
							</div>				
						</div>
						<span>Campos Obrigatórios</span>
						<div class="row">
							<p class="text-right" style="padding-right: 5%">
								<button type="reset" class="btn btn-primary">
									<fmt:message key="btn.cliente.limpar"/>
								</button>
								<c:if test="${cliente == null}">
									<button type="submit" name="action" value="salvar" class="btn btn-primary">
										<fmt:message key="btn.cliente.salvar"/>
									</button>
								</c:if>
								<c:if test="${cliente != null}">
									<button type="submit" name="action" value="alterar" class="btn btn-primary">
										<fmt:message key="btn.cliente.salvar"/>									
									</button>
									<button type="submit" name="action" value="excluir"	class="btn btn-primary">
										<fmt:message key="btn.cliente.excluir"/>
									</button>
								</c:if>
							</p>
						</div>
				</form>
			</div>
		</div>

	<div class="panel panel-primary">
		<div class="panel-heading">			
<!-- 				<h3 class="panel-title">Clientes Cadastrados</h3> -->
			</div>
			<div class="table-responsive">
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th>#</th>
							<th>
								<fmt:message key="form.cliente.nome"/>
							</th>
							<th>
								<fmt:message key="form.cliente.endereco"/>
							</th>
							<th>
								<fmt:message key="form.cliente.telefone"/>
							</th>
							<th>
								<fmt:message key="form.cliente.endereco"/>
							</th>
							<th>
								<fmt:message key="form.cliente.rg"/>
							</th>
							<th>
								<fmt:message key="form.cliente.cpf"/>
							</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listaClientes}" var="cliente" varStatus="index">
						<tr>
							<td>${index.count}</td>
							<td>${cliente.nome}</td>
							<td>${cliente.endereco}</td>
							<td>${cliente.telefone}</td>
							<td>${cliente.rg}</td>
							<td>${cliente.cpf}</td>
							<td style="width: 125px;">
								[<a href="./ManterCliente?action=carregar&cpf=${cliente.cpf}" 
								style="font-size: 11px;">Carregar</a>]
							</td>
						</tr>
						</c:forEach>
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