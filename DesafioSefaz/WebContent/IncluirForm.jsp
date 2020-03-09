<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bulma.css">
<script type="text/javascript" src="js/adicionar_telefones.js"></script>
<meta charset="ISO-8859-1">
<title>Incluir - DesafioSefaz duducalheiros</title>
</head>
<body>

<h1>INCLUIR USUÁRIO</h1>

<br>Vamos incluir um usuario
<br>Digite o Nome Completo, o Email, a Senha e os telefones

<%
  if (request.getParameter("erro") != null) {
%>
<h3><%= request.getParameter("erro") %></h3>
<%	  
  }
%>

<form method=post action="/DesafioSefaz/incluir">

<br>Nome: <input type="text" name="nome">
<br>Email: <input type="text" name="email">
<br>Senha: <input type="text" name="senha">
<br>
<br>Telefones: 
<br>
    <input name=ddd1 type="number" value=ddd>
    <input name="numero1" type="text" value="numero">
    <input name="tipo1" type="text" value="tipo">
<br>
    <input name=ddd2 type="number" value=ddd>
    <input name="numero2" type="text" value="numero">
    <input name="tipo2" type="text" value="tipo">
<br>
    <input name=ddd3 type="number" value=ddd>
    <input name="numero3" type="text" value="numero">
    <input name="tipo3" type="text" value="tipo">
<br>

<br><input type=submit value="Incluir" class="button is-primary">

<br><a href="/DesafioSefaz/Menu.jsp">Voltar</a>

</form>

</body>
</html>