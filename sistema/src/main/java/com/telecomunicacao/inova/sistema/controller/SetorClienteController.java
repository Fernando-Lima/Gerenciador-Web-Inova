package com.telecomunicacao.inova.sistema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.telecomunicacao.inova.sistema.modal.SetorCliente;
import com.telecomunicacao.inova.sistema.service.SetorClienteDAO;

@Controller
@RequestMapping("/setorCliente")
public class SetorClienteController {
	private static String TAG = "/setorCliente";
	
	@Autowired
	SetorClienteDAO<SetorCliente> setorClienteDao;
	
	public ModelAndView listar() {
		ModelAndView mv;
		try {
			List<SetorCliente> listaSetorCliente = setorClienteDao.listAll();
			mv = new ModelAndView("PesquisaSetorCliente");
			mv.addObject("setorClientes", listaSetorCliente);
		} catch (Exception e) {
			e.printStackTrace();
			mv = new ModelAndView("404");
		}
		return mv;
	}
}
