package com.telecomunicacao.inova.sistema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.telecomunicacao.inova.sistema.modal.Patrimonio;
import com.telecomunicacao.inova.sistema.service.PatrimonioDAO;

@Controller
@RequestMapping("/patrimonios")
public class PatrimonioController {
	
	@Autowired
	PatrimonioDAO<Patrimonio> dao; 

	@RequestMapping
	public ModelAndView listarPatrimonios() {
		ModelAndView mv;
		try {
			List<Patrimonio> todosPatrimonios = dao.listAll();
			mv = new ModelAndView("PesquisaPatrimonios");
			mv.addObject("patrimonios", todosPatrimonios);
		} catch (Exception e) {
			e.printStackTrace();
			mv = new ModelAndView("404");
		}
		return mv;
	}
	
	@RequestMapping("/novo")
	public ModelAndView  novo() {
		ModelAndView mv;
		mv = new ModelAndView("cadastroPatrimonio");
		mv.addObject(new Patrimonio());
		return mv;
	}
}
