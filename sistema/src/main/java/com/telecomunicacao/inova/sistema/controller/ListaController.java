package com.telecomunicacao.inova.sistema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.telecomunicacao.inova.sistema.Listas;
import com.telecomunicacao.inova.sistema.modal.Lista;
import com.telecomunicacao.inova.sistema.modal.Setor;

@Controller
@RequestMapping("/admin/lista")
public class ListaController {
	
	@Autowired
	private Listas listas;

	@RequestMapping
	public String lista(){
		return "Lista";
	}
	@RequestMapping("/novo")
	public String novo() {
		return "CadastroLista";
	}
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(Lista lista) {
		//listas.save(lista);
		ModelAndView mv = new ModelAndView("CadastroLista");
		mv.addObject("mensagem", "Lista salva com sucesso!");
		return mv;
	}
}
