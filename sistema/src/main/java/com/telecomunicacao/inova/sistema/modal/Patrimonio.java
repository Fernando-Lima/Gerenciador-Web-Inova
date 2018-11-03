package com.telecomunicacao.inova.sistema.modal;

public class Patrimonio extends MinhaEntidade{
	private String nome;
	private Long patrimonio;
	private String descricao;
	private Modelo modelo;
	private String mac;
	private String ns; 
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getPatrimonio() {
		return patrimonio;
	}
	public void setPatrimonio(Long patrimonio) {
		this.patrimonio = patrimonio;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao =  descricao;
	}
	public Modelo getModelo() {
		return modelo;
	}
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getNs() {
		return ns;
	}
	public void setNs(String ns) {
		this.ns = ns;
	}
}
