<%@page import="br.com.fabricadeprogramador.entidade.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" content="text/html">
<title>Lista de Usuarios</title>

<script type="text/javascript">
	function confirmaExclusao(id) {
		if(window.confirm('Tem certeza que deseja excluir?')){
			location.href="usucontroller?acao=excluir&id="+id;
		}
	}


</script>

</head>
<body>
	<%
		List<Usuario> lista = (List<Usuario>) request.getAttribute("lista");
	%>
	<table border=4>
		<tr>
			<th>id</th>
			<th>nome</th>
			<th>ação</th>
		</tr>
		<%
			for (Usuario u : lista) {
		%>
		<tr>
			<td><%=u.getId()%></td>
			<td><%=u.getNome()%></td>
			<td><a href="javascript:confirmaExclusao(<%=u.getId() %>)">exlcuir</a> | <a href="usucontroller?acao=alt&id=<%= u.getId() %>">alterar</a></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>