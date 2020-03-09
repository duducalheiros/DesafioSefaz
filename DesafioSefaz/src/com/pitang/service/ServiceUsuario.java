package com.pitang.service;

import java.util.Collection;

import com.pitang.model.Usuario;
import com.pitang.repository.RepositorioUsuario;

public class ServiceUsuario {

	public static void main(String[] args) {
	
	}
	
	public boolean login(String email, String senha) throws Exception {
		if (senha.length() != 8) {
			throw new Exception("vnvjdfjdfbj");
		}
		
		RepositorioUsuario ru = new RepositorioUsuario();
		return ru.login(email, senha);
	}


	public Usuario incluir(Usuario usuario) {
		
		RepositorioUsuario ru = new RepositorioUsuario();
		return ru.incluir(usuario);
	}

	
	public Usuario alterar(Usuario usuario) {
		
		RepositorioUsuario ru = new RepositorioUsuario();
		return ru.alterar(usuario);
	}

	
	public Usuario remover(Usuario usuario) {
		
		RepositorioUsuario ru = new RepositorioUsuario();
		return ru.remover(usuario);
	}



}
