package com.telecomunicacao.inova.sistema.modal;

public class Cidade extends MinhaEntidade{

	private String nome;
	private Long cep;
	private Long populacao;
	private Uf uf;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getCep() {
		return cep;
	}
	public void setCep(Long cep) {
		this.cep = cep;
	}
	public Long getPopulacao() {
		return populacao;
	}
	public void setPopulacao(Long populacao) {
		this.populacao = populacao;
	}
	public Uf getUf() {
		return uf;
	}
	public void setUf(Uf uf) {
		this.uf = uf;
	}
	@Override
	public String toString() {
		return "Cidade [nome=" + nome + ", cep=" + cep + ", populacao=" + populacao + ", uf=" + uf + "]";
	}
	
}
