package com.telecomunicacao.inova.sistema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.telecomunicacao.inova.sistema.modal.Empresa;
import com.telecomunicacao.inova.sistema.service.EmpresaDAO;

@Controller
@RequestMapping("/empresas")
public class EmpresaController {
	
	@Autowired
	EmpresaDAO<Empresa> empresaDao;
	
	@RequestMapping
	public ModelAndView listar() {
		ModelAndView mv;
		try {
			List<Empresa> empresas = empresaDao.listAll();
			mv = new ModelAndView("PesquisaEmpresas");
			mv.addObject("listaEmpresas", empresas);
		} catch (Exception e) {
			e.printStackTrace();
			mv = new ModelAndView("404");
		}
		return mv;
	}
}
