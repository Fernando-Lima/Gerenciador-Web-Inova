package com.telecomunicacao.inova.sistema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@RequestMapping
	public String clientes() {
		return "Clientes";
	}
}
