package com.telecomunicacao.inova.sistema.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.telecomunicacao.inova.sistema.DAO.ListaDAO;
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
}
