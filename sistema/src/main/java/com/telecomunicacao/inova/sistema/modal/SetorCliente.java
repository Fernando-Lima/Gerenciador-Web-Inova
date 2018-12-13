package com.telecomunicacao.inova.sistema.modal;

import java.util.List;

public class SetorCliente extends MinhaEntidade{

	private String nome;
	private Unidade unidade;
	private Integer telefone;
	private List<Ramal> ramal;
		
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
	public Integer getTelefone() {
		return telefone;
	}
	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}
	public List<Ramal> getRamal() {
		return ramal;
	}
	public void setRamal(List<Ramal> ramal) {
		this.ramal = ramal;
	}
	
	
}
