package com.telecomunicacao.inova.sistema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.telecomunicacao.inova.sistema.modal.Lista;

@Controller
@RequestMapping("/admin/lista")
public class ListaController {

	@RequestMapping
	public String lista(){
		return "Lista";
	}
	@RequestMapping("/novo")
	public String novo() {
		return "CadastroLista";
	}
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(Lista lista) {
		System.out.println(">>>> " + lista.getResponsavel()+" "+ lista.getRamal()+" "+lista.getTelefone());
		return "Lista";
	}
}
