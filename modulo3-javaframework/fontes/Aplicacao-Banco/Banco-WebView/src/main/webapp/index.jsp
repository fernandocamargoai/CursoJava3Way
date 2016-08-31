<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta name="author" content="Wilker Machado">
    
    <title>.:: Projeto Banco 3Way NetWorks ::.</title>
    
    <link href="resources/css/bootstrap.css" rel="stylesheet">
    <link href="resources/css/geral.css" rel="stylesheet">
    <script type="text/javascript">
	    function getCookie() {
	
	        //variavel referente ao cookie name;
	        var name = "usuario=";
	        
	        var cookies = document.cookie.split(';');
	        
	        for(var i=0; i<cookies.length; i++){
	
	         //obtem a string referente ao cookie, ex:"acesso=09/01/2014"	
	          var cookie = cookies[i].trim();
	          
	          if (cookie.indexOf(name) == 0) { 
	
	        		// referente ao tamanho da string  name.length com o name  ex:"acesso=");
	    			// referente ao tamanho da string  cookie.length com o name e value ex:"acesso=09/01/2014");    
	    			// substring function javascript responsavel por cortar a string referente ao cookie recebendo apenas o value      
	              	return cookie.substring(name.length,cookie.length);
	          	}
	        }
	    	    
	    	return "";
	    }
    </script>
  </head>
  <body>
    <!-- Static navbar -->
	<jsp:include page="/templates/cabecalho.jsp"/>  
	<!-- /Static navbar -->
	
	<!-- container -->
    <div class="container">
	     
     	<div class="page-header">
	      	<h4>Banco:  <span style="font-size: 14px;color:red;"> ${agencia.nome} </span></h4>
	      	<h4>Agência:  <span style="font-size: 14px;color:red;"> ${agencia.banco.nome} </span> </h4>
      	</div>

		<div class="panel panel-default">
			<!-- Panel referente ao menu -->
			<jsp:include page="/templates/menu.jsp"/>
			<!-- Fim panel menu -->
		</div>

	</div> 
	<!-- /container -->

    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
        
  </body>
</html>
