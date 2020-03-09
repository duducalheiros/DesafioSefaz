package com.pitang.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pitang.repository.RepositorioUsuario;
import com.pitang.service.ServiceUsuario;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	

		public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
//		  showLoginForm(req, res);
		 }
		
		public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
			  String email = req.getParameter("email");
			  String senha = req.getParameter("senha");
			  if (email.isEmpty() || senha.isEmpty()) {
				  res.sendRedirect("LoginForm.jsp?erro=Preenchealgo");
			  } else {
				  ServiceUsuario su = new ServiceUsuario();
				  try {
					  Boolean sucesso = su.login(email, senha);
					  
					  if (sucesso) {
						  res.sendRedirect("Menu.jsp");
					  } else {
						  res.sendRedirect("LoginForm.jsp?erro=Fudeu");
					  }
				  } catch (Exception e) {
					  res.sendRedirect("LoginForm.jsp?erro=" + e.getMessage());
				  }
				 
				  
			  }
			  
			 }
	
}
