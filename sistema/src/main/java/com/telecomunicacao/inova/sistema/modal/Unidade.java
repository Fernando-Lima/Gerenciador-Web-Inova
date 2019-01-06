package com.telecomunicacao.inova.sistema.modal;

public class Unidade extends MinhaEntidade{

	private String nome;
	private Cliente cliente;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	@Override
	public String toString() {
		return "Unidade [nome=" + nome + ", cliente=" + cliente + "]";
	}
	
	
}
