package com.telecomunicacao.inova.sistema.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
