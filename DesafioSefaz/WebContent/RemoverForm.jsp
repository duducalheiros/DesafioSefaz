<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bulma.css">
<script type="text/javascript" src="js/adicionar_telefones.js"></script>
<meta charset="ISO-8859-1">
<title>Remover - DesafioSefaz duducalheiros</title>
</head>
<body>

<H1>REMOVER USU�RIO</H1>

<br>Vamos remover um usu�rio
<br>Digite o Id do usu�rio

<%
  if (request.getParameter("erro") != null) {
%>
<h3><%= request.getParameter("erro") %></h3>
<%	  
  }
%>

<form method=post action="/DesafioSefaz/remover">

<br>Id usuario: <input type="text" name="id">
<br>

<br><input type=submit value="Remover" class="button is-primary">

<br><a href="/DesafioSefaz/Menu.jsp">Voltar</a>

</form>

</body>
</html>