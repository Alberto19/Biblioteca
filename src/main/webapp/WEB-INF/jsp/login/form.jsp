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

</head>
<body>
	
		<div class="container">
		<form action="<c:url value='autentica' />" method="post">
			<div class="form-group">
				<label for="login">Login:</label>
				<input id="login"  class="form-control" type="text" name="usuario.login" />
			</div>
			<div class="form-group">
				<label for="senha">Senha:</label>
				<input id="senha"  class="form-control" type="password" name="usuario.senha" />
			</div>
			
			<input type="submit" value="Entrar" class="btn btn-default" />
		</form>
	</div>
	
		
	<c:forEach items="${errors}" var="erro">
		${erro.category} - ${erro.message}
	</c:forEach>
	
	
	
</body>
</html>