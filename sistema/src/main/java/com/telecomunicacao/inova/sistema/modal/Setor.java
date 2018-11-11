package com.telecomunicacao.inova.sistema.modal;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Setor extends MinhaEntidade{

	private String nome;
	@ManyToOne
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
