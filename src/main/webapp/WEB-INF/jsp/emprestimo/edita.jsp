
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Emprestimo</title>
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
	<%!  
	Date dateNow = new Date();
    Date getDate()  
    {  
      return dateNow;  
    } 
    %>
      
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
			        <li><a href="<c:url value='/item/index'/>"> Livros </a></li>
			        <li class="active"><a href="<c:url value='/emprestimo/index'/>">Emprestimo</a></li>
			        <li><a href="#">Devolução</a></li>
			        <li><a href="<c:url value='/usuario/index'/>">Usuarios</a></li>
			      </ul>
			      <ul class="nav navbar-nav navbar-right">
			        <li>
			        	<a href="<c:url value='/usuario/login'/>">
			        	<span class="glyphicon glyphicon-log-in"></span> Logout</a>
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
				        	<li><a href="<c:url value='/emprestimo/index'/>">Home</a></li>
				        	<li><a href="<c:url value='/emprestimo/form'/>">Pedir Emprestimo</a></li>
				        	<li class="active"><a href="<c:url value='/emprestimo/pedidos'/>">Lista de Pedidos</a></li>
				      	</ul>
			    </div>
				<div class="col-sm-9">
					<div class="form-group">
						<form action="altera" method="post">
					  		<fieldset>
							    <legend>Validar Emprestimo</legend>
								    <div class="form-group">
									    <input type="hidden" name="emprestimo.id" 
									      value="${emprestimo.id }" /> 
									    <input type="hidden" name="emprestimo.bibliotecario.id" 
									      value="${usuarioLogado.usuario.getId()}"/>  
								    
									    <label for="dataEmprestimo">Data Emprestimo:</label>
									    <input id="dataEmprestimo" type="text" name="emprestimo.dataEmprestimo"
									    value="<fmt:formatDate value="<%=getDate()%>"
					   							 pattern="dd/MM/yyyy"/>" />
								    </div>
							    
								    <div class="form-group">
								    	<input type="hidden" name="emprestimo.solicitante.id" 
									       value="${emprestimo.solicitante.id}"/>
									    <c:forEach items="${emprestimo.itens}" var="itens">
									    <input type="hidden" name="emprestimo.itens.isbn" 
									      value="${itens.isbn}" />
									     </c:forEach>    
								    
								    	<label for="dataEmprestimo">Data Devolucao:</label>
								    	<input id="dataEmprestimo" type="text" name="emprestimo.dataDevolucao"
								    	  />
								    </div>
							    <button class="btn btn-success " type="submit">Aprovar Pedido</button>
					  		</fieldset>
						</form>		
					</div>
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