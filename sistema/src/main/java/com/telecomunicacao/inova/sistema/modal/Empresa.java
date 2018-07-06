package com.telecomunicacao.inova.sistema.modal;

public class Empresa extends MinhaEntidade{

	private String nome;
	private Long cnpj;
	private String endereco;
	private Cidade cidade;
	public Long getCnpj() {
		return cnpj;
	}
	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	@Override
	public String toString() {
		return "Empresa [nome=" + nome + ", cnpj=" + cnpj + ", endereco=" + endereco + ", cidade=" + cidade + "]";
	}
	
	
}
