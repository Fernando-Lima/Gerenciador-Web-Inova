package com.telecomunicacao.inova.sistema.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.telecomunicacao.inova.sistema.modal.Cidade;
import com.telecomunicacao.inova.sistema.modal.Cliente;
import com.telecomunicacao.inova.sistema.modal.Situacao;
import com.telecomunicacao.inova.sistema.service.ClienteDAO;
import com.telecomunicacao.inova.sistema.service.CidadeDAO;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	private static final String TAG = "/cliente";

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

	@RequestMapping("/salvar")
	public String salvar(Cliente cliente, RedirectAttributes attributes) {
//		System.out.println("cliente >> " + cliente);
//		return "404";
		try {
			if (cliente.getCodigo() == null) {
				clienteDao.salvar(Cliente.class, cliente, TAG);
				attributes.addFlashAttribute("mensagem", "Cliente " + cliente.getNome() + " salvo com sucesso!");
				System.out.println("cliente salvo>> " + cliente);
			}else {
				clienteDao.atualizar(Cliente.class, cliente, TAG);
				attributes.addFlashAttribute("mensagem", "Cliente " + cliente.getNome() + " atualizado com sucesso!");
				System.out.println("cliente atualizado >> " + cliente);
			}
			return "redirect:/clientes/novo";
		} catch (Exception e) {
			e.printStackTrace();
			return "404";
		}
	}

	// metodo para montar o combo dinamicamente
	@ModelAttribute("listaCidade")
	public List<Cidade> listaCidade() {
		List<Cidade> cidades = cidadeDao.listAll();
		return cidades;
	}

//	@ModelAttribute("listaSituacao")
//	public List<Situacao> listaSituacao() {
//		return Arrays.asList(Situacao.values());
//	}
}
