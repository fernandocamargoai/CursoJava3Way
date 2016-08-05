<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="author" content="Ezequiel">

<title>.:: Projeto Banco 3Way NetWorks ::.</title>

<link href="resources/css/bootstrap.css" rel="stylesheet">
<link href="resources/css/geral.css" rel="stylesheet">
<link href="navbar-static-top.css" rel="stylesheet">

<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/functions.js"></script>
</head>
<body>

	<!-- Static navbar -->
	<jsp:include page="/templates/cabecalho.jsp"/>
	
	<!-- /Static navbar -->
	
	<div class="container">

		<div class="page-header">
	      	<h4>Banco:  <span style="font-size: 14px;color:red;"> ${agencia.nome} </span></h4>
	      	<h4>Agência:  <span style="font-size: 14px;color:red;"> ${agencia.banco.nome} </span> </h4>
      	</div>

		<div class="panel panel-default">
			<!-- Panel referente ao menu -->
			<jsp:include page="/templates/menu.jsp"/>
			<!-- Fim panel menu -->
		
			<c:if test="${msg != null}">
				<div class="alert alert-danger fade in" id="btnIndividual">
					<button type="button" class="close" data-dismiss="alert"
						aria-hidden="true">×</button>
					<strong>${msg}</strong>
				</div>
			</c:if>
			
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
							    <h3>Cliente: <span style="color:#990000">${conta.titular.nome}</span></h3>
							    <h2>Dados Bancarios</h2>
							    <p>Nº conta: <span style="color:#990000">${conta.numero}</span>,  
							       Data da abertura: <span style="color:#990000">${conta.dataFormatada}</span>, 
							       Saldo: <span style="color:#990000">${conta.saldo}</span>
							    </p>
							</div>
						</div>
						<hr>
						<div class="row">
								<p class="text-right" style="padding-right: 5%;">
									<button class="btn btn-sn btn-primary" data-toggle="modal" data-target="#modalConta" ${conta.identificador != null ? "disabled='disabled'" : ""} >Abrir Conta</button>
									
									<button class="btn btn-sn btn-success" data-toggle="modal" data-target="#modalSaque"  ${conta.identificador == null ? "disabled='disabled'": ""} >Deposito</button>
									<button class="btn btn-sn btn-danger" data-toggle="modal" data-target="#modalDeposito" ${conta.identificador == null ? "disabled='disabled'": ""} >Saque</button>
									<button class="btn btn-sn btn-warning" data-toggle="modal" data-target="#modalTransferencia" ${conta.identificador == null ? "disabled='disabled'": ""} >Transferencia</button>
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
									<th></th>
									<th>Tipo Transação</th>
									<th>Titular/ Conta Afetada</th>									
									<th>Data</th>
									<th>Valor</th>
								</tr>
							</thead>
							<tbody>
								
							<c:forEach items="${transacoes}" var="transacao" varStatus="index">
								<tr>
									<td>${index.count}</td>
									<td>${transacao.tipoTransacao}</td>
									<td>${transacao.contaCredito.titular.nome} / ${transacao.contaCredito.numero}</td>
									<td>${transacao.dataFormatada}</td>
									<td>${transacao.valor}</td>
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
	
<!-- Modal Abrir Conta -->
<div class="modal fade" id="modalConta" tabindex="-1" role="dialog" aria-hidden="true" draggable="auto">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
        <h4 class="modal-title" id="myModalLabel">
        	<fmt:message key="title.modal.abrirConta"/>
        </h4>
      </div>
      <form action="OperacoesBancarias" method="post">
	      <div class="modal-body">
	        <label>Abertura:</label>
			<div>
				<input type="text" disabled="disabled" class="form-control" value="${dataFormatada}">
			</div>
			 <label>Numero:</label>
			<div>
				<input type="text" name="numero" class="form-control" >
			</div>
			 <label>Saldo inicial:</label>
			<div>
				<input type="text" name="saldoInicial" class="form-control">
			</div>			
	      </div>
	      <div class="modal-footer">
	       <button type="submit" name="action" value="abrirConta" class="btn btn-primary"><fmt:message key="btn.cliente.salvar"/></button>
	       <button type="button" class="btn btn-default" data-dismiss="modal"><fmt:message key="btn.cliente.cancelar"/></button> 
	      </div>
      </form>
    </div>
  </div>
</div>
<!-- Fim modal Abrir conta -->	
	
<!-- modal deposito -->

<div class="modal fade" id="modalSaque" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
        <h4 class="modal-title" id="myModalLabel">Deposito em conta bancaria</h4>
      </div>
       <form action="OperacoesBancarias" method="post">
	      <div class="modal-body">
	        <label>Digite o valor do deposito:</label>
			<div >
				<input type="text" name="valor" class="form-control" placeholder="R$ valor">
			</div>
	      </div>
	      <div class="modal-footer">
	       <button type="submit" name="action" value="deposito" class="btn btn-primary">Ok</button>
	       <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button> 
	      </div>
	   </form>
    </div>
  </div>
</div>
<!-- /modal deposito -->

<!-- modal saque-->
<div class="modal fade" id="modalDeposito" tabindex="-1" role="dialog"  aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
        <h4 class="modal-title" id="myModalLabel">Saque em conta bancaria</h4>
      </div>
      <form action="OperacoesBancarias" method="post">
	      <div class="modal-body">
	        <label>Digite o valor do saque:</label>
			<div >
				<input type="text" name="valor" class="form-control" placeholder="R$ valor">
			</div>
	      </div>
	      <div class="modal-footer">
	       <button type="submit" name="action" value="saque" class="btn btn-primary">Ok</button>
	       <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>       
	      </div>
	    </form>
    </div>
  </div>
</div>

<!-- /modal saque-->

<!--  -->

<div class="modal fade" id="modalTransferencia" tabindex="-1" role="dialog"  aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
        <h4 class="modal-title" id="myModalLabel">Transferência entre contas bancarias</h4>
      </div>
      <form class="form-horizontal" action="OperacoesBancarias" method="post" role="form">
      <div class="modal-body">
       <fieldset>
		<legend style="font-size: 14px; padding-left: 14px;">Dados	da Conta</legend>
			
				<div class="form-group">
					<label class="col-sm-1 control-label">Nº</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" value="${conta.numero}" disabled="disabled" />
					</div>
					<label class="col-sm-3 control-label">Data da Abertura</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" value="${conta.dataFormatada}" disabled="disabled" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-1 control-label">Saldo</label>
						<div class="col-sm-2">
							<input type="text" class="form-control" value="${conta.saldo}" disabled="disabled">
						</div>
						
						<label class="col-sm-3 control-label">Titular da Conta</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" style="width: 265px;" value="${conta.titular.nome}" />
					</div>
				</div>
				
			
		</fieldset>
		
		 <fieldset>
		<legend style="font-size: 14px; padding-left: 14px;">Dados da Transferencia</legend>
			
				<div class="form-group">
					<label class="col-sm-4 control-label">Nº da conta destino</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" name="numContaDestino" required autofocus>
					</div>
					
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label">Valor da Transferencia</label>
						<div class="col-sm-2">
							<input type="text" class="form-control" placeholder="R$" name="valor" required>
						</div>
					
				</div>
		</fieldset>
		
      </div>
      <div class="modal-footer">
       <button type="submit" name="action" value="transferencia" class="btn btn-primary">Realizar Transferencia</button>
       <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>       
      </div>
      </form>
    </div>
  </div>
</div>



</body>
</html>
