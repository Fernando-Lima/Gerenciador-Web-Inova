package com.telecomunicacao.inova.sistema.modal;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Cliente extends MinhaEntidade{

	private String nome;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone="GMT-3")
	private Date data;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone="GMT-3")
	private Date dataInicioContrato;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone="GMT-3")
	private Date dataFinalContrato;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone="GMT-3")
	private Date sla;
	private Integer numeroAditivo;
	private Integer cnpj;
	private String endereco;
	private Cidade cidade;
	private String situacao;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date dataCadastro) {
		this.data = new Date();
	}
	public Date getDataInicioContrato() {
		return dataInicioContrato;
	}
	public void setDataInicioContrato(Date dataInicioContrato) {
		this.dataInicioContrato = null;
	}
	public Date getDataFinalContrato() {
		return dataFinalContrato;
	}
	public void setDataFinalContrato(Date dataFinalContrato) {
		this.dataFinalContrato = dataFinalContrato;
	}
	public Date getSla() {
		return sla;
	}
	public void setSla(Date sla) {
		this.sla = sla;
	}
	public Integer getNumeroAditivo() {
		return numeroAditivo;
	}
	public void setNumeroAditivo(Integer numeroAditivo) {
		this.numeroAditivo = numeroAditivo;
	}
	public Integer getCnpj() {
		return cnpj;
	}
	public void setCnpj(Integer cnpj) {
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
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", dataCadastro =" + data + ", dataInicioContrato=" + dataInicioContrato
				+ ", dataFinalContrato=" + dataFinalContrato + ", sla=" + sla + ", numeroAditivo=" + numeroAditivo
				+ ", cnpj=" + cnpj + ", endereco=" + endereco + ", cidade=" + cidade + "]";
	}
}
