package com.telecomunicacao.inova.sistema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PatrimonioController {

	@RequestMapping("/patrimonios/novo")
	public String novo() {
		return "index";
	}
	
}
