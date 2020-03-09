package com.pitang.model;

public class Telefone {

	private Integer id;
	private Integer ddd;
	private String numero;
	private String tipo;
	private Integer id_usuario;

	
	public Telefone(Integer id, Integer ddd, String numero, String tipo) {
		super();
		this.id = id;
		this.ddd = ddd;
		this.numero = numero;
		this.tipo = tipo;
	}


	public Telefone(Integer ddd, String numero, String tipo, Integer id_usuario) {
		super();
		this.ddd = ddd;
		this.numero = numero;
		this.tipo = tipo;
		this.id_usuario = id_usuario;
	}


	public Telefone(Integer ddd, String numero, String tipo) {
		super();
		this.ddd = ddd;
		this.numero = numero;
		this.tipo = tipo;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getDdd() {
		return ddd;
	}


	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
	public Integer getId_usuario() {
		return id_usuario;
	}


	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}


	
	
}
