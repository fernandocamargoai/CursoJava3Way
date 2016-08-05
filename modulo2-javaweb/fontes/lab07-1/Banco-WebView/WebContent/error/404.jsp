<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    
    <title><fmt:message key="erro.title"/></title>

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
          <h1><fmt:message key="erro.404.titulo"/></h1>
        </div>
        <p class="lead"><fmt:message key="erro.404.aviso"/></p>
        <p><a href="../Banco-WebView/login.jsp"><fmt:message key="inicio"/></a></p>
      </div>
    </div>
    
     <div id="footer">
      <div class="container">
        <p class="text-muted"></p>
      </div>      
    </div>

 </body>
</html>