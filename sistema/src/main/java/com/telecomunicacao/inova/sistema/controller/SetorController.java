package com.telecomunicacao.inova.sistema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.telecomunicacao.inova.sistema.modal.Setor;
import com.telecomunicacao.inova.sistema.service.SetorDAO;

@Controller
@RequestMapping("/setores")
public class SetorController {
	private static String TAG = "/setor";
	
	@Autowired
	SetorDAO<Setor> setorDao;
	
	@RequestMapping
	public ModelAndView listar() {
		ModelAndView mv;
		try {
			List<Setor> todosSetores = setorDao.listAll();
			mv = new ModelAndView("PesquisaSetor");
			mv.addObject("setores", todosSetores);
		} catch (Exception e) {
			e.printStackTrace();
			mv = new ModelAndView("404");
		}
		return mv;
	}
}
