<%@ page isErrorPage="true"  %>
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">

    <title><fmt:message key="erro.title"/></title>

    <!-- Bootstrap core CSS -->
    <link href="resources/css/bootstrap.css" rel="stylesheet">
    <link href="resources/css/footer.css" rel="stylesheet">

  </head>

  <body>

    <!-- Wrap all page content here -->
    <div id="wrap">
      <!-- Begin page content -->
      <div class="container" style="text-align: center">
     	 <img  src="./resources/img/ops.gif" style="text-align: center;">
        <div class="page-header">
          <h3><fmt:message key="erro.nullPointer.titulo"/></h3>
        </div>
        <p class="lead"><fmt:message key="erro.nullPointer.aviso"/></p>
			<div style="height:300px;color:red;overflow: scroll;">
				<jsp:scriptlet>
	  			 	exception.printStackTrace(new java.io.PrintWriter(out));   			 		
				</jsp:scriptlet>
			</div>
         
      </div>
      
     
    </div>
     <div id="footer">
      <div class="container">
        <p class="text-muted"><fmt:message key="erro.footer"/></p>
      </div>      
    </div>

 </body>
</html>
