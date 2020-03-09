package com.pitang.model;

import java.util.Collection;

public class Usuario {
	
	private Integer id;
	private String nome;
	private String email;
	private String senha;
	private Collection<Telefone> telefones;
	
		
	public Usuario(Integer id) {
		super();
		this.id = id;
	}


	public Usuario(String nome, String email, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	
	public Usuario(Integer id, String nome, String email, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	
	public Usuario(String nome, String email, String senha, Collection<Telefone> telefones) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.telefones = telefones;
	}


	public Usuario(Integer id, String nome, String email, String senha, Collection<Telefone> telefones) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.telefones = telefones;
	}

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Collection<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(Collection<Telefone> telefones) {
		this.telefones = telefones;
	}
	
	

}
