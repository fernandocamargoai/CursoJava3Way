<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="author" content="Wilker Machado">
<meta name="author" content="Ezequiel">

<title>.:: Projeto Banco 3Way NetWorks ::.</title>


<link href="resources/css/bootstrap.css" rel="stylesheet">
<link href="resources/css/geral.css" rel="stylesheet">
<script type="text/javascript" src="resources/js/jquery.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/jquery.maskedinput.js"></script>

<script type="text/javascript">
	jQuery(document).ready(function() {

		jQuery("input[name='telefone']").mask("(99)9999-9999");
		jQuery("input[name='cpf']").mask("999.999.999-99");
	});
</script>
</head>


<body>

	<!-- Static navbar -->
	<jsp:include page="/templates/cabecalho.jsp" />

	<!-- Container -->

	<div class="container">

		<div class="page-header">
			<h4>
				Banco: <span style="font-size: 14px; color: red;">
					${agencia.nome} </span>
			</h4>
			<h4>
				Agência: <span style="font-size: 14px; color: red;">
					${agencia.banco.nome} </span>
			</h4>
		</div>

		<div class="panel panel-default">

			<jsp:include page="/templates/menu.jsp" />

			<c:if test="${msg != null}">
				<div class="alert alert-danger fade in" id="btnIndividual">
					<button type="button" class="close" data-dismiss="alert"
						aria-hidden="true">×</button>
					<strong>${msg}</strong>
				</div>
			</c:if>
<div class="panel-body">
	<div class="panel panel-primary">
		<div class="panel-heading">
			<!-- <h3 class="panel-title">Cadastrar Cliente</h3> -->
		</div>
		<div class="panel-body">
			<form class="form-horizontal" method="post" action="ManterCliente"
				role="form">
				<div class="form-group">
					<label class="col-sm-2 control-label"><fmt:message
							key="form.cliente.nome" />:<a style="color: red">*</a></label>
					<div class="col-sm-4">
						<input type="text" name="nome" value="${cliente.nome}"
							class="form-control"
							placeholder="<fmt:message key="form.cliente.nome"/>" required="required">
					</div>
					<label class="col-sm-2 control-label"><fmt:message
							key="form.cliente.telefone" />:</label>
					<div class="col-sm-4">
						<input type="text" name="telefone" class="form-control"
							placeholder="<fmt:message key="form.cliente.telefone"/>"
							value="${cliente.telefone}">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label"><fmt:message
							key="form.cliente.endereco" />:</label>
					<div class="col-sm-10">
						<input type="text" name="endereco" value="${cliente.endereco}"
							class="form-control"
							placeholder="<fmt:message key="form.cliente.endereco"/>">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label"><fmt:message
							key="form.cliente.rg" />:</label>
					<div class="col-sm-10">
						<input type="text" name="rg" value="${cliente.rg}"
							class="form-control"
							placeholder="<fmt:message key="form.cliente.rg"/>">
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label"><fmt:message
							key="form.cliente.cpf" />:<a style="color: red">*</a></label>
					<div class="col-sm-10">
						<input type="text" name="cpf" value="${cliente.cpf}"
							class="form-control"
							placeholder="<fmt:message key="form.cliente.cpf"/>" required="required">
					</div>
				</div>
				<span>Campos obrigatorios <a style="color: red">*</a></span>
				<div class="row">
					<p class="text-right" style="padding-right: 5%;">
						<button type="submit" class="btn btn-primary">
							<fmt:message key="btn.cliente.limpar" />
						</button>
						<c:if test="${cliente == null}">
							<button type="submit" name="action" value="salvar"
								class="btn btn-primary">
								<fmt:message key="btn.cliente.salvar" />
							</button>
						</c:if>
						<c:if test="${cliente != null}">
							<button type="submit" name="action" value="alterar"
								class="btn btn-primary">
								<fmt:message key="btn.cliente.salvar" />
							</button>
							<button type="submit" name="action" value="excluir"
								class="btn btn-primary">
								<fmt:message key="btn.cliente.excluir" />
							</button>
						</c:if>
					</p>
				</div>
			</form>
		</div>
	</div>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<!-- 							<h3 class="panel-title">Clientes Cadastrados</h3> -->
		</div>
		<div class="table-responsive">
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>#</th>
						<th><fmt:message key="form.cliente.nome" /></th>
						<th><fmt:message key="form.cliente.endereco" /></th>
						<th><fmt:message key="form.cliente.telefone" /></th>
						<th><fmt:message key="form.cliente.rg" /></th>
						<th><fmt:message key="form.cliente.cpf" /></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listaClientes}" var="cliente"
						varStatus="index">
						<tr>
							<td>${index.count}</td>
							<td>${cliente.nome}</td>
							<td>${cliente.endereco}</td>
							<td>${cliente.telefone}</td>
							<td>${cliente.rg}</td>
							<td>${cliente.cpf}</td>
							<td style="width: 125px;">[ <a
								href="./ManterCliente?action=carregar&cpf=${cliente.cpf}"
								style="font-size: 11px;">Carregar</a> ]

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
