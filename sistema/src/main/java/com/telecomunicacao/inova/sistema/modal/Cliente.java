package com.telecomunicacao.inova.sistema.modal;

import java.util.Date;

public class Cliente extends MinhaEntidade{

	private String nome;
	private Date data;
	private Date dataInicioContrato;
	private Date dataFinalContrato;
	private Date sla;
	private Integer numeroAditivo;
	private Integer cnpj;
	private String endereco;
	private Cidade cidade;
	private SituacaoCliente situacaoCliente;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataCadastro() {
		return data;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.data = dataCadastro;
	}
	public Date getDataInicioContrato() {
		return dataInicioContrato;
	}
	public void setDataInicioContrato(Date dataInicioContrato) {
		this.dataInicioContrato = dataInicioContrato;
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
	public SituacaoCliente getSituacao() {
		return situacaoCliente;
	}
	public void setSituacao(SituacaoCliente situacaoCliente) {
		this.situacaoCliente = situacaoCliente;
	}
	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", dataCadastro =" + data + ", dataInicioContrato=" + dataInicioContrato
				+ ", dataFinalContrato=" + dataFinalContrato + ", sla=" + sla + ", numeroAditivo=" + numeroAditivo
				+ ", cnpj=" + cnpj + ", endereco=" + endereco + ", cidade=" + cidade + ", situacaoCliente=" + situacaoCliente + "]";
	}
	
	
	
}
