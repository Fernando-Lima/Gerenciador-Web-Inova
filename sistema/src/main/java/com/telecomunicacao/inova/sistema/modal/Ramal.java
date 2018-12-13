package com.telecomunicacao.inova.sistema.modal;

import java.util.List;

public class Ramal extends MinhaEntidade {

	private Integer ramal;
	private List<SetorCliente> setorCliente;
	public Integer getRamal() {
		return ramal;
	}
	public void setRamal(Integer ramal) {
		this.ramal = ramal;
	}
	public List<SetorCliente> getSetorCliente() {
		return setorCliente;
	}
	public void setSetorCliente(List<SetorCliente> setorCliente) {
		this.setorCliente = setorCliente;
	}
	
	
}
