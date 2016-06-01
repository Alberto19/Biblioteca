<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Impacta Biblioteca</title>
	<c:url value="/resources/css" var="cssPath" />
	<link rel="stylesheet" href="${cssPath }/bootstrap.min.css">
	<link rel="stylesheet" href="${cssPath }/bootstrap-theme.min.css">
	
 	<style>
		footer{
			background: #333;
			color: #fff;
			text-align: center;
			padding: 22px;
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
			      </button>
			      <a class="navbar-brand" href="<c:url value='/inicio/index'/>">Biblioteca Impacta</a>
			    </div>
			    <div class="collapse navbar-collapse" id="myNavbar">
				     <ul class="nav navbar-nav">
				        <li><a href="<c:url value='/item/index'/>">Livros</a></li>
				        <li><a href="#">Emprestimo</a></li>
				        <li><a href="#">Devolução</a></li>
				     	<li class="active"><a href="<c:url value='/usuario/index'/>">Usuarios</a></li>
				      </ul>
			      <ul class="nav navbar-nav navbar-right">
			        <li><a href="<c:url value='/usuario/login'/>"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
			      </ul>
			    </div>
			</div>
		</nav>
	</header>
	<main>
		<div class="container-fluid">
			<div class="row" >
				<div id="carousel" class="carousel slide" data-ride="carousel">
					<div class="carousel-inner" role="listbox">
						<c:url value="/resources/img" var="imgPath" />
						<div class="item active">
							<img src="${imgPath}/biblioteca3.jpg" alt="Biblioteca" >
						</div>
						<div class="item">	
							<img src="${imgPath}/biblioteca1.jpg" alt="Biblioteca" >
						</div>
						<div class="item">	
							<img src="${imgPath}/biblioteca2.jpeg" alt="Biblioteca" >
						</div>
					</div>
					<a href="#carousel" data-slide="prev" class="left carousel-control">
						<span class="glyphicon glyphicon-chevron-left"></span>
					</a>
					<a href="#carousel" data-slide="next" class="right carousel-control">
					<span class="glyphicon glyphicon-chevron-right">
					</a>
				</div>
			</div>
		</div>
	</main>

	<footer class="navbar-fixed-bottom navbar-inverse">
		<p>© Impacta 2015. Todos os direitos reservados. Tel.: 11 3254-8300 / CAMPUS BARRA FUNDA - Av. Rudge, 315</p>
	</footer>

	<c:url value="/resources/js" var="jsPath" />
	<script src="${jsPath}/wow.min.js" type="text/javascript"></script>
    <script src="${jsPath}/jquery-2.2.4.min.js" type="text/javascript"></script>
    <script src="${jsPath}/bootstrap.min.js" type="text/javascript"></script>

</body>
</html>