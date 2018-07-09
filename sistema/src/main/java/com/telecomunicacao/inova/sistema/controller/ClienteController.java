package com.telecomunicacao.inova.sistema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.telecomunicacao.inova.sistema.modal.Cidade;
import com.telecomunicacao.inova.sistema.modal.Cliente;
import com.telecomunicacao.inova.sistema.modal.SituacaoCliente;
import com.telecomunicacao.inova.sistema.modal.Uf;
import com.telecomunicacao.inova.sistema.service.ClienteDAO;
import com.telecomunicacao.inova.sistema.service.CidadeDAO;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	ClienteDAO<Cliente> clienteDao;
	
	@Autowired
	CidadeDAO<Cidade> cidadeDao;
	
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
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("cadastroCliente");
		mv.addObject(new Cliente());
		return mv;
	}
	
	// metodo para montar o combo dinamicamente
		@ModelAttribute("listaCidade")
		public List<Cidade> listaCidade() {
			List<Cidade> cidades = cidadeDao.listAll();
			return cidades;
		}
		
		@ModelAttribute("listaSituacaoCliente")
		public List<SituacaoCliente> situacao(){
			List<SituacaoCliente> lista = clienteDao.listaSituacao();
			return lista;
		}
}
