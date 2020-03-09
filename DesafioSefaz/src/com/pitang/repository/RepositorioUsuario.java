package com.pitang.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.pitang.model.Telefone;
import com.pitang.model.Usuario;

public class RepositorioUsuario {
	
	

	public static void main(String[] args) {

		RepositorioUsuario ru = new RepositorioUsuario();
		ru.init();

		
//		// ### Teste para Consultar Usuários ###
//		Collection<Usuario> usuarios = ru.consulta();
//		for (Iterator<Usuario> iterator = usuarios.iterator(); iterator.hasNext();) {
//			Usuario usuario = (Usuario) iterator.next();
//			System.out.println("Usuário: " +usuario.getId()+ "\nNome: " +usuario.getNome()+ "\nEmail: " +usuario.getEmail()+ "\nSenha: " +usuario.getSenha());
//			System.out.println("\nTelefones:");
//			
//			Collection<Telefone> telefones = usuario.getTelefones();
//			for (Iterator<Telefone> iterator1 = telefones.iterator(); iterator1.hasNext();) {
//				Telefone telefone = (Telefone) iterator1.next();
//				System.out.println("(" +telefone.getDdd()+ ") " +telefone.getNumero()+ " - " +telefone.getTipo());
//			}
//		
//			System.out.println("\n---------------------------\n");
//		}
		
//		// ### Teste para Incluir Usuário ###
//		Usuario usuario = new Usuario("Eduardo TESTE", "eduardo@TESTE", "TESTE");
//		
//		Collection<Telefone> telefones = new ArrayList();
//		
//		Telefone t1 = new Telefone(81, "999999999", "Celular");
//		telefones.add(t1);
//		Telefone t2 = new Telefone(81, "30303030", "Residencial");
//		telefones.add(t2);
//		Telefone t3 = new Telefone(81, "20202020", "Trabalho");
//		telefones.add(t3);
//		
//		usuario.setTelefones(telefones);
//		
//		Usuario inserido = ru.incluir(usuario);
//		System.out.println(inserido.getId());

		
//		// ### Teste para Alterar Usuário ###
//		Usuario usuario = new Usuario(16, "Eduardo Coutinho Calheiros TESTE", "duducalheiros@TESTE", "TESTE123");
//		
//		Collection<Telefone> telefones = new ArrayList();
//		
//		Telefone t1 = new Telefone(12, 21, "777777777", "Celular");
//		telefones.add(t1);
//		Telefone t2 = new Telefone(13, 21, "30303030", "Residencial");
//		telefones.add(t2);
//		Telefone t3 = new Telefone(14, 21, "20202020", "Trabalho");
//		telefones.add(t3);
//		
//		usuario.setTelefones(telefones);
//
//		
//		Usuario alterado = ru.alterar(usuario);
//		System.out.println(alterado.getNome());

		
//		// ### Teste para Remover Usuário ###
//		Usuario usuario = new Usuario(15);
//		Usuario removido = ru.remover(usuario);
//		System.out.println(removido.getNome());
		

	
	}
	
	public RepositorioUsuario() {
		init();
	}
	
	public void init() {
		  // 1. Load JDBC driver
		  try {
		   Class.forName("com.mysql.cj.jdbc.Driver");
		  } catch (ClassNotFoundException e) {
		   e.printStackTrace();
		  }
		 }
	
	//Query para Login OK
	public boolean login(String email, String senha) {
		  String url = "jdbc:mysql://localhost:3306/cadastro_sefaz?useTimezone=true&serverTimezone=UTC";
		  String dbUsername = "root";
		  String dbPassword = "12345678";
		  String query = "select id from usuario where email='" + email + "' and senha='" + senha + "'";
		try {
		  
		  // 2. Create a connection
		  Connection con = DriverManager.getConnection(url, dbUsername, dbPassword);
		  
		  // 3. Create a statement
		  Statement st = con.createStatement();
		  
		  // 4. Create a ResultSet
		  ResultSet rs = st.executeQuery(query);
		  
		  if (rs.next()) {
		   // 5. Close all connections
		   rs.close();
		   st.close();
		   con.close();
		   return true;
		  }
		  
		  // 5. Close all connections
		  rs.close();
		  st.close();
		  con.close();
		  return false;
		 }
		 catch (SQLException e) {
		  System.out.println(e.toString());
		 } catch (Exception e) {
		  System.out.println(e.toString());
		 }
		 return false;
		}

	//Query para Consultar Usuário OK
	public Collection<Usuario> consulta() {
		  String url = "jdbc:mysql://localhost:3306/cadastro_sefaz?useTimezone=true&serverTimezone=UTC";
		  String dbUsername = "root";
		  String dbPassword = "12345678";
		  String query = "select * from usuario";
		  Collection<Usuario> usuarios = new ArrayList<Usuario>();
		try {
		  
		  // Create a connection
		  Connection con = DriverManager.getConnection(url, dbUsername, dbPassword);
		  
		  // Create a statement
		  Statement st = con.createStatement();
		  
		  // Create a ResultSet
		  ResultSet rs = st.executeQuery(query);
		  
		 
		  while (rs.next()) {
			  Integer id = rs.getInt("id");
			  String nome = rs.getString("nome");
			  String email = rs.getString("email");
			  String senha = rs.getString("senha");
			  
			  Usuario u = new Usuario(id, nome, email, senha, telefones(con, id));
			  usuarios.add(u);
		  }
		  
		  // Close all connections
		  rs.close();
		  st.close();
		  con.close();
		  
		 }
		
		 catch (SQLException e) {
			 e.printStackTrace();
		  System.out.println(e.toString());
		 } catch (Exception e) {
		  System.out.println(e.toString());
		 }
		return usuarios;
		}

	
	//Query para Consultar Telefones de cada Usuário OK	
	private Collection<Telefone> telefones(Connection con, Integer idUsuario) {
		 Collection<Telefone> telefones = new ArrayList<Telefone>();
		 
		 try {
			// Create a statement
			  Statement st = con.createStatement();
			  
			  // Create a ResultSet
			  ResultSet rs = st.executeQuery("SELECT * FROM telefones WHERE id_usuario = " + idUsuario);
			  
			  while (rs.next()) {
				  Integer id = rs.getInt("id");
				  Integer ddd = rs.getInt("ddd");
				  String numero = rs.getString("numero");
				  String tipo = rs.getString("tipo");
				  
				  Telefone t = new Telefone(id, ddd, numero, tipo);
				  telefones.add(t);
			  }
			  
			  rs.close();
			  st.close();
			  
			  
		 } catch (SQLException e) {
			 e.printStackTrace();
		  System.out.println(e.toString());
		 } catch (Exception e) {
		  System.out.println(e.toString());
		 }
		  
		  return telefones;
		  
		  
	}


	//Query para Incluir Usuário OK
	public Usuario incluir(Usuario usuario) {
	
		  String url = "jdbc:mysql://localhost:3306/cadastro_sefaz?useTimezone=true&serverTimezone=UTC";
		  String dbUsername = "root";
		  String dbPassword = "12345678";
		  String query = "INSERT INTO usuario (Nome, Email, Senha) VALUES('" + usuario.getNome() + "', '" + usuario.getEmail() + "', '" + usuario.getSenha() + "')";
		  String query1 = "SELECT id FROM usuario WHERE email = '" + usuario.getEmail() +"'";
		  
		try {
		  
		  // Create a connection
		  Connection con = DriverManager.getConnection(url, dbUsername, dbPassword);
		  
		  // Create a statement
		  Statement st = con.createStatement();
		  st.execute(query);
		  
		  
		  // Create a statement
		  Statement st1 = con.createStatement();
		  // Create a ResultSet
		  ResultSet rs1 = st1.executeQuery(query1);
		  
		  if (rs1.next()) {
			  Integer id = rs1.getInt("id");	 
			  usuario.setId(id);
		  }
		  
		  Statement st2 = null;
		  for (Iterator iterator = usuario.getTelefones().iterator(); iterator.hasNext();) {
			Telefone telefone = (Telefone) iterator.next();
			
			 String query2 = "INSERT INTO telefones (ddd, Numero, Tipo, Id_usuario) VALUES('" + telefone.getDdd() + "', '" + telefone.getNumero() + "', '" + telefone.getTipo() + "', '" + usuario.getId() + "')";
			 st2 = con.createStatement();
			 st2.execute(query2);
		  }
		  
			  
		  // Close all connections
		  rs1.close();
		  st.close();
		  st1.close();
		  st2.close();
		  con.close();
		  
		 }
		
		 catch (SQLException e) {
			 e.printStackTrace();
		  System.out.println(e.toString());
		 } catch (Exception e) {
		  System.out.println(e.toString());
		 }
		return usuario;
		}
	
	
	//Query para Alterar Usuário OK
	public Usuario alterar(Usuario usuario) {
		
		  String url = "jdbc:mysql://localhost:3306/cadastro_sefaz?useTimezone=true&serverTimezone=UTC";
		  String dbUsername = "root";
		  String dbPassword = "12345678";
		  String query = "UPDATE usuario SET Nome = '" + usuario.getNome() +"', Email = '" + usuario.getEmail() +"', Senha = '" + usuario.getSenha() + "' WHERE Id = '" + usuario.getId() +"'";
	  
		try {
		  
		  // Create a connection
		  Connection con = DriverManager.getConnection(url, dbUsername, dbPassword);
		  
		  // Create a statement
		  Statement st = con.createStatement();
		  
		  
		  st.execute(query);
		  
		  
		  Statement st1 = null;
		  for (Iterator iterator = usuario.getTelefones().iterator(); iterator.hasNext();) {
			Telefone telefone = (Telefone) iterator.next();
			
			 String query1 = "UPDATE telefones SET ddd = '" + telefone.getDdd() + "', Numero = '" + telefone.getNumero() + "', Tipo = '" + telefone.getTipo() + "' WHERE Id = '" + telefone.getId() + "'";
			 st1 = con.createStatement();
			 st1.execute(query1);
		  }
		 
		  // Close all connections
		  st.close();
		  st1.close();
		  con.close();
		  
		 }
		
		 catch (SQLException e) {
			 e.printStackTrace();
		  System.out.println(e.toString());
		 } catch (Exception e) {
		  System.out.println(e.toString());
		 }
		return usuario;
		}

		
	//Query para Remover Usuário OK
	public Usuario remover(Usuario usuario) {
		
		  String url = "jdbc:mysql://localhost:3306/cadastro_sefaz?useTimezone=true&serverTimezone=UTC";
		  String dbUsername = "root";
		  String dbPassword = "12345678";
		  String query = "DELETE FROM telefones WHERE Id_usuario = " + usuario.getId();
		  String query1 = "DELETE FROM usuario WHERE Id = " + usuario.getId();

		  
		try {
		  
		  // Create a connection
		  Connection con = DriverManager.getConnection(url, dbUsername, dbPassword);
		  
		  // Create a statement
		  Statement st = con.createStatement();
		  
		  
		  st.execute(query);
		  
		
		  // Create a statement
		  Statement st1 = con.createStatement();
		  
		  // Create a ResultSet
		  st1.execute(query1);
		  
		  
		  st.close();
		  st1.close();
		  con.close();
	 
			  
		 }
		
		 catch (SQLException e) {
			 e.printStackTrace();
		  System.out.println(e.toString());
		 } catch (Exception e) {
		  System.out.println(e.toString());
		 }
		return usuario;
		}

	
	
}
