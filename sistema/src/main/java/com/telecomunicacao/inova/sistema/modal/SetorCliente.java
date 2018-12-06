package com.telecomunicacao.inova.sistema.modal;

public class SetorCliente extends MinhaEntidade{

	private String nome;
	private Unidade unidade;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Unidade getUnidade() {
		return unidade;
	}
	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
}
