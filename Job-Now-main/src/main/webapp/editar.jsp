<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Editar Vagas</title>

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
	
	<%

	Banco bd=new Banco();
	Vagas vg=null;
	int id=0;
	
	try{
	
		id = Integer.parseInt(request.getParameter("id"));	
		vg=bd.buscar(id);
		if(vg.getId()<0 || vg==null)
		{
			 response.sendRedirect("./listar.jsp");
		}
		
	
	}catch(Exception e){}
	
	
	try{
		String gravar=request.getParameter("descricao");	
		if(gravar!=null || gravar.equals("")==false)
		{
			vg=new Vagas();
			vg.setId(id);
			vg.setTitulo(request.getParameter("titulo"));
			vg.setAberta(Integer.parseInt(request.getParameter("aberta")));
			vg.setRemuneracao(request.getParameter("remuneracao"));
			vg.setLocalDeTrabalho(request.getParameter("localDeTrabalho"));
			vg.setRequisitosObrigatorios(request.getParameter("requisitosObrigatorios"));
			vg.setRequisitosDesejaveis(request.getParameter("requisitosDesejaveis"));
			vg.setBeneficios(request.getParameter("beneficios"));
			vg.setDescricao(request.getParameter("descricao"));
			
			bd.editar(vg);
			response.sendRedirect("./listar.jsp");
		}
		}catch(Exception e){	out.println("Erro em Editar JSP");	}
		finally{ }
	

	%>
	
	<div class="container">
		<div class="row">
			<div class="col mt-4">
				<h1 class="text-center">Editar Vaga</h1>
			</div>
		</div>
	</div>
	<div class="mt-5"></div>
	<form action="editar.jsp?id=<%=id%>" method="post">
		<div class="container">
			<div class="row mb-3">
				<div class="col">
					<label class="form-label">ID</label> 
					<input type="text" class="form-control" name="id" id="id" disabled >
				</div>
				<div class="col">
					<label class="form-label">Título</label>
					<input type="text" class="form-control" name="titulo" id="titulo">
				</div>
				<div class="col">
					<label class="form-label">Aberta</label>
					<input type="text" class="form-control" name="aberta" id="aberta">
				</div>
				<div class="col">
					<label class="form-label">Remuneração</label>
					<input type="text" class="form-control" name="remuneracao" id="remuneracao">
				</div>
				<div class="col">
					<label class="form-label">Local de Trabalho</label>
					<input type="text" class="form-control" name="localDeTrabalho" id="localDeTrabalho">
				</div>
			</div>
			<div class="row mb-3">
				<div class="col">
					<label class="form-label">Requisitos Obrigatórios</label>
					<input type="text" class="form-control" name="requisitosObrigatorios" id="requisitosObrigatorios">
				</div>
				<div class="col">
					<label class="form-label">Requisitos Desejáveis</label>
					<input type="text" class="form-control" name="requisitosDesejaveis" id="requisitosDesejaveis">
				</div>
			</div>
			<div class="row mb-3">
				<div class="col">
					<label class="form-label">Benefícios</label>
					<input type="text" class="form-control" name="beneficios" id="beneficios">
				</div>
				<div class="col">
					<label class="form-label">Descrição</label>
					<input type="text" class="form-control" name="descricao" id="descricao">
				</div>
			</div>
			<div class="mb-5"></div>
			<button type="submit" class="btn-lg btn-success">ENVIAR</button>
		</div>
		<div class="mb-5"></div>
	</form>
		
	<div class="mt-5"></div>
	
	<div class="footer-copyright text-center py-3">
		© 2022 Copyright | <a href="https://www.sp.senai.br/" class="footer-link">SENAI - UC12 SA1 Atividade 3</a>
  	</div>
	
	
	<script>
		document.getElementsByName("id")[0].value="<%=vg.getId()%>";
		document.getElementByName("titulo")[0].value="<%=vg.getTitulo()%>";
		document.getElementsByName("aberta")[0].value="<%=vg.getAberta()%>";
		document.getElementsByName("remuneracao")[0].value="<%=vg.getRemuneracao()%>";
		document.getElementsByName("localDeTrabalho")[0].value="<%=vg.getLocalDeTrabalho()%>";
		document.getElementsByName("requisitosObrigatorios")[0].value="<%=vg.getRequisitosObrigatorios()%>";
		document.getElementsByName("requisitosDesejaveis")[0].value="<%=vg.getRequisitosDesejaveis()%>";
		document.getElementsByName("beneficios")[0].value="<%=vg.getBeneficios() %>";
		document.getElementsByName("descricao")[0].value="<%=vg.getDescricao()%>";
	</script>
	
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
	
</body>
</html>