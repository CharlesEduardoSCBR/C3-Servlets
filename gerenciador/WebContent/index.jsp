<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h1>Bem vindo ao nosso gerenciador de empresas!</h1>
	<br />
	
	<c:if test="${usuarioLogado!=null}">
		Você está logado como ${usuarioLogado.email}<br />
	</c:if>
	
	<form action="/executa method="post">
		<input type="hidden" name= "tarefa" value="novaEmpresa" />
		Nome: <input type="text" name="nome" /><br /> <input type="submit"
			value="Enviar" />
	</form>

	<br />

	<form action="/executa method="post">
		<input type="hidden" name= "tarefa" value="login" />
		<label>Email:</label> <input type="text" name="email" /><br /> <label>Senha:</label>
		<input type="password" name="senha" /><br /> <input type="submit"
			value="Login" />
	</form>

	<form action="/executa method="post">
		<input type="hidden" name= "tarefa" value="logout" />
		<input type="submit" value="Logout" />
	</form>
</body>
</html>