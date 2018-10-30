package com.telecomunicacao.inova.sistema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.telecomunicacao.inova.sistema.modal.Modelo;
import com.telecomunicacao.inova.sistema.service.ModeloDAO;

@Controller
@RequestMapping("/modelos")
public class ModeloController {
	
	@Autowired
	ModeloDAO<Modelo> modeloDao;
	
	@RequestMapping
	public ModelAndView listarModelos() {
		ModelAndView mv;
		try {
			List<Modelo> modelos = modeloDao.listAll();
			mv = new ModelAndView("PesquisaModelos");
			mv.addObject(modelos);
		} catch (Exception e) {
			e.printStackTrace();
			mv = new ModelAndView("404");
		}
		return mv;
	}
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("cadastroModelo");
		mv.addObject(new Modelo());
		return mv;
	}

}
