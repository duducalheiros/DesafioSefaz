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

@WebServlet("/remover")
public class RemoverServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
	 }
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String id = req.getParameter("id");	
		
		ServiceUsuario su = new ServiceUsuario();
		 try {
		  Usuario usuario = new Usuario(Integer.parseInt(id));
		  su.remover(usuario);
				 
		} catch (Exception e) {
		  res.sendRedirect("ConsutarForm.jsp?erro=" + e.getMessage());
		}
			 
			  
	}
		  
}


