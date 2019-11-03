<!DOCTYPE html>
<%@page import="br.com.fabricadeprogramador.entidade.Usuario"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	Usuario usuario = (Usuario)request.getAttribute("usu"); 
	%>
	<form action="usucontroller" method="post">
		ID:    <input type="number" name="id" value="<%= usuario.getId() %>"/><br><br>
		Nome:  <input type="text" name="nome" value="<%= usuario.getNome() %>"/><br><br>
		Login: <input type="text" name="login" value="<%= usuario.getLogin() %>"/><br><br>
		Senha: <input type="text" name="senha" value="<%= usuario.getSenha() %>"/><br><br>
		
		<input type="submit" value="Salvar"/>
	</form>
	
</body>
</html>