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