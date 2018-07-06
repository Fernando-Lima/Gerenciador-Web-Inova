package com.telecomunicacao.inova.sistema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.telecomunicacao.inova.sistema.modal.Cliente;
import com.telecomunicacao.inova.sistema.service.CLienteDAO;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	CLienteDAO<Cliente> clienteDao;
	
	@RequestMapping
	public ModelAndView listar() {
		ModelAndView mv;
		try {
			List<Cliente> clientes = clienteDao.listAll();
			mv = new ModelAndView("PesquisaClientes");
			mv.addObject("listaClientes", clientes);
		} catch (Exception e) {
			e.printStackTrace();
			mv = new ModelAndView("404");
		}
		return mv;
	}
}
