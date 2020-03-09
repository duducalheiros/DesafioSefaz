<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bulma.css">
<script type="text/javascript" src="js/path-to-javascript-file.js"></script>
<meta charset="ISO-8859-1">
<title>Login - DesafioSefaz duducalheiros</title>
</head>
<body>

<br>Favor digitar Email e Senha

<%
  if (request.getParameter("erro") != null) {
%>
<h3><%= request.getParameter("erro") %></h3>
<%	  
  }
%>

<form method=post action="/DesafioSefaz/login">

<br>Email: <input type="text" name="email">
<br>Senha: <input type="text" name="senha">

<br><input type=submit value="Logar" class="button is-primary">
<br><a href="/DesafioSefaz/CadastroForm.jsp">Cadastrar</a>
</form>

</body>
</html>