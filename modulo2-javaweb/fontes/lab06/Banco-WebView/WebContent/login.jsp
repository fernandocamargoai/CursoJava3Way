<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="Tela de login">
<meta name="author" content="Ezequiel">
<link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">

<title>.:: Projeto Banco 3Way NetWorks ::.</title>

<link href="resources/css/bootstrap.css" rel="stylesheet">
<link href="resources/css/geral.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>

<style type="text/css">
.form-signin {
	max-width: 330px;
	padding: 15px;
	margin: 0 auto;
}

.form-signin .form-signin-heading, .form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin .checkbox {
	font-weight: normal;
}

.form-signin .form-control {
	position: relative;
	font-size: 16px;
	height: auto;
	padding: 10px;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}

.form-signin .form-control:focus {
	z-index: 2;
}

.form-signin input[type="text"] {
	margin-bottom: -1px;
	border-bottom-left-radius: 0;
	border-bottom-right-radius: 0;
}

.form-signin input[type="password"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}

.alert {
	width: 350px;
	margin-left: auto;
	margin-right: auto;
}
</style>
</head>

<body>

	<div class="container">

		<div>
			<div class="col-md-4 col-md-offset-4" style="margin-top: 20%;">
				<div class="panel panel-default">
					<div class="panel-heading">
						<span class="glyphicon glyphicon-lock"></span> Login
					</div>
					<div class="panel-body">
						<form class="form-horizontal" method="post" action="Login"
							role="form">
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-3 control-label">
									Login:</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" name="login"
										placeholder="login" required="required" autofocus="autofocus">
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-3 control-label">
									Password:</label>
								<div class="col-sm-9">
									<input type="password" class="form-control" name="senha"
										placeholder="senha" required="required">
								</div>
							</div>

							<div class="form-group last">
								<div class="col-sm-offset-3 col-sm-9">
									<button type="submit" class="btn btn-success btn-sm">
										Sign in</button>
									<button type="reset" class="btn btn-default btn-sm">
										Reset</button>
								</div>
							</div>
						</form>
					</div>
					<div class="panel-footer"
						style="text-align: center; font-size: 12px;">Banco S.A -
						Fone:(99) 999-9999</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>