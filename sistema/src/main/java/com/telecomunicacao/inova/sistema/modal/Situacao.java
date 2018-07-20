package com.telecomunicacao.inova.sistema.modal;

public enum Situacao {

	ATIVO("Ativo"),
	INATIVO("Inativo");
	
	private String descricao;
	
	Situacao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
