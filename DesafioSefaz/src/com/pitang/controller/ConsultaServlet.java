package com.pitang.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pitang.model.Telefone;
import com.pitang.model.Usuario;
import com.pitang.repository.RepositorioUsuario;
import com.pitang.service.ServiceUsuario;

@WebServlet("/consulta")
public class ConsultaServlet extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
	
		RepositorioUsuario ru = new RepositorioUsuario();
		Collection<Usuario> usuarios = ru.consulta();
		for (Iterator<Usuario> iterator = usuarios.iterator(); iterator.hasNext();) {
			Usuario usuario = (Usuario) iterator.next();
			PrintWriter out = res.getWriter();
			out.println("Usuário: " +usuario.getId()+ "\nNome: " +usuario.getNome()+ "\nEmail: " +usuario.getEmail()+ "\nSenha: " +usuario.getSenha());
			out.println("\nTelefones:");
			
			Collection<Telefone> telefones = usuario.getTelefones();
			for (Iterator<Telefone> iterator1 = telefones.iterator(); iterator1.hasNext();) {
				Telefone telefone = (Telefone) iterator1.next();
				out.println("Id " + telefone.getId() + " - (" + telefone.getDdd() + ") " + telefone.getNumero() + " - " + telefone.getTipo());
			}
		
			out.println("\n---------------------------\n");
		}

		
			
	
	}
	
}
