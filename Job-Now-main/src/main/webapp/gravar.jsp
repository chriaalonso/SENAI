<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Cadastrar Vagas</title>

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

	<%@ page import="classes.Banco" %>
	<%@ page import="classes.Vagas" %>
	
	<%
		try{
		
		String gravar= request.getParameter("descricao");	
		if(gravar!=null || gravar.equals("")==false)
		{
			
			Vagas vg=new Vagas();
			vg.setTitulo(request.getParameter("titulo"));
			vg.setAberta(
					Integer.parseInt(
							request.getParameter("aberta")
							)
					);
			vg.setRemuneracao(request.getParameter("remuneracao"));
			vg.setLocalDeTrabalho(request.getParameter("localDeTrabalho"));
			vg.setRequisitosObrigatorios(request.getParameter("requisitosObrigatorios"));
			vg.setRequisitosDesejaveis(request.getParameter("requisitosDesejaveis"));
			vg.setBeneficios(request.getParameter("beneficios"));
			vg.setDescricao(request.getParameter("descricao"));
	
			Banco bd=new Banco();		
			bd.inserir(vg);
			response.sendRedirect("./listar.jsp");
			
		}
		}catch(Exception e){		}
		finally{ }
	
	%>

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
	
	<div class="container">
		<div class="row">
			<div class="col mt-5">
				<h1 class="text-center">Cadastro de Vagas</h1>
			</div>
		</div>
	</div>
	<div class="mt-5"></div>
	<form action="./gravar.jsp" method="post">
		<div class="container">
			<div class="row mb-3">
				<div class="col">
				    <label class="form-label">ID</label>
				    <input type="number" class="form-control" name="id" value="" disabled>
				</div>
				<div class="col">
				    <label class="form-label">Título</label>
				    <input type="text" class="form-control" name="titulo" placeholder="Ex.: FullStack" required>
				</div>
				<div class="col">
				    <label class="form-label">Aberta</label>
				    <input type="number" class="form-control" name="aberta" placeholder="0 para não | 1 para sim " required>
				</div>
				<div class="col">
				    <label class="form-label">Remuneração</label>
				    <input type="text" class="form-control" name="remuneracao" placeholder="R$1234,56" required>
				</div>
				<div class="col">
				    <label class="form-label">Local de Trabalho</label>
				    <input type="text" class="form-control" name="localDeTrabalho" placeholder="Home Office, Híbrido em São Paulo" required>
				</div>
			</div>
			<div class="row mb-3">
				<div class="col">
				    <label class="form-label">Requisitos Obrigatórios</label>
				    <input type="text" class="form-control" name="requisitosObrigatorios" placeholder="HTML, CSS, JS, JAVA..." required>
				</div>
				<div class="col">
				    <label class="form-label">Requisitos Desejáveis</label>
				    <input type="text" class="form-control" name="requisitosDesejaveis" placeholder="Bando de Dados, MySQL..." required>
				</div>
			</div>
			<div class="row mb-3">
				<div class="col">
				    <label class="form-label">Benefícios</label>
				    <input type="text" class="form-control" name="beneficios" placeholder="Vale Alimentação, Vale Transporte..." required>
				</div>
				<div class="col">
				    <label class="form-label">Descrição</label>
				    <input type="text" class="form-control" name="descricao" placeholder="Detalhes do trabalho" required>
				</div>
				<div class="mt-5"></div>	
			</div>
			<button type="submit" class="btn-lg btn-success">ENVIAR</button>
		</div>
	</form>
	
	<div class="mt-5"></div>
	
	<div class="footer-copyright text-center py-3">
		© 2022 Copyright | <a href="https://www.sp.senai.br/" class="footer-link">SENAI - UC12 SA1 Atividade 3</a>
  	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
	
</body>
</html>