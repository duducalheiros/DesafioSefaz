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

@WebServlet("/incluir")
public class IncluirServlet extends HttpServlet {

		public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		 }
		
		public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
			String nome = req.getParameter("nome");	
			String email = req.getParameter("email");
			String senha = req.getParameter("senha");
			String ddd1 = req.getParameter("ddd1");
			String numero1 = req.getParameter("numero1");
			String tipo1 = req.getParameter("tipo1");
			String ddd2 = req.getParameter("ddd2");
			String numero2 = req.getParameter("numero2");
			String tipo2 = req.getParameter("tipo2");
			String ddd3 = req.getParameter("ddd3");
			String numero3 = req.getParameter("numero3");
			String tipo3 = req.getParameter("tipo3");

			  if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
				  res.sendRedirect("IncluirForm.jsp?erro=Preenchealgo");
			  } else {
				  ServiceUsuario su = new ServiceUsuario();
				  try {
					  Usuario usuario = new Usuario(nome, email, senha);
					  Collection<Telefone> telefones = new ArrayList();
						if (ddd1!="") {
							Telefone t1 = new Telefone(Integer.parseInt(ddd1), numero1, tipo1);
							telefones.add(t1);							
						}if (ddd2!="") {
							Telefone t2 = new Telefone(Integer.parseInt(ddd2), numero2, tipo2);
							telefones.add(t2);
						}if (ddd3!="") {
							Telefone t3 = new Telefone(Integer.parseInt(ddd3), numero3, tipo3);
							telefones.add(t3);
						}
						
						usuario.setTelefones(telefones);
					  
					  su.incluir(usuario);
					 
				  } catch (Exception e) {
					  res.sendRedirect("IncluirForm.jsp?erro=" + e.getMessage());
				  }
				 
				  
			  }
			  
			 }

}
