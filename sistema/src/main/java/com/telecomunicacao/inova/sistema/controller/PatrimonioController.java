package com.telecomunicacao.inova.sistema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/patrimonios")
public class PatrimonioController {

	
	public String novo() {
		return "tabelaPatrimonio";
	}
}
