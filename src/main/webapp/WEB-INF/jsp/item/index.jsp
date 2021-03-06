<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
       <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Livros</title>
	<c:url value="/resources/css" var="cssPath" />
	<link rel="stylesheet" href="${cssPath }/bootstrap.min.css">
	<link rel="stylesheet" href="${cssPath }/bootstrap-theme.min.css">
	
  <style>
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    .row.content {height: 550px}
    
	footer{
		background: #333;
		color: #fff;
		text-align: center;
		padding: 20px;
	}
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
    main{
    	padding-top: 20px;
   	}
  </style>
</head>
<body>
	<header>
		<nav class="navbar navbar-inverse">
 			<div class="container-fluid">
	    		<div class="navbar-header">
			      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>                          
			      </button>
			      <a class="navbar-brand" href="<c:url value='/inicio/index'/>">Biblioteca Impacta</a>
			    </div>
			    <div class="collapse navbar-collapse" id="myNavbar">
			       <ul class="nav navbar-nav">
			        <li class="active"><a href="<c:url value='/item/index'/>">Livros</a></li>
			        <li><a href="<c:url value='/emprestimo/index'/>">Emprestimo</a></li>
			        <li><a href="#">Devolu��o</a></li>
			     	<li><a href="<c:url value='/usuario/index'/>">Usuarios</a></li>
			      </ul>
			      <ul class="nav navbar-nav navbar-right">
			        <li>
			        	<a href="<c:url value='/usuario/login'/>">
			        	<span class="glyphicon glyphicon-log-in" ></span> Logout</a>
			        </li>
			      </ul>
			    </div>
			</div>
		</nav>
	</header>
	<main>
	
	<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-3 sidenav">
      <ul class="nav nav-pills nav-stacked">
        <li class="active"><a href="<c:url value='/item/index'/>">Home</a></li>
        <li><a href="<c:url value='/item/form'/>">Inserir Livros</a></li>
      </ul>
    </div>

    <div class="col-sm-9">
 		<table class="table table-stripped table-hover  table-bordered">
			<thead>
				<tr>
					<th>Titulo</th>
					<th>Autor</th>
					<th>Editora</th>
					<th>Ano</th>
					<th>Staus</th>
					<th>Especial</th>
				</tr>
			</thead>
			<tbody>
			
				<c:forEach items="${itemList}" var="item">
					<tr>
						<td>${item.titulo}</td>
						<td>${item.autor}</td>
						<td>${item.editora}</td>
						<td><fmt:formatDate value="${item.ano.time}"
   							 pattern="dd/MM/yyyy" />       </td>
						<td>${item.status}</td>
						<td>${item.especial} </td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
    </div>
  </div>
</div>

	</main>
	<footer class="navbar-fixed-bottom navbar-inverse">
		<p>� Impacta 2015. Todos os direitos reservados. Tel.: 11 3254-8300 / CAMPUS BARRA FUNDA - Av. Rudge, 315</p>
	</footer>

	<c:url value="/resources/js" var="jsPath" />
	<script src="${jsPath}/wow.min.js" type="text/javascript"></script>
    <script src="${jsPath}/jquery-2.2.4.min.js" type="text/javascript"></script>
    <script src="${jsPath}/bootstrap.min.js" type="text/javascript"></script>

</body>
</html>