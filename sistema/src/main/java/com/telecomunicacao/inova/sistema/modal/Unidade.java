package com.telecomunicacao.inova.sistema.modal;

import java.util.Date;

public class Unidade extends MinhaEntidade{

	private String nome;
	private Cliente cliente;
	private boolean internet;
	private String endereco;
	private Integer codigoAtivacao;
	private String planoInternet;
	private String conexao;
	private String senha;
	private String host;
	private boolean portabilidade;
	private Integer linha;
	private Integer ramal;
	private Date dataSolicitacao;
	private StatusPortabilidade statusPortabilidade;
	private Provedor provedor;
	
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
	public boolean isInternet() {
		return internet;
	}
	public void setInternet(boolean internet) {
		this.internet = internet;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Integer getCodigoAtivacao() {
		return codigoAtivacao;
	}
	public void setCodigoAtivacao(Integer codigoAtivacao) {
		this.codigoAtivacao = codigoAtivacao;
	}
	public String getPlanoInternet() {
		return planoInternet;
	}
	public void setPlanoInternet(String planoInternet) {
		this.planoInternet = planoInternet;
	}
	public String getConexao() {
		return conexao;
	}
	public void setConexao(String conexao) {
		this.conexao = conexao;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public boolean isPortabilidade() {
		return portabilidade;
	}
	public void setPortabilidade(boolean portabilidade) {
		this.portabilidade = portabilidade;
	}
	public Integer getLinha() {
		return linha;
	}
	public void setLinha(Integer linha) {
		this.linha = linha;
	}
	public Integer getRamal() {
		return ramal;
	}
	public void setRamal(Integer ramal) {
		this.ramal = ramal;
	}
	public Date getDataSolicitacao() {
		return dataSolicitacao;
	}
	public void setDataSolicitacao(Date dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}
	public StatusPortabilidade getStatusPortabilidade() {
		return statusPortabilidade;
	}
	public void setStatusPortabilidade(StatusPortabilidade statusPortabilidade) {
		this.statusPortabilidade = statusPortabilidade;
	}
	public Provedor getProvedor() {
		return provedor;
	}
	public void setProvedor(Provedor provedor) {
		this.provedor = provedor;
	}
	@Override
	public String toString() {
		return "Unidade [nome=" + nome + ", cliente=" + cliente + ", internet=" + internet + ", endereco=" + endereco
				+ ", codigoAtivacao=" + codigoAtivacao + ", planoInternet=" + planoInternet + ", conexao=" + conexao
				+ ", senha=" + senha + ", host=" + host + ", portabilidade=" + portabilidade + ", linha=" + linha
				+ ", ramal=" + ramal + ", dataSolicitacao=" + dataSolicitacao + "]";
	}
	public Unidade(String nome, Cliente cliente, boolean internet, String endereco, Integer codigoAtivacao,
			String planoInternet, String conexao, String senha, String host, boolean portabilidade, Integer linha,
			Integer ramal, Date dataSolicitacao) {
		super();
		this.nome = nome;
		this.cliente = cliente;
		this.internet = internet;
		this.endereco = endereco;
		this.codigoAtivacao = codigoAtivacao;
		this.planoInternet = planoInternet;
		this.conexao = conexao;
		this.senha = senha;
		this.host = host;
		this.portabilidade = portabilidade;
		this.linha = linha;
		this.ramal = ramal;
		this.dataSolicitacao = dataSolicitacao;
	}
	public Unidade() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
