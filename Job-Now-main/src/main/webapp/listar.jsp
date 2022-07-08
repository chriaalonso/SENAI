<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Listar Vagas</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link href="css/style.css" rel="stylesheet">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Raleway&display=swap" rel="stylesheet">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Raleway&display=swap" rel="stylesheet">

</head>
<body>
	
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  		<div class="container-fluid">
    		<a class="navbar-brand" href="./index.jsp">Job Now</a>
    		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      			<span class="navbar-toggler-icon"></span>
    		</button>
    		<div class="collapse navbar-collapse justify-content-center" id="navbarNav">
      			<ul class="navbar-nav justify-content-center">
			        <li class="nav-item">
			        	<a class="nav-link" href="./index.jsp">Home</a>
			        </li>
			        <li class="nav-item">
			        	<a class="nav-link" href="./gravar.jsp">Cadastrar Vaga</a>
			        </li>
			        <li class="nav-item">
			        	<a class="nav-link" href="./listar.jsp">Listar</a>
			        </li>
      			</ul>
    		</div>
  		</div>
	</nav>
	
	<%@ page import="classes.Banco" %>
	<%@ page import="classes.Vagas" %>
	<div class="container mt-5">
		<div class="row">
			<div class="col">
				
					<%
						Banco bd=new Banco();
						try{	
						int lista = Integer.parseInt(request.getParameter("lista"));
					     //fechada 0
						if(lista==0)
							out.println(bd.listar(0));
					    //aberta 1
					    else if(lista==1)
							out.println(bd.listar(1));
					    else
					    	out.println(bd.listar(2));
						
						}catch(Exception e){ 	out.println(bd.listar(2)); }
					%>
				
			</div>
		</div>
	</div>
		
	<div class="mt-5"></div>
	
	<div class="footer-copyright text-center py-3">
		© 2022 Copyright | <a href="https://www.sp.senai.br/" class="footer-link">SENAI - UC12 SA1 Atividade 3</a>
  	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>	
		
</body>
</html>