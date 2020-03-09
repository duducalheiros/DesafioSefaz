package com.pitang.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pitang.model.Telefone;
import com.pitang.model.Usuario;
import com.pitang.service.ServiceUsuario;

@WebServlet("/alterar")
public class AlterarServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
	 
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String id = req.getParameter("id");
		String nome = req.getParameter("nome");	
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		String id1 = req.getParameter("id1");
		String ddd1 = req.getParameter("ddd1");
		String numero1 = req.getParameter("numero1");
		String tipo1 = req.getParameter("tipo1");
		String id2 = req.getParameter("id2");
		String ddd2 = req.getParameter("ddd2");
		String numero2 = req.getParameter("numero2");
		String tipo2 = req.getParameter("tipo2");
		String id3 = req.getParameter("id3");
		String ddd3 = req.getParameter("ddd3");
		String numero3 = req.getParameter("numero3");
		String tipo3 = req.getParameter("tipo3");

		  if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
			  res.sendRedirect("IncluirForm.jsp?erro=Preenchealgo");
		  } else {
			  ServiceUsuario su = new ServiceUsuario();
			  try {
				  Usuario usuario = new Usuario(Integer.parseInt(id), nome, email, senha);
				  Collection<Telefone> telefones = new ArrayList();
					if (ddd1!="") {
						Telefone t1 = new Telefone(Integer.parseInt(id1), Integer.parseInt(ddd1), numero1, tipo1);
						telefones.add(t1);							
					}if (ddd2!="") {
						Telefone t2 = new Telefone(Integer.parseInt(id2), Integer.parseInt(ddd2), numero2, tipo2);
						telefones.add(t2);
					}if (ddd3!="") {
						Telefone t3 = new Telefone(Integer.parseInt(id3), Integer.parseInt(ddd3), numero3, tipo3);
						telefones.add(t3);
					}
					
					usuario.setTelefones(telefones);
				  
				  su.alterar(usuario);
				 
			  } catch (Exception e) {
				  res.sendRedirect("AlterarForm.jsp?erro=" + e.getMessage());
			  }
			 
			  
		  }
		  
		 }
	
}
