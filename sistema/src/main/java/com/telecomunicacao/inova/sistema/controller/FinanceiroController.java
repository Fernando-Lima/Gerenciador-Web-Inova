package com.telecomunicacao.inova.sistema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/financeiro")
public class FinanceiroController {
	
	@RequestMapping
	public String financeiro() {
		return "Financeiro";
	}
}
