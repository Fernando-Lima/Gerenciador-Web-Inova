package com.telecomunicacao.inova.sistema.modal;


public class SetorCliente extends MinhaEntidade{

	private String nome;
	private Unidade unidade;
	private Integer telefone;
	private Integer ramal;
		
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
	public Integer getRamal() {
		return ramal;
	}
	public void setRamal(Integer ramal) {
		this.ramal = ramal;
	}
	@Override
	public String toString() {
		return "SetorCliente [nome=" + nome + ", unidade=" + unidade + ", telefone=" + telefone + ", ramal=" + ramal
				+ "]";
	}
	
	
	
}
