<%@page import="threeway.projeto.modelo.Log"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
						<form action="Logout" id="formIcons">
							<span>Bem vindo, sr(a).</span> <b> <script
									type="text/javascript">
								document.write(getCookie());
							</script>
							</b> <input type="submit" name="action" class="btn btn-xs btn-danger"
								value="sair">
							<button type="button" name="action"
								class="btn btn-xs btn-default" value="info" data-toggle="modal"
								data-target="#modalInfo">
								<img alt="iformações" name="info"
									src="resources/img/information2.png" />
							</button>
						</form>
				</a></li>
			</ul>
		</div>
	</div>
</div>

<div class="modal fade" id="modalInfo" tabindex="-1" role="dialog"
	aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">x</button>
				<h4 class="modal-title" id="myModalLabel">Gerenciamento de log</h4>
			</div>
			<div class="modal-body">
				<div class="table-responsive">
					<table class="table table-bordered table-hover">
						<thead>
							<tr>
								<th>Action</th>
								<th>Data</th>
							</tr>
						</thead>
						<tbody>
							<%
								List<Log> dados = (List<Log>)request.getSession().getAttribute("dadosLog");

								for (Log log : dados) {
							%>
							<tr>
								<td>
									<%
										out.print(log.getDescricao());
									%>
								</td>
								<td>
									<%
										out.print(log.getDataFormatada());
									%>
								</td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
			</div>
		</div>
	</div>
</div>