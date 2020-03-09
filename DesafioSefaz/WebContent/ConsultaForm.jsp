<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bulma.css">
<script type="text/javascript" src="js/path-to-javascript-file.js"></script>
<meta charset="ISO-8859-1">
<title>Consulta - DesafioSefaz duducalheiros</title>
</head>
<body>

<br>CONSULTAR USUÁRIOS

<%
  if (request.getParameter("erro") != null) {
%>
<h3><%= request.getParameter("erro") %></h3>
<%	  
  }
%>

<form method=post action="/DesafioSefaz/consulta">

<br><input type=submit value="Consultar" class="button is-primary">

<br><a href="/DesafioSefaz/Menu.jsp">Voltar</a>

</form>

</body>
</html>