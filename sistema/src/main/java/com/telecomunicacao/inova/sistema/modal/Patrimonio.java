package com.telecomunicacao.inova.sistema.modal;

import java.util.Date;

public class Patrimonio extends MinhaEntidade{
	private String nome = "Telefone Ip";
	private Long patrimonio;
	private String descricao;
	private Modelo modelo;
	private String mac;
	private String ns; 
	private Date dataEntrada = new Date();
	private Setor setor;
	
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
		if(ns == "") {
			this.ns = null;
		}else{
			this.ns = ns;
		}
		
	}

	
	public Date getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = new Date();
	}
	public Setor getSetor() {
		return setor;
	}
	public void setSetor(Setor setor) {
		this.setor = setor;
	}
	@Override
	public String toString() {
		return "Patrimonio [nome=" + nome + ", patrimonio=" + patrimonio + ", descricao=" + descricao + ", modelo="
				+ modelo + ", mac=" + mac + ", ns=" + ns + ", dataEntrada=" + dataEntrada + ", setor=" + setor + "]";
	}
	
	
	
}
