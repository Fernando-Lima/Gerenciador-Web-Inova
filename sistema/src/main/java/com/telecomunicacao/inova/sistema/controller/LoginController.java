package com.telecomunicacao.inova.sistema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@RequestMapping
	public ModelAndView telaLogin () {
		ModelAndView mv = new ModelAndView("Login");
		return mv;
	}
	
	
}
