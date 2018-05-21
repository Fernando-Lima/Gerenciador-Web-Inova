package com.telecomunicacao.inova.sistema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cadastro")
public class CadastroController {

	@RequestMapping
	public String cadastro() {
		return "Cadastro";
	}
}
