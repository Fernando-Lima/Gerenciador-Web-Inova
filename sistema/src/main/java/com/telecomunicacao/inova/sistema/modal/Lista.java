package com.telecomunicacao.inova.sistema.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Lista {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	private Integer ramal;
	private Integer telefone;
	private String responsavel;
	@ManyToOne
	@JoinColumn(name="setor_IdSetor")
	private Setor setor;

	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public Integer getRamal() {
		return ramal;
	}
	public void setRamal(Integer ramal) {
		this.ramal = ramal;
	}
	public Integer getTelefone() {
		return telefone;
	}
	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	public Setor getSetor() {
		return setor;
	}
	public void setSetor(Setor setor) {
		this.setor = setor;
	}
	
}