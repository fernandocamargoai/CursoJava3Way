<%@ page isErrorPage="true" %>
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">

    <title>Sticky Footer Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="resources/css/bootstrap.css" rel="stylesheet">
    <link href="resources/css/footer.css" rel="stylesheet">

  </head>

  <body>

    <!-- Wrap all page content here -->
    <div id="wrap">
      <!-- Begin page content -->
      <div class="container">
        <div class="page-header">
          <h1><fmt:message key="erro.nullPointer.titulo"/></h1>
        </div>
        <p class="lead"><fmt:message key="erro.nullPointer.aviso"/></p>
        <p style="color:red;"><%= exception %></p>
         
      </div>
      
     
    </div>
     <div id="footer">
      <div class="container">
        <p class="text-muted"><fmt:message key="erro.footer"/></p>
      </div>      
    </div>

 </body>
</html>