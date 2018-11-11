package com.telecomunicacao.inova.sistema.modal;

public class Setor extends MinhaEntidade{

	private String nome;
	private Empresa empresa;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
}
