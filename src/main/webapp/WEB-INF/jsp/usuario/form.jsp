<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulario de Login</title>

<c:url value="/resources/css" var="cssPath" />
<link rel="stylesheet" href="${cssPath }/bootstrap.min.css">
<link rel="stylesheet" href="${cssPath }/bootstrap-theme.min.css">

	<style>
		.navbar-header button{
			color:#fff;
		}
		.fullscreen {
			width: 100%;
		}

		main{
			padding-top: 50px;
		}
		footer{
			background: #333;
			color: #fff;
			text-align: center;
			padding: 20px;
		}
		
		label{
		color: #FFFAFA;
		}
	</style>

</head>
<body>
	<header> 
		<nav class="navbar navbar-fixed-top navbar-inverse">
			<div class="navbar-header">
				<a href="#home" class="navbar-brand">Biblioteca Impacta </a>
			</div>
			<form class="form-inline navbar-form navbar-right"  action="<c:url value='autentica' />" method="post">
				<div class="form-group">
					<label for="login">Login:</label> 
					<input id="login" class="form-control" type="text" name="usuario.login"  />
				</div>
				<div class="form-group">
					<label for="senha">Senha:</label> 
					<input id="senha" class="form-control" type="password" name="usuario.senha" />
				</div>
	
				<input type="submit" value="Entrar" class="btn btn-primary" />
			</form>
		</nav> 
	</header>
	<main>	
	<div class="container-fluid">
		<div class="row" id="home"> 
			<div id="carousel" class="carousel slide" data-ride="carousel">
				<div class="carousel-inner" role="listbox">
					<c:url value="/resources/img" var="imgPath" />
					<div class="item active">
						<img src="${imgPath}/biblioteca.jpg" alt="Biblioteca"  class="fullscreen">
					</div>
					<div class="item">	
						<img src="${imgPath}/biblioteca1.jpg" alt="Biblioteca" class="fullscreen">
					</div>
					<div class="item">	
						<img src="${imgPath}/biblioteca2.jpg" alt="Biblioteca" class="fullscreen">
					</div>
				</div>
					<a href="#carousel" data-slide="prev" class="left carousel-control" role="button">
						<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a>
					<a href="#carousel" data-slide="next" class="right carousel-control" role="button">
						<span class="glyphicon glyphicon-chevron-right" aria-hidden="true">
						<span class="sr-only">Next</span>
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